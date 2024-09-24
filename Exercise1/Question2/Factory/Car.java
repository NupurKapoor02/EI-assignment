package Question2.Factory;
public class Car implements Vehicle {
    @Override
    public void drive() {
        try {
            System.out.println("Driving a car...");
        } catch (Exception e) {
            System.err.println("An error occurred while driving the car: " + e.getMessage());
        }
    }
}
