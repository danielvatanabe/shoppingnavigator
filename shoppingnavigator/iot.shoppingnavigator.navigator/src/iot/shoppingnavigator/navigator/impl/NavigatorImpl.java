package iot.shoppingnavigator.navigator.impl;

import java.util.Collection;
import java.util.Scanner;
import java.util.Vector;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import iot.shoppingnavigator.central.Central;
import iot.shoppingnavigator.navigator.Navigator;
import iot.shoppingnavigator.sensor.Sensor;

public class NavigatorImpl implements Navigator{
	
	private Collection<ServiceReference<Sensor>> sensorRefs;
	private BundleContext context;
    private Central central;
    private NavigatorPosition navigatorPosition;

    private int id;

	NavigatorImpl(BundleContext context, Central central, Collection<ServiceReference<Sensor>> sensorRefs) {
		this.context = context;
		this.central = central;
		this.sensorRefs = sensorRefs;
		this.navigatorPosition = new NavigatorPosition(context, sensorRefs);
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
	public void sendAnswerToCentral(int answer) {		
		central.receiveAnswer(id, answer);
	}
	
}
