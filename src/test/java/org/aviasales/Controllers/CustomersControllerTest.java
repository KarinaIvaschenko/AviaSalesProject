package org.aviasales.Controllers;

import org.aviasales.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomersControllerTest {
    private CustomersController customersController1;
    private CustomersController customersController2;
    private Customer customer;

    @BeforeEach
    void init() {
        this.customersController1 = new CustomersController();
        this.customersController2 = new CustomersController();
        List<Customer> customers = new ArrayList<>();
        this.customer = new Customer(1, "Eugen", "Lobok", "man", "Eugen", "123");
        customers.add(0, customer);
        this.customersController1.setAllCustomers(customers);
    }
    @Test
    void getAllCustomers() {
        assertNotEquals(customersController1.getAllCustomers(), customersController2.getAllCustomers());
    }

    @Test
    void setAllCustomers() {
        assertNotEquals(customersController1.getAllCustomers(), customersController2.getAllCustomers());
    }

    @Test
    void generateID() {
        assertNotEquals(1, customersController1.generateID());
    }

    @Test
    void signUp() {
        customersController1.signUp(customer);
        assertNotEquals(customersController1.getAllCustomers(), customersController2.getAllCustomers());
    }

    @Test
    void signIn() {
        customersController1.signUp(customer);
        String login = "Eugen";
        String password = "123";
        assertEquals(customer, customersController1.signIn(login, password));
    }

}