package iot.shoppingnavigator.restaurant.impl;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import iot.shoppingnavigator.restaurant.Restaurant;

public class Activator implements BundleActivator  {
    ServiceRegistration restaurantService;
    Restaurant restaurant;
    
    public void start(BundleContext context) throws Exception {

        final Dictionary<String, Object> props = new Hashtable<String, Object>();
        
		props.put(Restaurant.NAME, "FastFood");
		props.put(Restaurant.X, 5.0);
		props.put(Restaurant.Y, 95.0);
    	restaurant = new RestaurantImpl("FastFood", 5, 95);
    	restaurant.addMenu("Hambuguer: $10");
    	restaurant.addMenu("French Fries: $15");
    	context.registerService(Restaurant.class.getName(), restaurant, props);
    	
		props.put(Restaurant.NAME, "Japanese Food");
		props.put(Restaurant.X, 15.0);
		props.put(Restaurant.Y, 95.0);
    	restaurant = new RestaurantImpl("Japanese Food", 10, 95);
    	restaurant.addMenu("Sushi: $3");
    	restaurant.addMenu("Yakisoba: $15");
    	context.registerService(Restaurant.class.getName(), restaurant, props);
    	
		props.put(Restaurant.NAME, "Vegetarian");
		props.put(Restaurant.X, 25.0);
		props.put(Restaurant.Y, 95.0);
    	restaurant = new RestaurantImpl("Vegetarian", 25, 95);
    	restaurant.addMenu("Salad: $10");
    	restaurant.addMenu("Soy Meat: $12");
    	context.registerService(Restaurant.class.getName(), restaurant, props);
    }
    public void stop(BundleContext context) throws Exception {
    	restaurantService.unregister();
    }
}