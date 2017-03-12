package org.usfirst.frc.team1339.robot.subsystems;

import org.usfirst.frc.team1339.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Climb extends Subsystem {

	private static CANTalon climbMotor;
	
	private Compressor comp = new Compressor();
	
	public Climb(){
		climbMotor = new CANTalon(RobotMap.climbMotor);
	}

	public void setMotorValue(double throttle){
		if(throttle > 0.05) comp.stop();
		else comp.start();
		climbMotor.set(throttle);
		SmartDashboard.putNumber("Current", climbMotor.getOutputCurrent());
	}
	
	public double returnCurrentDraw(){
		return climbMotor.getOutputCurrent();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.s
    }
    
    public void setComp(boolean val){
    	if(val) comp.start();
    	else comp.stop();
    }
}

