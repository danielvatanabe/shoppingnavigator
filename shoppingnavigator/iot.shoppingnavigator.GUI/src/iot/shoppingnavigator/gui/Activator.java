package iot.shoppingnavigator.gui;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import iot.shoppingnavigator.navigator.Navigator;
import iot.shoppingnavigator.realposition.RealPosition;

public class Activator implements BundleActivator {
    ServiceRegistration<User> userService;
    private ServiceReference navigatorReference, realPositionReference;
    private Navigator navigator;
    private RealPosition real;

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		
    	navigatorReference = context.getServiceReference(Navigator.class.getName());
        navigator = (Navigator) context.getService(navigatorReference);
        
		realPositionReference = context.getServiceReference(RealPosition.class.getName());
        real = (RealPosition) context.getService(realPositionReference);
        
		User user = new User(navigator, real);
		userService = context.registerService(User.class, user, null);
		
		Thread threadUser = new Thread(user);
		threadUser.start();
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		System.out.println("Goodbye World!!");
	}

}
