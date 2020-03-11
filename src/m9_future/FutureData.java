package m9_future;

public class FutureData implements Data {
    private RealData realData = null;
    private boolean ready = false;

    synchronized void setRealData(RealData realData) {
        if (ready) return; // balkパターン
        this.realData = realData;
        this.ready = true;
        notifyAll();
    }

    @Override
    public synchronized String getContent() {
        while (!ready) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        return realData.getContent();
    }
}
