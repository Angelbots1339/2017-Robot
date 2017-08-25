package org.usfirst.frc.team1339.robot.commands;

import org.usfirst.frc.team1339.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;

public class ArcadeDrive extends CommandBase{
	
	double throttle, turn;
	Joystick stick;

	public ArcadeDrive(){
		requires(chassis);
	}

	protected void initialize(){
	}

	protected void execute(){
		//stick = oi.getSaitek();
		stick = oi.getXboxStick();
		throttle = stick.getRawAxis(RobotMap.xboxLeftYAxis);
		turn = stick.getRawAxis(RobotMap.xboxRightXAxis);
		//throttle = stick.getRawAxis(RobotMap.saitekThrottle);
		//turn = stick.getRawAxis(RobotMap.saitekTurn);
		
		
		chassis.driveWithJoystick(throttle, turn);
	}

	protected boolean isFinished(){
		return false;
	}
	
	protected void end(){
		
	}
	
	protected void interrupted(){
		
	}
}
