package org.usfirst.frc.team1339.robot.commands.groups;

import org.usfirst.frc.team1339.robot.commands.Chill;
import org.usfirst.frc.team1339.robot.commands.GyroTurn;
import org.usfirst.frc.team1339.robot.commands.StraightMotionProfileLow;
import org.usfirst.frc.team1339.utils.AngelMath;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLeft extends CommandGroup {

    public AutoLeft() {
    	addSequential(new AutoStartUp());
    	addSequential(new StraightMotionProfileLow(AngelMath.inchesToClicks(75), 25, 0), 2.5);
    	addSequential(new Chill(0.1));
    	addSequential(new GyroTurn(60), 1);
    	addSequential(new Chill(0.1));
    	addSequential(new AutoDelivery());
    	//addSequential(new TouchUp());
    }
}
