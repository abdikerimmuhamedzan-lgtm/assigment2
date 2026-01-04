package fleet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FleetApp {
    private List<Vehicle> vehicles = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("""
                    Fleet Management System
                    1. Print all vehicles
                    2. Add new car
                    3. Add new bus
                    4. Show total yearly insurance fees
                    5. Show vehicles older than N years
                    6. Perform service for all vehicles
                    7. Quit
                    """);

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> printAllVehicles();
                case 2 -> addCar();
                case 3 -> addBus();
                case 4 -> showTotalInsurance();
                case 5 -> showOlderThan();
                case 6 -> performServiceAll();
                case 7 -> running = false;
                default -> System.out.println("Invalid option");
            }
        }
    }

    private void printAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in the fleet");
            return;
        }
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }

    private void addCar() {
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Year: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Base price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Number of doors: ");
        int doors = Integer.parseInt(scanner.nextLine());

        vehicles.add(new Car(model, year, price, doors));
    }

    private void addBus() {
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Year: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Base price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Passenger capacity: ");
        int capacity = Integer.parseInt(scanner.nextLine());

        vehicles.add(new Bus(model, year, price, capacity));
    }

    private void showTotalInsurance() {
        double total = 0;
        for (Vehicle v : vehicles) {
            total += v.calculateInsuranceFee();
        }
        System.out.println("Total insurance fee: " + total);
    }

    private void showOlderThan() {
        System.out.print("Current year: ");
        int currentYear = Integer.parseInt(scanner.nextLine());
        System.out.print("N years: ");
        int n = Integer.parseInt(scanner.nextLine());

        for (Vehicle v : vehicles) {
            if (v.getAge(currentYear) > n) {
                System.out.println(v);
            }
        }
    }

    private void performServiceAll() {
        for (Vehicle v : vehicles) {
            Servicable s = v;
            s.performService();
        }
    }

    public static void main(String[] args) {
        new FleetApp().run();
    }
}
