package org.usfirst.frc.team1339.robot.commands;

/**
 *
 */
public class GearRampDown extends CommandBase {
	
	public GearRampDown() {
		requires(gearRamp);
		setTimeout(0.05);
	}

	protected void initialize() {
		gearRamp.setPlateUpSolenoid(false);
		gearRamp.setPlateDownSolenoid(true);
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
		gearRamp.setPlateDownSolenoid(false);
		gearRamp.setPlateIsUp(false);
	}

	protected void interrupted() {
		gearRamp.setPlateDownSolenoid(false);
		gearRamp.setPlateIsUp(false);
	}
}
