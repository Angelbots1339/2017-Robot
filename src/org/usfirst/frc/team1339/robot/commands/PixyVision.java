package org.usfirst.frc.team1339.robot.commands;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PixyVision extends CommandBase{

	int lastCenterX = 0;
	double lastTime = 0;

	public PixyVision(){
		requires(chassis);
	}

	protected void initialize(){
		chassis.pixyTurnPID.setSetpoint(160);
		
	}

	public void execute(){
		int centerX = Integer.parseInt(NetworkTable.getTable("SmartDashboard").getString("pixy X", ""));
		SmartDashboard.putNumber("Pixy CenterX", centerX);
		chassis.runPixyPid(centerX);
	}

	public boolean isFinished(){
		return false;
	}

	protected void end(){
	}

	protected void interrupted(){
	}
}
