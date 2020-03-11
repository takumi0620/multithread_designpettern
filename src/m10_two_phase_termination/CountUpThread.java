package m10_two_phase_termination;

public class CountUpThread extends Thread {
    private long counter = 0;
    private volatile boolean shutdownRequested = false; // 終了要求フラグ

    void shutdownRequest() {
        shutdownRequested = true;
        interrupt();
    }

    boolean isShutdownRequested() {
        return shutdownRequested;
    }

    @Override
    public final void run() {
        try {
            while (!isShutdownRequested()) {
                doWork();
            }
        } catch (InterruptedException e) {
        } finally {
            doShutdown();
        }
    }

    /**
     * メイン処理
     */
    private void doWork() throws InterruptedException{
        counter++;
        System.out.println("doWork: counter = " + counter);
        Thread.sleep(500);
    }

    /**
     * 終了処理
     */
    private void doShutdown() {
        System.out.println("doShutdown: counter = " + counter);
    }
}
