package iot.shoppingnavigator.obstacle;

public interface Obstacle {
	
	public double[] getPosNearOrigin();
	public double[] getPosFarOrigin();

	public String Description();

}
