package org.usfirst.frc.team1339.robot.subsystems;

import org.usfirst.frc.team1339.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearHolder extends Subsystem {
	
	private Solenoid plateUp, plateDown;
	private boolean isUp = false;
	
	public GearHolder(){
		plateUp = new Solenoid(RobotMap.gearHolderUp);
		plateDown = new Solenoid(RobotMap.gearHolderDown);
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

