package org.usfirst.frc.team1339.robot.commands;

/**
 *
 */
public class ShiftHigh extends CommandBase {
	
	public ShiftHigh() {
		requires(shifting);
		setTimeout(0.05);
	}

	protected void initialize() {
		shifting.setSolenoidOut(false);
		shifting.setSolenoidIn(true);
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
		shifting.setSolenoidIn(false);
		shifting.setIsHighGear(true);
	}

	protected void interrupted() {
		shifting.setSolenoidIn(false);
		shifting.setIsHighGear(true);
	}
}
