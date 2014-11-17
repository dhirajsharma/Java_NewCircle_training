public class BankAccountDemo {
    public static void main(String[] args) {
        BankAccount checking =
                new BankAccount("checking");
        checking.deposit(100);
        BankAccount savings =
                new BankAccount("savings");
        savings.deposit(50);
        checking.transferFrom(savings, 25);

        System.out.println(checking.getInfo());
        System.out.println(savings.getInfo());
    }
}
