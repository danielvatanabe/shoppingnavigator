package iot.shoppingnavigator.sensor.impl;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import iot.shoppingnavigator.realposition.RealPosition;
import iot.shoppingnavigator.sensor.Sensor;

public class Activator implements BundleActivator {
    ServiceRegistration sensorRegistration;
    private ServiceReference realPositionReference;
    private RealPosition real;

	public void start(BundleContext context) throws Exception {
		
		realPositionReference = context.getServiceReference(RealPosition.class.getName());
        real = (RealPosition) context.getService(realPositionReference);
		
        
        final Dictionary<String, Object> props = new Hashtable<String, Object>();
		int gridSizeX = 100;
		int gridSizeY = 100;
		int sensorRange = 25;
		int id = 1;
		
		for (int i = 1; i <= gridSizeX/sensorRange; ++i) {
			for (int j = 1; j <= gridSizeY/sensorRange; ++j) {
				props.put(Sensor.ID, id);
				props.put(Sensor.X, (double)i*sensorRange);
		    	props.put(Sensor.Y, (double)j*sensorRange);
		    	props.put(Sensor.RANGE, (double)sensorRange);
		    	Sensor sensorService = new SensorImpl(real, i*sensorRange, j*sensorRange);
		    	context.registerService(Sensor.class, sensorService, props);
				id++;
			}
		}

        
         
    	
    	
		System.out.println("Sensors Regristered");

    	
    }
    public void stop(BundleContext context) throws Exception {
    	sensorRegistration.unregister();
    }
       
}