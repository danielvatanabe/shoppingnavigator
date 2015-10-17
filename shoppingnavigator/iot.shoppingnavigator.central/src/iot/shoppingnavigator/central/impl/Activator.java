package iot.shoppingnavigator.central.impl;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import iot.shoppingnavigator.central.Central;

public class Activator implements BundleActivator {
    ServiceRegistration sensorRegistration;
	public void start(BundleContext context) throws Exception {
		final Dictionary<String, Object> props = new Hashtable<String, Object>();
		props.put(Central.ID, 1);
    	Central sensorService = new CentralImpl();
    	sensorRegistration = context.registerService(Central.class, sensorService, props);
    	
    	props.put(Central.ID, 2);
    	// progs.put(Sensor.X, 200)
    	// props.put(Sensor.Y, 240)
    	Central sensorService2 = new CentralImpl();
    	sensorRegistration = context.registerService(Central.class, sensorService2, props);   
    	
    	
		System.out.println("Sensors Regristered");

    	
    }
    public void stop(BundleContext context) throws Exception {
    	sensorRegistration.unregister();
    }
       
}