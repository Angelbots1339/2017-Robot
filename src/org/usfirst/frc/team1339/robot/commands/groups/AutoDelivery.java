package org.usfirst.frc.team1339.robot.commands.groups;

import org.usfirst.frc.team1339.robot.commands.AutoDrive;
import org.usfirst.frc.team1339.robot.commands.Chill;
import org.usfirst.frc.team1339.robot.commands.GearHolderDown;
import org.usfirst.frc.team1339.robot.commands.UltraGear;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDelivery extends CommandGroup {

    public AutoDelivery() {
    	addSequential(new UltraGear(10, .85), 3);
    	addSequential(new GearHolderDown());
    	addSequential(new Chill(0.1));
    	addSequential(new AutoDrive(-1, .25));
    	/*addSequential(new GearHolderUp());
    	addSequential(new Chill(.4));
    	addSequential(new AutoDrive(0.7, .6));
    	addSequential(new Chill(.4));
    	addSequential(new AutoDrive(-1, .25));*/
    }
}