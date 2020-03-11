package infrastructure;

import domain.memento.ShoppingBasketMemento;
import domain.shoppingBasket.ShoppingBasket;
import domain.user.UserId;

import java.util.HashMap;

public class InMemoryBasketRepository implements IBasketRepository {

    HashMap<UserId, ShoppingBasket> userBasketList = new HashMap<UserId, ShoppingBasket>();

    @Override
    public void save(ShoppingBasket shoppingBasket) {
        ShoppingBasketMemento shoppingBasketMemento = shoppingBasket.createMemento();
        userBasketList.put(new UserId(shoppingBasketMemento.userId.id), shoppingBasket);
    }

    @Override
    public ShoppingBasket get(UserId userId) {
        if(userBasketList.containsKey(userId)) return userBasketList.get(userId);
        return null;
    }

    @Override
    public ShoppingBasketMemento memento(UserId userId) {
        ShoppingBasket shoppingBasket = get(userId);
        if(shoppingBasket == null) return null;
        return shoppingBasket.createMemento();
    }
}
