package Question2.Factory;
public class Truck implements Vehicle {
    @Override
    public void drive() {
        try {
            System.out.println("Driving a truck...");
        } catch (Exception e) {
            System.err.println("An error occurred while driving the Truck: " + e.getMessage());
        }
    }
}