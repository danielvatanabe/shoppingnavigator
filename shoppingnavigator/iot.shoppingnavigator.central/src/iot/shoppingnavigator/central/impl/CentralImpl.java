package iot.shoppingnavigator.central.impl;

import java.util.Collection;
import java.util.Vector;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import iot.shoppingnavigator.bathroom.Bathroom;
import iot.shoppingnavigator.central.Central;
import iot.shoppingnavigator.restaurant.Restaurant;
import iot.shoppingnavigator.store.Store;

// TODO: Auto-generated Javadoc
/**
 * The Class CentralImpl.
 */
public class CentralImpl implements Central{
	
	/** The restaurant refs. */
	private Collection<ServiceReference<Restaurant>> restaurantRefs;
	private Collection<ServiceReference<Store>> storeRefs;
	private Collection<ServiceReference<Bathroom>> bathroomRefs;

	/** The context. */
	private BundleContext context;
	
	/** The answer. */
	private String answer;
	
	/** The state. */
	private States state;
	private double[] positionNavigator;
	private double[] positionToGo;
	
	private FindPath path;

	/** The current restaurant. */	
	private Restaurant currentRestaurant;
	private Store currentStore;
	private Vector<double[]> coordinates = new Vector<double[]>();
	private Bathroom bathroom;
	
	/**
	 * The Enum States.
	 */
	public enum States {
		Initial, Bathroom, BathroomM, BathroomW, Restaurants, ShowMenuRestaurant, Stores, ShowPromotionStore, GoPlace; 
	}

	/**
	 * Instantiates a new central impl.
	 *
	 * @param restaurantRefs the restaurant refs
	 * @param context the context
	 */
	CentralImpl(Collection<ServiceReference<Restaurant>> restaurantRefs, Collection<ServiceReference<Store>> storeRefs, Collection<ServiceReference<Bathroom>> bathroomRefs, BundleContext context) {
		this.state = States.Initial;
		this.restaurantRefs = restaurantRefs;
		this.storeRefs = storeRefs;
		this.bathroomRefs = bathroomRefs;
		this.context = context;
		path = new FindPath();
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
			case Bathroom:
				options.add("Man Bathrooms?");
			    options.add("Woman Bathrooms?");
			    break;
			case BathroomM:
				for (final ServiceReference<Bathroom> bathroomRef : bathroomRefs) {
					if (answer.compareTo((String) bathroomRef.getProperty(Bathroom.GENDER)) == 0) {
						bathroom = (Bathroom) context.getService(bathroomRef);	
						if (bathroom.isItOpen()) {
							coordinates.add(bathroom.getPosition());
						}
					}
		    	}	
				options = path.findWay(positionNavigator, coordinates);
				coordinates.clear();
				state = States.Initial;
			    break;
			case BathroomW:
				for (final ServiceReference<Bathroom> bathroomRef : bathroomRefs) {
					if (answer.compareTo((String) bathroomRef.getProperty(Bathroom.GENDER)) == 0) {
						bathroom = (Bathroom) context.getService(bathroomRef);	
						if (bathroom.isItOpen()) {
							coordinates.add(bathroom.getPosition());
						}
					}
		    	}	
				options = path.findWay(positionNavigator, coordinates);
				coordinates.clear();
				state = States.Initial;
			    break;
			case Restaurants:
				for (final ServiceReference<Restaurant> restaurantRef : restaurantRefs) {
					System.out.println("prop name "+restaurantRef.getProperty(Restaurant.NAME));
					options.add((String) restaurantRef.getProperty(Restaurant.NAME));
		    	}	
			    break;
			case ShowMenuRestaurant:
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
				break;
			case Stores:
				for (final ServiceReference<Store> storeRef : storeRefs) {
					options.add((String) storeRef.getProperty(Store.NAME));
		    	}		
			    break;
			case ShowPromotionStore:
				//type of restaurants
				for (final ServiceReference<Store> storeRef : storeRefs) {
					if (answer.compareTo((String) storeRef.getProperty(Store.NAME)) == 0) {
						//restaurant found
						currentStore = (Store) context.getService(storeRef);	
						for ( String s: currentStore.getPromotions()) {
							options.add(s);
						}
						break;
					}
		    	}	
				break;

			case GoPlace:
				options = path.findWay(positionNavigator, positionToGo);
				state = States.Initial;
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
				if (answer.compareTo("1") == 0) state = States.Bathroom;
				else if (answer.compareTo("2") == 0) state = States.Restaurants;
				else if (answer.compareTo("3") == 0) state = States.Stores;
				else state = States.Initial;
			    break;
			case Bathroom:
				this.answer = answer;
				if (answer.compareTo("Man") == 0) state = States.BathroomM;
				else if (answer.compareTo("Woman") == 0) state = States.BathroomW;
				else state = States.Initial;
			    break;
			case Restaurants:
				state = States.ShowMenuRestaurant;
				this.answer = answer;
			    break;
			case ShowMenuRestaurant:
				if (answer.compareTo("Yes") == 0) {
					positionToGo = currentRestaurant.getPosition();
					state = States.GoPlace;
				}
				else if (answer.compareTo("Back") == 0) state = States.Restaurants;
				else state = States.Initial;	
			case Stores:
				state = States.ShowPromotionStore;
				this.answer = answer;
			    break;
			case ShowPromotionStore:
				if (answer.compareTo("Yes") == 0) {
					positionToGo = currentStore.getPosition();
					state = States.GoPlace;
				}
				else if (answer.compareTo("Back") == 0) state = States.Stores;
				else state = States.Initial;	
			    break;
			    
			default:
				state = States.Initial;
		}	
	}

	@Override
	public void receivePosition(int id, double[] pos) {
		positionNavigator = pos;
	}	
}
