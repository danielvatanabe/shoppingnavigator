package iot.shoppingnavigator.restaurant;

import java.util.Vector;

public interface Restaurant{
	
	final public String NAME = "name";
	final public String X = "x";
	final public String Y = "y";
	
	public String getName();
	
	public void setName(String Name);
	
	public double[] getPosition();
			
	public void setOpen(boolean open);
	
	public boolean isItOpen();
	
	public Vector<String> getMenu();
	
	public void addMenu(String dish);
	
}
