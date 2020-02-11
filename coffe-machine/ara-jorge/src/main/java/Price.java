import java.util.Objects;

public class Price {
    private Double price;

    public Price(Double price) {
        this.price = price;
    }

    public void add(double addValue) {
        price = price + addValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return Objects.equals(price, price1.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }

}
