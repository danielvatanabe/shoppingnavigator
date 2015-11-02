package iot.shoppingnavigator.obstacle.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import iot.shoppingnavigator.obstacle.Obstacle;

public class Activator implements BundleActivator  {

	public void start(BundleContext context) throws Exception {
		
    	Obstacle obstacle = new ObstacleImpl(22, 15, 25, 17, "Piano");
    	context.registerService(Obstacle.class.getName(), obstacle, null);
    	
    }
    public void stop(BundleContext context) throws Exception {
    }
}