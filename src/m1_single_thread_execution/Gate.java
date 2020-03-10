package m1_single_thread_execution;

public class Gate {
    private int counter = 0;
    private String name = "Nobody";
    private String address = "Nowhere";

    synchronized void pass(String name, String address) {
        this.counter++;
        this.name = name;
        this.address = address;
        check();
    }

    @Override
    public synchronized String toString() {
        return "No. " + counter + ": " + name + ", " + address;
    }

    void check() {
        if (name.charAt(0) != address.charAt(0)) {
            System.out.println("******* BROKEN ******* " + toString());
        }
    }
}
