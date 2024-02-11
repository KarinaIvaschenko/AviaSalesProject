package org.aviasales.DAO;

import org.aviasales.Customer;

import java.util.List;

public interface CustomersDAO {
    List<Customer> getAllCustomers();

    void setAllCustomers(List<Customer> customers);

    int generateID();
    public void signUp(Customer customer);
    public Customer signIn(String login, String password);
}
