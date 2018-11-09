package CFHS.LegoRobots.main;

import lejos.hardware.Brick;
import lejos.hardware.BrickFinder;
import lejos.hardware.sensor.*;

interface Sensor{
	public double getValue();
}
private class Port{
	private SensorPort p;
	public Port(int port) {
		switch (port) {
		case 1:
			p
		}
	};
}
class TouchSensor implements Sensor{
	public TouchSensor(int port) {
		Brick brick = BrickFinder.getDefault();
	    lejos.hardware.port.Port  = brick.getPort("S4");
		EV3TouchSensor = new EV3TouchSensor();
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
