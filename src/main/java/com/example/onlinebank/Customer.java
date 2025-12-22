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

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }

    /**
     * Выводит информацию о клиенте в консоль.
     */
    public void printInfo() {
        System.out.println("Customer{name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", account=" + account + "}");
    }

    /**
     * Строковое представление клиента.
     */
    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", account=" + account +
                '}';
    }

    /**
     * Переопределение equals.
     * Клиенты считаются одинаковыми, если совпадает email.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;
        return Objects.equals(email, customer.email);
    }

    /**
     * Переопределение hashCode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
