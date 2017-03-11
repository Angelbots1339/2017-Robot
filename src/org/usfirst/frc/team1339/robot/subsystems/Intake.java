package org.usfirst.frc.team1339.robot.subsystems;

import org.usfirst.frc.team1339.robot.RobotMap;
import org.usfirst.frc.team1339.robot.commands.IntakeDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {

	private static CANTalon intakeTop, intakeBottom;
	
	public Intake(){
		intakeTop = new CANTalon(RobotMap.intakeTop);
		intakeBottom = new CANTalon(RobotMap.intakeBottom);
	}
	
	public void setMotorValues(double top, double bottom){
		top *= .5;
		bottom *= .5;
		if(Math.abs(top) < 0.05) top = 0;
		if(Math.abs(bottom) < 0.05) bottom = 0;
		intakeTop.set(top);
		intakeBottom.set(bottom);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new IntakeDrive());
    }
}

