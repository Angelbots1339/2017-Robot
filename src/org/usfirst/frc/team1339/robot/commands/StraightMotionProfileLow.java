package org.usfirst.frc.team1339.robot.commands;

import edu.wpi.first.wpilibj.command.Scheduler;

public class StraightMotionProfileLow extends CommandBase {
	
	private double m_goal, tolerance, initialLeft, initialRight, m_decelerateVel;
	private int counter;
	
	public StraightMotionProfileLow(double goal, double input_tolerance, double decelerateVel){
		requires(chassis);
		m_goal = goal;
		tolerance = input_tolerance;
		m_decelerateVel = decelerateVel;
	}

	protected void initialize() {
		// TODO Auto-generated method stub
		Scheduler.getInstance().add(new ShiftLow());
		chassis.gyroTurnPID.setSetpoint(0);
		chassis.chassisMPLow.configureNewProfile(m_goal, m_decelerateVel);
		initialLeft = chassis.getLeftEnc();
		initialRight = chassis.getRightEnc();
		chassis.chassisMPLow.initializeProfile(initialLeft, initialRight);
	}

	public void execute() {
		// TODO Auto-generated method stub
		chassis.motionProfileLow();
		if((Math.abs(chassis.getLeftEnc() - m_goal - initialLeft) < tolerance)
				&& (Math.abs(chassis.getRightEnc() - m_goal - initialRight) < tolerance)){
			counter++;
		}
	}

	public boolean isFinished() {
		// TODO Auto-generated method stub
		return chassis.chassisMPLow.isFinishedTrajectory() && counter >= 50;
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
