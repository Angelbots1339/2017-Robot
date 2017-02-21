package org.usfirst.frc.team1339.robot.subsystems;

import org.usfirst.frc.team1339.robot.RobotMap;
import org.usfirst.frc.team1339.robot.commands.ArcadeDrive;
import org.usfirst.frc.team1339.utils.SynchronousPID;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

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
	private Encoder leftEnc = new Encoder(RobotMap.leftDriveAEncoder, RobotMap.leftDriveBEncoder);
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

	public Chassis(){
		rightFrontMotor = new CANTalon(RobotMap.rightFront);
		rightBackMotor = new CANTalon(RobotMap.rightBack);
		leftFrontMotor = new CANTalon(RobotMap.leftFront);
		leftBackMotor = new CANTalon(RobotMap.leftBack);
		
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
	
	public void runPixyPid(int[] centerX){
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
			double left = output;
			double right = -output;
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
	
	public void setMotorValues(double right, double left){
		rightFrontMotor.set(-right);
		rightBackMotor.set(-right);		
		leftFrontMotor.set(left);
		leftBackMotor.set(left);
	}

	public void driveWithJoystick(double throttle, double turn){
		double right = throttle;
		double left = throttle;
		double turningThrottleScale;

		if (Math.abs(throttle) > 0.1) turningThrottleScale = Math.abs(throttle);
		else turningThrottleScale = 0.75;

		right -= turn * turningThrottleScale;  
		left += turn * turningThrottleScale;

		if(Math.abs(right) <= 0.05)
			right = 0;
		if(Math.abs(left) <= 0.05)
			left = 0;

		setMotorValues(left, right);
	}
}
