package example.testng;

/**
 * Simple bank account
 * 
 * @author me
 * @version 1.0
 */
public class BankAccount implements Comparable<BankAccount> {

    private double balance = 0.00;

    private final String name;

    /**
     * Constructor with name and 0.00 initial balance.
     * 
     * @param name the name of the account
     * @throws NullPointerException if name is null
     * @throws IllegalArgumentException if name is blank
     */
    public BankAccount(String name) {
        if (name == null) {
            throw new NullPointerException("Bank account name cannot be null");
        } else if (name.length() == 0) {
            throw new IllegalArgumentException(
                    "Bank account name cannot be blank");
        }
        this.name = name;
    }

    /**
     * Constructor with name and initial balance.
     * 
     * @param name the name of the account
     * @param initialBalance the initial balance to set
     * @throws NullPointerException if name is null
     * @throws IllegalArgumentException if amount is negative
     * @throws IllegalArgumentException if name is blank
     */
    public BankAccount(String name, double initialBalance) {
        this(name);
        this.deposit(initialBalance);
    }

    /**
     * Get the account name
     * 
     * @return account name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Deposit money into this account.
     * 
     * @param amount the amount of money to deposit
     * @throws IllegalArgumentException if amount is negative
     */
    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount " + amount
                    + " must not be negative");
        } else {
            this.balance += amount;
        }
    }

    /**
     * Withdraw money from this account.
     * 
     * @param amount the amount of money to withdraw.
     * @throws IllegalArgumentException if amount is negative
     * @throws InsufficientBalanceException if amount exceeds this account's
     *             balance
     */
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount " + amount
                    + " must not be negative");
        } else if (amount > this.balance) {
            throw new InsufficientBalanceException(this.balance, amount);
        } else {
            this.balance -= amount;
        }
    }

    /**
     * Transfer money from another account into this account.
     * 
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
     * 
     * @return current account balance.
     */
    public double getBalance() {
        return this.balance;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj != null && obj.getClass().equals(this.getClass())) {
            BankAccount o = (BankAccount) obj;
            return this.getName().equals(o.getName())
                    && this.getBalance() == o.getBalance();
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(this.getBalance());
        int result = 13 + 23 * this.getName().hashCode();
        result += 31 * (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s bank account with balance of $%.2f",
                this.getName(), this.getBalance());
    }

    public int compareTo(BankAccount o) {
        if (this.getBalance() < o.getBalance()) {
            return -1;
        } else if (this.getBalance() > o.getBalance()) {
            return 1;
        } else {
            return this.getName().compareTo(o.getName());
        }
    }
}
