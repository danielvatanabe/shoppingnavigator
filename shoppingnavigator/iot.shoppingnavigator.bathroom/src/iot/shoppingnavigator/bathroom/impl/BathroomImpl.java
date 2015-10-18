package iot.shoppingnavigator.bathroom.impl;

import iot.shoppingnavigator.bathroom.Bathroom;

public class BathroomImpl implements Bathroom{

	int id;
	double[] position = new double[2];
	boolean open;
	String gender;
	
	public BathroomImpl(int id, double x, double y, String gender) {
		this.position[0] = x;
		this.position[1] = y;
		this.open = true;
		this.gender = gender;
	}
	
	@Override
	public int getId() {
		return id;
	}
	
	public String getGender() {
		return this.gender;
	}


	@Override
	public double[] getPosition() {
		return position;
	}

	@Override
	public void setOpen(boolean open) {
		this.open = open;
	}

	@Override
	public boolean isItOpen() {
		return open;
	}
	
}
