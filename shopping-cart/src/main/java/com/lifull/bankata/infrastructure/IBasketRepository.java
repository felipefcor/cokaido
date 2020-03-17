package com.lifull.bankata.infrastructure;

import com.lifull.bankata.memento.ShoppingBasketMemento;
import com.lifull.bankata.shoppingBasket.ShoppingBasket;
import com.lifull.bankata.user.UserId;

public interface IBasketRepository {

    public void save(ShoppingBasket shoppingBasket);

    ShoppingBasket get(UserId userId);

    ShoppingBasketMemento memento(UserId userId);
}

