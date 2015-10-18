package iot.shoppingnavigator.central.impl;

import java.util.Collection;
import java.util.Vector;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import iot.shoppingnavigator.central.Central;
import iot.shoppingnavigator.restaurant.Restaurant;

// TODO: Auto-generated Javadoc
/**
 * The Class CentralImpl.
 */
public class CentralImpl implements Central{
	
	/** The restaurant refs. */
	private Collection<ServiceReference<Restaurant>> restaurantRefs;
	
	/** The context. */
	private BundleContext context;
	
	/** The answer. */
	private String answer;
	
	/** The state. */
	private States state;
	
	/** The current restaurant. */
	private Restaurant currentRestaurant;
	
	
	/**
	 * The Enum States.
	 */
	public enum States {
		
		/** The Initial. */
		Initial, 
		 /** The Bathroom. */
		 Bathroom, 
		 /** The Restaurants. */
		 Restaurants, 
		 /** The Choose restaurant. */
		 ChooseRestaurant, 
		 /** The Get menu current restaurant. */
		 GetMenuCurrentRestaurant, 
		 /** The Stores. */
		 Stores; 
	}

	/**
	 * Instantiates a new central impl.
	 *
	 * @param restaurantRefs the restaurant refs
	 * @param context the context
	 */
	CentralImpl(Collection<ServiceReference<Restaurant>> restaurantRefs, BundleContext context) {
		this.state = States.Initial;
		this.restaurantRefs = restaurantRefs;
		this.context = context;
	}
	
	@Override
	public Vector<String> getOptions(int id) {
		
		Vector<String> options = new Vector<String>();
		switch (state) {
			case Initial:
				//initial state
				options.add("Welcome to the Smart Shopping Center");
			    options.add("1-Bathroom");
			    options.add("2-Food");
			    options.add("3-Shopping");			
			    break;
			case Restaurants:
				for (final ServiceReference<Restaurant> restaurantRef : restaurantRefs) {
					options.add((String) restaurantRef.getProperty(Restaurant.NAME));
		    	}	
			    break;
			case GetMenuCurrentRestaurant:
				//type of restaurants
				for (final ServiceReference<Restaurant> restaurantRef : restaurantRefs) {
					//System.out.println("a= "+ answer + "prop name "+restaurantRef.getProperty(Restaurant.NAME));

					if (answer.compareTo((String) restaurantRef.getProperty(Restaurant.NAME)) == 0) {
						//restaurant found
						currentRestaurant = (Restaurant) context.getService(restaurantRef);	
						for ( String s: currentRestaurant.getMenu()) {
							options.add(s);
						}
						break;
					}
		    	}	
				state = States.Initial;	
				break;
			case Stores:
				options.add("1-Clothes Store");
			    options.add("2-Toy Store");
			    options.add("3-BookStore");	
			    break;
			    
			default:
			    //options.add("No options Found");			
		}	
		return options;
	}
	
	
	public void receiveAnswer(int id, String answer) {
		//System.out.println("central: "+answer);
		switch (state) {
			case Initial:
				if (answer.compareTo("2") == 0) state = States.Restaurants;
				else if (answer.compareTo("3") == 0) state = States.Stores;
				else state = States.Initial;
			    break;
			case Restaurants:
				state = States.GetMenuCurrentRestaurant;
				this.answer = answer;
			    break;
			default:
				state = States.Initial;
		}	
	}	
}
