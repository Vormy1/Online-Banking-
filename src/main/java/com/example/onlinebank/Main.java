package com.example.onlinebank;

/**
 * Точка входа в программу.
 * Демонстрирует работу банковской системы.
 */
public class Main {

    public static void main(String[] args) {

        // Создание банковских счетов
        BankAccount acc1 = new BankAccount("ACC1001", 1500.0, "Savings");
        BankAccount acc2 = new BankAccount("ACC1002", 500.0, "Checking");
        BankAccount acc3 = new BankAccount("ACC1003", 1500.0, "Savings");

        // Создание клиентов
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

        // Клиент-дубликат с тем же email
        Customer cloneOfBob = new Customer(
                "Bogdan T.",
                "mrprofessor228@gmail.com",
                "+77770001111",
                acc3
        );

        // Создание банка
        Bank bank = new Bank("Demo Bank");

        // Добавление клиентов в банк
        bank.addCustomer(bob);
        bank.addCustomer(alice);
        bank.addCustomer(cloneOfBob); // не добавится (дубликат)

        // Операции со счетами
        System.out.println();
        bob.getAccount().deposit(250.0);
        alice.getAccount().withdraw(100.0);
        alice.getAccount().withdraw(1000.0); // недостаточно средств

        // Вывод всех клиентов банка
        System.out.println();
        bank.printAllCustomers();

        // Сравнение объектов
        System.out.println();
        System.out.println("Is bob equal to cloneOfBob? " + bob.equals(cloneOfBob));
        System.out.println("Is acc1 equal to acc3 (by account number)? " + acc1.equals(acc3));

        // Вывод балансов
        System.out.println("Bob's balance: " + bob.getAccount().getBalance());
        System.out.println("Alice's balance: " + alice.getAccount().getBalance());
    }
}
