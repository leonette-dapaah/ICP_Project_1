package galamsey.IMS;

import java.lang.NumberFormatException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MonitoringIO {
    public static void main (String[] args){
        Scanner s = new Scanner(System.in);
        String u_choice = "";

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
                            String year = s.nextLine();
                            int yr = Integer.parseInt(year);

                            System.out.println("Enter area covered by the observatory (in square kilometers): ");
                            String col = s.nextLine();
                            double c = Double.parseDouble(col);

                            System.out.println("List of 'galamsey' events recorded: ");
                            System.out.println();

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

                            break;
                        }
                        catch (Exception e) {
                            System.out.println("Invalid Input");
                            System.out.println();
                            break;
                        }

                    case "3":
                        System.out.println("The largest average 'galamsey': ");
                        System.out.println("Largest 'galamsey' ever recorded: ");
                        System.out.println("All 'galamsey' with colour value greater than ...");
                        break;

                    default:
                        System.out.println("Invalid Input");
                        System.out.println();
                        break;

                    case "4":
                        System.exit(0);
                }

        }
    }
}
