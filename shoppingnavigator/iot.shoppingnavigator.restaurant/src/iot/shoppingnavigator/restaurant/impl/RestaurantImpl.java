package iot.shoppingnavigator.restaurant.impl;

import java.util.Vector;

import iot.shoppingnavigator.restaurant.Restaurant;
import iot.shoppingnavigator.util.EstablishmentImpl;

/**
 * The Class RestaurantImpl.
 */
public class RestaurantImpl extends EstablishmentImpl implements Restaurant{

	String name;
	boolean open;
	double[] pos = new double[2];
	
	Vector<String> menu;
	
	/**
	 * Instantiates a new restaurant impl.
	 *
	 * @param name the name
	 * @param x the position
	 * @param y the position
	 */
	public RestaurantImpl(String name, double x, double y) {
		super(name, x, y);	
		menu = new Vector<String>();
	}
	@Override
	public Vector<String> getMenu() {
		return menu;
	}
	
	@Override
	public void addMenu(String dish) {
		menu.add(dish);
	}
}
