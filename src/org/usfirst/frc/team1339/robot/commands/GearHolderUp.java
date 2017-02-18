package org.usfirst.frc.team1339.robot.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class GearHolderUp extends CommandBase {

	private boolean done = false;
	private double timeStart = 0;
	
	public GearHolderUp() {
		requires(gearHolder);
	}

	protected void initialize() {
		gearHolder.setPlateDownSolenoid(false);
		gearHolder.setPlateUpSolenoid(true);
		timeStart = Timer.getFPGATimestamp();
	}

	protected void execute() {
		if((Timer.getFPGATimestamp() - timeStart) >= 0.05){
			gearHolder.setPlateUpSolenoid(false);
			gearHolder.setPlateIsUp(true);
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
