package main.pl.javasolution.service.impl;

import main.pl.javasolution.domain.Customer;
import main.pl.javasolution.domain.repository.CustomerRepository;
import main.pl.javasolution.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.getAllCustomers();
    }
}
