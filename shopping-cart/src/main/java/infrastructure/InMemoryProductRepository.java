package infrastructure;

import domain.product.Product;
import domain.product.ProductId;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryProductRepository implements IProductRepository {

    Map<ProductId, Product> productList = new HashMap();

    public InMemoryProductRepository() {
        Product hobbit = new Product(new ProductId(10002), "The Hobbit", 5.00);
        Product rings = new Product(new ProductId(10001), "Lord of the Rings", 10.00);
        Product got = new Product(new ProductId(20001), "Game of Thrones", 9.00);
        Product heinsenberg = new Product(new ProductId(20110), "Breaking Bad", 7.00);

        productList.put(new ProductId(10002), hobbit);
        productList.put(new ProductId(10001), rings);
        productList.put(new ProductId(20001), got);
        productList.put(new ProductId(20110), heinsenberg);
    }

    @Override
    public Optional<Product> get(ProductId productId) {
        if(productList.containsKey(productId)) return Optional.ofNullable(productList.get(productId));
        return Optional.empty();
    }
}
