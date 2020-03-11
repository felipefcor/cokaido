package domain.lineItem;

import domain.memento.LineItemMemento;
import domain.product.Product;

import java.util.Objects;

public class LineItem {
    private final Product product;
    private int quantity;

    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public void increaseQuantity(int quantity) {
        this.quantity += quantity;
    }

    public boolean checkProduct(Product product) {
        return this.product.equals(product);
    }

    public void decreaseQuantity(int quantity) {
        this.quantity -= quantity;
    }

    public LineItemMemento createMemento() {
        LineItemMemento lineItemMemento = new LineItemMemento();
        lineItemMemento.quantity = this.quantity;
        lineItemMemento.productMemento = product.createMemento();
        lineItemMemento.total = calculateTotal();
        return lineItemMemento;
    }

    public double calculateTotal() {
        return product.calculateTotal(this.quantity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineItem lineItem = (LineItem) o;
        return quantity == lineItem.quantity &&
                Objects.equals(product, lineItem.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, quantity);
    }


    public boolean isQuantityZero() {
        return this.quantity <= 0;
    }

    @Override
    public String toString() {
        return "LineItem{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
