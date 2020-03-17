package com.lifull.bankata.infrastructure;

import com.lifull.bankata.product.Product;
import com.lifull.bankata.product.ProductId;

import java.util.Optional;

public interface IProductRepository {

    Optional<Product> get(ProductId productId);
}
