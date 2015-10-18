package iot.shoppingnavigator.store;

import java.util.Vector;

public interface Store{
	
	final public String NAME = "name";
	final public String X = "x";
	final public String Y = "y";
	
	public String getName();
	
	public String getType();

	public void setName(String Name);
	
	public double[] getPosition();
			
	public void setOpen(boolean open);
	
	public boolean isItOpen();
	
	public Vector<String> getPromotions();
	
	public void addPromotion(String... args);
	
}
