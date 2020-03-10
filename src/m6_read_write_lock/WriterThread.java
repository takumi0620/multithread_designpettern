package m6_read_write_lock;

import java.util.Random;

public class WriterThread extends Thread {
    private static final Random random = new Random();
    private final Data data;
    private final String filler;
    private int index = 0;
    public WriterThread(Data data, String filler) {
        this.data = data;
        this.filler = filler;
    }

    @Override
    public void run() {
        try {
            while (true) {
                char c = nextChar();
                data.write(c);
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
        }
    }

    private char nextChar() {
        char c = filler.charAt(index);
        index = (index + 1) % filler.length();
        return c;
    }
}
