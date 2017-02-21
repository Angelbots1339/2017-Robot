package org.usfirst.frc.team1339.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	//Controller Ports
	public final static int xboxPort = 0;
	public final static int operatorPort = 1;

	//Xbox Axis
	public final static int xboxLeftXAxis = 0;
	public final static int xboxLeftYAxis = 1;
	public final static int xboxLeftTrigger = 2;
	public final static int xboxRightTrigger = 3;
	public final static int xboxRightXAxis = 4;
	public final static int xboxRightYAxis = 5;

	//Xbox Buttons
	public final static int xboxAButton = 1;
	public final static int xboxBButton = 2;
	public final static int xboxXButton = 3;
	public final static int xboxYButton = 4;
	public final static int xboxLeftBumper = 5;
	public final static int xboxRightBumper = 6;
	public final static int xboxViewButton = 7;
	public final static int xboxMenuButton = 8;
	public final static int xboxLeftStickButton = 9;
	public final static int xboxRightStickButton = 10;

	//Mad Catz Axis
	public final static int operatorXAxis = 0;
	public final static int operatorYAxis = 1;
	public final static int operatorZAxis = 2;
	public final static int operatorZRotate = 3;

	//Mad Catz Buttons
	public final static int operatorOneButton = 1;
	public final static int operatorTwoButton = 2;
	public final static int operatorThreeButton = 3;
	public final static int operatorFourButton = 4;
	public final static int operatorFiveButton = 5;
	public final static int operatorSixButton = 6;
	public final static int operatorSevenButton = 7;

	//Drive Motors
	public final static int leftFront = 4;
	public final static int leftBack = 3;
	public final static int rightFront = 5;
	public final static int rightBack = 6;

	//Intake Motors
	public final static int intakeTop = 2;
	public final static int intakeBottom = 7;

	//Climbing Motor
	public final static int climbMotor = 8;

	//Solenoids
	public final static int shiftIn = 7;
	public final static int shiftOut = 6;
	public final static int gearRampDown = 0;
	public final static int gearRampUp = 1;
	public final static int gearHolderDown = 2;
	public final static int gearHolderUp = 3;
	public final static int pancakeOut = 4;
	public final static int pancakeIn = 5;

	//Ultrasonics
	public final static int ultraLeftOut = 0;
	public final static int ultraLeftIn = 1;
	public final static int ultraRightOut = 2;
	public final static int ultraRightIn = 3;
	
	//Encoders
	public final static int leftDriveAEncoder = 4;
	public final static int leftDriveBEncoder = 5;
	public final static int rightDriveAEncoder = 6;
	public final static int rightDriveBEncoder = 7;
	
	//Arduino
	public final static int bitOnePort = 8;
	public final static int bitTwoPort = 9;
	public final static int bitThreePort = 10;
	
	//PID Values
	public final static double gyroTurnP = 0.02;
	public final static double gyroTurnI = 0;
	public final static double gyroTurnD = 0;
	
	public final static double ultraP = 0.05;
	public final static double ultraI = 0;
	public final static double ultraD = 0;
	
	public final static double visionTurnP = 0.002;
	public final static double visionTurnI = 0;
	public final static double visionTurnD = 0;
	
	public final static double visionThrottleP = 0.02;
	public final static double visionThrottleI = 0;
	public final static double visionThrottleD = 0;

	public final static double pixyTurnP = 0.04;
	public final static double pixyTurnI = 0;
	public final static double pixyTurnD = 0;
}
