package org.usfirst.frc.team1339.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team1339.robot.Robot;
import org.usfirst.frc.team1339.robot.RobotMap;

public class HoldPosition extends CommandBase{

	public HoldPosition(){
		requires(chassis);
	}

	protected void initialize(){
		chassis.talonPositionControl(chassis.getLeftEnc()+500, chassis.getRightEnc()+500);
	}

	protected void execute(){
		chassis.updateDashboard();
	}

	protected boolean isFinished(){
		return false;
	}
	
	protected void end(){

	}
	
	protected void interrupted(){
		
	}
}
