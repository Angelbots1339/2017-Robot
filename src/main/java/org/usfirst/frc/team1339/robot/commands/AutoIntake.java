package org.usfirst.frc.team1339.robot.commands;

import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 */
public class AutoIntake extends CommandBase {

	double speed;
	
    public AutoIntake(double speed) {
    	requires(intake);
    	this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Scheduler.getInstance().add(new GearRampDown());
    	Scheduler.getInstance().add(new GearHolderUp());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	intake.setMotorValues(speed, .8);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	intake.setMotorValues(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	intake.setMotorValues(0, 0);
    }
}
