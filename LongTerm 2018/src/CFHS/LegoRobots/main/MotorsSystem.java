package CFHS.LegoRobots.main;

import lejos.utility.Delay;
import CFHS.LegoRobots.main.Motors;

public class MotorsSystem{
	private Motors m1;
	private Motors m2;
	
	public MotorsSystem(Motors motor1, Motors motor2){
		m1 = motor1;
		m2 = motor2;
		m1.setUpSyncMotor(m2);
	}
	
	public void RunInSync(double percentOfMotor1, double percentOfMotor2) {
		m1.resetEncoder();
		m2.resetEncoder();
		m1.startingSync();
		m1.TurnOnMotorsForDegrees(percentOfMotor1);
		m2.TurnOnMotorsForDegrees(percentOfMotor2);
		m1.stoppingSync();
		m1.waitForFinish();
		m2.waitForFinish();
		m1.getEncoderValue();
		m2.getEncoderValue();
		Delay.msDelay(10000);
	}
}