package interfaces;

import java.util.ArrayList;
import java.util.List;

public class StoreImpl extends EstablishmentImpl implements Store {
	
	private int promotion;
	private List<String> listPromotions;
	
	public StoreImpl(String Name, double x, double y, int open)
	{
		this.setName(Name);
		
		EstablishmentImpl.position[0] = x;
		EstablishmentImpl.position[1] = y;
		
		this.listPromotions = new ArrayList<String>();
		
		this.setOpen(open);
	}
	
	public int getPromotion() {
		return promotion;
	}
	
	public void setPromotion(int promotion) {
		this.promotion = promotion;
	}
	
	public List<String> getPromotions() {
		
		return listPromotions;
	}
	
	public void setPromotions(String... args) {
		
		List<String> newlistPromotions = getPromotions();
		newlistPromotions.clear();
		
		for (String arg: args) {
			newlistPromotions.add(arg);
		}
	}
	
	@Override 
	public String toString() {
		
		double pos[] = getPosition();
		
		return "Store: " + getName() + ":  X = " + pos[0] + " Y = " + pos[1] +"; Open = " + isItOpen();
	}
	
	
}
