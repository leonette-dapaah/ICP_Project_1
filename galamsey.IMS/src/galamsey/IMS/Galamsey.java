package galamsey.IMS;
public class Galamsey {

    private String veg_colour;
    private String position;
    private int colour_val;
    private int year;

    public Galamsey(){

    }

    /**
     * An overloaded Galamsey constructor
     * */
    public Galamsey(String veg_colour, String position,
                    int colour_val, int year){
        this.veg_colour = veg_colour;
        this.position = position;
        this.colour_val = colour_val;
        this.year = year;
    }

    /**
     * @return Vegetation Colour
     * */
    public String getVeg_colour() {
        return veg_colour;
    }

    /**
     * @param veg_colour
     * */
    public void setVeg_colour(String veg_colour) {
        this.veg_colour = veg_colour;
    }

    /**
     * @return Vegetation Colour
     * */
    public String getPosition() {
        return position;
    }

    /**
     * @param position
     * */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * @return Colour Value
     * */
    public int getColour_val() {
        return colour_val;
    }

    /**
     * @param colour_val
     * */
    public void setColour_val(int colour_val) {
        this.colour_val = colour_val;
    }

    /**
     * @return Year of the event
     * */
    public int getYear() {
        return year;
    }

    /**
     * @param year
     * */
    public void setYear(int year) {
        this.year = year;
    }
    
    @Override
    public String toString() {
    	return "Vegetation Colour: "+ getVeg_colour()+"\n Color Value: "+getColour_val()+"\n Position: "+
    			getPosition()+"\n Year of data: "+ getYear()+"\n";
    }
//    public static void main(String[] args) {
//		Galamsey kumasi = new Galamsey("Green","1.2300,9.632",1,2019);
//		System.out.println(kumasi);
//	}
}
