package main.pl.javasolution.service.impl;

import main.pl.javasolution.domain.Product;
import main.pl.javasolution.domain.repository.ProductRepository;
import main.pl.javasolution.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
     private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepository.getProductByCategory(category);
    }

    @Override
    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        return productRepository.getProductsByFilter(filterParams);
    }

    @Override
    public Product getProductById(String productId) {
        return productRepository.getProductById(productId);
    }

    @Override
    public List<Product> getPorductsByManufacturer(String manufacturer) {
        return productRepository.getProductsByManufacturer(manufacturer);
    }

    @Override
    public List<Product> getProductsByPrice(Map<String, String> priceParams) {
        return productRepository.getProductByPriceFilter(priceParams);
    }

    @Override
    public List<Product> getFilterProductManufacturer(String manufacturer, String category, Map<String, String> filterParams) {
        List<Product> productCategory = getProductsByCategory(category);
        List<Product> productManufacturer = getPorductsByManufacturer(manufacturer);
        List<Product> productPriceFilter = getProductsByPrice(filterParams);
        List<Product> finalProducts = productPriceFilter.stream().filter(product ->
                productCategory.stream().anyMatch(p->p.getProductId().equals(product.getProductId()))
                        && productManufacturer.stream().anyMatch(p->p.getProductId().equals(product.getProductId())))
                .collect(Collectors.toList());
        return finalProducts;
    }

    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }
}
