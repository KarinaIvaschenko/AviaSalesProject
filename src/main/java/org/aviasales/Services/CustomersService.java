package org.aviasales.Services;

import org.aviasales.Customer;
import org.aviasales.DAO.CollectionCustomersDAO;

import java.util.List;

public class CustomersService {
    private final CollectionCustomersDAO collectionCustomersDAO = new CollectionCustomersDAO();

    public List<Customer> getAllCustomers() {
        return collectionCustomersDAO.getAllCustomers();
    }

    public void setAllCustomers(List<Customer> customers) {
        collectionCustomersDAO.setAllCustomers(customers);
    }

    public int generateID() {
        return collectionCustomersDAO.generateID();
    }

    public void signUp(Customer customer) {
     collectionCustomersDAO.signUp(customer);
    }
}
