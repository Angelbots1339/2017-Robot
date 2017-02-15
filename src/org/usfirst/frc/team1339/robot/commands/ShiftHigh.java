package org.usfirst.frc.team1339.robot.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class ShiftHigh extends CommandBase {

	private boolean done = false;
	private double timeStart = 0;
	
	public ShiftHigh() {
		requires(shifting);
	}

	protected void initialize() {
		shifting.setSolenoidOut(false);
		shifting.setSolenoidIn(true);
		timeStart = Timer.getFPGATimestamp();
	}

	protected void execute() {
		if((Timer.getFPGATimestamp() - timeStart) >= 0.05){
			shifting.setSolenoidIn(false);
			shifting.setIsHighGear(true);
			done = true;
		}
	}

	protected boolean isFinished() {
		return done;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
