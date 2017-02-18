package org.usfirst.frc.team1339.robot.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class GearHolderDown extends CommandBase {

	private boolean done = false;
	private double timeStart = 0;
	
	public GearHolderDown() {
		requires(gearHolder);
	}

	protected void initialize() {
		gearHolder.setPlateUpSolenoid(false);
		gearHolder.setPlateDownSolenoid(true);
		timeStart = Timer.getFPGATimestamp();
	}

	protected void execute() {
		if((Timer.getFPGATimestamp() - timeStart) >= 0.05){
			gearHolder.setPlateDownSolenoid(false);
			gearHolder.setPlateIsUp(false);
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
