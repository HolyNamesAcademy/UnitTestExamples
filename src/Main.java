import java.util.Scanner;

public class Main {

    private static void PrintHelp() {
        System.out.println("\nOptions: ");
        System.out.println("  status (s): print the current status of the car");
        System.out.println("  on (n): start the car");
        System.out.println("  off (f): stop the car");
        System.out.println("  help (h): show this help message");
        System.out.println("  quit (q): quit the program");
    }

    /**
     * Start program execution
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Engine engine = new Engine(14.8, 10, 35);
        Car car = new Car(engine);

        car.GetStatusReport();

        PrintHelp();
        
        // Keep looping until the user gives us valid input
        while (true) {

            System.out.print("Enter your choice:\t");
            String program = scanner.next().toLowerCase();
            System.out.println();

            switch (program) {
                case "s":
                case "status":
                    car.GetStatusReport();
                    break;
                case "n":
                case "on":
                    car.Start();
                    break;
                case "f":
                case "off":
                    car.Stop();
                    break;
                case "r":
                case "refuel":
                    break;
                case "c":
                case "collision":
                    break;
                case "h":
                case "help":
                    PrintHelp();
                    break;
                case "q":
                case "quit":
                    return;
                default:
                    System.out.println("Sorry, the input was invalid.");
                    break;
            }
        }
    }
}
