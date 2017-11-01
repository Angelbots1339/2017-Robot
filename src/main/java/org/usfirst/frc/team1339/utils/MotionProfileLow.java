package org.usfirst.frc.team1339.utils;

import org.usfirst.frc.team1339.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MotionProfileLow {

	@SuppressWarnings("unused")
	private double Kp, Ki, Kd, Ka, Kv, goal, cruiseVel,
	maxAcc, cruiseVelScaleFactor, lastRightError = 0,
	lastLeftError = 0, rightOutput = 0, leftOutput = 0,
	leftStartPos, rightStartPos, decelerateVel;
	private double lastTime;
	public Segment initialSegment = new Segment(0, 0, 0);
	public Segment currentSegment = new Segment(0, 0, 0);
	public Segment nextSegment = new Segment(0, 0, 0);
	
	public MotionProfileLow(){
		nextSegment = new Segment(0, 0, 0);
	}
	
	public MotionProfileLow(double Kp, double Ki, double Kd, double Ka,
			double Kv){
		this.Kp = Kp;
		this.Ki = Ki;
		this.Kd = Kd;
		this.Ka = Ka;
		this.Kv = Kv;
		nextSegment = new Segment(0, 0, 0);
	}
	
	private enum MotionState{
		ACCELERATING, CRUISING, DECELERATING, END
	}
	
	private MotionState state = MotionState.END;
	
	private void setState(MotionState newState){
		state = newState;
	}
	
	private MotionState getState(){
		return state;
	}

	public static class Segment{
		public double pos, vel, acc;
		
		public Segment(double pos, double vel, double acc){
			this.pos = pos;
			this.vel = vel;
			this.acc = acc;
		}
	}
	
	public void configureNewProfile(double distance, double decelerateSpeed){
		this.goal = distance;
		this.maxAcc = RobotMap.maxLowAcceleration;
		this.cruiseVelScaleFactor = RobotMap.motionProfileSlowScaleFactor;
		if(distance < 0){
			this.maxAcc *= -1;
		}
		this.cruiseVel = getCruiseVel(this.goal);
		if(distance < 0){
			this.cruiseVel *= -1;
		}
		this.currentSegment = new Segment(0, 0, 0);
		setState(MotionState.ACCELERATING);
		lastTime = Timer.getFPGATimestamp();
		this.decelerateVel = decelerateSpeed;
	}
	
	public void configureNewProfile(double Kp, double Ki, double Kd, double Ka,
			double Kv, double distance){
		this.Kp = Kp;
		this.Ki = Ki;
		this.Kd = Kd;
		this.Ka = Ka;
		this.Kv = Kv;
		this.goal = distance;
		this.cruiseVel = getCruiseVel(this.goal);
		this.maxAcc = RobotMap.maxLowAcceleration;
		this.currentSegment = initialSegment;
		this.cruiseVelScaleFactor = RobotMap.motionProfileFastScaleFactor;
		setState(MotionState.ACCELERATING);
		lastTime = Timer.getFPGATimestamp();
	}
	
	public void setProfileConstants(double Kp, double Ki, double Kd, double Ka,
			double Kv){
		this.Kp = Kp;
		this.Ki = Ki;
		this.Kd = Kd;
		this.Ka = Ka;
		this.Kv = Kv;
	}
	
	private double getCruiseVel(double distance){
		double halfDist = distance / 2;
		double maxVelOverHalfDistance = Math.sqrt(2 * halfDist * maxAcc);
		return Math.min(maxVelOverHalfDistance * cruiseVelScaleFactor, RobotMap.maxCruiseSpeed);
	}
	
	public void initializeProfile(double leftCurrentPos, double rightCurrentPos){
		this.leftStartPos = leftCurrentPos;
		this.rightStartPos = rightCurrentPos;
		lastTime = Timer.getFPGATimestamp();
	}
	
	public void calculate(double rightDistance, double leftDistance){
		double dt;
		double currentTime = Timer.getFPGATimestamp();
		dt = currentTime - lastTime;
		lastTime = currentTime;
		double currentVel = currentSegment.vel;
		double distanceToGo = goal - currentSegment.pos;
		
		double t_to_cruise = (cruiseVel - currentVel) / maxAcc; //time to accelerate to cruise speed
		double x_to_cruise = currentVel * t_to_cruise + .5 * maxAcc * t_to_cruise * t_to_cruise; //distance to get to cruise speed
		
		double t_to_zero = Math.abs((currentVel -  this.decelerateVel)/ maxAcc); //time to get to zero speed from cruise speed
		double x_to_zero = currentVel * t_to_zero - .5 * maxAcc * t_to_zero * t_to_zero; //distance to get to zero speed
		
		double cruiseX;
		if(goal > 0){
			cruiseX  = Math.max(0, distanceToGo - x_to_cruise - x_to_zero);
		}
		else{
			cruiseX  = Math.min(0, distanceToGo - x_to_cruise - x_to_zero);
		}
		double cruiseT = Math.abs(cruiseX / cruiseVel);
		
		if (getState() == MotionState.ACCELERATING){
			if (t_to_cruise < dt){
				setState(MotionState.CRUISING);
			}
		}
		
		if(getState() == MotionState.CRUISING){
			if(cruiseT < dt){
				setState(MotionState.DECELERATING);
			}
		}
		
		if(getState() == MotionState.DECELERATING){
			if(t_to_zero < dt){
				setState(MotionState.END);
			}
		}
		
		if(getState() == MotionState.ACCELERATING){
			nextSegment.pos = currentVel * dt + .5 * maxAcc * dt * dt;
			nextSegment.vel = currentVel + dt * maxAcc;
			nextSegment.acc = maxAcc;
		}
		else if(getState() == MotionState.CRUISING){
			nextSegment.pos = cruiseVel * dt;
			nextSegment.vel = cruiseVel;
			nextSegment.acc = 0;
		}
		else if(getState() == MotionState.DECELERATING){
			nextSegment.pos = currentVel * dt - 0.5 *maxAcc * dt * dt;
			nextSegment.vel = currentVel - maxAcc * dt;
			nextSegment.acc = -maxAcc;
		}
		else{
			nextSegment.pos = 0;
			currentSegment.pos = goal;
			nextSegment.vel = this.decelerateVel;
			nextSegment.acc = 0;
		}
		
		currentSegment.pos += nextSegment.pos;
		currentSegment.vel = nextSegment.vel;
		currentSegment.acc = nextSegment.acc;

		//System.out.println("cruiseVel" + cruiseVel);
		double output = Kv * currentSegment.vel + Ka * currentSegment.acc;
		
		double rightError = currentSegment.pos + this.rightStartPos - rightDistance;
		SmartDashboard.putNumber("right Error", rightError);
		
		rightOutput = rightError * Kp + ((rightError - lastRightError) / dt) * Kd + output;
		lastRightError = rightError;
		
		double leftError = currentSegment.pos + this.leftStartPos - leftDistance;
		SmartDashboard.putNumber("left Error", leftError);
		
		SmartDashboard.putNumber("pos", currentSegment.pos);
		leftOutput = leftError * Kp + ((leftError - lastLeftError) / dt) * Kd + output;
		lastLeftError = leftError;
	}
	
	public double getRightOutput(){
		rightOutput = Math.min(rightOutput, 1);
		rightOutput = Math.max(rightOutput, -1);
		return rightOutput;
	}
	
	public double getLeftOutput(){
		leftOutput = Math.min(leftOutput, 1);
		leftOutput = Math.max(leftOutput, -1);
		return leftOutput;
	}
	
	public boolean isFinishedTrajectory() {
        return currentSegment.pos == goal;
    }
	
	public double getGoal(){
		return goal;
	}
}
