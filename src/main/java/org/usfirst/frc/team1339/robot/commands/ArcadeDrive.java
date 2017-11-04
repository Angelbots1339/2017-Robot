package org.usfirst.frc.team1339.robot.commands;

import com.ctre.CANTalon;
import org.usfirst.frc.team1339.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;

public class ArcadeDrive extends CommandBase{
	
	double throttle, turn;
	Joystick stick;

	public ArcadeDrive(){
		requires(chassis);
	}

	protected void initialize(){
		chassis.setBrakes(false);
		chassis.setTalonMode(CANTalon.TalonControlMode.PercentVbus);
	}

	protected void execute(){
		stick = oi.getXboxStick();
		throttle = stick.getRawAxis(RobotMap.xboxLeftYAxis);
		turn = stick.getRawAxis(RobotMap.xboxRightXAxis);

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
