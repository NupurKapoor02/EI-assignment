package Question3.Decorator;
import Question3.Decorator.Logs.Logger;

public class MilkDecorator extends Coffee {
    private Coffee coffee;

    public MilkDecorator(Coffee coffee) {
        this.coffee = coffee;
        Logger.log("Added milk to coffee.");
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }

    @Override
    public double cost() {
        return coffee.cost() + 0.50;
    }
}
