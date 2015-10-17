package iot.shoppingnavigator.gui;

import java.util.Scanner;
import java.util.Vector;

import iot.shoppingnavigator.navigator.Navigator;
import iot.shoppingnavigator.realposition.RealPosition;



public class User implements Runnable{

	private Navigator navigator;
	private RealPosition real;
	
	public User(Navigator navigator, RealPosition real) {
		
		this.navigator = navigator;
		this.real = real;	
	}
	
	@Override
	public void run() {
		
        Scanner sc = new Scanner(System.in);
        Vector<String> options = null;
        while (true) {        	
        	String command = sc.nextLine();
        	
        	if (command.equals("w")) real.goUp();
        	else if (command.equals("d")) real.goRight();
        	else if (command.equals("s")) real.goDown();
        	else if (command.equals("a")) real.goLeft();
        	else if (command.equals("o")) {
        		options = navigator.getOptionFromCentral();
        		for (String s : options) System.out.println(s);
        	}
        	else if (command.equals("p")) {
            	int answer = sc.nextInt();
            	sc.nextLine();
        		navigator.sendAnswerToCentral(answer);
        	}
        
        	if (command.equals("w") || command.equals("d") || command.equals("s") || command.equals("a"))
        		System.out.println("Position ("+ real.getX() + ", " + real.getY() + ")");
        }
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
}
