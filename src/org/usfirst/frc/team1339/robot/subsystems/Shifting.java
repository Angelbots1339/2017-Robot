package org.usfirst.frc.team1339.robot.subsystems;

import org.usfirst.frc.team1339.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shifting extends Subsystem {
	
	Solenoid solenoidIn, solenoidOut;
	public boolean isHighGear;

	public void initDefaultCommand() {
    }
    
    public Shifting() {
    	solenoidIn = new Solenoid(RobotMap.shiftIn);
    	solenoidOut = new Solenoid(RobotMap.shiftOut);
    }
    
    public void setSolenoidOut(boolean value) {
    	solenoidOut.set(value);
    }
    public void setSolenoidIn(boolean value) {
    	solenoidIn.set(value);
    }
    
    public boolean isHighGear() {
		return isHighGear;
	}

	public void setIsHighGear(boolean isHighGear) {
		this.isHighGear = isHighGear;
	}
}

