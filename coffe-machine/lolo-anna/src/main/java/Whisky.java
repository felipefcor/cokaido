public class Whisky extends CoffeeExtrasDecorator {
    public Whisky(Coffee currentCoffee) {
        super(currentCoffee);
    }

    public String getDescription() {
        return "Irish " + currentCoffee.getDescription();
    }

    public double getCost() {
        return currentCoffee.getCost() + 1.00;
    }

}
