package iot.shoppingnavigator.sensor;

public interface Sensor {
	
	public static final String ID = "id";
	public static final String X = "x";
	public static final String Y = "y";
	public static final String RANGE = "range";


	public void printSensorLocation();
	
	public double[] getNavPosition(int navId);
	
}
