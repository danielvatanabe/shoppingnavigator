package iot.shoppingnavigator.obstacle.impl;

import iot.shoppingnavigator.obstacle.Obstacle;

public class ObstacleImpl implements Obstacle{

	
	double xN, yN, xF, yF;
	String description;
	
	public ObstacleImpl(double xN, double yN, double xF, double yF, String description) {
		this.xN = xN;
		this.yN = yN;
		this.xF = xF;
		this.yF = yF;
		this.description = description;
	}
	
	public double[] getPosNearOrigin() {
		return new double[] {xN, yN};
	}

	public double[] getPosFarOrigin() {
		return new double[] {xF, yF};
	}

	public String Description() {
		return description;
	}
}
