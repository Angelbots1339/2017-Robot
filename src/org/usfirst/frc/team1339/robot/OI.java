package org.usfirst.frc.team1339.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());
	
	Joystick stick = new Joystick(RobotMap.xboxPort);
	
	Button ViewButton = new JoystickButton(stick, RobotMap.xboxViewButton);
	Button MenuButton = new JoystickButton(stick, RobotMap.xboxMenuButton);
	
	private JoystickButton AButton = new JoystickButton(stick, RobotMap.xboxAbutton);
	private JoystickButton BButton = new JoystickButton(stick, RobotMap.xboxBbutton);
	private JoystickButton XButton = new JoystickButton(stick, RobotMap.xboxXbutton);
	private JoystickButton YButton = new JoystickButton(stick, RobotMap.xboxYbutton);
	private JoystickButton rightBumper = new JoystickButton(stick, RobotMap.xboxRightBumper);
	private JoystickButton leftBumper = new JoystickButton(stick, RobotMap.xboxLeftBumper);
	
	private JoystickButton rightStickButton = new JoystickButton(stick, RobotMap.xboxRightStickButton);
	private JoystickButton leftStickButton = new JoystickButton(stick, RobotMap.xboxLeftStickButton);
	
	public Joystick getXboxStick(){
		return stick;
	}
	public JoystickButton getAButton(){
		return AButton;
	}
	public JoystickButton getBButton(){
		return BButton;
	}
	public JoystickButton getXButton(){
		return XButton;
	}
	public JoystickButton getYButton(){
		return YButton;
	}
	public JoystickButton getLeftBumper(){
		return leftBumper;
	}
	public JoystickButton getRightBumper(){
		return rightBumper;
	}
	public JoystickButton getLeftStickButton(){
		return leftStickButton;
	}
	public JoystickButton getRightStickButton(){
		return rightStickButton;
	}
	

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
