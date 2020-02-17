package jdbc;
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
	// This method returns A list of all â€œgalamseyâ€? recorded with colour 
	// value greater than a given/arbitrary number.
	public ArrayList<Observatory> getObservatories(){
		
		return Observatories;
	}
	// This method returns The observatory with the largest average â€œgalamseyâ€? colour value.
	
	public String getObservatoryWithLargeAverage() {
		Observatory large = null;
		for(Observatory E:getObservatories())
			if(E.averageGalamseyCValue()>large.averageGalamseyCValue())
				large = E;
		return large.toString();
	}
	public double getLargestAverageGalamseyValue() {
		double large = 0.0;
		for(Observatory E:getObservatories())
			if(E.averageGalamseyCValue()>large)
				large = E.averageGalamseyCValue();
		return large;
	}
	public int largestGalamseyValueEverRecord() {
		int large = 0;
		for(Observatory E:getObservatories())
			if(E.getLargestGalamseyColorV()>large)
				large = E.getLargestGalamseyColorV();
		return large;
	}
	
	public String getAllGalamseyActAboveValueof(int value) {
		String info = "";
		for(Observatory E:getObservatories())
			if(E.averageGalamseyCValue()>value) {
				String y =E+"\n";
				info+=y;
			}
		return info;
	}
		
		
}


