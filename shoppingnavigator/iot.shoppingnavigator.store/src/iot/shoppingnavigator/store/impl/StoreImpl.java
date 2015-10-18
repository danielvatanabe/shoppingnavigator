package iot.shoppingnavigator.store.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import iot.shoppingnavigator.store.Store;
import iot.shoppingnavigator.util.EstablishmentImpl;

public class StoreImpl extends EstablishmentImpl implements Store {
	
	private String type;
	private Vector<String> listPromotions;
	
	public StoreImpl(String name, String type, double x, double y)
	{	
		super(name, x, y);		
		this.type = type;
		this.listPromotions = new Vector<String>();		

	}
	
	public Vector<String> getPromotions() {
		
		return listPromotions;
	}
	
	public void addPromotion(String... args) {	
		for (String arg: args) {
			listPromotions.add(arg);
		}
	}

	@Override
	public String getType() {
		return type;
	}
}
