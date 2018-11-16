package CFHS.LegoRobots.main;

import CFHS.LegoRobots.main.Motors;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.Color;
import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;

public class MainClass {

	
	public static void main(String[] args) throws ParmeterNotInRange {
		// TODO Auto-generated method stub
		Motors aMM = new Motors(Motors.A, Motors.Medium);
		Motors bML = new Motors(Motors.B, Motors.Large);
		Motors cML = new Motors(Motors.C, Motors.Large);
		MotorsSystem MS1 = new MotorsSystem(bML, cML);
		aMM.TurnOnMotorsForDegrees(1, 180);
		MS1.RunInSyncWithDegrees(1, 2000, 1, 2000);
		Sensor ColorSensor = new Sensor('c', 3);
		while(true) {
				if(ColorSensor.getValue() == Color.GREEN || ColorSensor.getValue() == Color.BLUE) {
					bML.TurnOnMotors(.75);
					cML.TurnOnMotors(.50);
				}
				else {
					bML.TurnOnMotors(.50);
					cML.TurnOnMotors(.75);
				}
		}
		
		//	EV3TouchSensor ts = new EdV3TouchSensor(SensorPort.S1);
		
	}

}