package m1_single_thread_execution;

public class Main {
    public static void main(String[] args) {
        System.out.println("Testing Gate, Hit CTRL+C to exit.");
        Gate gate = new Gate();
        new UserThread(gate, "Alice", "Alaska").start();
        new UserThread(gate, "Bobby", "Brazil").start();
        new UserThread(gate, "Chris", "Canada").start();
    }
}
