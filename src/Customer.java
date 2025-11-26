/**
 * Represents a bank customer with personal information
 * and a bank account
 */

public class Customer {
    private String name;
    private String email;
    private Account account;

    private String[] messages = new String[5];

    /**
     * Constructs a Customer object with name and email
     * @param name the customer's name
     * @param email the customer's email
     */

    public Customer(String name, String email) {
        this.name = name.trim();
        this.email = email.toLowerCase();
        this.account = null;
    }

    /**
     * Gets the customer's name
     * @return customer name
     */

    public String getName() {
        return name;
    }

    /**
     * Gets the customer's bank account
     * @return the Account object or null if none exists
     */

    public Account getAccount() {
        return account;
    }

    /**
     * Opens a new checking account for the customer
     * @param accountNumber desired account number
     */

    public void openAccount(String accountNumber) {
        if (this.account == null) {
            this.account = new CheckingAccount(accountNumber);
            System.out.println("Checking account created successfully!");
        } else {
            System.out.println("You already have an account!");
        }
    }

    /**
     * OverLoaded method to open an account with an initial deposit
     * @param accountNumber the account number
     * @param initialDeposit the starting deposit amount
     */

    public void openAccount(String accountNumber, double initialDeposit) {
        if (this.account == null) {
            this.account = new CheckingAccount(accountNumber, initialDeposit);
            System.out.println("Checking account created with initial deposit!");
            } else {
            System.out.println("You already have an account!");
        }
    }
}
