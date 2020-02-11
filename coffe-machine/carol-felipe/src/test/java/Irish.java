public class Irish implements Coffee {
    private Coffee coffee;

    public Irish(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public double price() {
        return 1.00 + coffee.price() ;
    }

    @Override
    public String name() {
        return "Irish " + coffee.name() ;
    }
}
