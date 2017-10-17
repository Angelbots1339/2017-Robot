package org.usfirst.frc.team1339.robot.commands;

public class CurvedMotionProfile extends CommandBase{

	double m_radius, m_angle, m_startVel;
	boolean m_direction;
	
	public CurvedMotionProfile(double radius, double angle, double startVel, boolean direction) {
		// TODO Auto-generated constructor stub
		requires(chassis);
		m_radius = radius;
		m_angle = Math.toRadians(angle);
		m_direction = direction;
		m_startVel = startVel;
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		chassis.chassisSP.configureSplineProfile(m_radius, m_angle, m_startVel, m_direction);
		chassis.chassisSP.initializeProfile(chassis.getLeftEnc(), chassis.getRightEnc(),
				chassis.getSpartanGyro());
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		if(!chassis.chassisSP.isFinishedTrajectory()){
			chassis.splineProfile();
		}
	}

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return chassis.chassisSP.isFinishedTrajectory();
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		chassis.setMotorValues(0, 0);
	}

}
