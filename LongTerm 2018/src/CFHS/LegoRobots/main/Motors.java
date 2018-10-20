package CFHS.LegoRobots.main;

import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.Port;
import lejos.robotics.RegulatedMotor;

//Samuel = comment
public class Motors{
	//Defining ports
	public static char A = 'a';
	public static char B = 'b';
	public static char C = 'c';
	public static char D = 'd';
	
	private RegulatedMotor motor;
	private Port whichPort;
	private int maxSpeed;
	
	public Motors(char port, char size) {
		/**
		 * The port is represent by the Lower case letters a b c d
		 * The size with l and m and with m as small motor and l as large
		 */
		switch (port){
		case 'a' : whichPort = MotorPort.A;
			break;
		case 'b' : whichPort = MotorPort.B;		
			break;
		case 'c' : whichPort = MotorPort.C;
			break;
		case 'd' : whichPort = MotorPort.D;
			break;
		default :
			System.out.println("Given Port does not exist.");
			System.out.println("Giving default port of A");
			whichPort = MotorPort.A;
			break;
		}
		
		if(size =='l') {
			motor = new EV3LargeRegulatedMotor(whichPort);
			maxSpeed = 59400;
		}
		else if (size == 'm') {
			 motor = new EV3MediumRegulatedMotor(whichPort);
			 maxSpeed = 84600;
		}
		else {
			System.out.println("Given Size does not exist");
			System.out.println("Giving a default value of Large");
			motor = new EV3LargeRegulatedMotor(whichPort);
		}
	}
	
	public void TurnOnMotors(double percentOfSpeed) {
		int speed = (int)(maxSpeed * percentOfSpeed);
		motor.setSpeed(speed);
		motor.forward();
		
	}
	
	public void TurnOnMotorsForDegrees(double percentOfSpeed) {
		int speed = (int)(maxSpeed * Math.abs(percentOfSpeed));
		if (percentOfSpeed == Math.abs(percentOfSpeed)) {
			motor.setSpeed(speed);
			motor.rotate(360, true);
		}
		else {
			motor.setSpeed(speed);
			motor.rotate(-360, true);
		}
	}
	
	public void stopMotor() {
		motor.stop();
	}
	
	public void resetEncoder() {
		motor.resetTachoCount();
	}
	
	public double getEncoderValue() {
		System.out.println(motor.getTachoCount());
		return motor.getTachoCount();
	}
	
	public int getMaxSpeed() {
		System.out.println(maxSpeed);
		return maxSpeed;
	}
	
	private EV3LargeRegulatedMotor castMotorsToEV3LargeRegulatedMotors() {
		return (EV3LargeRegulatedMotor) motor;
	}
	
	private EV3MediumRegulatedMotor castMotorsToEV3MediumRegulatedMotors() {
		return (EV3MediumRegulatedMotor) motor;
	}
	//
	public void setUpSyncMotor(Motors m2) {
		if (motor.getClass() == EV3MediumRegulatedMotor.class) {
			motor.synchronizeWith(new RegulatedMotor[] {m2.castMotorsToEV3MediumRegulatedMotors()});
		}
		else {
			motor.synchronizeWith(new RegulatedMotor[] {m2.castMotorsToEV3LargeRegulatedMotors()});
		}
		
	}//
	
	public void startingSync() {
		motor.startSynchronization();
	}
	
	public void stoppingSync() {
		motor.endSynchronization();
	}
	
	public void waitForFinish() {
		motor.waitComplete();
	}
}
