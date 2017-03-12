package org.usfirst.frc.team1339.robot.commands;

import org.usfirst.frc.team1339.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class IntakeDrive extends CommandBase {
	
	double throttle;
	Joystick stick;
	
    public IntakeDrive() {
        // Use requires() here to declare subsystem dependencies
        //requires();
    	requires(intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	stick = oi.getMadCatzStick();
    	throttle = stick.getRawAxis(RobotMap.operatorYAxis);
    	if(Math.abs(throttle) < 0.1) throttle = 0;
    	intake.setMotorValues(throttle, throttle);
    	if(Math.abs(throttle) > .8){
    		if(gearRamp.isPlateUp()) Scheduler.getInstance().add(new GearRampDown());
    		if(!gearHolder.isPlateUp()) Scheduler.getInstance().add(new GearHolderUp());
    	}
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
