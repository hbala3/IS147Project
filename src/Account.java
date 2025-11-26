/**
 * Abstract class representing a generic bank account
 * Provides basic deposit functionality and balance display
 */

public abstract class Account {
    protected final String accountNumber;
    protected double balance;

    /**
     * Constructs an Account with an account number
     * @param accountNumber unique account identifier
     */

    public Account(String accountNumber) {
        this.accountNumber = accountNumber.trim().toUpperCase();
        this.balance = 0.0;
    }

    /**
     * Gets the account number
     * @return account number
     */

    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Gets the account balance
     * @return current balance
     */

    public double getBalance() {
        return balance;
    }

    /**
     * Deposits money into the account
     * @param amount the amount to deposit
     */

    public void deposit(double amount) {
        deposit(amount, "DEPOSIT");
    }

    /**
     * OverLoaded deposit method that includes a transaction type
     * @param amount the amount to deposit
     * @param type type of deposit
     */

    public void deposit(double amount, String type) {
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }
        balance += amount;
        System.out.println("Successfully deposited $" + amount);
    }

    /**
     * Abstract withdraw method to be implemented by subclasses
     * @param amount amount to withdraw
     */

    public abstract void withdraw(double amount);

    /**
     * Displays the current account balance
     */

    public void displayBalance() {
        System.out.printf("Current Balance: $%.2f%n", balance);
    }
}