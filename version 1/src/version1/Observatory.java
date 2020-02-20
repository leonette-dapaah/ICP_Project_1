package version1;
import java.util.ArrayList;
/**
 * @author Abdul-Aziz
 *
 */
public class Observatory {
	
	private String obsName;
	private String country;
	private String yearStarted;
	private double areaCovered;
	private ArrayList<Galamsey>GalamseyEvents;
	
	/**
     * An overloaded Observatory constructor
     * 
     * */
	public Observatory(String obsName, String country, String yearStarted, double areaCovered) {
		this.obsName = obsName;
		this.country = country;
		this.yearStarted = yearStarted;
		this.areaCovered = areaCovered;
		this.GalamseyEvents = new ArrayList<>();
	}

	/**
	 * this method returns the name of the international 
	 * observatory system
	 * @return the obsName
	 */
	public String getObsName() {
		return obsName;
	}

	/**
	 * sets the name of the observatory system to obsName
	 * @param obsName 
	 */
	public void setObsName(String obsName) {
		this.obsName = obsName;
	}

	/**
	 * returns the country the observatory system is working
	 * @return country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * sets the country of operation to the parameter passed
	 * @param country 
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * returns the year the observatory system started working
	 * @return yearStarted
	 */
	public String getYearStarted() {
		return yearStarted;
	}

	/**
	 * sets the year the observatory started to the parameter passed
	 * @param yearStarted 
	 */
	public void setYearStarted(String yearStarted) {
		this.yearStarted = yearStarted;
	}

	/**
	 * returns the area the observatory system covered
	 * @return areaCovered
	 */
	public double getAreaCovered() {
		return areaCovered;
	}

	/**
	 * sets the area the observatory system covered to the parameter passed
	 * @param areaCovered 
	 */
	public void setAreaCovered(double areaCovered) {
		this.areaCovered = areaCovered;
	}

	/**
	 * returns an arraylist of all galamsey events recorded
	 * @return GalamseyEvents
	 */
	public ArrayList<Galamsey> getGalamseyEvents() {
		return GalamseyEvents;
	}

	/**
	 * adds the galamsey event to the arraylist containing 
	 * other galasey events
	 * @param  galamsey
	 */
	public void addGalamsey(Galamsey galamsey) {
		GalamseyEvents.add(galamsey);
		
	}
	
	/**
	 * returns the galamsey event with color value larger than the 
	 * color value passed
	 * @return large
	 */
	public int getLargestGalamseyColorV() {
		int large = 0;
		for(Galamsey E:getGalamseyEvents())
			if(E.getColour_val()>large)
				large = E.getColour_val();
		return large;
	}
	
	/**
	 * 
	 * @return the average galamsey color value
	 */
	public double averageGalamseyCValue(){
		int total = 0;
		int count = 0;
		for(Galamsey E:getGalamseyEvents()) {
			total+=E.getColour_val();
			count++;
		}
		
		if (count != 0)
			return total/count;
		else 
			return 0.0;
			
	}
	
	/**
	 * @param value
	 * @return the GalamseyEvents above a given value
	 */
	public String galamseyAboveValueOf(int value) {
		String info = "";
		int i = 1;
		for(Galamsey E:getGalamseyEvents())
			if(E.getColour_val()>value) {
				String y = i+"."+E;
				info+=y;
				i++;
			}
				
		return info;
	}
	
	/**
	 * @return a toString of all the data collected
	 */
	public String toString() {
		return "Name of Observatory: "+getObsName()+"\nCountry of Observatory: "+getCountry()+
				"\nYear started: "+getYearStarted()+"\nArea covered by Observatory: "+getAreaCovered();
	}
	
//	public static void main(String[] args) {
//		Observatory Ghana = new Observatory("main source","Ghana",2002,4589.65);
//		System.out.println(Ghana);
//	}
}
