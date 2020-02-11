public class Milk extends Extra {


    public Milk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public Price getPrice() {
        Price price = inProgressCoffee.getPrice();
        price.add(0.3);
        return price;
    }

    @Override
    public String getName() {
        return "Milk " + inProgressCoffee.getName();
    }
}
