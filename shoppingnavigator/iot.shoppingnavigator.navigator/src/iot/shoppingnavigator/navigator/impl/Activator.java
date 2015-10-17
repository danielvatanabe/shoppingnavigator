package iot.shoppingnavigator.navigator.impl;

import java.util.Collection;

import org.eclipse.osgi.framework.console.CommandInterpreter;
import org.eclipse.osgi.framework.console.CommandProvider;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import iot.shoppingnavigator.navigator.Navigator;
import iot.shoppingnavigator.sensor.Sensor;
import iot.shoppingnavigator.central.Central;


public class Activator implements BundleActivator  {
    ServiceRegistration navigatorRegistration;
    private ServiceReference centralReference;
    private Sensor sensor;
    private Central central;

    public void start(BundleContext context) throws Exception {		

    	//get sensors
    	Collection<ServiceReference<Sensor>> sensorRefs = context.getServiceReferences(Sensor.class,null);
        //get central
    	centralReference = context.getServiceReference(Central.class.getName());
        central = (Central) context.getService(centralReference);
		
    	NavigatorPosition navigatorPosition = new NavigatorPosition(context, sensorRefs);

        //register navigator
        Navigator navigatorService = new NavigatorImpl(central, navigatorPosition);
    	navigatorRegistration =context.registerService(Navigator.class.getName(), navigatorService, null);
    	System.out.println("qwert Navigator Regristered");
		
    	
		Thread threadNav = new Thread(navigatorService);
		threadNav.start();
    }
    public void stop(BundleContext context) throws Exception {
    	navigatorRegistration.unregister();
    }
    
    
	public void _sensorNavPostion(CommandInterpreter ci) {
		System.out.println("sensorNavPostion command:");
	}  
}