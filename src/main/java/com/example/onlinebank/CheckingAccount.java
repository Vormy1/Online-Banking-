package com.example.onlinebank;

/**
 * CheckingAccount — расчетный счёт
 * Списывает фиксированную ежемесячную комиссию
 */
public class CheckingAccount extends BankAccount {

    private double monthlyFee;

    public CheckingAccount(String accountNumber, double balance, double monthlyFee) {
        super(accountNumber, balance);
        this.monthlyFee = monthlyFee;
    }

    @Override
    public void applyMonthlyUpdate() {
        withdraw(monthlyFee);
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                super.toString() +
                ", monthlyFee=" + monthlyFee +
                '}';
    }
}
