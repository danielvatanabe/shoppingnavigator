package iot.shoppingnavigator.bathroom.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import iot.shoppingnavigator.bathroom.Bathroom;

public class Activator implements BundleActivator  {
    ServiceRegistration bathroomService;
    public void start(BundleContext context) throws Exception {
    	System.out.println("example");
    	Bathroom bathroom = new BathroomImpl();
    	bathroomService = context.registerService(Bathroom.class.getName(), bathroom, null);
    }
    public void stop(BundleContext context) throws Exception {
    	bathroomService.unregister();
    }
}