package org.usfirst.frc.team1339.robot.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class ShiftLow extends CommandBase {

	private boolean done = false;
	private double timeStart = 0;
	
	public ShiftLow() {
		requires(shifting);
	}

	protected void initialize() {
		shifting.setSolenoidIn(false);
		shifting.setSolenoidOut(true);
		timeStart = Timer.getFPGATimestamp();
	}

	protected void execute() {
		if((Timer.getFPGATimestamp() - timeStart) >= 0.05){
			shifting.setSolenoidOut(false);
			shifting.setIsHighGear(false);
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
