package CFHS.LegoRobots.main;

public class Robot {
	private Sensor[] sensors = new Sensor[4];
	private Motors[] motors = new Motors[4];
	private MotorsSystem motorSystem;
	/**
	 * @param sensors is a string with length of 4 Used charators for sensors
	 * 'e' for a empty port
	 * 't' for a touch sensor
	 * 'c' for a color sensor
	 * 'g' for a gyro sensor
	 * @param Used charators for motors
	 * 'e' for a empty port
	 * 'm' for a medium motor
	 * 'l' for a large motor
	 */
	public Robot(String sensor, String motor) {
		try {
			while(sensor.length() < 4) {
				sensor += "e";
			}
			
			while(motor.length() < 4) {
				motor += "e";
			}
			
			int counter = 0;
			while (counter < 4) {
				if (sensor.charAt(counter) != 'e') {
					sensors[counter] = new Sensor(sensor.charAt(counter), counter + 1);
				}
			
				if (motor.charAt(counter) != 'e') {
					motors[counter] = new Motors(motor.charAt(counter), changeToLetterPort(counter + 1));
				}
				counter ++;
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
	
	public void turnOnMotor(char port, double speed) {
		 motors[changeToNumberPort(port)].TurnOnMotors(speed);
	}
	
	public void stopMotor(char port) {
		motors[changeToNumberPort(port)].stopMotor();
	}
	
	public double getValueForSensor(int port) {
		return sensors[port - 1].getValue();
	}
	
	public void setUpMotorSystem(char portOfMotor1, char portOfMotor2) {
		if(motorSystem == null) {	
			motorSystem = new MotorsSystem(motors[changeToNumberPort(portOfMotor1)], motors[changeToNumberPort(portOfMotor2)]);
		}
	}
	
	public void runSyncMotor(double powerOfMotor1, double powerOfMotor2) {
		if(motorSystem != null) {
			motorSystem.turnOnSyncMotors(powerOfMotor1, powerOfMotor2);
		}
	}
	public void runSyncMotorDegrees(double powerOfMotor1, int degreesOfMotor1, double powerOfMotor2, int degreesOfMotor2) {
		if(motorSystem != null) {
			motorSystem.runInSyncWithDegrees(powerOfMotor1, degreesOfMotor1, powerOfMotor2, degreesOfMotor2);
		}
	}
	public void stopSyncMotor() {
		if(motorSystem != null) {
			motorSystem.stopSyncMotors();
		}
	}
	public void resetSensor(int port) {
		sensors[port - 1].reset();		
	}
}