package example.testng;

import org.testng.annotations.Test;

public class BankAccountTest {

    @Test(expectedExceptions = { NullPointerException.class }, groups = { "constructor" })
    public void constructorWithNullName() {
        new BankAccount(null);
        new BankAccount(null, 123.45);
    }

    @Test(expectedExceptions = { IllegalArgumentException.class }, groups = { "constructor" })
    public void constructorWithBlankName() {
        new BankAccount("");
        new BankAccount("", 123.45);
    }

    @Test(expectedExceptions = { IllegalArgumentException.class }, groups = { "constructor" })
    public void constructorWithNegativeBalance() {
        new BankAccount("Checking", -50.00);
    }

    @Test(groups = { "constructor" })
    public void constructorWithNoBalance() {
        BankAccount bankAccount = new BankAccount("Checking");
        assert bankAccount.getBalance() == 0.00 : bankAccount.getBalance();
    }

    @Test(groups = { "constructor" })
    public void constructorWithZeroBalance() {
        BankAccount bankAccount = new BankAccount("Checking", 0.00);
        assert bankAccount.getBalance() == 0.00 : bankAccount.getBalance();
    }

    @Test(groups = { "constructor" })
    public void constructorWithPositiveBalance() {
        String name = "Checking";
        double initBalance = 123.45;
        BankAccount bankAccount = new BankAccount(name, initBalance);
        assert bankAccount.getBalance() == initBalance : bankAccount.getBalance();
        assert bankAccount.getName().equals(name) : bankAccount.getName();
    }

    @Test(expectedExceptions = { IllegalArgumentException.class }, groups = { "deposit" }, dependsOnGroups = { "constructor" })
    public void depositNegative() {
        BankAccount bankAccount = new BankAccount("Checking", 100);
        bankAccount.deposit(-50);
    }

    @Test(groups = { "deposit" }, dependsOnGroups = { "constructor" })
    public void depositZero() {
        BankAccount bankAccount = new BankAccount("Checking", 100);
        bankAccount.deposit(0);
        assert bankAccount.getBalance() == 100 : bankAccount.getBalance();
    }

    @Test(groups = { "deposit" }, dependsOnGroups = { "constructor" })
    public void depositPositive() {
        BankAccount bankAccount = new BankAccount("Checking", 100);
        bankAccount.deposit(50);
        assert bankAccount.getBalance() == 150 : bankAccount.getBalance();
    }

    @Test(expectedExceptions = { IllegalArgumentException.class }, groups = { "withdraw" }, dependsOnGroups = { "constructor" })
    public void withdrawNegative() throws InsufficientBalanceException {
        BankAccount bankAccount = new BankAccount("Checking", 100);
        bankAccount.withdraw(-50);
    }

    @Test(groups = { "withdraw" }, dependsOnGroups = { "constructor" })
    public void withdrawZero() throws InsufficientBalanceException {
        BankAccount bankAccount = new BankAccount("Checking", 100);
        bankAccount.withdraw(0);
        assert bankAccount.getBalance() == 100 : bankAccount.getBalance();
    }

    @Test(groups = { "withdraw" }, dependsOnGroups = { "constructor" })
    public void withdrawLessThanAvailable() throws InsufficientBalanceException {
        BankAccount bankAccount = new BankAccount("Checking", 100);
        bankAccount.withdraw(25);
        assert bankAccount.getBalance() == 75 : bankAccount.getBalance();
    }

    @Test(expectedExceptions = { InsufficientBalanceException.class }, groups = { "withdraw" }, dependsOnGroups = { "constructor" })
    public void withdrawMoreThanAvailable() throws InsufficientBalanceException {
        BankAccount bankAccount = new BankAccount("Checking", 100);
        bankAccount.withdraw(150);
    }

    @Test(groups = { "withdraw" }, dependsOnGroups = { "constructor" })
    public void withdrawExact() throws InsufficientBalanceException {
        BankAccount bankAccount = new BankAccount("Checking", 100);
        bankAccount.withdraw(100);
        assert bankAccount.getBalance() == 0 : bankAccount.getBalance();
    }

    @Test(expectedExceptions = { NullPointerException.class }, groups = { "transfer" }, dependsOnGroups = {
            "deposit", "withdraw" })
    public void transferNull() throws InsufficientBalanceException {
        BankAccount bankAccount = new BankAccount("Checking", 100);
        bankAccount.transferFrom(null, 50);
    }

    @Test(expectedExceptions = { IllegalArgumentException.class }, groups = { "transfer" }, dependsOnGroups = {
            "deposit", "withdraw" })
    public void transferNegative() throws InsufficientBalanceException {
        BankAccount bankAccount1 = new BankAccount("Checking", 100);
        BankAccount bankAccount2 = new BankAccount("Savings", 75);
        bankAccount1.transferFrom(bankAccount2, -50);
    }

    @Test(groups = { "transfer" }, dependsOnGroups = { "deposit", "withdraw" })
    public void transferZero() throws InsufficientBalanceException {
        BankAccount bankAccount1 = new BankAccount("Checking", 100);
        BankAccount bankAccount2 = new BankAccount("Savings", 75);
        bankAccount1.transferFrom(bankAccount2, 0);
        assert bankAccount1.getBalance() == 100 : bankAccount1.getBalance();
        assert bankAccount2.getBalance() == 75 : bankAccount2.getBalance();
    }

    @Test(groups = { "transfer" }, dependsOnGroups = { "deposit", "withdraw" })
    public void transferLessThanAvailable() throws InsufficientBalanceException {
        BankAccount bankAccount1 = new BankAccount("Checking", 100);
        BankAccount bankAccount2 = new BankAccount("Savings", 75);
        bankAccount1.transferFrom(bankAccount2, 50);
        assert bankAccount1.getBalance() == 150 : bankAccount1.getBalance();
        assert bankAccount2.getBalance() == 25 : bankAccount2.getBalance();
    }

