package main.pl.javasolution.domain.repository;

import main.pl.javasolution.domain.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProductRepository {
    List<Product> getAllProducts();

    Product getProductById(String productId);

    List<Product> getProductByCategory(String category);

    Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
}
