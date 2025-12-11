package com.example.onlinebank;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Bank {
    private String name;
    private List<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    // Getters & Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Customer> getCustomers() { return customers; }
    public void setCustomers(List<Customer> customers) { this.customers = customers; }

    // Methods
    public void addCustomer(Customer customer) {
        if (customer == null) return;
        // проверка по email
        Optional<Customer> exists = customers.stream()
                .filter(c -> c.getEmail().equals(customer.getEmail()))
                .findFirst();
        if (exists.isPresent()) {
            System.out.println("Customer with email " + customer.getEmail() + " already exists.");
        } else {
            customers.add(customer);
            System.out.println("Added customer: " + customer.getName());
        }
    }

    public void printAllCustomers() {
        System.out.println("Customers in " + name + ":");
        for (Customer c : customers) {
            System.out.println(c);
        }
    }

    public Customer findCustomerByEmail(String email) {
        for (Customer c : customers) {
            if (c.getEmail().equals(email)) return c;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", customersCount=" + customers.size() +
                '}';
    }
}
