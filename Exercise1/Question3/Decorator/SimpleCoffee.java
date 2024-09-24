package Question3.Decorator;
public class SimpleCoffee extends Coffee {
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double cost() {
        return 2.00;
    }
}
