package iot.shoppingnavigator.realposition.impl;

import java.util.Dictionary;

import org.eclipse.osgi.framework.console.CommandInterpreter;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
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
    
    
	public void _sensorNavPostion(CommandInterpreter ci) {
		System.out.println("sensorNavPostion command:");
	}  
}