package org.usfirst.frc.team1339.robot.commands;

/**
 *
 */
public class GearHolderUp extends CommandBase {
	
	public GearHolderUp() {
		requires(gearHolder);
		setTimeout(0.05);
	}

	protected void initialize() {
		gearHolder.setPlateDownSolenoid(false);
		gearHolder.setPlateUpSolenoid(true);
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
		gearHolder.setPlateUpSolenoid(false);
		gearHolder.setPlateIsUp(true);
	}

	protected void interrupted() {
		gearHolder.setPlateUpSolenoid(false);
		gearHolder.setPlateIsUp(true);
	}
}
