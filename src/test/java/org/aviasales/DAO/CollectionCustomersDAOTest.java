package org.aviasales.DAO;

import org.aviasales.Entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CollectionCustomersDAOTest {
    private CollectionCustomersDAO collectionCustomersDAO1;
    private CollectionCustomersDAO collectionCustomersDAO2;
    private Customer customer;

    @BeforeEach
    void init() {
        this.collectionCustomersDAO1 = new CollectionCustomersDAO();
        this.collectionCustomersDAO2 = new CollectionCustomersDAO();
        List<Customer> customers = new ArrayList<>();
        this.customer = new Customer(1, "Eugen", "Lobok", "man", "Eugen", "123");
        customers.add(0, customer);
        this.collectionCustomersDAO1.setAllCustomers(customers);
    }

    @Test
    void getAllCustomers() {
        assertNotEquals(collectionCustomersDAO1.getAllCustomers(), collectionCustomersDAO2.getAllCustomers());
    }

    @Test
    void setAllCustomers() {
        assertNotEquals(collectionCustomersDAO1.getAllCustomers(), collectionCustomersDAO2.getAllCustomers());
    }

    @Test
    void generateID() {
        assertNotEquals(1, collectionCustomersDAO1.generateID());
    }

    @Test
    void signUp() {
        collectionCustomersDAO1.signUp(customer);
        assertNotEquals(collectionCustomersDAO1.getAllCustomers(), collectionCustomersDAO2.getAllCustomers());
    }

    @Test
    void signIn() {
        collectionCustomersDAO1.signUp(customer);
        String login = "Eugen";
        String password = "123";
        assertEquals(customer, collectionCustomersDAO1.signIn(login, password));
    }
}