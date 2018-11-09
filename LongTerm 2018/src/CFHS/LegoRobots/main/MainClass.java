package CFHS.LegoRobots.main;

import CFHS.LegoRobots.main.Motors;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;

public class MainClass {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Motors aMM = new Motors(Motors.A, Motors.Medium);
		Motors bML = new Motors(Motors.B, Motors.Large);
		Motors cML = new Motors(Motors.C, Motors.Large);
		MotorsSystem MS1 = new MotorsSystem(bML, cML);
		aMM.TurnOnMotorsForDegrees(1, 180);
		MS1.RunInSyncWithDegrees(1, 2000, 1, 2000);

		
		//	EV3TouchSensor ts = new EdV3TouchSensor(SensorPort.S1);
		
	}

}