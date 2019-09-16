package main.pl.javasolution.domain.repository;

import main.pl.javasolution.domain.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getAllProducts();

    Product getProductById(String productId);
}
