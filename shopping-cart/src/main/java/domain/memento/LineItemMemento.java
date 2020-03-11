package domain.memento;

import java.util.Objects;

public class LineItemMemento {
    public int quantity;
    public ProductMemento productMemento;
    public double total;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineItemMemento that = (LineItemMemento) o;
        return quantity == that.quantity &&
                Double.compare(that.total, total) == 0 &&
                Objects.equals(productMemento, that.productMemento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, productMemento, total);
    }
}
