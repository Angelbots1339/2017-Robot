package org.usfirst.frc.team1339.robot.subsystems;

import org.usfirst.frc.team1339.robot.RobotMap;
import org.usfirst.frc.team1339.robot.commands.ArcadeDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Chassis extends Subsystem {
	private static CANTalon rightFrontMotor, rightBackMotor,
		leftFrontMotor, leftBackMotor;
	
	public Chassis(){
		rightFrontMotor = new CANTalon(RobotMap.rightFront);
		rightBackMotor = new CANTalon(RobotMap.rightBack);
		leftFrontMotor = new CANTalon(RobotMap.leftFront);
		leftBackMotor = new CANTalon(RobotMap.leftBack);
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new ArcadeDrive());
	}

	public void setMotorValues(double right, double left){
		rightFrontMotor.set(-right);
		rightBackMotor.set(-right);		
		leftFrontMotor.set(left);
		leftBackMotor.set(left);
	}

	public void driveWithJoystick(double throttle, double turn){
		double right = throttle;
		double left = throttle;
		double turningThrottleScale;

		if (Math.abs(throttle) > 0.1) turningThrottleScale = Math.abs(throttle);
		else turningThrottleScale = 0.75;


		right -= turn * turningThrottleScale;  
		left += turn * turningThrottleScale;

		if(Math.abs(right) <= 0.05)
			right = 0;
		if(Math.abs(left) <= 0.05)
			left = 0;

		setMotorValues(left, right);
	}
}
