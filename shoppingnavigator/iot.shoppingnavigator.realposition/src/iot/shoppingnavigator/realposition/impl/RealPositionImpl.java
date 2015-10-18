package iot.shoppingnavigator.realposition.impl;

import java.util.Random;

import iot.shoppingnavigator.realposition.RealPosition;

public class RealPositionImpl implements RealPosition, Runnable{

	double x, y;
	
	public RealPositionImpl() {
		x = 50;
		y = 50;
	}
	
	@Override
	public void run() {
		
		/*
		try {
			while (!Thread.currentThread().isInterrupted()) {
				Thread.sleep(1000);
				randomWalk();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}


	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public void goUp() {
		y += 1;
	}

	@Override
	public void goDown() {
		y -= 1;
	}

	@Override
	public void goLeft() {
		x -= 1;
	}

	@Override
	public void goRight() {
		x += 1;
	}


	
	public void randomWalk() {
		Random ger = new Random();
		int n = ger.nextInt(4);		
		if (n == 0) goUp();
		else if (n == 1) goDown();
		else if (n == 2) goLeft();
		else goRight();
	}

	
}
