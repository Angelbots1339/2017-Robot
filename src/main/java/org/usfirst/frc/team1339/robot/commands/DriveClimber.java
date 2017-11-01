package org.usfirst.frc.team1339.robot.commands;

/**
 *
 */
public class DriveClimber extends CommandBase {
	
	double throttle, tolerance;

    public DriveClimber(double throttle) {
    	requires(climb);
    	this.throttle = throttle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	climb.setMotorValue(throttle);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	climb.setMotorValue(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	climb.setMotorValue(0);
    }
}
