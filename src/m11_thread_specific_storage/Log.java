package m11_thread_specific_storage;

public class Log {
    private static final ThreadLocal<TSLog> tsLogCollection = new ThreadLocal<>();

    /**
     * ログを書く
     */
    static void println(String s) {
        getTSLog().println(s);
    }

    /**
     * ログを閉じる
     */
    static void close() {
        getTSLog().close();
    }

    private static TSLog getTSLog() {
        TSLog tsLog = tsLogCollection.get();

        if (tsLog == null) {
            tsLog = new TSLog(Thread.currentThread().getName() + "-log.txt");
            tsLogCollection.set(tsLog);
        }

        return tsLog;
    }
}
