package org.usfirst.frc.team1339.robot.subsystems;

import com.mindsensors.CANLight;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1339.robot.commands.Christmas;

public class LEDs extends Subsystem {

    CANLight lights;

    public LEDs(){
        lights = new CANLight(20);
    }

    public void initDefaultCommand(){
        setDefaultCommand(new Christmas());
    }

    public void setColor(int red, int green, int blue){
        lights.showRGB(red, green, blue);
    }
}
