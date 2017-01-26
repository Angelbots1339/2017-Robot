package org.usfirst.frc.team1339.robot.subsystems;

import org.usfirst.frc.team1339.robot.RobotMap;
import org.usfirst.frc.team1339.robot.commands.ArcadeDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Chassis extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public static CANTalon rightFrontMotor = new CANTalon(RobotMap.rightFrontMotor);
	public static CANTalon rightBackMotor = new CANTalon(RobotMap.rightBackMotor);
	public static CANTalon leftFrontMotor = new CANTalon(RobotMap.leftFrontMotor);
	public static CANTalon leftBackMotor = new CANTalon(RobotMap.leftBackMotor);

	public static Solenoid rightSolenoid = new Solenoid(RobotMap.solenoidRight);
	public static Solenoid leftSolenoid = new Solenoid(RobotMap.solenoidLeft);
	
	double leftLastSpeed, rightLastSpeed;
	double rightSpeed, leftSpeed;
	double rate = 0.085;

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new ArcadeDrive());
	}

	public void setMotorValues(double right, double left){
		rightFrontMotor.set(right);
		rightBackMotor.set(-right);		
		leftFrontMotor.set(left);
		leftBackMotor.set(-left);
	}

	public void driveWithJoystick(double throttle, double turn){
		double right = throttle;
		double left = throttle;
		double turningThrottleScale;

		if (java.lang.Math.abs(throttle) > 0.1) {
			turningThrottleScale = java.lang.Math.abs(throttle);
		}
		else{
			turningThrottleScale = 0.75;
		}
		turningThrottleScale *= 1.5;

		right += turn * turningThrottleScale;  
		left -= turn * turningThrottleScale;

		if(Math.abs(right) <= 0.05)
			right = 0;
		if(Math.abs(left) <= 0.05)
			left = 0;

		if(left >= leftLastSpeed + rate)
			leftSpeed = leftLastSpeed + rate;
		else if (left <= leftLastSpeed - rate)
			leftSpeed = leftLastSpeed - rate;
		else
			leftSpeed = left;

		if(right >= rightLastSpeed + rate)
			rightSpeed = rightLastSpeed + rate;
		else if (right <= rightLastSpeed - rate)
			rightSpeed = rightLastSpeed - rate;
		else
			rightSpeed = right;


		setMotorValues(leftSpeed, rightSpeed);

		leftLastSpeed = leftSpeed;
		rightLastSpeed = rightSpeed;
	}


}
