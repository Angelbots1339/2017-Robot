package org.usfirst.frc.team1339.robot.commands.groups;

import org.usfirst.frc.team1339.robot.commands.GearRampUp;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoMid extends CommandGroup {

    public AutoMid() {
    	addSequential(new GearRampUp());
    	addSequential(new AutoDelivery());
    	addSequential(new TouchUp());
    }
}
