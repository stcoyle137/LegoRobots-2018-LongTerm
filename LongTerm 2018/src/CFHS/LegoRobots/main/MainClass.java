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
		MS1.RunInSync(1, -1);
		
//		EV3LargeRegulatedMotor m1 = new EV3LargeRegulatedMotor(MotorPort.B);
//		EV3LargeRegulatedMotor m2 = new EV3LargeRegulatedMotor(MotorPort.C);
//		m1.synchronizeWith(new RegulatedMotor[] {m2});
//		m1.startSynchronization();
//		m1.setSpeed(10000);
//		m2.setSpeed(10000);
//		m1.forward();
//		m2.forward();
//		m1.endSynchronization();
//		m1.waitComplete();
//		m2.waitComplete();
	}

}

