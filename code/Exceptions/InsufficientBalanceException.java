/**
 * Exception thrown to indicate that there is insufficient 
 * balance in a bank account.
 * @author me
 * @version 1.0
 */
public class InsufficientBalanceException extends Exception {
    private final double available;
    private final double required;

    /**
     * Constructor.
     * @param available available account balance
     * @param required required account balance
     */
    public InsufficientBalanceException(double available, double required) {
        super("Available $"+available+" but required $"+required);
        this.available = available;
        this.required = required;
    }

    /**
     * Get available account balance
     * @return available account balance
     */
    public double getAvailable() {
        return available;
    }

    /**
     * Get required account balance
     * @return required account balance
     */
    public double getRequired() {
        return required;
    }

    /**
     * Get the difference between required and available account balances
     * @return required - available
     */
    public double getDifference() {
        return required - available;
    }
}
