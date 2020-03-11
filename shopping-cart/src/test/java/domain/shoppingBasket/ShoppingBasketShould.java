package domain.shoppingBasket;

import domain.exceptions.NegativeQuantityException;
import domain.exceptions.ProductDoesNotExistException;
import domain.memento.*;
import domain.product.ProductId;
import domain.user.UserId;
import org.junit.Assert;
import domain.product.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShoppingBasketShould {

    @Test
    void increase_basket_products_quantity() {

        ProductId productId = new ProductId(10002);
        Product product = new Product(productId, "The Hobbit",5.00);
        ShoppingBasket shoppingBasket = new ShoppingBasket(new UserId(1),"04/03/2020");
        ShoppingBasket expectedShoppingBasket = new ShoppingBasket(new UserId(1),"04/03/2020");
        expectedShoppingBasket.add(product,2);

        shoppingBasket.add(product, 1);
        shoppingBasket.add(product, 1);

        Assert.assertEquals(expectedShoppingBasket, shoppingBasket);
    }

    @Test
    public void not_allow_add_negative_quantity(){
        ProductId productId = new ProductId(10002);
        Product product = new Product(productId, "The Hobbit",5.00);
        ShoppingBasket shoppingBasket = new ShoppingBasket(new UserId(1),"04/03/2020");

        Assertions.assertThrows(NegativeQuantityException.class, ()-> shoppingBasket.add(product, -1));
    }

    @Test
    public void remove_product_from_shoppingBasket() {

        ProductId productId = new ProductId(10002);
        Product product = new Product(productId, "The Hobbit",5.00);
        ShoppingBasket shoppingBasket = new ShoppingBasket(new UserId(1), "04/03/2020");
        ShoppingBasket expectedShoppingBasket = new ShoppingBasket(new UserId(1),"04/03/2020");
        shoppingBasket.add(product, 1);
        shoppingBasket.add(product, 1);
        expectedShoppingBasket.add(product, 1);

        shoppingBasket.remove(product, 1);

        Assert.assertEquals(expectedShoppingBasket, shoppingBasket);
    }

    @Test
    public void remove_product_from_shopping_basket_if_quantity_is_zero(){

        ProductId productId = new ProductId(10002);
        Product product = new Product(productId, "The Hobbit",5.00);
        ShoppingBasket shoppingBasket = new ShoppingBasket(new UserId(1), "04/03/2020");
        ShoppingBasket expectedShoppingBasket = new ShoppingBasket(new UserId(1),"04/03/2020");
        shoppingBasket.add(product, 1);

        shoppingBasket.remove(product, 1);

        Assert.assertEquals(expectedShoppingBasket, shoppingBasket);
    }

    @Test
    public void not_allow_to_add_a_non_existent_product(){
        ShoppingBasket shoppingBasket = new ShoppingBasket(new UserId(1), "04/03/2020");

        Assertions.assertThrows(ProductDoesNotExistException.class, ()-> shoppingBasket.add(null,1));
    }

    @Test
    public void know_how_to_create_a_memento_with_its_state() {
        ShoppingBasket shoppingBasket = new ShoppingBasket(new UserId(1), "04/03/2020");
        Product product = new Product(new ProductId(10002), "The Hobbit", 5.00);
        shoppingBasket.add(product, 2);
        ShoppingBasketMemento expectedMemento = new ShoppingBasketMemento();
        expectedMemento.date = "04/03/2020";
        ProductMemento productMemento = new ProductMemento();
        productMemento.name = "The Hobbit";
        productMemento.price = 5.00;
        LineItemMemento lineItemMemento = new LineItemMemento();
        lineItemMemento.productMemento = productMemento;
        lineItemMemento.quantity = 2;
        lineItemMemento.total = 10.00;
        expectedMemento.lineItemList = new LineItemListMemento();
        expectedMemento.lineItemList.items.add(lineItemMemento);
        expectedMemento.lineItemList.total = 10.00;
        UserIdMemento userIdMemento = new UserIdMemento();
        userIdMemento.id = 1;
        expectedMemento.userId = userIdMemento;

        ShoppingBasketMemento memento = shoppingBasket.createMemento();

        Assert.assertEquals(expectedMemento, memento);
    }

    @Test
    public void print_summary() {
        ShoppingBasket shoppingBasket = new ShoppingBasket(new UserId(1), "04/03/2020");
        Product product = new Product(new ProductId(10002), "The Hobbit", 5.00);
        shoppingBasket.add(product, 2);
        String expectedShoppingBasket = "Creation date : 04/03/2020\n" +
                "2x The Hobbit 2x 5.00 = €10.00\n" + "Total: €10.00 ";
        ShoppingBasketMemento shoppingBasketMemento = shoppingBasket.createMemento();

        Assert.assertEquals(expectedShoppingBasket, shoppingBasketMemento.toString());
    }

}