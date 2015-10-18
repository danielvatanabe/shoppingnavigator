package iot.shoppingnavigator.navigator.impl;

import java.util.Collection;
import java.util.Vector;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import iot.shoppingnavigator.sensor.Sensor;

/**
 * The Class NavigatorPosition.
 */
public class NavigatorPosition implements Runnable{
	
	private Collection<ServiceReference<Sensor>> sensorRefs;
	private BundleContext context;

    private double navX, navY;
    private final long refreshTime = 500; // miliseconds
    private final double  maxRangeBeforeRefresh= 5/refreshTime;

	NavigatorPosition(BundleContext context, Collection<ServiceReference<Sensor>> sensorRefs) {
		this.context = context;
		this.sensorRefs = sensorRefs;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			while (!Thread.currentThread().isInterrupted()) {
				Thread.sleep((long) refreshTime);
				refreshNavigatorPos();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Refresh navigator pos.
	 *
	 * @return the boolean
	 */
	public Boolean refreshNavigatorPos() {
		Vector<Double> vx = new Vector<Double>();
		Vector<Double> vy = new Vector<Double>();

		Sensor sensor;
		//find all sensors nearby
		for (final ServiceReference<Sensor> sensorRef : sensorRefs) {
			double sx = (double) sensorRef.getProperty(Sensor.X);
			double sy = (double) sensorRef.getProperty(Sensor.Y);
			double srange = (double) sensorRef.getProperty(Sensor.RANGE);

			if (Math.abs(sx - navX) <= srange && Math.abs(sy - navY) <= srange) {
				sensor = (Sensor) context.getService(sensorRef);
	            double[] aux_pos = sensor.getNavPosition(0);
	            vx.addElement(aux_pos[0]);
	            vy.addElement(aux_pos[1]);     
			}
    	}

		if (vx.isEmpty()) return false;	
		//System.out.println(this.navX + "   " + this.navY);

		//simple start algorithm, assign the position found for the first sensor
		this.navX = vx.get(0);
		this.navY = vy.get(0);
		
		return true;
	}
	
	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	double getX(){
		return navX;
	}
	
	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	double getY(){
		return navY;
	}

}
