package org.usfirst.frc.team1339.robot.subsystems;

import org.usfirst.frc.team1339.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arduino extends Subsystem {
	
	private DigitalOutput bitOne, bitTwo, bitThree;
	
	public Arduino(){
		bitOne = new DigitalOutput(RobotMap.bitOnePort);
		bitTwo = new DigitalOutput(RobotMap.bitTwoPort);
		bitThree = new DigitalOutput(RobotMap.bitThreePort);
	}

    public void initDefaultCommand() {
    }
    
    public void setNum(int num){
    	if(num < 0) num = 0;
    	else if(num > 7) num = 7;
    	
    	String bin = Integer.toBinaryString(num);
    	while(bin.length() < 3) bin = "0" + bin;
    	
    	boolean one = bin.substring(0, 1).equals("1");
    	boolean two = bin.substring(1, 2).equals("1");
    	boolean three = bin.substring(2).equals("1");

    	bitOne.set(one);
    	bitTwo.set(two);
    	bitThree.set(three);
    }
}

