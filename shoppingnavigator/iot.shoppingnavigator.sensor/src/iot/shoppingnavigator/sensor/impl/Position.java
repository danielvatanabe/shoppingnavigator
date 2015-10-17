package iot.shoppingnavigator.sensor.impl;

public class Position {
	
	double x, y;
	
	public void Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	double getX() {
		return x;
	}
	double getY() {
		return y;
	}
	
}
