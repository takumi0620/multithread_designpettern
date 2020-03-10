package m3_guarded_suspension;

public class Main {
    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();
        new ClientThread(requestQueue, "Alice", 314000L).start();
        new ServerThread(requestQueue, "Bobby", 312311L).start();
    }
}
