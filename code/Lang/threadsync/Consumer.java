package threadsync;

public class Consumer implements Runnable {
    public static final Object END_OF_INPUT = new Object();
    private final Queue queue;
    public Consumer(Queue queue) {
        this.queue = queue;
    }
    public void run() {
        try {
            while(true) {
                Object o = queue.get();
                if (o == END_OF_INPUT) { break; }
                System.out.println("Consumed " + o);
            }
        } catch (InterruptedException e) {
            System.err.println("Interrupted");
        }
    }
}
