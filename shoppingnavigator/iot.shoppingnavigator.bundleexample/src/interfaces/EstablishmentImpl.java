package interfaces;

public abstract class EstablishmentImpl implements Establishment {
	
	String name;
	static double[] position = new double[2];
	int open;
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String Name) {
		this.name = Name;
	}
	
	public double[] getPosition() {
		return position;
	}
	
	public int getOpen() {
		
		return open;
	}
	
	public void setOpen(int open) {
		
		this.open = open;
	}
	
	public boolean isItOpen() {
		
		if ( getOpen() == 1 ) {
			return true;
		}
		return false;
	}
	
	
}
