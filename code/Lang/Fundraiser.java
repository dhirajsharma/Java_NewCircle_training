public class Fundraiser {
    public static void main(String[] args) throws InterruptedException {
        int numThreads = Integer.parseInt(args[0]);
        int count = Integer.parseInt(args[1]);
        BankAccount account = new BankAccount("Fundraiser");

        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < threads.length; i++) {
            Runner r = new Runner("Runner " + i, count, account);
            threads[i] = new Thread(r);
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        System.out.println(account.getInfo());
    }

    private static class Runner implements Runnable {
        private final String name;
        private final int count;
        private final BankAccount account;

        public Runner(String name, int count, BankAccount account) {
            this.name = name;
            this.count = count;
            this.account = account;
        }
        public void run() {
            try {
                for (int i = 0; i < count; i++) {
                    this.account.deposit(5.0);
                    this.account.withdraw(1.0);
                    this.account.withdraw(1.0);
                    this.account.withdraw(2.0);
                    //Thread.yield();
                    //System.out.print('$');
                }
            } catch (InsufficientBalanceException e) {
               System.err.println(e.getMessage()); 
            }
        }
    }
}

