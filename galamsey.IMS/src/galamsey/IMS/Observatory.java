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
	
	public int largestGalamseyColor() {return 1;}
	public double averageGalamseyValue() {return 1.1;}
	
	
	
}
