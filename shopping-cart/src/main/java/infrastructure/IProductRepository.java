package infrastructure;

import domain.product.Product;
import domain.product.ProductId;

import java.util.Optional;

public interface IProductRepository {

    Optional<Product> get(ProductId productId);
}
