/*
package controllers;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ShoppingBasketControllerShould {
    @Mock
    InMemoryBasketRepository basketRepository;
    @Mock
    SQLProductRepository productRepository;
    @Mock
    ITimeServer timeServer;
    @InjectMocks
    private ShoppingBasketController controller;

    @Test
    public void retrieve_basket_from_userId() {

        MockitoAnnotations.initMocks(this);
        when(basketRepository.memento(new UserId(1))).thenReturn(new ShoppingBasketMemento());

        ResponseEntity<ShoppingBasketMemento> basket = controller.shoppingBasketByUserId(1);

        Assert.assertNotNull(basket);
        Assert.assertEquals(HttpStatus.OK, basket.getStatusCode());
    }
}
*/
