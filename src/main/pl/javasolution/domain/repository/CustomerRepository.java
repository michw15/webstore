package main.pl.javasolution.domain.repository;

import main.pl.javasolution.domain.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> getAllCustomers();

    Customer getCustomerById(String customerId);
}
