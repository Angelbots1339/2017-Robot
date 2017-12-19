package org.usfirst.frc.team1339.robot.commands;

import edu.wpi.first.wpilibj.Timer;

public class Christmas extends CommandBase {

    double lastTime = 0;
    double interval = 1;

    boolean isRed;

    public Christmas(){
        requires(leds);
    }

    protected void initialize(){
        leds.setColor(0, 0, 0);
        isRed = true;
    }

    protected void execute(){
        double time = Timer.getFPGATimestamp();
        if(time > lastTime + interval){
            lastTime = time;
            if(isRed){
                leds.setColor(0, 0, 0);
            }
            else{
                leds.setColor(255, 255, 255);
            }
            isRed = !isRed;
        }
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end(){

    }

    protected void interrupted(){

    }
}
