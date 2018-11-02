package CFHS.LegoRobots.main;

import lejos.hardware.Brick;
import lejos.hardware.BrickFinder;
import lejos.hardware.sensor.*;

interface Sensor{
	public double getValue();
}
private class Port{
	public Port(int port)
}
class TouchSensor implements Sensor{
	public TouchSensor(int port) {
		Brick brick = BrickFinder.getDefault();
	    lejos.hardware.port.Port  = brick.getPort("S4");
		EV3TouchSensor = new EV3TouchSensor();
	}
}