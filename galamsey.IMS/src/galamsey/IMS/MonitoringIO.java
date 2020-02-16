package jdbc;

import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.NumberFormatException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.*;

/**
 * @version 1.0.1
 *
 */
public class MonitoringIO {
	

	public static void main (String[] args){
		
		/**
		 * Description of some variables here.
		 */
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://localhost:3306/test?useSSL=false";
		
		final String USER = "hawa";
		final String PASS = "aziz";
		 
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

                            System.out.println("Enter country location: ");
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
                    		 * Description of some variables here.
                    		 */
                            
                            // Creating connection with the database and putting the inputs into the Monitoring database table
                            Connection myConn = null;
                    		Statement myStmt = null; //We can also used PreparedStatement
                    		 
                    		try {
                    			/**
                    			 * Writing the inputs into the tables of the databasee.
                    			 */
                    			Class.forName(JDBC_DRIVER);
                    			
                    			myConn = DriverManager.getConnection(DB_URL, USER, PASS);
                    			
                    			myStmt = myConn.createStatement();
                    			
                    			String sql = "insert into Monitoring "
                    						+ " (obs_name, country, year_started, area_covered)"
                    						+ " values ('"+name+"', '"+location+"', '"+yr+"', '"+c+"')";
                    			
                    			
                    			myStmt.executeUpdate(sql);
                    			}catch(Exception se){
                    				se.printStackTrace();
                    			}
                    		
                    		    
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

                            System.out.println("Enter position (Latitude and Longitude (eg: 5.603 N, 0.187 W))");
                            String position = s.nextLine();

                            System.out.println("Enter colour value: ");
                            String col_val = s.nextLine();
                            int cv = Integer.parseInt(col_val);

                            System.out.println("Enter year of event: ");
                            String yr = s.nextLine();
                            
                            // Creating connection with database and inputing the records
                            Connection myConn = null;
                    		Statement myStmt = null; //We can also used PreparedStatement
                    		 
                    		/**
                    		 * Writing the data collected into a database.
                    		 */
                    		try {
                    			Class.forName(JDBC_DRIVER);
                    			
                    			myConn = DriverManager.getConnection(DB_URL, USER, PASS);
                    			
                    			myStmt = myConn.createStatement();
                    			
                    			String sql = "insert into Observatory "
                    						+ " (veg_color, position, col_value, year)"
                    						+ " values ('"+colour+"', '"+position+"', '"+cv+"', '"+yr+"')";
                    			
                    			
                    			myStmt.executeUpdate(sql);
                    			}catch(Exception se){
                    				se.printStackTrace();
                    			}
                            
                    		//
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
                    	// Writing the inputs into csv files
                    	Connection myConn = null;
                		PreparedStatement myStmt = null;
                		
                    	try {
                    		
                    		PrintWriter pw = new PrintWriter(new File("C:\\Users\\Abdul-Aziz\\Desktop\\icp_java_week11_LoginGUIMySQL\\Monitoring.csv"));
                    		PrintWriter pw1 = new PrintWriter(new File("C:\\Users\\Abdul-Aziz\\Desktop\\icp_java_week11_LoginGUIMySQL\\Observatory.csv"));
                    		StringBuilder sb = new StringBuilder();
                    		StringBuilder sb1 = new StringBuilder();

                    		
                    		
                    		Class.forName(JDBC_DRIVER);
                			
                			myConn = DriverManager.getConnection(DB_URL, USER, PASS);
                			
                			ResultSet rs = null;
                			
                			String query = "Select * from Monitoring";
                			myStmt = myConn.prepareStatement(query);
                			rs = myStmt.executeQuery();
                			
                			while (rs.next()) {
                				sb.append(rs.getString("id"));
                				sb.append(",");
                				sb.append(rs.getString("obs_name"));
                				sb.append(",");
                				sb.append(rs.getString("country"));
                				sb.append(",");
                				sb.append(rs.getString("year_started"));
                				sb.append(",");
                				sb.append(rs.getString("area_covered"));
                				sb.append("\r\n");
                			}
                			
                			pw.write(sb.toString());
                			pw.close();
                			
                			ResultSet rs1 = null;
                			String query1 = "Select * from Observatory";
                			myStmt = myConn.prepareStatement(query1);
                			rs1 = myStmt.executeQuery();
                			
                			while (rs1.next()) {
                				sb1.append(rs1.getString("id"));
                				sb1.append(",");
                				sb1.append(rs1.getString("veg_color"));
                				sb1.append(",");
                				sb1.append(rs1.getString("position"));
                				sb1.append(",");
                				sb1.append(rs1.getString("col_value"));
                				sb1.append(",");
                				sb1.append(rs1.getString("year"));
                				sb1.append("\r\n");
                			}
                			
                			pw1.write(sb1.toString());
                			pw1.close();
                			System.out.println("Finished!");
                    	}catch(Exception e) {
                    		e.printStackTrace(); 
                    	} 
				/*
				 * PrintWriter printWriter = null;
				 * 
				 * try { //Note that we are able to append to the file because of the "true"
				 * parameter printWriter = new PrintWriter(new FileOutputStream("Galamsey.csv",
				 * true));
				 * 
				 * }catch(FileNotFoundException fnfe) { fnfe.getMessage(); } for (int i = 0;
				 * i<Africa.getObservatories().size(); i++) {
				 * printWriter.print(Africa.getObservatories().get(i)+"\n");
				 * //printWriter.println(); printWriter.print("\n" +
				 * Africa.getObservatories().get(i).getGalamseyEvents()); }
				 * 
				 * //printWriter.print(Africa.getObservatories());
				 * //printWriter.print((Africa.getObservatories()).getGalamseyEvents());
				 * //printWriter.println();
				 * 
				 * 
				 * 
				 * //Close Writer printWriter.close();
				 * System.out.println("Information saved in a Galamsey textfile");
				 */
                        System.exit(0);
                        
                    default:
                        System.out.println("Invalid Input");
                        System.out.println();
                        break;

                    
                }

        }
		
	}   
}
