package m6_read_write_lock;

public final class ReadWriteLock {
    private int readingReaders = 0; // 実際に読んでいる最中のスレッド数
    private int waitingWriters = 0; // 書くのを待っているスレッド数
    private int writingWriters = 0; // 実際に書いている最中のスレッド数
    private boolean preferWriter = true; // 書くのを優先するならtrue

    /**
     * 読む
     */
    synchronized void readLock() throws InterruptedException {
        while (writingWriters > 0 || (preferWriter && waitingWriters > 0)) {
            wait();
        }
        readingReaders++;
    }

    /**
     * 読み終わる
     */
    synchronized void readUnlock() {
        readingReaders--;
        preferWriter = true;
        notifyAll();
    }

    /**
     * 書く
     */
    synchronized void writeLock() throws InterruptedException {
        waitingWriters++;
        try {
            while (readingReaders > 0 || writingWriters > 0) {
                wait();
            }
        } finally {
            waitingWriters--;
        }
        writingWriters++;
    }

    /**
     * 書き終わる
     */
    synchronized void writeUnlock() {
        writingWriters--;
        preferWriter = false;
        notifyAll();
    }
}
