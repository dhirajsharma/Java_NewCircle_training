package threadsync;

public class Queue {
    private static class Element {
        final Object value;
        Element next;
        Element(Object value) {this.value = value;}
    }
    private Element first;
    private Element last;
    private int curSize;
    private final int maxSize;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
    }

    public synchronized void put(Object o) throws InterruptedException {
        while (this.curSize == this.maxSize) {
            this.wait();
        }
        if (this.first == null) {
            this.first = this.last = new Element(o);
        } else {
            this.last = this.last.next = new Element(o);
        }
        this.curSize++;
        this.notifyAll();
    }

    public synchronized Object get() throws InterruptedException {
        while (this.curSize == 0) {
            this.wait();
        }
        Object o = this.first.value;
        this.first = this.first.next;
        this.curSize--;
        this.notifyAll();
        return o;
    }
}
