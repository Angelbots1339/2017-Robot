package org.usfirst.frc.team1339.robot.commands;

import java.util.Arrays;

import org.usfirst.frc.team1339.robot.RobotMap;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class UltraGear extends CommandBase {

	int numAvg = 5;
	double[] ultraRight = new double[numAvg];
	double[] ultraLeft = new double[numAvg];
	double leftTotal = 0;
	double rightTotal = 0;
	int ind = 0;
	int counter = 0;
	
	double setpoint, limiter;
	
    public UltraGear(double setpoint, double limiter) {
        // Use requires() here to declare subsystem dependencies
        requires(chassis);
        this.setpoint = setpoint;
        this.limiter = limiter;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	vision.start();
    	chassis.ultraPID.setSetpoint(setpoint);
    	chassis.visionTurnPID.setSetpoint(RobotMap.visionSetPoint);
    	
    	leftTotal = 0;
    	rightTotal = 0;
    	
    	for (int i=0; i < numAvg; i++){
    		double right = chassis.getUltraRight();
    		ultraRight[i] = right;
    		rightTotal += right;
    		
    		double left = chassis.getUltraLeft();
    		ultraLeft[i] = left;
    		leftTotal += left;
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double oldLeft = ultraLeft[ind];
    	leftTotal -= oldLeft;
    	double newLeft = chassis.getUltraLeft();
    	leftTotal += newLeft;
    	ultraLeft[ind] = newLeft;
    	
    	double oldRight = ultraRight[ind];
    	rightTotal -= oldRight;
    	double newRight = chassis.getUltraRight();
    	rightTotal += newRight;
    	ultraRight[ind] = newRight;
    	
    	ind++;
    	if (ind == numAvg)
    		ind = 0;
        
    	double left = leftTotal / numAvg;
    	double right = rightTotal / numAvg;
    	double avg = (left + right) / 2;
    	

		int[] centerX = vision.getCenterX();
		SmartDashboard.putString("CENTERX", Arrays.toString(centerX));
    	
    	chassis.ultraGear(centerX, avg, limiter);
    	if(chassis.ultraPID.onTarget(2)) counter++;
    	else counter = 0;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return counter == 3;
    }

    // Called once after isFinished returns true
    protected void end() {
    	vision.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	vision.stop();
    }
}
