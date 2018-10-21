package CFHS.LegoRobots.main;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;
import CFHS.LegoRobots.main.Motors;

public class MainClass {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Motors aMM = new Motors(Motors.A, 'm');
		Motors bML = new Motors(Motors.B, 'l');
		Motors cML = new Motors(Motors.C, 'l');
		MotorsSystem MS1 = new MotorsSystem(bML, cML);
		MS1.RunInSyncForever(1, -1);
		
	}

}

