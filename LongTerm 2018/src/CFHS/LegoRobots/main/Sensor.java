package CFHS.LegoRobots.main;

import java.lang.reflect.Array;

import lejos.hardware.sensor.*;
import lejos.robotics.SampleProvider;

//please work

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