package version1;
import java.util.ArrayList;

/**
 * @author Hussein Fuseini
 *
 */
public class Monitoring {
	
	
	
	private ArrayList<Observatory> Observatories;
	
	/**
     *Monitoring constructor
     * 
     * */
	public Monitoring() {
		Observatories = new ArrayList<>();
	}
	
	/**
     * @return 0
     * 
     * */
	public int largestGalamColVal() {
		return 0;
	}
	
	/**
	 * @param observatory
	 * Takes an instance of an observatory and adds it to 
	 * an instance of the monitoring class
	 */
	public void addObservatory(Observatory Observe) {
		Observatories.add(Observe);
	}
	/** This method returns A list of all observatory systems recorded 
	 * @return Observatories
	*/
	public ArrayList<Observatory> getObservatories(){
		
		return Observatories;
	}
	// This method returns The observatory with the largest average â€œgalamseyâ€? colour value.
	
	/**
	 * returns observatory with largest galamsey color value
     *@return observatory 
     * 
     * */
	public String getObservatoryWithLargeAverage() {
		Observatory large = null;
		for(Observatory E:getObservatories())
			if(E.averageGalamseyCValue()>large.averageGalamseyCValue())
				large = E;
		return large.toString();
	}
	
	/**
	 * 
	 * @return the average galamsey color value
	 */
	public double getLargestAverageGalamseyValue() {
		double large = 0.0;
		for(Observatory E:getObservatories())
			if(E.averageGalamseyCValue()>large)
				large = E.averageGalamseyCValue();
		return large;
	}
	
	/**
	 * 
	 * @return the largest galamsey color value ever recorded
	 */
	public int largestGalamseyValueEverRecord() {
		int large = 0;
		for(Observatory E:getObservatories())
			if(E.getLargestGalamseyColorV()>large)
				large = E.getLargestGalamseyColorV();
		return large;
	}
	
	/**
	 * returns the galamsey event with color value larger than the 
	 * color value passed
	 * @return large
	 */
	public String getAllGalamseyActAboveValueof(int value) {
		String info = "";
		for(Observatory E:getObservatories()) {
			for(Galamsey A:E.getGalamseyEvents()) {
				if(A.getColour_val()>value) {
					String y =A+"\n";
					info+=y;
			}
		}
	}
		return info;
	}		
}


