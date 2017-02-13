package org.usfirst.frc.team1339.robot.subsystems;

import org.usfirst.frc.team1339.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shifting extends Subsystem {
	Solenoid solenoidIn, solenoidOut;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
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
    
    
}

