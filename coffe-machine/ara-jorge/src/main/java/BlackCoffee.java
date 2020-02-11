public class BlackCoffee implements Coffee {
    String name;
    Price price;

    public BlackCoffee(){
        name = "Coffee";
        price = new Price(1.0);
    }

    @Override
    public Price getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }
}
