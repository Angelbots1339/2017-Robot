package org.usfirst.frc.team1339.robot.commands.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoMid extends CommandGroup {

    public AutoMid() {
    	addSequential(new AutoStartUp());
    	//addSequential(new StraightMotionProfileLow(AngelMath.inchesToClicks(54), 50, 0), 3.5);
    	//addSequential(new Waddle(3));
    	/*
    	addSequential(new StraightMotionProfileLow(AngelMath.inchesToClicks(76), 50, 0), 3.5); //54
    	addSequential(new Chill(0.1)); 
    	addSequential(new GearHolderDown());
    	addSequential(new Chill(0.1));
    	addSequential(new AutoDrive(-1, .25));
    	addSequential(new Chill(.5));
    	addSequential(new GearHolderUp());
    	*/
    	addSequential(new AutoDelivery());
    	//addSequential(new TouchUp());
    }
}