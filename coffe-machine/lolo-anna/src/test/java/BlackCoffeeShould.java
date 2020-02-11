import org.junit.Assert;
import org.junit.Test;

public class BlackCoffeeShould {

    @Test
    public void have_coffee_as_description_and_1_euro_price_by_default() {

        Coffee blackCoffee = new BlackCoffee();

        Assert.assertEquals("Coffee", blackCoffee.getDescription());
        Assert.assertEquals(1.00, blackCoffee.getCost(), 2);
    }

    @Test
    public void get_Milk_Coffee_ass_description_and_1euro_30cents_as_price(){
        Coffee milkCoffee = new Milk(new BlackCoffee());

        Assert.assertEquals("Milk Coffee", milkCoffee.getDescription());
        Assert.assertEquals(1.30, milkCoffee.getCost(), 2);
    }

    @Test
    public void get_Irish_as_description_and_2euros_as_price(){
        Coffee irishCoffee = new Whisky(new BlackCoffee());

        Assert.assertEquals("Irish Coffee", irishCoffee.getDescription());
        Assert.assertEquals(2.00, irishCoffee.getCost(),2);
    }

    @Test
    public void get_Irish_Milk_coffee_as_description_and_2euros_30cents_as_price(){
        Coffee irishMilkCoffee = new Whisky(new Milk(new BlackCoffee()));

        Assert.assertEquals("Irish Milk Coffee", irishMilkCoffee.getDescription());
        Assert.assertEquals(2.30, irishMilkCoffee.getCost(),2);
    }
}
