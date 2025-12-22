package com.example.onlinebank;

/**
 * Точка входа в программу.
 * Демонстрирует работу банковской системы.
 */
public class Main {

    public static void main(String[] args) {

        // Создание счетов
        BankAccount acc1 = new SavingsAccount("SA001", 1000, 0.05);
        BankAccount acc2 = new CheckingAccount("CA001", 800, 50);
        BankAccount acc3 = new SavingsAccount("SA001", 500, 0.05);

        // Полиморфизм
        acc1.applyMonthlyUpdate();
        acc2.applyMonthlyUpdate();

        // Клиенты
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

        Customer cloneOfBob = new Customer(
                "Bogdan T.",
                "mrprofessor228@gmail.com",
                "+77770001111",
                acc3
        );

        // Банк
        Bank bank = new Bank("Demo Bank");
        bank.addCustomer(bob);
        bank.addCustomer(alice);
        bank.addCustomer(cloneOfBob); // не добавится

        // Операции
        bob.getAccount().deposit(250);
        alice.getAccount().withdraw(100);

        // Вывод
        bank.printAll();

        // equals / hashCode
        System.out.println("Bob equals cloneOfBob: " + bob.equals(cloneOfBob));
        System.out.println("acc1 equals acc3: " + acc1.equals(acc3));
    }
}
