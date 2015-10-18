package iot.shoppingnavigator.bathroom;

public interface Bathroom {
	
	final public String ID = "id";
	final public String X = "x";
	final public String Y = "y";
	final public String GENDER = "gender";

	
	public int getId();
		
	public String getGender();

	public double[] getPosition();
			
	public void setOpen(boolean open);
	
	public boolean isItOpen();
}
