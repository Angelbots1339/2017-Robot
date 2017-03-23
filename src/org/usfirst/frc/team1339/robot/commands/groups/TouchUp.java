package org.usfirst.frc.team1339.robot.commands.groups;

import org.usfirst.frc.team1339.robot.commands.AutoDrive;
import org.usfirst.frc.team1339.robot.commands.Chill;
import org.usfirst.frc.team1339.robot.commands.GearHolderUp;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TouchUp extends CommandGroup {

    public TouchUp() {
    	addSequential(new GearHolderUp());
    	addSequential(new Chill(.4));
    	addSequential(new AutoDrive(0.7, .4));//.6
    	addSequential(new Chill(.4));
    	addSequential(new AutoDrive(-1, .25));
    }
}