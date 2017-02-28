package org.usfirst.frc.team1339.robot.commands;

/**
 *
 */
public class GyroTurn extends CommandBase {

	double angle;
	
    public GyroTurn(double angle) {
        requires(chassis);
        this.angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	chassis.gyroTurnPID.setSetpoint(chassis.getSpartanGyro() + angle);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	chassis.runGyroPid();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return chassis.gyroTurnPID.onTarget(2);
    }

    // Called once after isFinished returns true
    protected void end() {
    	chassis.setMotorValues(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	chassis.setMotorValues(0, 0);
    }
}
