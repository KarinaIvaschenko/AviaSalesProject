package org.aviasales.DAO;

import org.aviasales.Customer;

import java.util.ArrayList;
import java.util.List;

public class CollectionCustomersDAO implements CustomersDAO {
    private List<Customer> customers;

    public CollectionCustomersDAO() {
        this.customers = new ArrayList<>();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return this.customers;
    }

    @Override
    public void setAllCustomers(List<Customer> customers) {
        this.customers = customers;
    }
    @Override
    public int generateID() {
        if (this.customers.isEmpty()) {
            return 1;
        } else {
            return this.customers.size() + 1;
        }
    }

    @Override
    public void signUp(Customer customer) {
        if (this.customers.contains(customer)) {
            int index = this.customers.indexOf(customer);
            this.customers.set(index, customer);
        } else {
            this.customers.add(customer);
        }
    }

    @Override
    public Customer signIn(String login, String password) {
        return this.customers.stream()
                .filter(customer -> customer.getLogin().equals(login) && customer.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }
}
