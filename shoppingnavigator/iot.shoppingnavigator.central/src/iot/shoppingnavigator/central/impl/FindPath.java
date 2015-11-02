package iot.shoppingnavigator.central.impl;

import java.util.Collection;
import java.util.Vector;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import iot.shoppingnavigator.obstacle.Obstacle;

public class FindPath {

	private BundleContext context;
	Collection<ServiceReference<Obstacle>> obstacleRefs;
	int[][] map;
	
	public FindPath(Collection<ServiceReference<Obstacle>> obstacleRefs, int[][] map, BundleContext context) {
		this.obstacleRefs = obstacleRefs;
		this.map = map;
		this.context = context;
	}
	
	public Vector<String> findWay(double[] positionNavigator, double[] positionToGo) {
		Obstacle obstacle;
		double[][] nearPos = new double[obstacleRefs.size()][2];
		double[][] farPos = new double[obstacleRefs.size()][2];

		int i = 0;
		for (final ServiceReference<Obstacle> obstacleRefs : obstacleRefs) {
				obstacle = (Obstacle) context.getService(obstacleRefs);	
				nearPos[i] = obstacle.getPosNearOrigin();
				farPos[i++] = obstacle.getPosFarOrigin();
		}
		return null;
	}
	public Vector<String> findWay(double[] positionNavigator, Vector<double[]> positionToGo) {
		return null;		
	}
	
}
