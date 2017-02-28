package org.usfirst.frc.team1339.robot.subsystems;

import org.usfirst.frc.team1339.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Climb extends Subsystem {

	private static CANTalon climbMotor;
	
	public Climb(){
		climbMotor = new CANTalon(RobotMap.climbMotor);
	}

	public void setMotorValue(double throttle){
		climbMotor.set(throttle);
		SmartDashboard.putNumber("Current", climbMotor.getOutputCurrent());
	}
	
	public double returnCurrentDraw(){
		return climbMotor.getOutputCurrent();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.s
    }
}

