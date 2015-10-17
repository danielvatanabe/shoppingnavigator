package iot.shoppingnavigator.store.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import iot.shoppingnavigator.store.Store;

public class Activator implements BundleActivator  {
    ServiceRegistration storeService;
    public void start(BundleContext context) throws Exception {
    	System.out.println("example");
    	Store store = new StoreImpl();
    	storeService = context.registerService(Store.class.getName(), store, null);
    }
    public void stop(BundleContext context) throws Exception {
    	storeService.unregister();
    }
}