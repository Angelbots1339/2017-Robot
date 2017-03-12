package org.usfirst.frc.team1339.robot.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class Waddle extends CommandBase {
	
	boolean left;
	double lastTime;
	double wait = 0.5;

    public Waddle(double timeout) {
        // Use requires() here to declare subsystem dependencies
        requires(chassis);
        setTimeout(timeout);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	lastTime = 0;
    	left = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double time = Timer.getFPGATimestamp();
    	if(time > lastTime + wait){
    		lastTime = time;
    		left = !left;
    	}
    	if(left) chassis.setMotorValues(-.1, -.25);
    	else chassis.setMotorValues(-.25, -.1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	chassis.setMotorValues(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	chassis.setMotorValues(0, 0);
    }
}
