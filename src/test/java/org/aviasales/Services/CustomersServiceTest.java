package org.aviasales.Services;

import org.aviasales.DAO.CollectionCustomersDAO;
import org.aviasales.Entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomersServiceTest {

    private CustomersService customersService1;
    private CustomersService customersService2;
    private Customer customer;

    @BeforeEach
    void init() {
        this.customersService1 = new CustomersService(new CollectionCustomersDAO());
        this.customersService2 = new CustomersService(new CollectionCustomersDAO());
        List<Customer> customers = new ArrayList<>();
        this.customer = new Customer(1, "Eugen", "Lobok", "man", "Eugen", "123");
        customers.add(0, customer);
        this.customersService1.setAllCustomers(customers);
    }
    @Test
    void getAllCustomers() {
        assertNotEquals(customersService1.getAllCustomers(), customersService2.getAllCustomers());
    }

    @Test
    void setAllCustomers() {
        assertNotEquals(customersService1.getAllCustomers(), customersService2.getAllCustomers());
    }

    @Test
    void generateID() {
        assertNotEquals(1, customersService1.generateID());
    }

    @Test
    void signUp() {
        customersService1.signUp(customer);
        assertNotEquals(customersService1.getAllCustomers(), customersService2.getAllCustomers());
    }

    @Test
    void signIn() {
        customersService1.signUp(customer);
        String login = "Eugen";
        String password = "123";
        assertEquals(customer, customersService1.signIn(login, password));
    }
}