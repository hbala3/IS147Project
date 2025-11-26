import java.util.Scanner;

/**
 * Main class to run the Online Banking System
 * Displays a menu and allows users to create accounts, open checking
 * accounts, deposit money, withdraw money, and check balances
 */

public class Main {

    /**
     * Program entry point; runs the banking system loop
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();
        Customer currentCustomer = null;

        while (true) {
            System.out.println("\n==== ONLINE BANKING SYSTEM ====");
            System.out.println("1. Create New Customer Account");
            System.out.println("2. Open Checking Account");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Check Balance");
            System.out.println("6. Exit");
            System.out.println("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter your name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter your email: ");
                    String email = sc.nextLine();
                    bank.createCustomer(name, email);
                    currentCustomer = bank.getCustomer(email);
                    break;

                case 2:
                    if (currentCustomer == null) {
                        System.out.println("Please create a customer account first!");
                    } else {
                        System.out.println("Enter new account number: ");
                        String accNumber = sc.nextLine();
                        currentCustomer.openAccount(accNumber);
                    }
                    break;

                case 3:
                    if (currentCustomer == null || currentCustomer.getAccount() == null) {
                        System.out.println("Please open a checking account first!");
                    } else {
                        System.out.println("Enter amount to deposit: ");
                        double deposit = sc.nextDouble();
                        currentCustomer.getAccount().deposit(deposit);
                    }
                    break;

                case 4:
                    if (currentCustomer == null || currentCustomer.getAccount() == null) {
                        System.out.println("Please open a checking account first!");
                    } else {
                        System.out.println("Enter amount to withdraw: ");
                        double withdraw = sc.nextDouble();
                        currentCustomer.getAccount().withdraw(withdraw);
                    }
                    break;

                case 5:
                    if (currentCustomer == null || currentCustomer.getAccount() == null) {
                        System.out.println("Please open a checking account first!");
                    } else {
                        currentCustomer.getAccount().displayBalance();
                    }
                    break;

                case 6:
                    System.out.println("Thank you for using the Online Banking System!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Option! Please try again.");
            }
        }
    }
}
