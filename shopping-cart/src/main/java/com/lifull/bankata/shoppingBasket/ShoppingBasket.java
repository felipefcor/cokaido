package com.lifull.bankata.shoppingBasket;

import com.lifull.bankata.exceptions.ProductDoesNotExistException;
import com.lifull.bankata.exceptions.NegativeQuantityException;
import com.lifull.bankata.lineItem.LineItemList;
import com.lifull.bankata.memento.ShoppingBasketMemento;
import com.lifull.bankata.user.UserId;
import com.lifull.bankata.product.Product;

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
