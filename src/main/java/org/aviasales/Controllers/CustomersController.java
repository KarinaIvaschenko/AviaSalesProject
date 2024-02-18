package org.aviasales.Controllers;

import org.aviasales.Entity.Customer;
import org.aviasales.Services.CustomersService;

import java.util.List;

public class CustomersController {
    CustomersService customersService;

    public CustomersController(CustomersService customersService) {
        this.customersService = customersService;
    }

    public List<Customer> getAllCustomers() {
        return customersService.getAllCustomers();
    }

    public void setAllCustomers(List<Customer> customers) {
        customersService.setAllCustomers(customers);
    }

    public int generateID() {
        return customersService.generateID();
    }

    public void signUp(Customer customer) {
        customersService.signUp(customer);
    }

    public Customer signIn(String login, String password) {
        return customersService.signIn(login, password);
    }
}
