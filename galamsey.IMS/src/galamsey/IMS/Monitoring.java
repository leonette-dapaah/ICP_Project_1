package galamsey.IMS;
import java.util.ArrayList;

public class Monitoring {
	/**
	 * @author Hussein Fuseini
	 * @version 1.0.1
	 */
	
	
	private ArrayList<Observatory> Observatories;
	
	public Monitoring() {
		Observatories = new ArrayList<>();
	}
	// This method returns the largest “galamsey” colour value ever recorded.
	public int largestGalamColVal() {
		return 0;
	}
	public void addObservatory(Observatory Observe) {
		Observatories.add(Observe);
	}
	// This method returns A list of all “galamsey” recorded with colour 
	// value greater than a given/arbitrary number.
	public ArrayList<Observatory> getObservatories(){
		
		return Observatories;
	}
	// This method returns The observatory with the largest average “galamsey” colour value.
	
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


