package m10_two_phase_termination;

public class Main {
    public static void main(String[] args) {
        System.out.println("main: BEGIN");
        try {
            CountUpThread thread = new CountUpThread();
            thread.start();

            Thread.sleep(10000);
            System.out.println("main: shutdownRequest");
            thread.shutdownRequest();

            System.out.println("main: join");

            thread.join(); // スレッドの終了を待つ
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main: END");
    }
}
