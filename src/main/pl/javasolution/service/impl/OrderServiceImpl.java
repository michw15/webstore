package main.pl.javasolution.service.impl;

import main.pl.javasolution.domain.Product;
import main.pl.javasolution.domain.repository.ProductRepository;
import main.pl.javasolution.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void processOrder(String productId, int count) {
        Product productById = productRepository.getProductById(productId);
        if (productById.getUnitsInStock() < count){
            throw new IllegalArgumentException("Zbyt mało towaru. Obecna liczba sztuk w magazynie: "+ productById.getUnitsInStock());
        }
        productById.setUnitsInStock(productById.getUnitsInStock() - count);
    }
}
