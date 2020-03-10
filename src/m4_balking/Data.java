package m4_balking;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Data {
    private final String fileName;
    private String content;
    private boolean changed;

    Data(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
        this.changed = true;
    }

    /**
     * データを書き換える
     */
    synchronized void change(String newContent) {
        content = newContent;
        changed = true;
    }

    /**
     * データの内容が変更されていたらファイルに保存する
     */
    synchronized void save() throws IOException {
        if (!changed) return;

        doSave();
        changed = false;
    }

    /**
     * データの内容を実際にファイルに保存する
     */
    private void doSave() throws IOException {
        System.out.println(Thread.currentThread().getName() + " calls doSave, content = " + content);
        Writer writer = new FileWriter(fileName);
        writer.write(content);
        writer.close();
    }
}
