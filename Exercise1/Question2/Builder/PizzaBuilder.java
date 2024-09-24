public class PizzaBuilder {
    public String size;
    public boolean cheese;
    public boolean pepperoni;
    public boolean mushrooms;
    public boolean onions;

    public PizzaBuilder(String size) {
        this.size = size;
    }

    public PizzaBuilder addCheese(boolean cheese) {
        this.cheese = cheese;
        return this;
    }

    public PizzaBuilder addPepperoni(boolean pepperoni) {
        this.pepperoni = pepperoni;
        return this;
    }

    public PizzaBuilder addMushrooms(boolean mushrooms) {
        this.mushrooms = mushrooms;
        return this;
    }

    public PizzaBuilder addOnions(boolean onions) {
        this.onions = onions;
        return this;
    }

    public Pizza build() {
        return new Pizza(this);
    }
}
