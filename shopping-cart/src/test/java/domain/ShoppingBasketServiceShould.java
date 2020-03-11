package domain;

import infrastructure.IBasketRepository;
import infrastructure.IProductRepository;
import domain.product.ProductId;
import domain.shoppingBasket.ShoppingBasket;
import domain.timeserver.ITimeServer;
import domain.user.UserId;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import domain.product.Product;

import static org.mockito.Mockito.*;

public class ShoppingBasketServiceShould {
    @Mock IProductRepository productRepository;
    @Mock IBasketRepository basketRepository;
    @Mock ITimeServer timeServer;

    @Test
        public void send_new_shopping_basket_to_repo_when_basket_does_not_exist() {

        MockitoAnnotations.initMocks(this);
        UserId userId = new UserId(1);
        ProductId productId = new ProductId(10002);
        Product product = new Product(productId, "The Hobbit",5.00);
        ShoppingBasketService shoppingBasketService = new ShoppingBasketService(productRepository, basketRepository, timeServer);
        when(timeServer.getDate()).thenReturn("10/02/1990");
        ShoppingBasket shoppingBasket = new ShoppingBasket(userId, timeServer.getDate());
        when(basketRepository.get(userId)).thenReturn(null);
        when(productRepository.get(productId)).thenReturn(java.util.Optional.of(product));
        shoppingBasket.add(product,2);

        shoppingBasketService.addItem(userId, productId, 2);

        verify(basketRepository).save(shoppingBasket);
    }
}