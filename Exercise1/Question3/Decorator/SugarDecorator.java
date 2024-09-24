package Question3.Decorator;
import Question3.Decorator.Logs.Logger;

public class SugarDecorator extends Coffee {
    private Coffee coffee;

    public SugarDecorator(Coffee coffee) {
        this.coffee = coffee;
        Logger.log("Added sugar to coffee.");
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Sugar";
    }

    @Override
    public double cost() {
        return coffee.cost() + 0.25;
    }
}
