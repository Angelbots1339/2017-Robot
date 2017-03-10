package org.usfirst.frc.team1339.robot.commands.groups;

import org.usfirst.frc.team1339.robot.commands.GearHolderUp;
import org.usfirst.frc.team1339.robot.commands.GearRampUp;
import org.usfirst.frc.team1339.robot.commands.ShiftLow;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoStartUp extends CommandGroup {

    public AutoStartUp() {
    	addSequential(new ShiftLow());
    	addSequential(new GearHolderUp());
    	addSequential(new GearRampUp());
    }
}
