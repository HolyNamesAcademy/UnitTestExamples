import java.util.Collection;
import java.util.Scanner;

public class Main {
    private static final double GasPricePerGallon = 3.25;

    private static void PrintHelp() {
        System.out.println("\nOptions: ");
        System.out.println("  status (s):  print the current status of the car");
        System.out.println("  on (n):      start the car");
        System.out.println("  off (f):     stop the car");
        System.out.println("  refuel (r):  fill the car's gas tank");
        System.out.println("  drive (d):   drive the car a specified distance");
        System.out.println("  crash (c):   simulate a collision");
        System.out.println("  help (h):    show this help message");
        System.out.println("  quit (q):    quit the program");
    }

    private static void Refuel(BankAccount bankAccount, Car car) {
        Engine engine = car.GetEngine();
        double toFill = engine.FuelCapacity() - engine.FuelRemaining();
        if (toFill == 0) {
            System.out.println("Tank is already full.");
            return;
        }

        double totalPrice = toFill * GasPricePerGallon;
        String m = String.format("Total price to fill %.2f gallons of gas: $%.2f", toFill, totalPrice);
        System.out.println(m);

        if (bankAccount.Withdraw(totalPrice) == 0) {
            System.out.println("Not enough money to fill the tank.");
            return;
        }

        engine.FillTank();
        System.out.println("Filled the tank.");
    }

    private static void Drive(Scanner scanner, Car car) {
        System.out.print("How far would you like to travel (in miles)?\t");
        String str = scanner.next();
        System.out.println();

        double milesToTravel = Double.parseDouble(str);
        car.Drive(milesToTravel);
    }

    private static void SimulateCollision(Scanner scanner, Car car) {
        System.out.print("How much force should we simulate in the collision (in Newtons)?\t");
        String str = scanner.next();
        System.out.println();

        double force = Double.parseDouble(str);
        car.GetSafetySystem().Crash(force);
    }


    /**
     * Start program execution
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BankAccount bankAccount = new BankAccount("Serena Williams", 50);
        Engine engine = new Engine(14.8, 10, 35);
        Car car = new Car(engine);

        // car.GetStatusReport();

        PrintHelp();

        while (true) {
            System.out.print("\nEnter your choice:\t");
            String option = scanner.next().toLowerCase();
            System.out.println();

            switch (option) {
                case "s":
                case "status":
                    car.GetStatusReport();
                    System.out.println("\nBank account:\n" + bankAccount);
                    break;
                case "n":
                case "on":
                    car.Start();
                    break;
                case "f":
                case "off":
                    car.Stop();
                    break;
                case "c":
                case "crash":
                    SimulateCollision(scanner, car);
                    break;
                case "d":
                case "drive":
                    Drive(scanner, car);
                    break;
                case "r":
                case "refuel":
                    Refuel(bankAccount, car);
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
