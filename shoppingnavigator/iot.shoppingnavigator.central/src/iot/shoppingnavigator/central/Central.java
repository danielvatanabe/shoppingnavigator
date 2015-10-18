package iot.shoppingnavigator.central;

import java.util.Vector;

/**
 * The Interface Central.
 */
public interface Central {
	
	public static final String ID = "id";

	/**
	 * Gets the options.
	 *
	 * @param id the id
	 * @return the options
	 */
	public Vector<String> getOptions(int id);
	
	/**
	 * Receive answer.
	 *
	 * @param id the id
	 * @param answer the answer
	 */
	public void receiveAnswer(int id , String answer);
	
	
	
}
