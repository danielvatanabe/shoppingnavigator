package iot.shoppingnavigator.navigator.impl;


import java.util.Vector;

import iot.shoppingnavigator.central.Central;
import iot.shoppingnavigator.navigator.Navigator;

public class NavigatorImpl implements Navigator{
	
    private Central central;
    private NavigatorPosition navigatorPosition;

    private int id;

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
	
	public double getY(){
		return navigatorPosition.getY();
	}

	@Override
	public Vector<String> getOptionFromCentral() {		
		return central.getOptions(id);
	}
	public void sendAnswerToCentral(String answer) {		
		central.receiveAnswer(id, answer);
	}
	public void sendPositionToCentral() {		
		central.receivePosition(id, navigatorPosition.getPosition());
	}

	
}
