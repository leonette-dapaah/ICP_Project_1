package version1;

import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.lang.NumberFormatException;
import java.util.Scanner;

/**
 * @version 1.0.1
 * @class MonitoringIO
 */
public class MonitoringIO {
	

	public static void main (String[] args){
		 
		//Creating instance of the Scanner class to accept input
		Scanner s = new Scanner(System.in);
        String u_choice = "";
        
        /**
         * Creating an instance of the Monitoring class.
         */
        Monitoring Africa = new Monitoring();

        
        /**
         * Displaying the options to the user.
         */
        while (u_choice != "4"){
            System.out.println("          MENU        ");
            System.out.println("Enter 1 for observatory data");
            System.out.println("Enter 2 for 'galamsey' data");
            System.out.println("Enter 3 for Monitoring statistics");
            System.out.println("Enter 4 to Exit");

            u_choice = s.nextLine();

            /**
             * @param u_choice
             * Takes the user's choice and choose the case to run.
             */
                switch (u_choice) {
                    case "1":
                        try {
                        	
                        	//Collecting data from the user.
                            System.out.println("Name of observatory: ");
                            String name = s.nextLine();

                            System.out.println("Enter country of operation: ");
                            String location = s.nextLine();

                            System.out.println("Enter year galamsey operations began: ");
                            String yr = s.nextLine();
//                          String year = s.nextLine();
//                          int yr = Integer.parseInt(year);

                            System.out.println("Enter area covered by the observatory (in square kilometers): ");               
                            double c = Double.parseDouble(s.nextLine());

                            System.out.println();
                            // System.out.println("List of 'galamsey' events recorded: ");
                    		
                    		    
                    		/**
                    		 *Creating an observatory instance and putting it into the Monitoring object called Africa.
                    		 *@param name, location, yr, c
                    		 */
                    		 Africa.addObservatory(new Observatory(name, location, yr, c));
                    		 System.out.println("Input recorded!");
//                           System.out.println(Africa.getObservatories().get(Africa.getObservatories().size()-1));
//                           System.out.println("----------------------------------------------\n");
//                           private Observatory obs = new Observatory(name, location, yr, c);
//                           Monitoring.addObservatories(obs);
                            break;
                        }
                        catch (NumberFormatException a){
                            System.out.println("Wrong Input");
                            System.out.println();
                            break;
                        }

                        
                       
                    case "2":
                        try {
                        	//Collecting data from the user
                        	
                            System.out.println("Enter vegetation colour: ");
                            String colour = s.nextLine();

                            System.out.println("Enter position in degrees(Latitude and Longitude. eg. (56N, 18W)): ");
                            String position = s.nextLine();

                            System.out.println("Enter colour value (from 1 to 3): ");
                            String col_val = s.nextLine();
                            int cv = Integer.parseInt(col_val);

                            System.out.println("Enter year of event: ");
                            String yr = s.nextLine();
                            
                    		/**
                    	     *Creating a galamsey event and putting it into 
                    	     *the ArrayList of the Observatory created
                    	     * 
                    	     * */
                            Africa.getObservatories().get(Africa.getObservatories().size()-1).addGalamsey(new Galamsey(colour, position, cv,yr));
                            System.out.println("Input recorded!");
                           // System.out.println(Africa.getObservatories().get(Africa.getObservatories().size()-1).galamseyAboveValueOf(0));
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
                    	
				
				  PrintWriter printWriter = null;
				  
				  try { //Note that we are able to append to the file because of the "true"
				  printWriter = new PrintWriter(new FileOutputStream("Galamsey.csv",true));
				 
				  }catch(FileNotFoundException fnfe) { 
					  fnfe.getMessage(); 
					  }
				  for (int i = 0; i<Africa.getObservatories().size(); i++) {
					  printWriter.print(Africa.getObservatories().get(i)+"\n");
					  printWriter.println(); 
					  printWriter.print("\n" + Africa.getObservatories().get(i).getGalamseyEvents()); 
				  }
				  
				  //printWriter.print(Africa.getObservatories());
				  //printWriter.print((Africa.getObservatories()).getGalamseyEvents());
				  //printWriter.println();
				  
				  
				  
				  printWriter.close();
				  System.out.println("Information saved in a csv file named Galamsey.csv");
				 
                        System.exit(0);
                        
                    default:
                        System.out.println("Invalid Input");
                        System.out.println();
                        break;

                    
                }

        }
		
	}   
}
