package iot.shoppingnavigator.bundleexample.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import iot.shoppingnavigator.bundleexample.BundleExample;

public class Activator implements BundleActivator  {
    ServiceRegistration BundleExample;
    public void start(BundleContext context) throws Exception {
    	System.out.println("example");
    	BundleExample bundleExample = new BundleExampleImpl();
    	BundleExample =context.registerService(BundleExample.class.getName(), bundleExample, null);
    }
    public void stop(BundleContext context) throws Exception {
    	BundleExample.unregister();
    }
}