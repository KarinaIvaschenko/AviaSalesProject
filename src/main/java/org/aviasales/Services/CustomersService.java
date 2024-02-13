package org.aviasales.Services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aviasales.Customer;
import org.aviasales.DAO.CollectionCustomersDAO;

import java.util.List;

public class CustomersService {
    private final CollectionCustomersDAO collectionCustomersDAO = new CollectionCustomersDAO();
    private static final Logger logger = LogManager.getLogger(CustomersService.class);

    public List<Customer> getAllCustomers() {
        logger.info("loading all customers");
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

    public Customer signIn(String login, String password) {
        return collectionCustomersDAO.signIn(login, password);
    }
}
