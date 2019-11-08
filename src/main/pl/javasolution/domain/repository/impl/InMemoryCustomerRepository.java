package main.pl.javasolution.domain.repository.impl;

import main.pl.javasolution.domain.Customer;
import main.pl.javasolution.domain.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

    private List<Customer> listOfCustomers = new ArrayList<>();

    public InMemoryCustomerRepository(){
        Customer customer1  = new Customer("C1234","Kowalski","Rozana 33");
        customer1.setNoOfOrdersMade(true);

        Customer customer2  = new Customer("C321","Graczyk","Wawer 21");
        customer2.setNoOfOrdersMade(true);

        Customer customer3  = new Customer("C5667","Roztowski","Saska 4");
        customer3.setNoOfOrdersMade(true);

        listOfCustomers.add(customer1);
        listOfCustomers.add(customer2);
        listOfCustomers.add(customer3);
    }
    @Override
    public List<Customer> getAllCustomers() {
        return listOfCustomers;
    }

    @Override
    public Customer getCustomerById(String customerId) {
        Customer customeById = null;
        for (Customer cust : listOfCustomers) {
            if (cust != null && cust.getCustomerId() != null && cust.getCustomerId().equals(customerId)) {
                customeById = cust;
                break;
            }
        }
        if (customeById == null){
            throw new IllegalArgumentException("Brak klienta o podaym Id : "+customerId);


        }
        return customeById;
    }

}
