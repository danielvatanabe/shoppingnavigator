package interfaces;

import java.util.List;

public interface Restaurant {
	
	public List<String> getMenu();
	
	public void setMenu(String... args);
	
	public void showMenu();

}
