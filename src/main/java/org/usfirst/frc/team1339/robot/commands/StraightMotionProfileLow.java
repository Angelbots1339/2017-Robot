package org.usfirst.frc.team1339.robot.commands;

public class StraightMotionProfileLow extends CommandBase {
	
	private double m_goal, tolerance, initialLeft, initialRight, m_decelerateVel;
	private int counter;
	
	/**
	 * Allocate a low gear motion profile object with the given constants, goal, input tolerance, and deceleration velocity.
	 * <p>
	 * ***
	 * <p>
	 * Prior to using this command, shift into low gear.
	 * @param goal
	 * @param input_tolerance
	 * @param decelerateVel
	 */
	public StraightMotionProfileLow(double goal, double input_tolerance, double decelerateVel){
		requires(chassis);
		m_goal = goal;
		tolerance = input_tolerance;
		m_decelerateVel = decelerateVel;
	}

	protected void initialize() {
		// TODO Auto-generated method stub
		chassis.gyroTurnPID.setSetpoint(chassis.getSpartanGyro());
		chassis.chassisMPLow.configureNewProfile(m_goal, m_decelerateVel);
		initialLeft = chassis.getLeftEnc();
		initialRight = chassis.getRightEnc();
		chassis.chassisMPLow.initializeProfile(initialLeft, initialRight);
		counter = 0;
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
		return chassis.chassisMPLow.isFinishedTrajectory() && counter >= 10;
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
