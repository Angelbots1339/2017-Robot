package org.usfirst.frc.team1339.robot.subsystems;

import org.usfirst.frc.team1339.utils.Constants;
import org.usfirst.frc.team1339.utils.scanse.SweepDevice;
import org.usfirst.frc.team1339.utils.scanse.SweepSample;

import java.util.List;
import java.util.ArrayList;

public class ScanseSweep {

    static ArrayList<List> log = new ArrayList<List>();

    public static void start(){
        try (SweepDevice device = new SweepDevice("/dev/ttyUSB0")) {
            int speed = Constants.SCANSE_SPEED;
            int rate = Constants.SCANSE_RATE;

            device.setMotorSpeed(speed);
            device.setSampleRate(rate);

            device.startScanning();

            for (List<SweepSample> s : device.scans()){
                log.add(s);
            }
            System.out.println(log);
        }
    }

}
