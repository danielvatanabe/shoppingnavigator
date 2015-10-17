package iot.shoppingnavigator.realposition;

public interface RealPosition extends Runnable{
	
	public double getX();
	public double getY();
	public void goUp();
	public void goDown();
	public void goLeft();
	public void goRight();

}
