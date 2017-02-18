package org.usfirst.frc.team1339.robot.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class GearRampUp extends CommandBase {

	private boolean done = false;
	private double timeStart = 0;
	
	public GearRampUp() {
		requires(gearRamp);
	}

	protected void initialize() {
		gearRamp.setPlateDownSolenoid(false);
		gearRamp.setPlateUpSolenoid(true);
		timeStart = Timer.getFPGATimestamp();
	}

	protected void execute() {
		if((Timer.getFPGATimestamp() - timeStart) >= 0.05){
			gearRamp.setPlateUpSolenoid(false);
			gearRamp.setPlateIsUp(true);
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
