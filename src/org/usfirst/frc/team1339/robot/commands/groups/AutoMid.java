package org.usfirst.frc.team1339.robot.commands.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoMid extends CommandGroup {

    public AutoMid() {
    	addSequential(new AutoStartUp());
    	addSequential(new AutoDelivery());
    	addSequential(new TouchUp());
    }
}