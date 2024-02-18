package org.aviasales.Services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aviasales.Entity.Customer;
import org.aviasales.DAO.CollectionCustomersDAO;

import java.util.List;

public class CustomersService {
    private final CollectionCustomersDAO collectionCustomersDAO;
    private static final Logger logger = LogManager.getLogger(CustomersService.class);

    public CustomersService(CollectionCustomersDAO collectionCustomersDAO) {
        this.collectionCustomersDAO = collectionCustomersDAO;
    }
    public List<Customer> getAllCustomers() {
        logger.info("loading all customers");
        return collectionCustomersDAO.getAllCustomers();
    }

    public void setAllCustomers(List<Customer> customers) {
        logger.info("saving all customers");
        collectionCustomersDAO.setAllCustomers(customers);
    }

    public int generateID() {
        logger.info("generating customer's id");
        return collectionCustomersDAO.generateID();
    }

    public void signUp(Customer customer) {
        logger.info("sign up customer");
        collectionCustomersDAO.signUp(customer);
    }

    public Customer signIn(String login, String password) {
        logger.info("sign in customer");
        return collectionCustomersDAO.signIn(login, password);
    }
}
