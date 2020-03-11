package infrastructure;

import domain.shoppingBasket.ShoppingBasket;
import domain.user.UserId;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryBasketRepositoryShould {
    @Test
    public void save_and_retrieve_a_shoping_basket_correctly(){

        ShoppingBasket shoppingBasket = new ShoppingBasket(new UserId(1), "04/03/2020");
        InMemoryBasketRepository inMemoryBasketRepository = new InMemoryBasketRepository();
        inMemoryBasketRepository.save(shoppingBasket);

        Assert.assertEquals(shoppingBasket, inMemoryBasketRepository.get(new UserId(1)));
    }
}