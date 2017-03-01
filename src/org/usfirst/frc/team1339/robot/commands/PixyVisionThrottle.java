package org.usfirst.frc.team1339.robot.commands;

import org.usfirst.frc.team1339.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PixyVisionThrottle extends CommandBase{
	
	Joystick stick;

	public PixyVisionThrottle(){
		requires(chassis);
	}

	protected void initialize(){
		chassis.pixyTurnPID.setSetpoint(160);
		
	}

	public void execute(){
		stick = oi.getXboxStick();
		double throttle = stick.getRawAxis(RobotMap.xboxLeftYAxis);
		
		int centerX = Integer.parseInt(NetworkTable.getTable("SmartDashboard").getString("pixy X", ""));
		SmartDashboard.putNumber("Pixy CenterX", centerX);
		chassis.runPixyPidThrottle(centerX, throttle);
	}

	public boolean isFinished(){
		return false;
	}

	protected void end(){
	}

	protected void interrupted(){
	}
}
