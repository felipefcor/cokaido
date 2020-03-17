package com.lifull.bankata;

import com.lifull.bankata.infrastructure.IBasketRepository;
import com.lifull.bankata.memento.ShoppingBasketMemento;
import com.lifull.bankata.infrastructure.IProductRepository;
import com.lifull.bankata.product.ProductId;
import com.lifull.bankata.shoppingBasket.ShoppingBasket;
import com.lifull.bankata.user.UserId;
import com.lifull.bankata.timeserver.ITimeServer;
import com.lifull.bankata.product.Product;

public class ShoppingBasketService {
    private final IProductRepository productRepository;
    private final IBasketRepository basketRepository;
    private final ITimeServer timeServer;

    public ShoppingBasketService(IProductRepository productRepository, IBasketRepository basketRepository, ITimeServer timeServer) {
        this.productRepository = productRepository;
        this.basketRepository = basketRepository;
        this.timeServer = timeServer;
    }

    public void addItem(UserId userId, ProductId productId, int quantity) {
        ShoppingBasket shoppingBasket = basketRepository.get(userId);
        if (shoppingBasket == null) shoppingBasket = new ShoppingBasket(userId, timeServer.getDate());

        Product product = productRepository.get(productId).orElse(null);
        shoppingBasket.add(product, quantity);
        basketRepository.save(shoppingBasket);
    }

    public ShoppingBasketMemento basketFor(UserId userId) {

        return basketRepository.memento(userId);
    }

    @Override
    public String toString() {
        return "ShoppingBasketService{" +
                "productRepository=" + productRepository +
                ", basketRepository=" + basketRepository +
                ", timeServer=" + timeServer +
                '}';
    }
}
