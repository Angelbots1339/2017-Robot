package org.usfirst.frc.team1339.robot.commands;

import java.util.Arrays;

import org.usfirst.frc.team1339.robot.RobotMap;

public class RunVision extends CommandBase{

	int[] centerX;

	public RunVision(){
		requires(chassis);
	}

	protected void initialize(){
		vision.start();
		chassis.visionTurnPID.setSetpoint(RobotMap.visionSetPoint);
	}

	public void execute(){
		centerX = vision.getCenterX();
		System.out.println(Arrays.toString(centerX));
		chassis.runVisionPid(centerX);
	}

	public boolean isFinished(){
		return false;
	}

	protected void end(){
		vision.stop();
	}

	protected void interrupted(){
		vision.stop();
	}
}
