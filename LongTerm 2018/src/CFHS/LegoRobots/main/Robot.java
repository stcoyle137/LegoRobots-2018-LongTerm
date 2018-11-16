package CFHS.LegoRobots.main;

import CFHS.LegoRobots.main.*;

public class Robot {
	private char[] sensorsChar;
	private char[] motorsChar;
	private Sensor[] sensors;
	private Motors[] motors;
	private MotorsSystem[] motorSystems;
	private int whichSystemOn = 0;
	/**
	 * @param sensorList a list of sensor with [0] being port 1. Used charators
	 * 'e' for a empty port
	 * 't' for a touch sensor
	 * 'c' for a color sensor
	 * 'g' for a gyro sensor
	 * @param motorList a list of motors with [0] being port a Use charators
	 * 'e' for a empty port
	 * 'm' for a medium motor
	 * 'l' for a large motor
	 */
	public Robot(char[] sensorList, char[] motorList) {
		try {
			while (motorsChar.length == 0) {
				if (motorList.length < 4) {
					motorList[(motorList.length + 2)] = 'e';
				}
				else if (motorList.length > 4) {
					int i = 0;
					while(i < 4) {
						motorsChar[i] = motorList[i];
						i++;
					}
				}
				else {
					motorsChar = motorList;
				}
			}
		
			while (sensorsChar.length == 0) {
				if (sensorList.length < 4) {
					sensorList[(sensorList.length)] = 'e';
				}
				else if (sensorList.length > 4) {
					int i = 0;
					while(i < 4) {
						sensorsChar[i] = sensorList[i];
						i++;
					}
				}
				else {
					sensorsChar = sensorList;
				}
			}
		
			int counter = 0;
			while (counter < 4) {
				if (sensorsChar[counter] != 'e') {
					sensors[counter] = new Sensor(sensorsChar[counter], counter + 1);
				}
				else {
					sensors[counter] = null;
				}
			
				if (motorsChar[counter] != 'e') {
					motors[counter] = new Motors(motorsChar[counter], changeToLetterPort(counter + 1));
				}
				else {
					motors[counter] = null;
			
				}
			}
		}
		catch (ParmeterNotInRange e){
			System.out.println(e);
			System.out.println("Class " + this.getClass() + " is have a parmeter problem it will not work");
			motors = null;
			sensors = null;
		}
	}
	private static char changeToLetterPort(int port) throws ParmeterNotInRange {
		switch(port) {
		case 1:
			return 'a';
		case 2:
			return 'b';
		case 3:
			return 'c';
		case 4:
			return 'd';
		default:
			throw new ParmeterNotInRange("Some how you port is not 1 to 4 in the letter changing state");
		}
	}

	private static int changeToNumberPort(char port) {
		switch(port) {
		case 'a':
			return 0;
		case 'b':
			return 1;
		case 'c':
			return 2;
		case 'd':
			return 3;
		default:
			return 0;
		}
	}
	
	public void runMotorDegrees(char port, int degrees, double speed) {
		 motors[changeToNumberPort(port)].TurnOnMotorsForDegrees(speed, degrees);
	}
	
	public double getValueForSensor(int port) {
		return sensors[port - 1].getValue();
	}
	
	public void setUpMotorSystem(char portOfMotor1, char portOfMotor2) {
		motorSystems[whichSystemOn] = new MotorsSystem(motors[changeToNumberPort(portOfMotor1)], motors[changeToNumberPort(portOfMotor2)]);
		whichSystemOn ++;
	}
	
	public void runMotorForASensorCondition(char motorPort, int sensorPort, double condition) {
		Thread motorRunner;
		Thread sensorRunner;
	}
}