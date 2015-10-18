package iot.shoppingnavigator.store.impl;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import iot.shoppingnavigator.store.Store;

public class Activator implements BundleActivator  {
    public void start(BundleContext context) throws Exception {
    	
        final Dictionary<String, Object> props = new Hashtable<String, Object>();
        
		props.put(Store.NAME, "NaModa");
		props.put(Store.X, 95.0);
		props.put(Store.X, 50.0);
    	Store store = new StoreImpl("NaModa", "Clothes",95, 50);
    	store.addPromotion("Cool T-Shirt: $30");
		context.registerService(Store.class.getName(), store, props);
    	
    }
    public void stop(BundleContext context) throws Exception {
    }
}