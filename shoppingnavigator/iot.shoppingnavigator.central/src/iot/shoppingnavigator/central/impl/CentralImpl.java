package iot.shoppingnavigator.central.impl;

import java.util.Vector;

import iot.shoppingnavigator.central.Central;

public class CentralImpl implements Central{
	
	
	int state;
	CentralImpl() {
		state = 0;
	}

	@Override
	public Vector<String> getOptions(int id) {
		
		Vector<String> options = new Vector<String>();
		switch (state) {
			case 0:
				//initial state
			    System.out.println("Welcome to the Smart Shopping Center");
			    options.add("1-Bathroom");
			    options.add("2-Food");
			    options.add("3-Shopping");			
			    break;
			case 100:
				//type of restaurants
				options.add("1-Fast Food");
			    options.add("2-Japanese Food");
			    options.add("3-Vegetarian");	
			    break;
			case 101:
				//type of restaurants
				options.add("Fast Food: Has Hamburguer and French Fries for $10");
			    break;
			case 102:
				//type of restaurants
			    options.add("Japanese Food: Sushi and Sashimi for $34");
			    break;
			case 103:
				//type of restaurants
			    options.add("Vegetarian: Green Stuff for $5");
			    break;
			case 200:
				options.add("1-Clothes Store");
			    options.add("2-Toy Store");
			    options.add("3-BookStore");	
			    break;
			    
			default:
			    //options.add("No options Found");			
		}	
		return options;
	}
	
	public void receiveAnswer(int id, int answer) {
		switch (state) {
			case 0:
				if (answer == 1) state = 0;
				else if (answer == 2) state = 100;
				else if (answer == 3) state = 200;
				else state = 0;
			    break;
			case 100:
				//type of restaurants
				if (answer == 1) state = 101;
				else if (answer == 2) state = 102;
				else if (answer == 3) state = 103;
				else state = 0;
			    break;
			case 200:
				//type of restaurants
				if (answer == 1) state = 201;
				else if (answer == 2) state = 202;
				else if (answer == 3) state = 203;
				else state = 0;
				break;
			default:
				state = 0;
		}	
	}


	
}
