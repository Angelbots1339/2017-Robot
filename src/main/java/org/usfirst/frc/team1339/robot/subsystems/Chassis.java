package org.usfirst.frc.team1339.robot.subsystems;

import org.usfirst.frc.team1339.robot.RobotMap;
import org.usfirst.frc.team1339.robot.commands.ArcadeDrive;
import org.usfirst.frc.team1339.utils.MotionProfileHigh;
import org.usfirst.frc.team1339.utils.MotionProfileLow;
import org.usfirst.frc.team1339.utils.SplineProfileLow;
import org.usfirst.frc.team1339.utils.SynchronousPID;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Chassis extends Subsystem {
	//Motors
	private CANTalon rightFrontMotor, rightBackMotor,
	leftFrontMotor, leftBackMotor;


	//Sensors
	private ADXRS450_Gyro spartanGyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);
	private Ultrasonic ultraLeft = new Ultrasonic(RobotMap.ultraLeftOut,
			RobotMap.ultraLeftIn);
	private Ultrasonic ultraRight = new Ultrasonic(RobotMap.ultraRightOut,
			RobotMap.ultraRightIn);
	private Encoder leftEnc = new Encoder(RobotMap.leftDriveAEncoder, RobotMap.leftDriveBEncoder, true);
	private Encoder rightEnc = new Encoder(RobotMap.rightDriveAEncoder, RobotMap.rightDriveBEncoder);

	//PID
	public SynchronousPID gyroTurnPID = new SynchronousPID
			(RobotMap.gyroTurnP, RobotMap.gyroTurnI, RobotMap.gyroTurnD);
	public SynchronousPID visionTurnPID = new SynchronousPID
			(RobotMap.visionTurnP, RobotMap.visionTurnI, RobotMap.visionTurnD);
	public SynchronousPID visionThrottlePID = new SynchronousPID
			(RobotMap.visionThrottleP, RobotMap.visionThrottleI, RobotMap.visionThrottleD);
	public SynchronousPID pixyTurnPID = new SynchronousPID
			(RobotMap.pixyTurnP, RobotMap.pixyTurnI, RobotMap.pixyTurnD);
	public SynchronousPID ultraPID = new SynchronousPID
			(RobotMap.ultraP, RobotMap.ultraI, RobotMap.ultraD);

	//Motion Profile Low
	public MotionProfileLow chassisMPLow = new MotionProfileLow(
			RobotMap.chassisMPLowKp, RobotMap.chassisMPLowKi, 
			RobotMap.chassisMPLowKd, RobotMap.chassisMPLowKa, 
			RobotMap.chassisMPLowKv);

	//Motion Profile High
	public MotionProfileHigh chassisMPHigh = new MotionProfileHigh(
			RobotMap.chassisMPHighKp, RobotMap.chassisMPHighKi, 
			RobotMap.chassisMPHighKd, RobotMap.chassisMPHighKa,
			RobotMap.chassisMPHighKv);

	//Spline Profile
	public SplineProfileLow chassisSP = new SplineProfileLow(
			RobotMap.splineMPKp, RobotMap.splineMPKi, 
			RobotMap.splineMPKd, RobotMap.splineMPKa, 
			RobotMap.splineMPKv);

	public Chassis(){
		rightFrontMotor = new CANTalon(RobotMap.rightFront);
		rightBackMotor = new CANTalon(RobotMap.rightBack);
		rightBackMotor.changeControlMode(CANTalon.TalonControlMode.Follower);
		rightBackMotor.set(RobotMap.rightFront);

		leftFrontMotor = new CANTalon(RobotMap.leftFront);
		leftBackMotor = new CANTalon(RobotMap.leftBack);
		leftBackMotor.changeControlMode(CANTalon.TalonControlMode.Follower);
		leftBackMotor.set(RobotMap.leftFront);

		ultraLeft.setAutomaticMode(true);
		ultraRight.setAutomaticMode(true);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new ArcadeDrive());
	}

	public double getSpartanGyro() {
		return spartanGyro.getAngle();
	}

	public double getSpartanGyroRate(){
		return spartanGyro.getRate();
	}

	public void resetGyro(){
		spartanGyro.reset();
	}

	public double getUltraLeft(){
		return ultraLeft.getRangeInches();
	}

	public double getUltraRight(){
		return ultraRight.getRangeInches();
	}

	public int getRightEnc(){
		return rightEnc.get();
	}

	public int getLeftEnc(){
		return leftEnc.get();
	}

	public void resetRightEnc(){
		rightEnc.reset();
	}

	public void resetLeftEnc(){
		leftEnc.reset();
	}

	public void resetEncs(){
		resetRightEnc();
		resetLeftEnc();
	}

	public void runGyroPid(){
		double output = gyroTurnPID.calculate(getSpartanGyro());
		double left = -output;
		double right = output;
		setMotorValues(right, left);
	}

	public void runVisionPid(int[] centerX){
		double targetSum = 0;
		for(int i = 0; i < centerX.length; i++){
			targetSum += centerX[i];
		}
		double targetAvg = targetSum/centerX.length;
		if(centerX.length == 0){
			setMotorValues(0, 0);
		}
		else{
			double output = visionTurnPID.calculate(targetAvg);
			double left = -output;
			double right = output;
			setMotorValues(left, right);
		}
	}

	public void runVisionPIDThrottle(int[] centerX, double throttle){
		double visionOutput = 0;
		double right = throttle;
		double left = throttle;
		double targetSum = 0;
		for(int i = 0; i < centerX.length; i++){
			targetSum += centerX[i];
		}
		double targetAvg = targetSum/centerX.length;
		if(centerX.length != 0){
			visionOutput = visionTurnPID.calculate(targetAvg);
		}
		right += visionOutput;
		left -= visionOutput;
		setMotorValues(left, right);
	}

	public void ultraDist(double dist){
		double output = ultraPID.calculate(dist);
		setMotorValues(output, output);
	}

	public void autoGear(int[] centerX, int[] heights){
		double gyroOutput = 0;
		double distOutput = 0;
		double targetSum = 0;

		for(int i = 0; i < centerX.length; i++){
			targetSum += centerX[i];
		}
		double targetAvg = targetSum/centerX.length;
		if(centerX.length != 0){
			gyroOutput = visionTurnPID.calculate(targetAvg);
		}

		targetSum = 0;
		for(int i = 0; i < heights.length; i++){
			targetSum += heights[i];
		}
		targetAvg = targetSum/heights.length;
		if(heights.length != 0){
			distOutput = -visionThrottlePID.calculate(targetAvg);
		}

		double right = distOutput + gyroOutput;
		double left = distOutput - gyroOutput;
		setMotorValues(left, right);
	}

	public void ultraGear(int[] centerX, double dist, double limiter){
		double visionOutput = 0;
		double distOutput = 0;
		double targetSum = 0;

		distOutput = ultraPID.calculate(dist) * limiter;

		for(int i = 0; i < centerX.length; i++){
			targetSum += centerX[i];
		}
		double targetAvg = targetSum/centerX.length;
		if(centerX.length != 0){
			visionOutput = visionTurnPID.calculate(targetAvg);
		}

		//visionOutput = Math.pow(visionOutput, 3);

		double right = distOutput + visionOutput;
		double left = distOutput - visionOutput;
		setMotorValues(left, right);
	}

	public void runPixyPid(int centerX){
		double output = pixyTurnPID.calculate(centerX);
		double left = -output;
		double right = output;
		setMotorValues(right, left);
	}

	public void runPixyPidThrottle(int centerX, double throttle){
		double output = pixyTurnPID.calculate(centerX);
		double left = throttle - output;
		double right = throttle + output;
		setMotorValues(right, left);
	}
	
	public void motionProfileLow(){
		chassisMPLow.calculate(getRightEnc(), getLeftEnc());
		double gyroOutput = gyroTurnPID.calculate(spartanGyro.getAngle()) * 4;//2
		double rightSpeed = chassisMPLow.getRightOutput() * .75;
		double leftSpeed = chassisMPLow.getLeftOutput() * .75; 
		rightSpeed -= gyroOutput;
		leftSpeed += gyroOutput;
		SmartDashboard.putNumber("MP right output", rightSpeed);
		SmartDashboard.putNumber("MP left output", leftSpeed);
		SmartDashboard.putNumber("Gyro Output", gyroOutput);
		setMotorValues(-rightSpeed, -leftSpeed);
	}

	public void motionProfileHigh(){
		chassisMPHigh.calculate(getRightEnc(), getLeftEnc());
		//double gyroOutput = gyroTurnPID.calculate(spartanGyro.getAngle());
		double rightSpeed = chassisMPHigh.getRightOutput();
		double leftSpeed = chassisMPHigh.getLeftOutput();
		//rightSpeed += gyroOutput;
		//leftSpeed -= gyroOutput;
		SmartDashboard.putNumber("MP output", rightSpeed);
		setMotorValues(-rightSpeed, -leftSpeed);
	}

	public void splineProfile(){
		chassisSP.calculate(getRightEnc(), getLeftEnc());
		double leftSpeed = chassisSP.getLeftOutput();
		double rightSpeed = chassisSP.getRightOutput();
		SmartDashboard.putNumber("spline speed", -leftSpeed);
		setMotorValues(-rightSpeed, -leftSpeed);
	}

	public void setMotorValues(double right, double left){
		if(Math.abs(left) < 0.075) left = 0;
		if(Math.abs(right) < 0.075) right = 0;
		
		rightFrontMotor.set(-right);
		//rightBackMotor.set(-right);
		leftFrontMotor.set(left);
		//leftBackMotor.set(left);
	}

	public void driveWithJoystick(double throttle, double turn){
		double right = throttle;
		double left = throttle;
		double turningThrottleScale;

		if (Math.abs(throttle) > 0.1) turningThrottleScale = Math.abs(throttle) * 2;
		else turningThrottleScale = 1;

		right += turn * turningThrottleScale;  
		left -= turn * turningThrottleScale;

		if(Math.abs(right) <= 0.05)
			right = 0;
		if(Math.abs(left) <= 0.05)
			left = 0;

		setMotorValues(right, left);
	}
}
