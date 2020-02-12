package galamsey.IMS;
import java.util.ArrayList;

public class Monitoring {
	/**
	 * @author Hussein Fuseini
	 * @version 1.0.1
	 */
	
	
	private ArrayList<Observatory> Observatories;
	
	public Monitoring() {
		
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
	public ArrayList<Observatory> getAllRecordsAbove(){
		
		return Observatories;
	}
	// This method returns The observatory with the largest average “galamsey” colour value.
	public String getObservatoryWithHighAverage() {
		return "Hussein";
	}
}