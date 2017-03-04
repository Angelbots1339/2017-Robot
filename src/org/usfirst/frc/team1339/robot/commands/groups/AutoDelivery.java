package org.usfirst.frc.team1339.robot.commands.groups;

import org.usfirst.frc.team1339.robot.commands.AutoDrive;
import org.usfirst.frc.team1339.robot.commands.GearHolderDown;
import org.usfirst.frc.team1339.robot.commands.GearHolderUp;
import org.usfirst.frc.team1339.robot.commands.UltraGear;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDelivery extends CommandGroup {

    public AutoDelivery() {
    	addSequential(new UltraGear(12), 3);
    	addSequential(new GearHolderDown());
    	addSequential(new AutoDrive(-1, .35));
    	//addSequential(new GearHolderUp());
    }
}