/**
 * Represents a checking account with an overdraft limit
 * Extends the abstract Account class
 */

public class CheckingAccount extends Account {

    private double overdraftLimit = 100.0;

    /**
     * Creates a checking account with a given account number
     * @param accountNumber the account number
     */

    public CheckingAccount(String accountNumber) {
        super(accountNumber);
    }

    /**
     * Creates a checking account with an initial deposit
     * @param accountNumber the account number
     * @param initialDeposit the starting deposit
     */

    public CheckingAccount(String accountNumber, double initialDeposit) {
        super(accountNumber);
        deposit(initialDeposit, "INITIAL DEPOSIT");
    }

    /**
     * Withdraws money from the account using overdraft if necessary
     * Includes Math.abs() to ensure positive withdrawal
     * @param amount amount to withdraw
     */

    @Override
    public void withdraw(double amount) {

        amount = Math.abs(amount);

        boolean canWithdraw = (balance + overdraftLimit >= amount) ? true : false;

        if (!canWithdraw) {
            System.out.println("Withdrawal denied: insufficient funds.");
            return;
        }

        balance -= amount;
        System.out.println("Successfully withdrew $" + amount);
    }
}
