package org.aviasales.DAO;

import org.aviasales.Booking;
import org.aviasales.Customer;
import org.aviasales.Enums.Aircrafts;
import org.aviasales.Enums.Aviacompanies;
import org.aviasales.Enums.Cities;
import org.aviasales.Flight;
import org.aviasales.Human;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CollectionCustomersDAOTest {

    @Test
    void getAllCustomers() {
        CollectionCustomersDAO collectionCustomersDAO1 = new CollectionCustomersDAO();
        CollectionCustomersDAO collectionCustomersDAO2 = new CollectionCustomersDAO();
        Customer customer = new Customer(1,"Eugen", "Lobok", "man", "Eugen", "123");
        List<Customer> customers = new ArrayList<>();
        customers.add(0, customer);
        collectionCustomersDAO1.setAllCustomers(customers);
        assertNotEquals(collectionCustomersDAO1.getAllCustomers(), collectionCustomersDAO2.getAllCustomers());
    }

    @Test
    void setAllCustomers() {
        CollectionCustomersDAO collectionCustomersDAO1 = new CollectionCustomersDAO();
        CollectionCustomersDAO collectionCustomersDAO2 = new CollectionCustomersDAO();
        Customer customer = new Customer(1,"Eugen", "Lobok", "man", "Eugen", "123");
        List<Customer> customers = new ArrayList<>();
        customers.add(0, customer);
        collectionCustomersDAO1.setAllCustomers(customers);
        assertNotEquals(collectionCustomersDAO1.getAllCustomers(), collectionCustomersDAO2.getAllCustomers());
    }

    @Test
    void generateID() {
        CollectionCustomersDAO collectionCustomersDAO1 = new CollectionCustomersDAO();
        Customer customer = new Customer(1, "Eugen", "Lobok", "man", "Eugen", "123");
        List<Customer> customers = new ArrayList<>();
        customers.add(0, customer);
        collectionCustomersDAO1.setAllCustomers(customers);
        assertNotEquals(1, collectionCustomersDAO1.generateID());
    }

    @Test
    void signUp() {
        CollectionCustomersDAO collectionCustomersDAO1 = new CollectionCustomersDAO();
        CollectionCustomersDAO collectionCustomersDAO2 = new CollectionCustomersDAO();
        Customer customer = new Customer(1, "Eugen", "Lobok", "man", "Eugen", "123");
        collectionCustomersDAO1.signUp(customer);
        assertNotEquals(collectionCustomersDAO1.getAllCustomers(), collectionCustomersDAO2.getAllCustomers());
    }

    @Test
    void signIn() {
        CollectionCustomersDAO collectionCustomersDAO1 = new CollectionCustomersDAO();
        Customer customer = new Customer(1, "Eugen", "Lobok", "man", "Eugen", "123");
        collectionCustomersDAO1.signUp(customer);
        String login = "Eugen";
        String password = "123";
        assertEquals(customer, collectionCustomersDAO1.signIn(login, password));
    }
}