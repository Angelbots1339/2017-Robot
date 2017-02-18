package org.usfirst.frc.team1339.robot.commands;

import org.usfirst.frc.team1339.robot.subsystems.Climb;

public class ClimberDrive extends CommandBase {
	
	double throttle;
	
    public ClimberDrive(double throttle) {
        requires(climb);
        this.throttle = throttle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Climb.setMotorValue(throttle);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Climb.setMotorValue(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Climb.setMotorValue(0);
    }
}
