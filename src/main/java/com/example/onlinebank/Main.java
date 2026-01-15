package com.example.onlinebank;

/**
 * Main class
 * Demonstrates:
 * - OOP principles (Assignment 2)
 * - JDBC + PostgreSQL CRUD operations (Assignment 3)
 */
public class Main {

    public static void main(String[] args) {

        // =========================
        // ASSIGNMENT 2 — OOP PART
        // =========================

        // Creating bank accounts (abstraction + inheritance)
        BankAccount acc1 = new SavingsAccount("SA001", 1000, 0.05);
        BankAccount acc2 = new CheckingAccount("CA002", 800, 50);
        BankAccount acc3 = new SavingsAccount("SA001", 500, 0.05); // same ID (equals test)

        // Polymorphism (different behavior for same method)
        acc1.applyMonthlyUpdate();
        acc2.applyMonthlyUpdate();

        // Creating customers
        Customer bob = new Customer(
                "Bogdan Tkachuk",
                "mrprofessor228@gmail.com",
                "+77770001111",
                acc1
        );

        Customer alice = new Customer(
                "Alice Johnson",
                "alice@mail.com",
                "+77770002222",
                acc2
        );

        // Duplicate customer (same email)
        Customer cloneOfBob = new Customer(
                "Bogdan T.",
                "mrprofessor228@gmail.com",
                "+77770001111",
                acc3
        );

        // Bank aggregation
        Bank bank = new Bank("Demo Bank");
        bank.addCustomer(bob);
        bank.addCustomer(alice);
        bank.addCustomer(cloneOfBob); // will NOT be added (equals + hashCode)

        // Account operations
        bob.getAccount().deposit(250);
        alice.getAccount().withdraw(100);

        // Output all customers
        bank.printAll();

        // equals / hashCode demonstration
        System.out.println("Bob equals cloneOfBob: " + bob.equals(cloneOfBob));
        System.out.println("acc1 equals acc3: " + acc1.equals(acc3));


        // =========================
        // ASSIGNMENT 3 — DATABASE PART
        // =========================

        System.out.println("\n--- DATABASE OPERATIONS ---");

        CustomerDAO customerDAO = new CustomerDAO();

        // New objects for database work
        Customer dbBob = new Customer(
                "Bogdan Tkachuk",
                "bob_db@mail.com",
                "+70000000001",
                acc1
        );

        Customer dbAlice = new Customer(
                "Alice Johnson",
                "alice_db@mail.com",
                "+70000000002",
                acc2
        );

        // CREATE
        customerDAO.addCustomer(dbBob);
        customerDAO.addCustomer(dbAlice);

        // READ
        customerDAO.printAllCustomers();

        // UPDATE
        customerDAO.updatePhone("alice_db@mail.com", "+999999999");

        // DELETE
        customerDAO.deleteByEmail("bob_db@mail.com");
    }
}
