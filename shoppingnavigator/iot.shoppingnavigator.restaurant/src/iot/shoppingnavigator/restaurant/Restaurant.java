package iot.shoppingnavigator.restaurant;

import java.util.Vector;

/**
 * The Interface Restaurant.
 */
public interface Restaurant{
	
	final public String NAME = "name";
	final public String X = "x";
	final public String Y = "y";
	
	public String getName();
	
	public void setName(String Name);
	
	public double[] getPosition();
			
	public void setOpen(boolean open);
	
	public boolean isItOpen();
		
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
