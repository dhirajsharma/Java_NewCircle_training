public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        int numThreads = Integer.parseInt(args[0]);
        int count = Integer.parseInt(args[1]);

        Thread[] threads = new Thread[numThreads];
        System.out.println("Creating threads");
        for (int i = 0; i < threads.length; i++) {
            Runner r = new Runner("Runner " + i, count);
            threads[i] = new Thread(r);
        }
        System.out.println("Starting threads");
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        System.out.println("Waiting for threads");
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        System.out.println("Done");
    }

    private static class Runner implements Runnable {
        private final String name;
        private final int count;

        public Runner(String name, int count) {
            this.name = name;
            this.count = count;
        }
        public void run() {
            for (int i = 0; i < count; i++) {
                System.out.println(name + "=" + i);
                Thread.yield();
            }
        }
    }
}

