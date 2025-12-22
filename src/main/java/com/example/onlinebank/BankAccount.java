
import java.util.Objects;

/**
 * Абстрактный класс BankAccount представляет банковский счет клиента.
 */
public abstract class BankAccount {

    // Уникальный номер счета
    private String accountNumber;

    // Текущий баланс
    private double balance;

    // Конструктор
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // ===== Getters =====

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // ===== Business methods =====

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            System.out.println("Invalid withdrawal.");
            return false;
        }
        balance -= amount;
        return true;
    }

    // Абстрактный метод (полиморфизм)
    public abstract void applyMonthlyUpdate();

    @Override
    public String toString() {
        return "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount)) return false;
        BankAccount that = (BankAccount) o;
        return Objects.equals(accountNumber, that.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }
}
