package org.usfirst.frc.team1339.robot.subsystems;

import java.util.ArrayList;

import org.usfirst.frc.team1339.robot.RobotMap;
import org.usfirst.frc.team1339.robot.commands.ArcadeDrive;
import org.usfirst.frc.team1339.utils.MotionProfileHigh;
import org.usfirst.frc.team1339.utils.MotionProfileLow;
import org.usfirst.frc.team1339.utils.SplineProfileLow;
import org.usfirst.frc.team1339.utils.SynchronousPID;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Chassis extends Subsystem {
	//Motors
	private CANTalon rightFrontMotor, rightBackMotor,
	leftFrontMotor, leftBackMotor;
  
	//Sensors
	private ADXRS450_Gyro spartanGyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);
	private Ultrasonic ultraLeft = new Ultrasonic(RobotMap.ultraLeftOut,
			RobotMap.ultraLeftIn);
	private Ultrasonic ultraRight = new Ultrasonic(RobotMap.ultraRightOut,
			RobotMap.ultraRightIn);
	private Encoder leftEnc = new Encoder(RobotMap.leftDriveAEncoder, RobotMap.leftDriveBEncoder, true);
	private Encoder rightEnc = new Encoder(RobotMap.rightDriveAEncoder, RobotMap.rightDriveBEncoder);

	//PID
	public SynchronousPID gyroTurnPID = new SynchronousPID
			(RobotMap.gyroTurnP, RobotMap.gyroTurnI, RobotMap.gyroTurnD);
	public SynchronousPID visionTurnPID = new SynchronousPID
			(RobotMap.visionTurnP, RobotMap.visionTurnI, RobotMap.visionTurnD);
	public SynchronousPID visionThrottlePID = new SynchronousPID
			(RobotMap.visionThrottleP, RobotMap.visionThrottleI, RobotMap.visionThrottleD);
	public SynchronousPID pixyTurnPID = new SynchronousPID
			(RobotMap.pixyTurnP, RobotMap.pixyTurnI, RobotMap.pixyTurnD);
	public SynchronousPID ultraPID = new SynchronousPID
			(RobotMap.ultraP, RobotMap.ultraI, RobotMap.ultraD);

	//Motion Profile Low
	public MotionProfileLow chassisMPLow = new MotionProfileLow(
			RobotMap.chassisMPLowKp, RobotMap.chassisMPLowKi, 
			RobotMap.chassisMPLowKd, RobotMap.chassisMPLowKa, 
			RobotMap.chassisMPLowKv);

	//Motion Profile High
	public MotionProfileHigh chassisMPHigh = new MotionProfileHigh(
			RobotMap.chassisMPHighKp, RobotMap.chassisMPHighKi, 
			RobotMap.chassisMPHighKd, RobotMap.chassisMPHighKa,
			RobotMap.chassisMPHighKv);

	//Spline Profile
	public SplineProfileLow chassisSP = new SplineProfileLow(
			RobotMap.splineMPKp, RobotMap.splineMPKi, 
			RobotMap.splineMPKd, RobotMap.splineMPKa, 
			RobotMap.splineMPKv);

	private double lastTime = 0, lastRightSpeed = 0, lastLeftSpeed = 0;
  
	private ArrayList<Double> accel = new ArrayList<Double>();

	/**
	 * 
	 */
	public Chassis(){
		rightFrontMotor = new CANTalon(RobotMap.rightFront);
		rightBackMotor = new CANTalon(RobotMap.rightBack);
		leftFrontMotor = new CANTalon(RobotMap.leftFront);
		leftBackMotor = new CANTalon(RobotMap.leftBack);

		ultraLeft.setAutomaticMode(true);
		ultraRight.setAutomaticMode(true);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new ArcadeDrive());
	}

	//Getters and Setters for Sensors
	public double getSpartanGyro() {
		return spartanGyro.getAngle();
	}

	public double getSpartanGyroRate(){
		return spartanGyro.getRate();
	}

	public void resetGyro(){
		spartanGyro.reset();
	}
  
	public int getRightEnc(){
		return rightEnc.get();
	}

	public int getLeftEnc(){
		return leftEnc.get() * 2;
	}
  
	public void resetEncoder(){
		rightEnc.reset();
		leftEnc.reset();
	}

	public double getUltraLeft(){
		return ultraLeft.getRangeInches();
	}

	public double getUltraRight(){
		return ultraRight.getRangeInches();
	}
	
	public void setMotorValues(double right, double left){
		rightFrontMotor.set(-right);
		rightBackMotor.set(-right);		
		leftFrontMotor.set(left);
		leftBackMotor.set(left);

		SmartDashboard.putNumber("Output R", right);
		SmartDashboard.putNumber("Output L", left);
		//SmartDashboard.putNumber("Gyro Output" , getSpartanGyro());
	}

	public void driveWithJoystick(double throttle, double turn){
		double left = throttle;
		double right = throttle;
		double turningThrottleScale;

		if (Math.abs(throttle) > 0.1) turningThrottleScale = Math.abs(throttle);
		else turningThrottleScale = 0.75;

		right += turn * turningThrottleScale;  
		left -= turn * turningThrottleScale;

		if(Math.abs(right) <= 0.05)
			right = 0;
		if(Math.abs(left) <= 0.05)
			left = 0;
    
		setMotorValues(right, left);
	}
	public void runGyroPid(){
		double output = gyroTurnPID.calculate(getSpartanGyro());
		double left = -output;
		double right = output;
		setMotorValues(right, left);
	}

	public void runVisionPid(int[] centerX){
		double targetSum = 0;
		for(int i = 0; i < centerX.length; i++){
			targetSum += centerX[i];
		}
		double targetAvg = targetSum/centerX.length;
		if(centerX.length == 0){
			setMotorValues(0, 0);
		}
		else{
			double output = visionTurnPID.calculate(targetAvg);
			double left = output;
			double right = -output;
			setMotorValues(right, left);
		}
	}

	public void runPixyPid(int[] centerX){
		double targetSum = 0;
		for(int i = 0; i < centerX.length; i++){
			targetSum += centerX[i];
		}
		double targetAvg = targetSum/centerX.length;
		if(centerX.length == 0){
			setMotorValues(0, 0);
		}
		else{
			double output = visionTurnPID.calculate(targetAvg);
			double left = -output;
			double right = output;
			setMotorValues(right, left);
		}
	}

	public void runVisionPIDThrottle(int[] centerX, double throttle){
		double visionOutput = 0;
		double right = throttle;
		double left = throttle;
		double targetSum = 0;
		for(int i = 0; i < centerX.length; i++){
			targetSum += centerX[i];
		}
		double targetAvg = targetSum/centerX.length;
		if(centerX.length != 0){
			visionOutput = visionTurnPID.calculate(targetAvg);
		}
		right -= visionOutput;
		left += visionOutput;
		setMotorValues(right, left);
	}

	public void ultraDist(double dist){
		double output = ultraPID.calculate(dist);
		setMotorValues(output, output);
	}

	public void autoGear(int[] centerX, int[] heights){
		double gyroOutput = 0;
		double distOutput = 0;
		double targetSum = 0;

		for(int i = 0; i < centerX.length; i++){
			targetSum += centerX[i];
		}
		double targetAvg = targetSum/centerX.length;
		if(centerX.length != 0){
			gyroOutput = visionTurnPID.calculate(targetAvg);
		}

		targetSum = 0;
		for(int i = 0; i < heights.length; i++){
			targetSum += heights[i];
		}
		targetAvg = targetSum/heights.length;
		if(heights.length != 0){
			distOutput = -visionThrottlePID.calculate(targetAvg);
		}

		double right = distOutput - gyroOutput;
		double left = distOutput + gyroOutput;
		setMotorValues(right, left);
	}

	public void ultraGear(int[] centerX, double dist){
		double visionOutput = 0;
		double distOutput = 0;
		double targetSum = 0;

		distOutput = ultraPID.calculate(dist);

		for(int i = 0; i < centerX.length; i++){
			targetSum += centerX[i];
		}
		double targetAvg = targetSum/centerX.length;
		if(centerX.length != 0){
			visionOutput = visionTurnPID.calculate(targetAvg);
		}

		visionOutput = Math.pow(visionOutput, 3);

		double right = distOutput - visionOutput;
		double left = distOutput + visionOutput;
		setMotorValues(right, left);
	}
  
	public void motionProfileLow(){
		chassisMPLow.calculate(getRightEnc(), getLeftEnc());
		double gyroOutput = gyroTurnPID.calculate(spartanGyro.getAngle());
		double rightSpeed = chassisMPLow.getRightOutput();
		double leftSpeed = chassisMPLow.getLeftOutput();
		//rightSpeed -= gyroOutput;
		//leftSpeed += gyroOutput;
		SmartDashboard.putNumber("MP right output", rightSpeed);
		SmartDashboard.putNumber("MP left output", leftSpeed);
		SmartDashboard.putNumber("Gyro Output", gyroOutput);
		setMotorValues(-rightSpeed, -leftSpeed);
	}

	public void motionProfileHigh(){
		chassisMPHigh.calculate(getRightEnc(), getLeftEnc());
		//double gyroOutput = gyroTurnPID.calculate(spartanGyro.getAngle());
		double rightSpeed = chassisMPHigh.getRightOutput();
		double leftSpeed = chassisMPHigh.getLeftOutput();
		//rightSpeed += gyroOutput;
		//leftSpeed -= gyroOutput;
		SmartDashboard.putNumber("MP output", rightSpeed);
		setMotorValues(-rightSpeed, -leftSpeed);
	}

	public void splineProfile(){
		chassisSP.calculate(getRightEnc(), getLeftEnc());
		double leftSpeed = chassisSP.getLeftOutput();
		double rightSpeed = chassisSP.getRightOutput();
		SmartDashboard.putNumber("spline speed", -leftSpeed);
		setMotorValues(-rightSpeed, -leftSpeed);
	}

	public void calculate(){
		double rightEncSpeed = rightEnc.getRate();
		double rightSpeed = rightEncSpeed - lastRightSpeed;
		lastRightSpeed = rightEncSpeed;

		double leftEncSpeed = leftEnc.getRate() * 2;
		double leftSpeed = leftEncSpeed - lastLeftSpeed;
		lastLeftSpeed = leftEncSpeed;
		double currentTime = Timer.getFPGATimestamp();
		double time = currentTime - lastTime;
		lastTime = currentTime;

		double rightAcc = rightSpeed / time;
		double leftAcc = leftSpeed / time;

		double avg = (rightAcc + leftAcc) / 2;
		accel.add(avg);

		double speedAvg = (leftEncSpeed + rightEncSpeed) / 2;

		SmartDashboard.putNumber("MP speed", speedAvg);
		SmartDashboard.putNumber("Accel Array", avg);
	}

	public ArrayList<Double> getAvgAcc(){
		return accel;
	}
}
