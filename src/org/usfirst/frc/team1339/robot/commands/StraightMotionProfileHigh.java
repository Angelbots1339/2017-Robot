package org.usfirst.frc.team1339.robot.commands;

import edu.wpi.first.wpilibj.command.Scheduler;

public class StraightMotionProfileHigh extends CommandBase {
	
	private double m_goal, tolerance, initialLeft, initialRight, m_decelerateVel;
	private int counter;
	
	public StraightMotionProfileHigh(double goal, double input_tolerance, double decelerateVel){
		requires(chassis);
		m_goal = goal;
		tolerance = input_tolerance;
		m_decelerateVel = decelerateVel;
	}

	protected void initialize() {
		// TODO Auto-generated method stub
		Scheduler.getInstance().add(new ShiftHigh());
		chassis.gyroTurnPID.setSetpoint(chassis.getSpartanGyro());
		chassis.chassisMPHigh.configureNewProfile(m_goal, m_decelerateVel);
		initialLeft = chassis.getLeftEnc();
		initialRight = chassis.getRightEnc();
		chassis.chassisMPHigh.initializeProfile(initialLeft, initialRight);
	}

	public void execute() {
		// TODO Auto-generated method stub
		//System.out.println("Running"); #Custom Scheduler
		chassis.motionProfileHigh();
		if((Math.abs(chassis.getLeftEnc() - m_goal - initialLeft) < tolerance)
				&& (Math.abs(chassis.getRightEnc() - m_goal - initialRight) < tolerance)){
			counter++;
		}
	}

	public boolean isFinished() {
		// TODO Auto-generated method stub
		return chassis.chassisMPHigh.isFinishedTrajectory() && counter >= 10;
	}

	protected void end() {
		// TODO Auto-generated method stub
		chassis.setMotorValues(0, 0);
	}

	protected void interrupted() {
		// TODO Auto-generated method stub
		chassis.setMotorValues(0, 0);
	}

}
