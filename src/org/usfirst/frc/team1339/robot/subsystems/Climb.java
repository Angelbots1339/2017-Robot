package org.usfirst.frc.team1339.robot.subsystems;

import org.usfirst.frc.team1339.robot.RobotMap;
import org.usfirst.frc.team1339.robot.commands.ClimberDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Climb extends Subsystem {

	private static CANTalon climbMotor;
	
	public Climb(){
		climbMotor = new CANTalon(RobotMap.climbMotor);
	}

	public static void setMotorValues(double throttle){
		climbMotor.set(throttle);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ClimberDrive());
    }
}

