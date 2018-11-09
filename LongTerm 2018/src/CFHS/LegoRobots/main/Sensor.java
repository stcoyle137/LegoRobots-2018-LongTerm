package CFHS.LegoRobots.main;

import java.lang.reflect.Array;

import lejos.hardware.sensor.*;
import lejos.robotics.SampleProvider;


import lejos.hardware.Brick;
import lejos.hardware.BrickFinder;
import lejos.hardware.sensor.*;

interface Sensor{
	public double getValue();
}


class TouchSensor implements Sensor{
	public TouchSensor (int port) {
		
	}
}

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
}

private class Port{
	private SensorPort port;
	public Port(int port) {
		switch (port) {
		case 1:
			port = SensorPort.S1;
			break;
		case 2:
			port = SensorPort.S2;
			break;
		case 3:
			port = SensorPort.S3;
			break;
		case 4:
			port = SensorPort.S4;
			break;
		default:
			System.out.print("Given port does not exist. Assuming 1")
			port = SensorPort.S1;
		}

	};
}
class TouchSensor implements Sensor{
	public TouchSensor(int port) {
		Port wPort = new Port(port);
		EV3TouchSensor = new EV3TouchSensor(wPort);
	}
}
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
}
