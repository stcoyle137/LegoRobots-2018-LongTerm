package CFHS.LegoRobots.main;

import lejos.utility.Delay;
import CFHS.LegoRobots.main.Motors;
//
public class MotorsSystem{
	private Motors m1;
	private Motors m2;
	
	public MotorsSystem(Motors motor1, Motors motor2){
		m1 = motor1;
		m2 = motor2;
		m1.setUpSyncMotor(m2);
	}
	
	public void RunInSyncWithDegrees(double percentOfMotor1, int degreesOfMotor1, double percentOfMotor2, int degreesOfMotor2) {
		m1.startingSync();
		m1.TurnOnMotorsForDegrees(percentOfMotor1, degreesOfMotor1);
		m2.TurnOnMotorsForDegrees(percentOfMotor2, degreesOfMotor2);
		m1.stoppingSync();
		m1.waitForFinish();
		m2.waitForFinish();
	}
	
	public void RunInSyncForever(double percentOfMotor1, double percentOfMotor2) {
		m1.startingSync();
		m1.TurnOnMotors(percentOfMotor1);
		m2.TurnOnMotors(percentOfMotor2);
		m1.stoppingSync();
		m1.waitForFinish();
		m2.waitForFinish();
	}
}