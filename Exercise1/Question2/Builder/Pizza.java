
public class Pizza {
    private String size;
    private boolean cheese;
    private boolean pepperoni;
    private boolean mushrooms;
    private boolean onions;

    public Pizza(PizzaBuilder builder) {
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
        this.mushrooms = builder.mushrooms;
        this.onions = builder.onions;
    }

    @Override
    public String toString() {
        return "Pizza [Size=" + size + 
                ", Cheese=" + cheese + 
                ", Pepperoni=" + pepperoni + 
                ", Mushrooms=" + mushrooms + 
                ", Onions=" + onions + "]";
    }
}

