package com.example.onlinebank;

import java.util.Objects;

/**
 * Класс BankAccount представляет банковский счет клиента.
 */
public class BankAccount {

    // Уникальный номер банковского счета
    private String accountNumber;

    // Текущий баланс счета
    private double balance;

    // Тип счета (например, Savings или Checking)
    private String accountType;

    /**
     * Конструктор банковского счета.
     */
    public BankAccount(String accountNumber, double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
    }

    // ===== Getters & Setters =====

    // Возвращает номер счета
    public String getAccountNumber() {
        return accountNumber;
    }

    // Устанавливает номер счета
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    // Возвращает баланс
    public double getBalance() {
        return balance;
    }

    // Устанавливает баланс
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Возвращает тип счета
    public String getAccountType() {
        return accountType;
    }

    // Устанавливает тип счета
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    // ===== Business methods =====

    /**
     * Пополнение баланса.
     * @param amount сумма пополнения
     */
    public void deposit(double amount) {
        // Проверка, что сумма положительная
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }

        // Увеличение баланса
        balance += amount;
        System.out.println("Deposited " + amount + " to account " + accountNumber +
                ". New balance: " + balance);
    }

    /**
     * Снятие денег со счета.
     * @param amount сумма снятия
     * @return true если успешно, иначе false
     */
    public boolean withdraw(double amount) {
        // Проверка, что сумма положительная
        if (amount <= 0) {
            System.out.println("Withdraw amount must be positive.");
            return false;
        }

        // Проверка на достаточность средств
        if (amount > balance) {
            System.out.println("Insufficient funds for withdrawal from account " + accountNumber);
            return false;
        }

        // Уменьшение баланса
        balance -= amount;
        System.out.println("Withdrew " + amount + " from account " + accountNumber +
                ". New balance: " + balance);
        return true;
    }

    /**
     * Строковое представление банковского счета.
     */
    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", accountType='" + accountType + '\'' +
                '}';
    }

    /**
     * Переопределение equals.
     * Счета считаются равными, если совпадает номер счета.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankAccount that = (BankAccount) o;
        return Objects.equals(accountNumber, that.accountNumber);
    }

    /**
     * Переопределение hashCode.
     * Используется в коллекциях.
     */
    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }
}
 amount + " to account " + accountNumber + ". New balance: " + balance);
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdraw amount must be positive.");
            return false;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds for withdrawal from account " + accountNumber);
            return false;
        }
        balance -= amount;
        System.out.println("Withdrew " + amount + " from account " + accountNumber + ". New balance: " + balance);
        return true;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", accountType='" + accountType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankAccount that = (BankAccount) o;
        // считаем одинаковыми по номеру счета
        return Objects.equals(accountNumber, that.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }
}
