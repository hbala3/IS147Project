import java.util.HashMap;
import java.util.Map;

/**
 * The Bank class manages customers and provides functionality
 * to create and retrieve customer accounts
 */

public class Bank {
    private final Map<String, Customer> customers = new HashMap<>();
    private static int customerCount = 0;

    /**
     * Creates a new customer and stores them in the bank system
     * @param name the customer's name
     * @param email the customer's email
     */

    public void createCustomer(String name, String email) {
        if (customers.containsKey(email)) {
            System.out.println("An account with this email already exists!");
        } else {
            customers.put(email, new Customer(name, email));
            customerCount++;
            System.out.println("Customer account created successfully!");
        }
    }

    /**
     * Retrieves a customer based on email
     * @param email the customer's email
     * @return the customer object, or null if not found
     */

    public Customer getCustomer(String email) {
        return customers.get(email);
    }

    /**
     * Retrieves a customer using their name
     * @param name the customer's name
     * @return the customer object or null if none match
     */

    public Customer getCustomerByName(String name) {
        for (Customer c : customers.values()) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Gets the total number of registered customers
     * @return total customer count
     */

    public static int getCustomerCount() {
        return customerCount;
    }
}