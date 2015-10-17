package interfaces;

public class BathroomImpl extends EstablishmentImpl implements Bathroom {
	
	private int gender;
	
	public BathroomImpl (String Name, double x, double y, int gender)
	{
		this.setName(Name);
		
		EstablishmentImpl.position[0] = x;
		EstablishmentImpl.position[1] = y;
		
		this.gender = gender;
	}
	
	public int getGender() {
		return this.gender;
	}
	
	/* Is 1 = woman's bathroom, if 0 = men's bathroom */
	
	public String whichGender() {
		
		if ( getGender() == 1 )
		{
			return "Women's Bathroom";
		}
		
		return "Men's Bathroom";
	}
	
	@Override
	public String toString() {
		
		double pos[] = getPosition();
		
		return getName() + ":  X = " + pos[0] + " Y = " + pos[1] + " - " + whichGender();
		
	}
}
