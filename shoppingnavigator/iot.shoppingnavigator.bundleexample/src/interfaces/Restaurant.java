package interfaces;

import java.util.List;

public interface Restaurant extends Establishment{
	
	public List<String> getMenu();
	
	public void setMenu(String... args);
	
	public void showMenu();

}
