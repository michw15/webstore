package main.pl.javasolution.service;

import main.pl.javasolution.domain.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProductService {

    List<Product> getAllProducts();

    List<Product> getProductsByCategory(String category);

    Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);

    Product getProductById(String productId);

    List<Product> getPorductsByManufacturer(String manufacturer);

    List<Product> getProductsByPrice(Map<String, String> priceParams);

    List<Product> getFilterProductManufacturer(String manufacturer, String category, Map<String,String> filterParams);

    void addProduct(Product product);
}
