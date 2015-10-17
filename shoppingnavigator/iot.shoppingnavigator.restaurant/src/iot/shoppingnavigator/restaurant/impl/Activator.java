package iot.shoppingnavigator.restaurant.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import iot.shoppingnavigator.restaurant.Restaurant;

public class Activator implements BundleActivator  {
    ServiceRegistration restaurantService;
    public void start(BundleContext context) throws Exception {
    	System.out.println("example");
    	Restaurant restaurant = new RestaurantImpl();
    	restaurantService = context.registerService(Restaurant.class.getName(), restaurant, null);
    }
    public void stop(BundleContext context) throws Exception {
    	restaurantService.unregister();
    }
}