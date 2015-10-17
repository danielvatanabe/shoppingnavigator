package iot.shoppingnavigator.central;

import java.util.Vector;

public interface Central {
	
	public static final String ID = "id";

	public Vector<String> getOptions(int id);
	public void receiveAnswer(int id , String answer);
	
	
	
}
