
package org.usfirst.frc.team1339.robot;

import java.io.IOException;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1339.robot.commands.AutoDrive;
import org.usfirst.frc.team1339.robot.commands.CommandBase;
import org.usfirst.frc.team1339.robot.commands.groups.AutoLeft;
import org.usfirst.frc.team1339.robot.commands.groups.AutoMid;
import org.usfirst.frc.team1339.robot.commands.groups.AutoRight;
import org.usfirst.frc.team1339.utils.AutonomousModeSelector;
import org.usfirst.frc.team1339.utils.Server;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	Server server;
	Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		CommandBase.init();

		server = new Server(8080);
		server.autonomousSelector = new AutonomousModeSelector();
		server.autonomousSelector.add("Do nothing", null);
		server.autonomousSelector.add("Auto Left", new AutoLeft());
		server.autonomousSelector.add("Auto Right", new AutoRight());
		server.autonomousSelector.add("Auto Mid", new AutoMid());
		server.autonomousSelector.add("Cross Baseline", new AutoDrive(0.5, 3));
		server.autonomousSelector.setCurrentMode(0);
		server.start();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	
	@Override
	public void autonomousInit() {
		autonomousCommand = server.autonomousSelector.getCurrentModeCommand();
		CommandBase.chassis.resetEncs();
		CommandBase.chassis.resetGyro();
		
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();

		CommandBase.chassis.resetEncs();
		CommandBase.chassis.resetGyro();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		server.valueDisplay.putValue("RightEnc", CommandBase.chassis.getRightEnc());
		server.valueDisplay.putValue("LeftEnc", CommandBase.chassis.getLeftEnc());
		SmartDashboard.putNumber("Gyro", CommandBase.chassis.getSpartanGyro());
		SmartDashboard.putNumber("Left Ultrasonic", CommandBase.chassis.getUltraLeft());
		SmartDashboard.putNumber("Right Ultrasonic", CommandBase.chassis.getUltraRight());
		SmartDashboard.putNumber("left encoder", CommandBase.chassis.getLeftEnc());
		SmartDashboard.putNumber("right encoder", CommandBase.chassis.getRightEnc());
		SmartDashboard.putNumber("Climb Current", CommandBase.climb.getCurrentDraw());
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
