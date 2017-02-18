package org.usfirst.frc.team1339.robot.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class GearRampDown extends CommandBase {

	private boolean done = false;
	private double timeStart = 0;
	
	public GearRampDown() {
		requires(gearRamp);
	}

	protected void initialize() {
		gearRamp.setPlateUpSolenoid(false);
		gearRamp.setPlateDownSolenoid(true);
		timeStart = Timer.getFPGATimestamp();
	}

	protected void execute() {
		if((Timer.getFPGATimestamp() - timeStart) >= 0.05){
			gearRamp.setPlateDownSolenoid(false);
			gearRamp.setPlateIsUp(false);
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
