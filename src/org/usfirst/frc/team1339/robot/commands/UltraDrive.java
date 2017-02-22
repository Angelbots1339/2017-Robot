package org.usfirst.frc.team1339.robot.commands;

/**
 *
 */
public class UltraDrive extends CommandBase {

	int numAvg = 5;
	double[] ultraRight = new double[numAvg];
	double[] ultraLeft = new double[numAvg];
	double leftTotal = 0;
	double rightTotal = 0;
	int ind = 0;
	int counter = 0;
	
	double setpoint;
	
    public UltraDrive(double setpoint) {
        // Use requires() here to declare subsystem dependencies
        requires(chassis);
        this.setpoint = setpoint;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	chassis.ultraPID.setSetpoint(setpoint);
    	
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
    	
    	chassis.ultraDist(avg);
    	if(chassis.ultraPID.onTarget(1)) counter++;
    	else counter = 0;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return counter == 3;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
