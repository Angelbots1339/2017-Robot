package org.usfirst.frc.team1339.robot.commands.groups;

import org.usfirst.frc.team1339.robot.commands.Chill;
import org.usfirst.frc.team1339.robot.commands.GyroTurn;
import org.usfirst.frc.team1339.robot.commands.StraightMotionProfileLow;
import org.usfirst.frc.team1339.utils.AngelMath;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRight extends CommandGroup {

    public AutoRight() {
    	addSequential(new AutoStartUp());
    	addSequential(new StraightMotionProfileLow(AngelMath.inchesToClicks(84), 25, 0), 4);
    	addSequential(new Chill(0.1));
    	addSequential(new GyroTurn(-60), 2);
    	addSequential(new Chill(0.1));
    	addSequential(new AutoDelivery());
    	addSequential(new TouchUp());
    }
}
