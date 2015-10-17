package iot.shoppingnavigator.navigator;

import java.util.Vector;

public interface Navigator extends Runnable {
	public default void run() {}
	public double getX();
	public double getY();
	
	public Vector<String> getOptionFromCentral();
	public void sendAnswerToCentral(String answer);
	
}
