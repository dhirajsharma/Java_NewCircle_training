public class BankAccount {
    private double balance;
    private final String name;

    public BankAccount(String name) {
        this.name = name;
    }

    public BankAccount(String name, double initialBalance) {
        this(name);
        this.deposit(initialBalance);
    }


    public String getName() {
        return this.name;
    }

    public String getInfo() {
        return this.name +
        " with balance of $" + this.balance;

    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && this.balance > amount) {
            this.balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean transferFrom(BankAccount other,
                                double amount) {
        if (other.withdraw(amount)) {
            if (this.deposit(amount)) {
                return true;
            } else {
                other.deposit(amount);
                return false;
            }
        } else {
            return false;
        }
    }

    public double getBalance() {
        return this.balance;
    }

}
