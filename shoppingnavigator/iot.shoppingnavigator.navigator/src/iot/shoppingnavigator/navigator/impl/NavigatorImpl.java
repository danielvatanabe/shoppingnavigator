package iot.shoppingnavigator.navigator.impl;


import java.util.Vector;

import iot.shoppingnavigator.central.Central;
import iot.shoppingnavigator.navigator.Navigator;

// TODO: Auto-generated Javadoc
/**
 * The Class NavigatorImpl.
 */
public class NavigatorImpl implements Navigator{
	
    /** The central. */
    private Central central;
    
    /** The navigator position. */
    private NavigatorPosition navigatorPosition;

    /** The id. */
    private int id;

	/**
	 * Instantiates a new navigator impl.
	 *
	 * @param central the central
	 * @param navigatorPosition the navigator position
	 */
	NavigatorImpl(Central central, NavigatorPosition navigatorPosition) {
		this.central = central;
		this.navigatorPosition = navigatorPosition;
	}
	
	@Override
	public void run() {
		
		Thread threadNav = new Thread(navigatorPosition);
		threadNav.start();
       
	}
	
	public double getX(){
		return navigatorPosition.getX();
	}
	
	/* (non-Javadoc)
	 * @see iot.shoppingnavigator.navigator.Navigator#getY()
	 */
	public double getY(){
		return navigatorPosition.getY();
	}

	/* (non-Javadoc)
	 * @see iot.shoppingnavigator.navigator.Navigator#getOptionFromCentral()
	 */
	@Override
	public Vector<String> getOptionFromCentral() {		
		return central.getOptions(id);
	}
	
	/* (non-Javadoc)
	 * @see iot.shoppingnavigator.navigator.Navigator#sendAnswerToCentral(java.lang.String)
	 */
	public void sendAnswerToCentral(String answer) {		
		central.receiveAnswer(id, answer);
	}
	
}
