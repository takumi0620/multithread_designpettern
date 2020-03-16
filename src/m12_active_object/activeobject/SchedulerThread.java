package m12_active_object.activeobject;

public class SchedulerThread extends Thread {
    private final ActivationQueue queue;
    SchedulerThread(ActivationQueue queue) {
        this.queue = queue;
    }

    void invoke(MethodRequest request) {
        queue.putRequest(request);
    }

    @Override
    public void run() {
        while (true) {
            MethodRequest request = queue.takeRequest();
            request.execute();
        }
    }
}
