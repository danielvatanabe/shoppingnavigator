package interfaces;

import java.util.ArrayList;
import java.util.List;

public class RestaurantImpl extends EstablishmentImpl implements Restaurant {
	
	private List<String> menu;
	
	public RestaurantImpl (String Name, double x, double y, int open)
	{
		this.setName(Name);
		
		EstablishmentImpl.position[0] = x;
		EstablishmentImpl.position[1] = y;
		
		this.menu = new ArrayList<String>();
		
		this.setOpen(open);
	}
	
	public List<String> getMenu() {
		
		return menu;
	}
	
	public void setMenu(String... args) {
		
		List<String> newMenu = getMenu();
		newMenu.clear();
		
		for (String arg: args) {
			newMenu.add(arg);
		}
	}
	
	public void showMenu() {
		
		if ( getOpen() == 1 ) {
			
			for (String temp : getMenu()) {
				System.out.println(temp);
			}
		}
		else
		{
			System.out.println("The restaurant is closed");
		}	
	}
	
	@Override 
	public String toString() {
		
		double pos[] = getPosition();
		
		return "Restaurant: " + getName() + ":  X = " + pos[0] + " Y = " + pos[1] +"; Open = " + isItOpen();
	}

}
