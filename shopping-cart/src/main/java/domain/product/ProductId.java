package domain.product;

import java.util.Objects;

public class ProductId {
    private final int productId;

    public ProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductId productId1 = (ProductId) o;
        return productId == productId1.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }
}
