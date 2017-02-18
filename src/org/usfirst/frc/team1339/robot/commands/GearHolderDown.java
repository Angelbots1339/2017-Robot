package org.usfirst.frc.team1339.robot.commands;

/**
 *
 */
public class GearHolderDown extends CommandBase {
	
	public GearHolderDown() {
		requires(gearHolder);
		setTimeout(0.05);
	}

	protected void initialize() {
		gearHolder.setPlateUpSolenoid(false);
		gearHolder.setPlateDownSolenoid(true);
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
		gearHolder.setPlateDownSolenoid(false);
		gearHolder.setPlateIsUp(false);
	}

	protected void interrupted() {
		gearHolder.setPlateDownSolenoid(false);
		gearHolder.setPlateIsUp(false);
	}
}
