/**
 * Simple bank account
 * @author me
 * @version 1.0
 */
public class BankAccount {
    private double balance;
    private final String name;

    /**
     * Constructor with name and 0.00 initial balance.
     * @param name the name of the account
     */
    public BankAccount(String name) {
        this.name = name;
    }

    /**
     * Constructor with name and initial balance.
     * @param name the name of the account
     * @param initialBalance the initial balance to set
     */
    public BankAccount(String name, double initialBalance) {
        this(name);
        this.deposit(initialBalance);
    }


    /**
     * Get the account name
     * @return account name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get account info.
     * @return this account's name followed by the current balance
     */
    public String getInfo() {
        return this.name +
        " with balance of $" + this.balance;

    }

    /**
     * Deposit money into this account.
     * @param amount the amount of money to deposit
     * @throws IllegalArgumentException if amount is negative
     */
    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount "+amount+" must not be negative");
        } else {
            this.balance += amount;
        } 
    }

    /**
     * Withdraw money from this account.
     * @param amount the amount of money to withdraw.
     * @throws IllegalArgumentException if amount is negative
     * @throws InsufficientBalanceException if amount exceeds this account's balance
     */
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount "+amount+" must not be negative");
        } else if (amount > this.balance) {
            throw new InsufficientBalanceException(this.balance, amount);
        } else {
            this.balance -= amount;
        }
    }

    /**
     * Transfer money from another account into this account.
     * @param other the account from which to transfer money.
     * @param amount the amount to transfer
     * @throws IllegalArgumentException if amount is negative
     * @throws NullPointerException if other is null
     * @throws InsufficientBalanceException if amount exceeds other.getBalance()
     */
    public void transferFrom(BankAccount other, double amount) 
        throws InsufficientBalanceException {
        other.withdraw(amount);
        try {
            this.deposit(amount);
        } catch (RuntimeException e) {
            other.deposit(amount);
            throw e;
        }
    }

    /**
     * Get current account balance.
     * @return current account balance.
     */
    public double getBalance() {
        return this.balance;
    }

}
