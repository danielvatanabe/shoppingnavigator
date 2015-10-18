package iot.shoppingnavigator.realposition.impl;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import iot.shoppingnavigator.realposition.RealPosition;


public class Activator implements BundleActivator  {
    ServiceRegistration<RealPosition> realPostionService;
    
    public void start(BundleContext context) throws Exception {
    
    	RealPosition realPostion = new RealPositionImpl();
    	realPostionService = context.registerService(RealPosition.class, realPostion, null);
    	
    	
    	Thread threadNav = new Thread(realPostion);
		threadNav.start();
    }
    public void stop(BundleContext context) throws Exception {
    	realPostionService.unregister();
    }
     
}