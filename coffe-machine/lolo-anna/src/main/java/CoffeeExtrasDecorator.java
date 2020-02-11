public abstract class CoffeeExtrasDecorator implements Coffee {

    protected Coffee currentCoffee;

    public CoffeeExtrasDecorator(Coffee newCoffee) {
        this.currentCoffee = newCoffee;
    }
}

