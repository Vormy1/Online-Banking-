package com.example.onlinebank;

import java.util.Objects;

/**
 * Класс Customer представляет клиента банка.
 */
public class Customer {

    private String name;
    private String email;
    private String phone;
    private BankAccount account;

    public Customer(String name, String email, String phone, BankAccount account) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.account = account;
    }

    // ===== Getters & Setters =====

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public BankAccount getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", account=" + account +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
