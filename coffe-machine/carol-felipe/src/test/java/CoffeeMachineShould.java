import org.junit.Assert;
import org.junit.Test;

public class CoffeeMachineShould {
    @Test
    public void display_Coffee_as_name_1_euro_as_price() {
        Coffee coffee = new BlackCoffee();

        Assert.assertEquals("Coffee", coffee.name());
        Assert.assertEquals(1.00, coffee.price(), 2);
    }

    @Test
    public void display_Milk_Coffee_as_name_1_30_euro_as_price() {
        Coffee milkCoffee = new Milk(new BlackCoffee());

        Assert.assertEquals("Milk Coffee", milkCoffee.name());
        Assert.assertEquals(1.30, milkCoffee.price(), 2);
    }

    @Test
    public void display_Irish_Coffee_as_name_2_euros_as_price() {
        Coffee irishCoffee = new Irish(new BlackCoffee());

        Assert.assertEquals("Irish Coffee", irishCoffee.name());
        Assert.assertEquals(2.00, irishCoffee.price(), 2);
    }

    @Test
    public void displays_Irish_Milk_Coffee_as_name_2and30_as_price() {
        Coffee irishMilkCoffee = new Irish(new Milk(new BlackCoffee()));

        Assert.assertEquals("Irish Milk Coffee", irishMilkCoffee.name());
        Assert.assertEquals(2.30, irishMilkCoffee.price(), 2);

    }
}
