package main.pl.javasolution.domain.repository.impl;

import main.pl.javasolution.domain.Product;
import main.pl.javasolution.domain.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private List<Product> listOfProducts = new ArrayList<>();

    public InMemoryProductRepository(){

        Product iphone = new Product("P1234","iPhone 6s", new BigDecimal(500));
        iphone.setDescription("Apple iphone, smartfon z 5 calowym wyswietlaczem");
        iphone.setCategory("Smart phone");
        iphone.setManufacturer("Apple");
        iphone.setUnitsInStock(1000);

        Product laptop_dell = new Product("P1235","Dell Inspiration", new BigDecimal(700));
        laptop_dell.setDescription("Dell inspiration 14 calowy z procesem Intel Core 3");
        laptop_dell.setCategory("Laptop");
        laptop_dell.setManufacturer("Dell");
        laptop_dell.setUnitsInStock(1000);

        Product tablet_Nexus = new Product("P1236","Nexus 7", new BigDecimal(300));
        tablet_Nexus.setDescription("Apple iphone, smartfon z 5 calowym wyswietlaczem");
        tablet_Nexus.setCategory("Tablet");
        tablet_Nexus.setManufacturer("Google");
        tablet_Nexus.setUnitsInStock(1000);

        listOfProducts.add(tablet_Nexus);
        listOfProducts.add(iphone);
        listOfProducts.add(laptop_dell);
    }

    @Override
    public List<Product> getAllProducts() {
        return listOfProducts;
    }

    @Override
    public Product getProductById(String productId) {
        Product productById = null;
        for (Product product : listOfProducts){
            if (product!= null && product.getProductId()!=null && product.getProductId().equals(productId)){
                productById = product;
                break;
            }
        }
        if (productById == null){
            throw new IllegalArgumentException("Brak przedmiotu o wskazanym id: "+ productId);
        }
        return productById;
    }

    @Override
    public List<Product> getProductByCategory(String category) {
        List<Product> productByCategory = new ArrayList<>();
        listOfProducts.stream().forEach(product -> {
            if (category.equalsIgnoreCase(product.getCategory())){
                productByCategory.add(product);
            }
        });
        return productByCategory;
    }

    @Override
    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        Set<Product> productsByBrand = new HashSet<>();
        Set<Product> productsByCategory = new HashSet<>();
        Set<String> criterias = filterParams.keySet();
        if (criterias.contains("brand")){
            filterParams.get("brand").stream().forEach(brandName ->{
                listOfProducts.stream().forEach(product -> {
                    if(brandName.equalsIgnoreCase(product.getManufacturer())){
                        productsByBrand.add(product);
                    }
                });
            });
        }
        if (criterias.contains("category")){
            filterParams.get("category").stream().forEach(category ->
                    productsByCategory.addAll(this.getProductByCategory(category)));
        }
        productsByCategory.retainAll(productsByBrand);
        return productsByCategory;
    }
}
