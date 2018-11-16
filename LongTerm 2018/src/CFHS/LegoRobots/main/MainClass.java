package CFHS.LegoRobots.main;

import CFHS.LegoRobots.main.Motors;
import lejos.robotics.Color;

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
		
	}

}