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
	public final static int operatorTwoButton = 2;

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
	public final static int shiftIn = 0;
	public final static int shiftOut = 1;
	public final static int frontPanelOneIn = 0;
	public final static int frontPanelOneOut = 0;
	public final static int frontPanelTwoIn = 0;
	public final static int frontPanelTwoOut = 0;
	public final static int backPanelOneIn = 0;
	public final static int backPanelOneOut = 0;
	public final static int backPanelTwoIn = 0;
	public final static int backPanelTwoOut = 0;



}
