package com.example.onlinebank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс Bank представляет банк.
 */
public class Bank {

    private String name;
    private List<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    // Добавление клиента (без дубликатов)
    public void addCustomer(Customer customer) {
        if (!customers.contains(customer)) {
            customers.add(customer);
        }
    }

    // Поиск по email
    public Customer findByEmail(String email) {
        return customers.stream()
                .filter(c -> c.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    // Фильтрация по минимальному балансу
    public List<Customer> filterByMinBalance(double minBalance) {
        return customers.stream()
                .filter(c -> c.getAccount().getBalance() >= minBalance)
                .collect(Collectors.toList());
    }

    // Сортировка по балансу
    public void sortByBalance() {
        customers.sort(Comparator.comparingDouble(c -> c.getAccount().getBalance()));
    }

    // Вывод всех клиентов
    public void printAll() {
        customers.forEach(System.out::println);
    }
}
