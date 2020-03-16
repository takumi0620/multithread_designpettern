package m11_thread_specific_storage;

import java.io.IOException;
import java.io.PrintWriter;

public class TSLog {
    private PrintWriter writer = null;

    TSLog(String fileName) {
        try {
            writer = new PrintWriter(new PrintWriter(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ログを書く
     */
    void println(String s) {
        writer.println(s);
    }

    /**
     * ログを閉じる
     */
    void close() {
        writer.println("==== End of log ====");
        writer.close();
    }
}
