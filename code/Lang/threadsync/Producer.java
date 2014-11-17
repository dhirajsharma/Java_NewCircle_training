package threadsync;

public class Producer implements Runnable {
    private final Queue queue;
    private final int count;
    public Producer(Queue queue, int count) {
        this.queue = queue;
        this.count = count;
    }
    public void run() {
        try {
            for (int i = 0; i < this.count; i++) {
                Object o = "product:" + i;
                System.out.println("Producing " + o);
                queue.put(o);
            }
            queue.put(Consumer.END_OF_INPUT);
        } catch (InterruptedException e) {
            System.err.println("Interrupted");
        }
    }
}
