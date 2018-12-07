package CFHS.LegoRobots.main;

import lejos.utility.Delay;
import lejos.robotics.Color;

public class MainClass {

	public static Robot r1 = new Robot("ecte","llle");
	public static boolean setUp = false;

	public static void main(String[] args) {
		r1.setUpMotorSystem('b', 'c');
		while(r1.getValueForSensor(2) != Color.BLUE) {
			greenTapeFollow();
		}
		r1.runSyncMotor(.5, -.5);
		Delay.msDelay(1000);
		while(true) {
			blueTapeFollow();
		}
	}
	
	public static void oneBoard() {
		if(!setUp) {
			r1.setUpMotorSystem('b', 'c');
			setUp = true;
		}
		r1.runSyncMotor(.4, .4);
		while(true) {
			if(r1.getValueForSensor(3) == 1) {
				r1.runMotorDegrees('a', 540*5, -.5);
				r1.stopSyncMotor();
				r1.runMotorDegrees('a', 180*5, -.5);
				break;
			}
		}
	}
	
	public static void rampWithGap() {
		if(!setUp) {
			r1.setUpMotorSystem('b', 'c');
			setUp = true;
		}
		r1.runSyncMotor(.4, .4);
		while(true) {
			if(r1.getValueForSensor(3) == 1) {
				r1.runMotorDegrees('a', 45*5, -.5);
				Delay.msDelay(100);
				r1.runMotorDegrees('a',135*5, -0.5);
				r1.stopSyncMotor();
				r1.runMotorDegrees('a', 180*5, -0.5);
				break;
			}
		}
		
	}
	
	public static void pyramid() {
		if(!setUp) {
			r1.setUpMotorSystem('b', 'c');
			setUp = true;
		}
		r1.runSyncMotor(.4, .4);
		while(true) {
			if(r1.getValueForSensor(3) == 1) {
				r1.runMotorDegrees('a', 900*5, -0.5);
				r1.stopSyncMotor();
				r1.runMotorDegrees('a', 180*5, -0.5);
					break;
				}
			}
		}

	public static void blueTapeFollow() {
		r1.setUpMotorSystem('b', 'c');
		if(r1.getValueForSensor(2) == Color.BLUE) {
			r1.runSyncMotor(.4, .2);
		}
		else {
			r1.runSyncMotor(.2, .4);
		}
	}
	
	public static void greenTapeFollow() {
		r1.setUpMotorSystem('b', 'c');
		if(r1.getValueForSensor(2) == Color.GREEN) {
			r1.runSyncMotor(.4, .2);
		}
		else {
			r1.runSyncMotor(.2, .4);
		}
	}
}
