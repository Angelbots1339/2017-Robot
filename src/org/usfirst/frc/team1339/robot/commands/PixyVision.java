package org.usfirst.frc.team1339.robot.commands;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PixyVision extends CommandBase{

	int lastCenterX = 0;
	
	public PixyVision(){
		requires(chassis);
	}

	protected void initialize(){
		chassis.visionTurnPID.setSetpoint(170);
	}

	public void execute(){
		int centerX = Integer.parseInt(NetworkTable.getTable("SmartDashboard").getString("pixy X", ""));
		if(centerX != lastCenterX){
			double angle = (170 - centerX) * 0.375;
			SmartDashboard.putNumber("Pixy Angle", angle);
			chassis.gyroTurnPID.setSetpoint(chassis.getSpartanGyro() + angle);
			lastCenterX = centerX;
		}
		chassis.runGyroPid();
	}

	public boolean isFinished(){
		return false;
	}

	protected void end(){
	}

	protected void interrupted(){
	}
}
