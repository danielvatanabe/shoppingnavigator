package iot.shoppingnavigator.central.impl;

import java.util.Collection;
import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import iot.shoppingnavigator.bathroom.Bathroom;
import iot.shoppingnavigator.central.Central;
import iot.shoppingnavigator.restaurant.Restaurant;
import iot.shoppingnavigator.store.Store;

public class Activator implements BundleActivator {
	public void start(BundleContext context) throws Exception {
		
		final Dictionary<String, Object> props = new Hashtable<String, Object>();
		
		//get references from restaurants and stores and bathroom
    	Collection<ServiceReference<Restaurant>> restaurantRefs = context.getServiceReferences(Restaurant.class,null);
    	Collection<ServiceReference<Store>> storeRefs = context.getServiceReferences(Store.class,null);
    	Collection<ServiceReference<Bathroom>> bathroomRefs = context.getServiceReferences(Bathroom.class,null);

		props.put(Central.ID, 1);		
    	Central centralService = new CentralImpl(restaurantRefs, storeRefs, bathroomRefs, context);
    	context.registerService(Central.class, centralService, props);
    	
    }
    public void stop(BundleContext context) throws Exception {
    }
       
}