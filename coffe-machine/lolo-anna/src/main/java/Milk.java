public class Milk extends CoffeeExtrasDecorator {

    public Milk(Coffee currentCoffee) {
        super(currentCoffee);
    }

    public String getDescription() {
        return "Milk " + currentCoffee.getDescription();
    }

    public double getCost() {
        return currentCoffee.getCost() + 0.30;
    }
}

