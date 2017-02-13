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
	
	//Controller Ports
	public final static int xboxPort = 0;
	
	//Axis
	public final static int xboxLeftXAxis = 0;
	public final static int xboxLeftYAxis = 1;
	public final static int xboxLeftTrigger = 2;
	public final static int xboxRightTrigger = 3;
	public final static int xboxRightXAxis = 4;
	public final static int xboxRightYAxis = 5;
	
	//Buttons
	public final static int xboxAbutton = 0;
	public final static int xboxBbutton = 1;
	public final static int xboxXbutton = 2;
	public final static int xboxYbutton = 3;
	public final static int xboxLeftBumper = 4;
	public final static int xboxRightBumper = 5;
	public final static int xboxViewButton = 6;
	public final static int xboxMenuButton = 7;
	public final static int xboxLeftStickButton = 8;
	public final static int xboxRightStickButton = 9;
	
	//Left Drive Motors
	public final static int leftFront = 4;
	public final static int leftBack = 3;
	
	//Right Drive Motors
	public final static int rightFront = 5;
	public final static int rightBack = 6;
	
	//Intake Motors
	public final static int intakeTop = 0;
	public final static int intakeBottom = 0;
	
	//Solenoids
	public final static int shiftIn = 0;
	public final static int shiftOut = 0;
	public final static int frontPanelOneIn = 0;
	public final static int frontPanelOneOut = 0;
	public final static int frontPanelTwoIn = 0;
	public final static int frontPanelTwoOut = 0;
	public final static int backPanelOneIn = 0;
	public final static int backPanelOneOut = 0;
	public final static int backPanelTwoIn = 0;
	public final static int backPanelTwoOut = 0;
	
	
	
}
