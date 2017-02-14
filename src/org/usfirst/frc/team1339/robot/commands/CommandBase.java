package org.usfirst.frc.team1339.robot.commands;

import org.usfirst.frc.team1339.robot.OI;
import org.usfirst.frc.team1339.robot.subsystems.Chassis;
import org.usfirst.frc.team1339.robot.subsystems.Climb;
import org.usfirst.frc.team1339.robot.subsystems.Intake;
import org.usfirst.frc.team1339.robot.subsystems.Shifting;

import edu.wpi.first.wpilibj.command.Command;


/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    
    public static Chassis chassis;
    public static Shifting shifting;
    public static Intake intake;
    public static Climb climb;
    
    public static void init() {
    	chassis = new Chassis();
    	shifting = new Shifting();
        oi = new OI();
        intake = new Intake();
        climb = new Climb();
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
        
    }
}