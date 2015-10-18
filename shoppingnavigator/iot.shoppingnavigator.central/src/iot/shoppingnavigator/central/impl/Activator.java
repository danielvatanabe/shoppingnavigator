package iot.shoppingnavigator.central.impl;

import java.util.Collection;
import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import iot.shoppingnavigator.central.Central;
import iot.shoppingnavigator.restaurant.Restaurant;

/**
 * The Class Activator.
 */
public class Activator implements BundleActivator {
    ServiceRegistration sensorRegistration;
	public void start(BundleContext context) throws Exception {
		
		final Dictionary<String, Object> props = new Hashtable<String, Object>();
		
		//get references from restaurants
    	Collection<ServiceReference<Restaurant>> restaurantRefs = context.getServiceReferences(Restaurant.class,null);
		
		props.put(Central.ID, 1);		
    	Central centralService = new CentralImpl(restaurantRefs, context);
    	context.registerService(Central.class, centralService, props);
    	
    }
    public void stop(BundleContext context) throws Exception {
    	sensorRegistration.unregister();
    }
       
}