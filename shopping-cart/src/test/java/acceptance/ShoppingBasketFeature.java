package acceptance;

import infrastructure.IBasketRepository;
import domain.ShoppingBasketService;
import domain.memento.ShoppingBasketMemento;
import infrastructure.InMemoryBasketRepository;
import infrastructure.InMemoryProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import domain.product.ProductId;
import domain.timeserver.ITimeServer;
import domain.user.UserId;

import static org.mockito.Mockito.when;

public class ShoppingBasketFeature {

    private InMemoryProductRepository inMemoryProductRepository = new InMemoryProductRepository();
    private IBasketRepository inMemoryBasketRepository = new InMemoryBasketRepository();

    @Mock
    ITimeServer timeServer;

    @Test
    public void create_a_shopping_basket_for_a_user_containing_the_added_products() {

        MockitoAnnotations.initMocks(this);
        when(timeServer.getDate()).thenReturn("01/03/2020");

        ShoppingBasketService shoppingBasketService = new ShoppingBasketService(inMemoryProductRepository, inMemoryBasketRepository, timeServer);
        shoppingBasketService.addItem(new UserId(1), new ProductId(10002), 2);
        shoppingBasketService.addItem(new UserId(1), new ProductId(20110), 5);

        ShoppingBasketMemento basket = shoppingBasketService.basketFor(new UserId(1));

        Assert.assertEquals("Creation date : 01/03/2020\n" +
                "2x The Hobbit 2x 5.00 = €10.00\n" +
                "5x Breaking Bad 5x 7.00 = €35.00\n" +
                "Total: €45.00 ", basket.toString());
    }
}
