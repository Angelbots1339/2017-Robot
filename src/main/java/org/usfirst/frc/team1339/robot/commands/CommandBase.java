package org.usfirst.frc.team1339.robot.commands;

import org.usfirst.frc.team1339.robot.OI;
import org.usfirst.frc.team1339.robot.subsystems.*;
import org.usfirst.frc.team1339.utils.Vision;

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
    public static Arduino arduino;
    public static GearRamp gearRamp;
    public static GearHolder gearHolder;
    public static Vision vision;
    public static LEDs leds;
    
    public static void init() {
    	chassis = new Chassis();
    	shifting = new Shifting();
        intake = new Intake();
        climb = new Climb();
        arduino = new Arduino();
        gearRamp = new GearRamp();
        gearHolder = new GearHolder();
        vision = new Vision();
        leds = new LEDs();
        
        oi = new OI();
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
        
    }
}