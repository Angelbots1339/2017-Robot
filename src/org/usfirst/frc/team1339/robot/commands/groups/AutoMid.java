package org.usfirst.frc.team1339.robot.commands.groups;

import org.usfirst.frc.team1339.robot.commands.AutoDrive;
import org.usfirst.frc.team1339.robot.commands.Chill;
import org.usfirst.frc.team1339.robot.commands.GearHolderDown;
import org.usfirst.frc.team1339.robot.commands.GearHolderUp;
import org.usfirst.frc.team1339.robot.commands.StraightMotionProfileLow;
import org.usfirst.frc.team1339.robot.commands.Waddle;
import org.usfirst.frc.team1339.utils.AngelMath;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoMid extends CommandGroup {

    public AutoMid() {
    	addSequential(new AutoStartUp());
    	addSequential(new StraightMotionProfileLow(AngelMath.inchesToClicks(54), 50, 0), 3.5);
    	addSequential(new Waddle(3));
    	addSequential(new Chill(0.1)); 
    	addSequential(new GearHolderDown());
    	addSequential(new Chill(0.1));
    	addSequential(new AutoDrive(-1, .25));
    	addSequential(new GearHolderUp());
    	//addSequential(new AutoDelivery());
    	//addSequential(new TouchUp());
    }
}