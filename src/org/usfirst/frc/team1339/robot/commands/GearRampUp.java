package org.usfirst.frc.team1339.robot.commands;

/**
 *
 */
public class GearRampUp extends CommandBase {
	
	public GearRampUp() {
		requires(gearRamp);
		setTimeout(0.3);
	}

	protected void initialize() {
		gearRamp.setPlateDownSolenoid(false);
		gearRamp.setPlateUpSolenoid(true);
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
		gearRamp.setPlateUpSolenoid(false);
		gearRamp.setPlateIsUp(true);
	}

	protected void interrupted() {
		gearRamp.setPlateUpSolenoid(false);
		gearRamp.setPlateIsUp(true);
	}
}
