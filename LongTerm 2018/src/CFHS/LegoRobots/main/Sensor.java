package CFHS.LegoRobots.main;

import lejos.hardware.sensor.*;
import lejos.robotics.SampleProvider;
import lejos.hardware.BrickFinder;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.*;

interface Sensor{
	public double getValue();

}


//class TouchSensor implements Sensor{
//	public TouchSensor (int port) {
//		
//	}
//}

class ColorSensor implements Sensor {
	private EV3ColorSensor colorSensor;
	public ColorSensor (int port) {
		colorSensor = new EV3ColorSensor(null);
	}
	public double getValue() {
		return colorSensor.getColorID();
	}
}	

class GyroSensor implements Sensor {
	private EV3GyroSensor gyroSensor;
	private float[] sample;
	private SampleProvider gyroReader;
	
	public GyroSensor (int port) {
		gyroSensor = new EV3GyroSensor(null);
		gyroSensor.reset();
		gyroReader = gyroSensor.getAngleMode();
		sample = new float[gyroReader.sampleSize()];
	}
	public double getValue() {
		gyroSensor.fetchSample(sample, 0);
		return sample[0];
	}

	public String getPort();

}


private class Port{
	private SensorPort portSensor;
	public Port(int port) {
		switch (port) {
		case 1:
			portSensor = SensorPort.S1;
			break;
		case 2:
			portSensor = SensorPort.S2;
			break;
		case 3:
			portSensor = (SensorPort) SensorPort.S3;
			break;
		case 4:
			portSensor = SensorPort.S4;
			break;
		default:
			System.out.print("Given port does not exist. Assuming 1")
			portSensor = SensorPort.S1;
		}

class PortForSensors{
	private lejos.hardware.port.Port port;
	private String whichPort;
	public PortForSensors(int portPlace) {
		switch (portPlace) {
			case 1:
				whichPort = "S1";
				break;
			
			case 2:
				whichPort = "S2";
				break;
			
			case 3:
				whichPort = "S3";
				break;
			
			case 4:
				whichPort = "S4";
				break;
		
			default:
				System.out.print("Given port does not exist. Assuming 1");
				whichPort = "S1";
			}
		port = BrickFinder.getDefault().getPort(whichPort);
	}
	
	public lejos.hardware.port.Port getPort() {
		return port;
	}
	
	public String getPortString() {
		return whichPort;
	}


}
class TouchSensor implements Sensor{

	private EV3TouchSensor touch;

	private EV3TouchSensor touchSensor;
	private PortForSensors wPort;
	private SensorMode touch;
	private float[] sample;
	

	public TouchSensor(int port) {

		Port wPort = new Port(port);
		touch = new EV3TouchSensor(wPort);

		wPort = new PortForSensors(port);
		touchSensor = new EV3TouchSensor(wPort.getPort());
		touch = touchSensor.getTouchMode();
		sample = new float[touch.sampleSize()];

	}
	public double getValue() {
		touch.fetchSample(sample, 0);
		return sample[0];
	}
	
	public String getPort() {
		return wPort.getPortString();

	}
}
class ColorSensor implements Sensor {
	private EV3ColorSensor colorSensor;
	private PortForSensors wPort;
	public ColorSensor (int port) {
		wPort = new PortForSensors(port);
		colorSensor = new EV3ColorSensor(wPort.getPort());
	}
	public double getValue() {
		return colorSensor.getColorID();
	}
	
	public String getPort() {
		return wPort.getPortString();
	}
}

class GyroSensor implements Sensor {
	private EV3GyroSensor gyroSensor;
	private float[] sample;
	private SampleProvider gyroReader;
	private PortForSensors wPort;
	
	public GyroSensor (int port) {
		wPort = new PortForSensors(port);
		gyroSensor = new EV3GyroSensor(wPort.getPort());
		gyroSensor.reset();
		gyroReader = gyroSensor.getAngleMode();
		sample = new float[gyroReader.sampleSize()];
	}
	
	public double getValue() {
		gyroSensor.fetchSample(sample, 0);
		return sample[0];
	}
	
	public String getPort() {
		return wPort.getPortString();
	}
}
