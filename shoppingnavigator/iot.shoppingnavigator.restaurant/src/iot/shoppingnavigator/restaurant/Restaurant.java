package iot.shoppingnavigator.restaurant;

import java.util.Vector;

import iot.shoppingnavigator.util.Establishment;

/**
 * The Interface Restaurant.
 */
public interface Restaurant extends Establishment{

	final String NAME = "name";
	final String X = "x";
	final String Y = "y";

	/**
	 * Gets the menu.
	 *
	 * @return the menu
	 */
	public Vector<String> getMenu();
	
	/**
	 * Adds the menu.
	 *
	 * @param dish the dish
	 */
	public void addMenu(String dish);
	
}
