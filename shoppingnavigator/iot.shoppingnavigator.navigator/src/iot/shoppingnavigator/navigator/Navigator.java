package iot.shoppingnavigator.navigator;

import java.util.Vector;

/**
 * The Interface Navigator.
 */
public interface Navigator extends Runnable {
	
	public default void run() {}
	
	/**
	 * Gets the option from central.
	 *
	 * @return the option from central
	 */
	public Vector<String> getOptionFromCentral();
	
	/**
	 * Send answer to central.
	 *
	 * @param answer the answer
	 */
	public void sendAnswerToCentral(String answer);
	public void sendPositionToCentral();

}
