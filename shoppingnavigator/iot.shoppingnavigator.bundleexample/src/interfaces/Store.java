package interfaces;

import java.util.List;

public interface Store {
	
	public int getPromotion();
	
	public void setPromotion(int promotion);
	
	public List<String> getPromotions();
	
	public void setPromotions(String... args);
	
}
