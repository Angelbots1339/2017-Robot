package org.usfirst.frc.team1339.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	//controller ports
	public static int xboxPort = 0;
	public static int xboxLeftXAxis = 0;
	public static int xboxLeftYAxis = 5;
	public static int xboxRightXAxis = 4;
	public static int xboxRightYAxis = 0;
	public static int xboxRightTrigger = 3;
	public static int xboxLeftTrigger = 2;
	public static int xboxAbutton = 0;
	public static int xboxBbutton = 1;
	public static int xboxXbutton = 2;
	public static int xboxYbutton = 3;
	public static int xboxLeftBumper = 4;
	public static int xboxRightBumper = 5;
	public static int xboxViewButton = 6;
	public static int xboxMenuButton = 7;
	public static int xboxRightStickButton = 9;
	public static int xboxLeftStickButton = 8;
	
	
	public static int leftFrontMotor = 0;
	public static int leftBackMotor = 0;
	public static int rightFrontMotor = 0;
	public static int rightBackMotor = 0;
	
	//Solenoids
	public static int solenoidLeft = 0;
	public static int solenoidRight = 1;
	
	
	
	
}