    @Test(groups = { "transfer" }, dependsOnGroups = { "deposit", "withdraw" })
    public void transferExact() throws InsufficientBalanceException {
        BankAccount bankAccount1 = new BankAccount("Checking", 100);
        BankAccount bankAccount2 = new BankAccount("Savings", 75);
        bankAccount1.transferFrom(bankAccount2, 75);
        assert bankAccount1.getBalance() == 175 : bankAccount1.getBalance();
        assert bankAccount2.getBalance() == 0 : bankAccount2.getBalance();
    }

    @Test(expectedExceptions = { InsufficientBalanceException.class }, groups = { "transfer" }, dependsOnGroups = {
            "deposit", "withdraw" })
    public void transferMoreThanAvailable() throws InsufficientBalanceException {
        BankAccount bankAccount1 = new BankAccount("Checking", 100);
        BankAccount bankAccount2 = new BankAccount("Savings", 75);
        bankAccount1.transferFrom(bankAccount2, 150);
    }

    @Test(groups = { "object" })
    public void equalsWithNull() {
        assert new BankAccount("Checking").equals(null) == false;
    }

    @Test(groups = { "object" })
    public void equalsReflexive() {
        BankAccount bankAccount = new BankAccount("Checking", 123.45);
        assert bankAccount.equals(bankAccount);
    }

    @Test(groups = { "object" })
    public void equalsSymmeticAndConsistent() {
        BankAccount bankAccount1 = new BankAccount("Checking", 123.45);
        BankAccount bankAccount2 = new BankAccount("Checking", 123.45);
        assert bankAccount1.equals(bankAccount2);
        assert bankAccount1.equals(bankAccount2);
        assert bankAccount2.equals(bankAccount1);
        assert bankAccount2.equals(bankAccount1);
    }

    @Test(groups = { "object" })
    public void equalsWithDifferentNames() {
        BankAccount bankAccount1 = new BankAccount("Checking", 123.45);
        BankAccount bankAccount2 = new BankAccount("Savings", 123.45);
        assert bankAccount1.equals(bankAccount2) == false;
    }

    @Test(groups = { "object" })
    public void equalsWithDifferentBalances() {
        BankAccount bankAccount1 = new BankAccount("Checking", 123.45);
        BankAccount bankAccount2 = new BankAccount("Checking", 543.21);
        assert bankAccount1.equals(bankAccount2) == false;
    }

    @Test(groups = { "object" })
    public void equalsWithDifferentNamesAndBalances() {
        BankAccount bankAccount1 = new BankAccount("Checking", 123.45);
        BankAccount bankAccount2 = new BankAccount("Savings", 543.21);
        assert bankAccount1.equals(bankAccount2) == false;
    }

    @Test(groups = { "object" })
    public void hashCodeSame() {
        BankAccount bankAccount1 = new BankAccount("Checking", 123.45);
        BankAccount bankAccount2 = new BankAccount("Checking", 123.45);
        assert bankAccount1.hashCode() == bankAccount2.hashCode();
    }

    @Test(groups = { "object" })
    public void hashCodeWithDifferentNames() {
        BankAccount bankAccount1 = new BankAccount("Checking", 123.45);
        BankAccount bankAccount2 = new BankAccount("Savings", 123.45);
        assert bankAccount1.hashCode() != bankAccount2.hashCode();
    }

    @Test(groups = { "object" })
    public void hashCodeWithDifferentBalances() {
        BankAccount bankAccount1 = new BankAccount("Checking", 123.45);
        BankAccount bankAccount2 = new BankAccount("Checking", 543.21);
        assert bankAccount1.hashCode() != bankAccount2.hashCode();
    }

    @Test(groups = { "object" })
    public void hashCodeWithDifferentNamesAndBalances() {
        BankAccount bankAccount1 = new BankAccount("Checking", 123.45);
        BankAccount bankAccount2 = new BankAccount("Savings", 543.21);
        assert bankAccount1.hashCode() != bankAccount2.hashCode();
    }

    @Test(groups = { "object" })
    public void compareToSmallerBalance() {
        BankAccount bankAccount1 = new BankAccount("Checking", 123.45);
        BankAccount bankAccount2 = new BankAccount("Checking", 100.00);
        assert bankAccount1.compareTo(bankAccount2) > 0;
    }

    @Test(groups = { "object" })
    public void compareToSmallerName() {
        BankAccount bankAccount1 = new BankAccount("Savings", 123.45);
        BankAccount bankAccount2 = new BankAccount("Checking", 123.45);
        assert bankAccount1.compareTo(bankAccount2) > 0;
    }

    @Test(groups = { "object" })
    public void compareToSame() {
        BankAccount bankAccount1 = new BankAccount("Checking", 123.45);
        BankAccount bankAccount2 = new BankAccount("Checking", 123.45);
        assert bankAccount1.compareTo(bankAccount2) == 0;
    }

    @Test(groups = { "object" })
    public void compareToGreaterBalance() {
        BankAccount bankAccount1 = new BankAccount("Checking", 100.00);
        BankAccount bankAccount2 = new BankAccount("Checking", 123.45);
        assert bankAccount1.compareTo(bankAccount2) < 0;
    }

    @Test(groups = { "object" })
    public void compareToGreaterName() {
        BankAccount bankAccount1 = new BankAccount("Checking", 123.45);
        BankAccount bankAccount2 = new BankAccount("Savings", 123.45);
        assert bankAccount1.compareTo(bankAccount2) < 0;
    }
}
