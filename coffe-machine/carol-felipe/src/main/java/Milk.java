public class Milk extends IngredientsDecorator {
    private Coffee coffee;

    public Milk(Coffee coffee) {
        this.coffee = coffee;
    }

    public double price(){
        return 0.30 + coffee.price();
    }

    public String name(){
        return "Milk " + coffee.name();
    }
}