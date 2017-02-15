package org.usfirst.frc.team1339.robot.commands;

import org.usfirst.frc.team1339.robot.subsystems.Climb;

import edu.wpi.first.wpilibj.Joystick;

public class ClimberDrive extends CommandBase {
	
	double throttle = .65;
	
    public ClimberDrive() {
        requires(climb);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Climb.setMotorValues(throttle);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
