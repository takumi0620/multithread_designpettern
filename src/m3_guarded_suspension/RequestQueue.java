package m3_guarded_suspension;

import java.util.LinkedList;
import java.util.Queue;

class RequestQueue {
    private final Queue<Request> queue = new LinkedList<>();

    synchronized Request getRequest() {
        while (queue.peek() == null) {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }
        return queue.remove();
    }

    synchronized void putRequest(Request request) {
        queue.offer(request);
        notifyAll();
    }
}
