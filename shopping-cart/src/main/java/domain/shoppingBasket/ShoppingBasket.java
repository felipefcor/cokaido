package domain.shoppingBasket;

import domain.exceptions.NegativeQuantityException;
import domain.exceptions.ProductDoesNotExistException;
import domain.lineItem.LineItemList;
import domain.memento.ShoppingBasketMemento;
import domain.user.UserId;
import domain.product.Product;

import java.util.Objects;

public class ShoppingBasket {

    private final UserId userId;
    private final String date;
    private LineItemList lineItemList = new LineItemList();

    public ShoppingBasket(UserId userId, String date) {
        this.userId = userId;
        this.date = date;

    }

    public void add(Product product, int quantity) throws NegativeQuantityException, ProductDoesNotExistException {
        if(product == null) throw new ProductDoesNotExistException();
        if(quantity < 0) throw new NegativeQuantityException();
        this.lineItemList.add(product, quantity);
    }

    public void remove(Product product, int quantity) {
        this.lineItemList.remove(product, quantity);
    }

    public ShoppingBasketMemento createMemento() {
        ShoppingBasketMemento shoppingBasketMemento = new ShoppingBasketMemento();
        shoppingBasketMemento.date = this.date;
        shoppingBasketMemento.lineItemList = lineItemList.createMemento();
        shoppingBasketMemento.userId = userId.createMemento();

        return shoppingBasketMemento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingBasket that = (ShoppingBasket) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(date, that.date) &&
                Objects.equals(lineItemList, that.lineItemList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, date, lineItemList);
    }

    @Override
    public String toString() {
        return "ShoppingBasket{" +
                "userId=" + userId +
                ", date='" + date + '\'' +
                ", lineItemList=" + lineItemList +
                '}';
    }


}
