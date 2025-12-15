package com.example.onlinebank;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Класс Bank представляет банк.
 * Хранит список клиентов и управляет ими.
 */
public class Bank {

    // Название банка
    private String name;

    // Список клиентов банка
    private List<Customer> customers;

    /**
     * Конструктор банка.
     * Инициализирует название банка и пустой список клиентов.
     */
    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    // ===== Getters & Setters =====

    // Возвращает название банка
    public String getName() {
        return name;
    }

    // Устанавливает новое название банка
    public void setName(String name) {
        this.name = name;
    }

    // Возвращает список клиентов
    public List<Customer> getCustomers() {
        return customers;
    }

    // Устанавливает новый список клиентов
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    // ===== Business methods =====

    /**
     * Добавляет клиента в банк.
     * Проверяет, чтобы клиент с таким email не существовал.
     */
    public void addCustomer(Customer customer) {
        // Проверка на null
        if (customer == null) return;

        // Поиск клиента с таким же email
        Optional<Customer> exists = customers.stream()
                .filter(c -> c.getEmail().equals(customer.getEmail()))
                .findFirst();

        // Если клиент уже существует — не добавляем
        if (exists.isPresent()) {
            System.out.println("Customer with email " + customer.getEmail() + " already exists.");
        } else {
            customers.add(customer);
            System.out.println("Added customer: " + customer.getName());
        }
    }

    /**
     * Выводит всех клиентов банка в консоль.
     */
    public void printAllCustomers() {
        System.out.println("Customers in " + name + ":");
        for (Customer c : customers) {
            System.out.println(c);
        }
    }

    /**
     * Ищет клиента по email.
     * @param email email клиента
     * @return найденный клиент или null
     */
    public Customer findCustomerByEmail(String email) {
        for (Customer c : customers) {
            if (c.getEmail().equals(email)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Возвращает строковое представление объекта Bank.
     */
    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", customersCount=" + customers.size() +
                '}';
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
