package infrastructure;

import domain.memento.ShoppingBasketMemento;
import domain.shoppingBasket.ShoppingBasket;
import domain.user.UserId;

public interface IBasketRepository {

    public void save(ShoppingBasket shoppingBasket);

    ShoppingBasket get(UserId userId);

    ShoppingBasketMemento memento(UserId userId);
}

