package iot.shoppingnavigator.sensor.impl;

import iot.shoppingnavigator.realposition.RealPosition;
import iot.shoppingnavigator.sensor.Sensor;

public class SensorImpl implements Sensor{
	
	final RealPosition real;
	final double x, y;
	
	public SensorImpl(RealPosition real, double x, double y) {
		this.real = real;
		this.x = x;
		this.y = y;
	}
	
	
	public void printSensorLocation() {
		System.out.println(x + " " + y);
	}
	@Override
	public double[] getNavPosition(int navId) {
		double[] pos = new double[2];
		pos[0] = real.getX();
		pos[1] = real.getY();
		return pos;
	}


	
}
