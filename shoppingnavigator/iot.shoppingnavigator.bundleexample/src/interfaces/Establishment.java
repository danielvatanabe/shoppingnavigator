package interfaces;

public interface Establishment {
	
	public String getName();
	
	public void setName(String Name);
	
	public double[] getPosition();
			
	public void setOpen(int open);
	
	public boolean isItOpen();
	
	@Override 
	public String toString();

}
