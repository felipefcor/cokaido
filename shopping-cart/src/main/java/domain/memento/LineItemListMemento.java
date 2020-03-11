package domain.memento;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LineItemListMemento {
    public List<LineItemMemento> items = new ArrayList<>();
    public double total;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineItemListMemento that = (LineItemListMemento) o;
        return Double.compare(that.total, total) == 0 &&
                Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items, total);
    }

    @Override
    public String toString() {
        return "LineItemListMemento{" +
                "items=" + items +
                ", total=" + total +
                '}';
    }
}
