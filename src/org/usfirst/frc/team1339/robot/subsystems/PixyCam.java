package org.usfirst.frc.team1339.robot.subsystems;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PixyCam extends Subsystem {

	SerialPort comm;
	
	public PixyCam(){
		comm = new SerialPort(9600, SerialPort.Port.kUSB1);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void getString(){
    	comm.readString();
    }
}

