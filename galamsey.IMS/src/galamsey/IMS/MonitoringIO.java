package galamsey.IMS;
import java.util.Scanner;

public class MonitoringIO {
    public static void main (String[] args){
        Scanner s = new Scanner(System.in);
        int u_choice = s.nextInt();
        System.out.println("          MENU        ");
        System.out.println("Enter 1 for observatory data");
        System.out.println("Enter 2 for 'galamsey' data");
        System.out.println("Enter 3 for Monitoring statistics");
        System.out.println("Enter 4 to Exit");

        switch (u_choice){
            case 1:
                System.out.println("Name of observatory: ");
                String name = s.next();

                System.out.println("Enter country location: ");
                String location = s.next();

                System.out.println("Enter year galamsey operations began: ");
                int yr = s.nextInt();

                System.out.println("Enter area covered by the observatory (in square kilometers): ");
                double col = s.nextDouble();

                System.out.println("List of 'galamsey' events recorded: ");
                System.out.println();

                break;

            case 2:
                System.out.println("Enter vegetation colour: ");
                String colour = s.next();

                System.out.println("Enter position (Latitude and Longitude: ): ");
                String position = s.next();

                System.out.println("Enter colour value: ");
                int col_val = s.nextInt();

                System.out.println("Enter year of event: ");
                int year = s.nextInt();
                break;

            case 3:
                System.out.println();
                break;

            default:
                System.out.println("Invalid Input");

            case 4:
                System.exit(0);
        }
    }
}
