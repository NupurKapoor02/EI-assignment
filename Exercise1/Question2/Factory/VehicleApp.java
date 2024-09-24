package Question2.Factory;

import Question2.Factory.Logs.Logger;
import java.util.Scanner;

public class VehicleApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VehicleFactory vehicleFactory = new VehicleFactory();
        Logger.log("Vehicle Application started.");

        try {
            String vehicleType = getVehicleType(scanner);
            Vehicle vehicle = vehicleFactory.createVehicle(vehicleType);
            if (vehicle != null) {
                vehicle.drive();
                Logger.log("Vehicle created and driven: " + vehicleType);
            } else {
                Logger.log("Error: Unable to create vehicle.");
                System.out.println("Error: Unable to create vehicle. Please try again.");
            }

        } catch (InvalidInputException e) {
            Logger.log("Error: " + e.getMessage());
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            Logger.log("Unexpected error occurred: " + e.getMessage());
            System.err.println("Unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
            Logger.log("Vehicle Application ended.");
        }
    }

    private static String getVehicleType(Scanner scanner) throws InvalidInputException {
        while (true) {
            System.out.print("Enter vehicle type (car/bike/truck): ");
            String vehicleType = scanner.nextLine().trim();
            if (vehicleType.equalsIgnoreCase("car") || vehicleType.equalsIgnoreCase("bike") || vehicleType.equalsIgnoreCase("truck")) {
                return vehicleType;
            } else {
                Logger.log("Invalid vehicle type entered: " + vehicleType);
                System.err.println("Invalid vehicle type. Please enter car, bike, or truck.");
            }
        }
    }
}

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}
