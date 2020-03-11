package m8_worker_thread;

public class Main {
    public static void main(String[] args) {
        Channel channel = new Channel(5); // ワーカースレッドの個数
        channel.startWorkers();
        new ClientThread("Alice", channel).start();
        new ClientThread("Bobby", channel).start();
        new ClientThread("Chris", channel).start();
    }
}
