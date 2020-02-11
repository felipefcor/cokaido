public abstract class Extra implements Coffee{

    protected Coffee inProgressCoffee;

    public Extra(Coffee coffee) {
        this.inProgressCoffee = coffee;
    }
}