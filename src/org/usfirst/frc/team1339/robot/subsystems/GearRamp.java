package org.usfirst.frc.team1339.robot.subsystems;

import org.usfirst.frc.team1339.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearRamp extends Subsystem {
	
	private Solenoid plateUp, plateDown;
	private boolean isUp = false;
	
	public GearRamp(){
		plateUp = new Solenoid(RobotMap.gearRampUp);
		plateDown = new Solenoid(RobotMap.gearRampDown);
	}

    public void initDefaultCommand() {
    	
    }
    
    public void setPlateUpSolenoid(boolean value){
    	plateUp.set(value);
    }
    
    public void setPlateDownSolenoid(boolean value){
    	plateDown.set(value);
    }
    
    public void setPlateIsUp(boolean value){
    	isUp = value;
    }
    
    public boolean isPlateUp(){
    	return isUp;
    }
}

