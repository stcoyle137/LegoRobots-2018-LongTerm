package CFHS.LegoRobots.main;

import java.util.ArrayList;

import CFHS.LegoRobots.main.*;
import lejos.robotics.Color;
import lejos.utility.Delay;

public class MainClass {

	
	public static void main(String[] args) {
		Robot r1 = new Robot("ttte","llle");
		r1.setUpMotorSystem('b', 'c');
		r1.runSyncMotor(.3, .3);
		
		while(true) {
			if(r1.getValueForSensor(2) == 1) {
				r1.TurnOnMotor('a', -1);
			}
			else if(r1.getValueForSensor(3) == 1) {
				r1.TurnOnMotor('a', 1);
			}
			else {
				r1.StopMotor('a');
			}
		}
//		aML.TurnOnMotorsForDegrees(1, 180);
//		MS1.RunInSyncWithDegrees(1, 2000, 1, 2000);
//		Sensor ColorSensor = new Sensor('c', 3);

//		while(aML == null) {
//				if(ColorSensor.getValue() == Color.GREEN || ColorSensor.getValue() == Color.BLUE) {
//					bML.TurnOnMotors(.75);
//					cML.TurnOnMotors(.50);
//				}
//				else {
//					bML.TurnOnMotors(.50);
//					cML.TurnOnMotors(.75);
//				}
//		}
		
	}

}