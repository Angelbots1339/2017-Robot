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
	
	public static void setMotorValues(double top, double bottom){
		intakeTop.set(top/2);
		intakeBottom.set(bottom/2);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new IntakeDrive());
    }
}

