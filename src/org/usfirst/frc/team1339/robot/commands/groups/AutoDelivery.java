package org.usfirst.frc.team1339.robot.commands.groups;

import org.usfirst.frc.team1339.robot.commands.AutoDrive;
import org.usfirst.frc.team1339.robot.commands.AutoGear;
import org.usfirst.frc.team1339.robot.commands.GearHolderDown;
import org.usfirst.frc.team1339.robot.commands.GearHolderUp;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDelivery extends CommandGroup {

    public AutoDelivery() {
    	addSequential(new AutoGear());
    	addSequential(new AutoDrive(0.55, 0.4));
    	addParallel(new GearHolderDown());
    	addSequential(new AutoDrive(-1, .5));
    	addSequential(new GearHolderUp());
    }
}