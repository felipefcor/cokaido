public class Whisky extends Extra {
    Price price;
    String name;

    public Whisky(Coffee coffee) {
        super(coffee);
        price = coffee.getPrice();
        name = coffee.getName();
    }

    @Override
    public Price getPrice() {
        price.add(2.0);
        return price;
    }

    @Override
    public String getName() {
        return "Irish " + name;
    }
}
