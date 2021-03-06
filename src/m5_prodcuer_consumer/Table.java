package m5_prodcuer_consumer;

public class Table {
    private final String[] buffer;
    private int tail;
    private int head;
    private int count;

    Table(int count) {
        this.buffer = new String[count];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    /**
     * ケーキを置く
     */
    synchronized void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " puts " + cake);
        while (count >= buffer.length) {
            wait();
        }

        buffer[tail] = cake;
        tail = (tail + 1) % buffer.length;
        count++;
        notifyAll();
    }

    /**
     * ケーキを取る
     */
    synchronized String take() throws InterruptedException {
        while (count <= 0) {
            wait();
        }

        String cake = buffer[head];
        head = (head + 1) % buffer.length;
        count--;
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " takes " + cake);
        return cake;
    }
}
