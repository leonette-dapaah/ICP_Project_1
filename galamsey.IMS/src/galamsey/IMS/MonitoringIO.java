package galamsey.IMS;

import java.lang.NumberFormatException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MonitoringIO {
	public static void input() {
		Scanner s = new Scanner(System.in);
        String u_choice = "";
        Monitoring Africa = new Monitoring();

        while (u_choice != "4"){
            System.out.println("          MENU        ");
            System.out.println("Enter 1 for observatory data");
            System.out.println("Enter 2 for 'galamsey' data");
            System.out.println("Enter 3 for Monitoring statistics");
            System.out.println("Enter 4 to Exit");

            u_choice = s.nextLine();


                switch (u_choice) {
                    case "1":
                        try {
                            System.out.println("Name of observatory: ");
                            String name = s.nextLine();

                            System.out.println("Enter country location: ");
                            String location = s.nextLine();

                            System.out.println("Enter year galamsey operations began: ");
                            int yr = Integer.parseInt(s.nextLine());
//                            String year = s.nextLine();
//                            int yr = Integer.parseInt(year);

                            System.out.println("Enter area covered by the observatory (in square kilometers): ");               
                            double c = Double.parseDouble(s.nextLine());

                            System.out.println("List of 'galamsey' events recorded: ");
                            System.out.println();
                            
                            Africa.addObservatory(new Observatory(name, location, yr, c));
                            System.out.println(Africa.getObservatories().get(Africa.getObservatories().size()-1));
                            System.out.println("----------------------------------------------\n");
//                            private Observatory obs = new Observatory(name, location, yr, c);
//                            Monitoring.addObservatories(obs);
                            break;
                        }
                        catch (NumberFormatException a){
                            System.out.println("Wrong Input");
                            System.out.println();
                            break;
                        }

                    case "2":
                        try {
                            System.out.println("Enter vegetation colour: ");
                            String colour = s.nextLine();

                            System.out.println("Enter position (Latitude and Longitude (eg: 5.603 N, 0.187 W))");
                            String position = s.nextLine();

                            System.out.println("Enter colour value: ");
                            String col_val = s.nextLine();
                            int cv = Integer.parseInt(col_val);

                            System.out.println("Enter year of event: ");
                            String yr1 = s.nextLine();
                            int y = Integer.parseInt(yr1);
                            
                            Africa.getObservatories().get(Africa.getObservatories().size()-1).addGalamsey(new Galamsey(colour, position, cv,y));
                            
                            System.out.println(Africa.getObservatories().get(Africa.getObservatories().size()-1).galamseyAboveValueOf(0));
//                            
//                            private Galamsey gala = new Galamsey(colour, positon, cv);
//                            Observatory.addObservatories(gala);
                            break;
                        }
                        catch (Exception e) {
                            System.out.println("Invalid Input");
                            System.out.println();
                            break;
                        }

                    case "3":
                    	try {
                    		System.out.println("Enter 1 to calculate the largest average galamsey value\n"
                    				+ "Enter 2 to calculate the largest 'galamsey' ever recorded\n"
                    				+ "Enter 3 to get All 'galamsey' with colour value greater than certain threshold value");
                    		String in = s.nextLine();
                    		switch(in) {
                    		case "1":
                    			System.out.println("The largest average recorded is: "+Africa.getLargestAverageGalamseyValue());
                    		case "2":
                    			System.out.println("The largest Galamsey color value ever record is: "+Africa.largestGalamseyValueEverRecord());
                    		case "3":
                    			try {
                    				System.out.println("Enter the Threshold: \n");
                    				int i = s.nextInt();
                    				System.out.println("The Galamsey Activities above the threshold are below:"
                    						+ "----------------------------------------\n"+
                    						Africa.getAllGalamseyActAboveValueof(i));
                    				
                    				
                    			}catch(Exception e) {
                           		 System.out.println("Invalid Input");
                                 System.out.println();
                                 break;
                    			}
                    		default:
                    			System.out.println("Invalid Input");
                                System.out.println();
                                break;
                    		}
                    	}catch(Exception e) {
                    		 System.out.println("Invalid Input");
                             System.out.println();
                             break;
                    	}
//                        System.out.println("The largest average 'galamsey': ");
//                        System.out.println("Largest 'galamsey' ever recorded: ");
//                        System.out.println("All 'galamsey' with colour value greater than ...");
                        break;
                    
                    case "4":
                        System.exit(0);
                        
                    default:
                        System.out.println("Invalid Input");
                        System.out.println();
                        break;

                    
                }

        }
		
	}
    public static void main (String[] args){
        
        input();
    }
}
