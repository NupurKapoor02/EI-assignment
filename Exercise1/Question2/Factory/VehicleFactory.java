package Question2.Factory;

public class VehicleFactory {
    public Vehicle createVehicle(String vehicleType) {
        try {
            if (vehicleType == null || vehicleType.isEmpty()) {
                throw new InvalidVehicleTypeException("Vehicle type cannot be null or empty.");
            }
            switch (vehicleType.toLowerCase()) {
                case "car":
                    return new Car();
                case "bike":
                    return new Bike();
                case "truck":
                    return new Truck();
                default:
                    throw new InvalidVehicleTypeException("Unknown vehicle type: " + vehicleType);
            }

        } catch (InvalidVehicleTypeException e) {
            System.err.println("Error creating vehicle: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.err.println("Unexpected error occurred while creating vehicle: " + e.getMessage());
            return null;
        }
    }
}

class InvalidVehicleTypeException extends Exception {
    public InvalidVehicleTypeException(String message) {
        super(message);
    }
}
