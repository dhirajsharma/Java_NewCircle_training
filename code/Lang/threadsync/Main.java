package threadsync;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Queue q = new Queue(Integer.parseInt(args[0]));
        Thread p = new Thread(new Producer(q, Integer.parseInt(args[1])));
        Thread c = new Thread(new Consumer(q));
        c.start();
        p.start();
        c.join();
        System.out.println("Done");
    }
}
