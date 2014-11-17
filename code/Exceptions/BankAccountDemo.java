public class BankAccountDemo {
    public static void main(String[] args) {
        BankAccount checking =
                new BankAccount("checking");
        checking.deposit(Double.parseDouble(args[0]));
        BankAccount savings =
                new BankAccount("savings");
        savings.deposit(Double.parseDouble(args[1]));
        
        try {
            checking.transferFrom(savings, Double.parseDouble(args[2]));
        } catch (InsufficientBalanceException e) {
            System.err.println("Failed transfer: "+ e.getMessage());
        }
        System.out.println(checking.getInfo());
        System.out.println(savings.getInfo());
    }
}
