package org.usfirst.frc.team1339.robot.commands;

/**
 *
 */
public class ShiftLow extends CommandBase {
	
	public ShiftLow() {
		requires(shifting);
		setTimeout(0.05);
	}

	protected void initialize() {
		shifting.setSolenoidIn(false);
		shifting.setSolenoidOut(true);
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
		shifting.setSolenoidOut(false);
		shifting.setIsHighGear(false);
	}

	protected void interrupted() {
		shifting.setSolenoidOut(false);
		shifting.setIsHighGear(false);
	}
}
