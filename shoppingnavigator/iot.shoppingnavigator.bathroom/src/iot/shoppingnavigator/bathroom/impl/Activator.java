package iot.shoppingnavigator.bathroom.impl;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import iot.shoppingnavigator.bathroom.Bathroom;

public class Activator implements BundleActivator  {
    public void start(BundleContext context) throws Exception {

    	Bathroom bathroom;
    	
        final Dictionary<String, Object> props = new Hashtable<String, Object>();
        
		props.put(Bathroom.ID, 1);
		props.put(Bathroom.X, 95.0);
		props.put(Bathroom.Y, 5.0);
		props.put(Bathroom.GENDER, "Man");
		bathroom = new BathroomImpl(1, 95, 5, "Man");
    	context.registerService(Bathroom.class.getName(), bathroom, props);
    	
		props.put(Bathroom.ID, 1);
		props.put(Bathroom.X, 95.0);
		props.put(Bathroom.Y, 10.0);
		props.put(Bathroom.GENDER, "Woman");
		bathroom = new BathroomImpl(2, 95, 10, "Woman");
		
    	context.registerService(Bathroom.class.getName(), bathroom, props);
    	
    }
    public void stop(BundleContext context) throws Exception {
    }
}