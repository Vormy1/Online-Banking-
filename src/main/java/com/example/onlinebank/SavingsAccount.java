package com.example.onlinebank;

/**
 * SavingsAccount — сберегательный счёт
 * Начисляет проценты каждый месяц
 */
public class SavingsAccount extends BankAccount {

    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void applyMonthlyUpdate() {
        double interest = getBalance() * interestRate;
        deposit(interest);
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                super.toString() +
                ", interestRate=" + interestRate +
                '}';
    }
}
