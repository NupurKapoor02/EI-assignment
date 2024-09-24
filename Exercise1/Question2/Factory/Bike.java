package Question2.Factory;
public class Bike implements Vehicle {
    @Override
    public void drive() {
        try {
            System.out.println("Driving a Bike...");
        } catch (Exception e) {
            System.err.println("An error occurred while driving the Bike: " + e.getMessage());
        }
    }
}
