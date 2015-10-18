package iot.shoppingnavigator.restaurant;

import java.util.Vector;

import iot.shoppingnavigator.util.Establishment;

public interface Restaurant extends Establishment{

	final String NAME = "name";
	final String X = "x";
	final String Y = "y";

	public Vector<String> getMenu();
	public void addMenu(String dish);
	
}
