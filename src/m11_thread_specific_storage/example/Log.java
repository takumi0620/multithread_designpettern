package m11_thread_specific_storage.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Log {
    private static PrintWriter writer = null;

    static {
        try {
            writer = new PrintWriter(new FileWriter("log.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void println(String s) {
        writer.println(s);
    }

    static void close() {
        writer.println("==== End of log ====");
        writer.close();
    }
}
