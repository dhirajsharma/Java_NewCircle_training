public class SyncThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        int numThreads = Integer.parseInt(args[0]);
        int maxCount = Integer.parseInt(args[1]);
        Counter counter = new Counter();

        Thread[] threads = new Thread[numThreads];
        System.out.println("Creating threads");
        for (int i = 0; i < threads.length; i++) {
            Runner r = new Runner(maxCount, counter);
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
        System.out.println("Done with count of " + counter.getCount());
    }

    private static class Counter {
        private int count = 0;
        public void setCount(int count) {
          this.count = count;
        }
        public int getCount() {
          return this.count;
        }
        public synchronized int count() {
          return ++this.count;
        }     
    }

    private static class Runner implements Runnable {
        private final int maxCount;
        private final Counter counter;

        public Runner(int maxCount, Counter counter) {
            this.maxCount = maxCount;
            this.counter = counter;
        }
        public void run() {
            for (int i = 0; i < this.maxCount; i++) {
                int currentCount;
                //synchronized(this.counter) {
                    currentCount = this.counter.getCount();
                    currentCount++;
                    this.counter.setCount(currentCount);
                //}
                System.out.println(Thread.currentThread().getName() + " at count " + currentCount);
            }
        }
    }
}

