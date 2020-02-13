package galamsey.IMS;
import java.util.ArrayList;
/**
 * @author Abdul-Aziz
 *
 */
public class Observatory {
	
	private String obsName;
	private String country;
	private int yearStarted;
	private double areaCovered;
	private ArrayList<Galamsey>GalamseyEvents;
	
	public Observatory(String obsName, String country, int yearStarted, double areaCovered) {
		this.obsName = obsName;
		this.country = country;
		this.yearStarted = yearStarted;
		this.areaCovered = areaCovered;
		this.GalamseyEvents = new ArrayList<Galamsey>();
	}

	/**
	 * @return the obsName
	 */
	public String getObsName() {
		return obsName;
	}

	/**
	 * @param obsName the obsName to set
	 */
	public void setObsName(String obsName) {
		this.obsName = obsName;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the yearStarted
	 */
	public int getYearStarted() {
		return yearStarted;
	}

	/**
	 * @param yearStarted the yearStarted to set
	 */
	public void setYearStarted(int yearStarted) {
		this.yearStarted = yearStarted;
	}

	/**
	 * @return the areaCovered
	 */
	public double getAreaCovered() {
		return areaCovered;
	}

	/**
	 * @param areaCovered the areaCovered to set
	 */
	public void setAreaCovered(double areaCovered) {
		this.areaCovered = areaCovered;
	}

	public ArrayList<Galamsey> getGalamseyEvents() {
		return GalamseyEvents;
	}

	public void addGalamsey(Galamsey galam) {
		GalamseyEvents.add(galam);
		
	}
	
	public int getLargestGalamseyColorV() {
		int large = 0;
		for(Galamsey E:getGalamseyEvents())
			if(E.getColour_val()>large)
				large = E.getColour_val();
		return large;
	}
	
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

	public String toString() {
		return "Name of Observatory: "+getObsName()+"\nCountry of Observatory: "+getCountry()+
				"\nYear started: "+getYearStarted()+"\nArea covered by Observatory: "+getAreaCovered();
	}
	
//	public static void main(String[] args) {
//		Observatory Ghana = new Observatory("main source","Ghana",2002,4589.65);
//		System.out.println(Ghana);
//	}
}
