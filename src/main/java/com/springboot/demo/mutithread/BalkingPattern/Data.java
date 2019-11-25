package com.springboot.demo.mutithread.BalkingPattern;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author gangping.liu
 * @date 2019/11/25
 */
public class Data {
    private String filename;
    private String content;
    private boolean changed;

    public Data(String filename, String content) {
        this.filename = filename;
        this.content = content;
        this.changed = true;
    }

    public void change(String content) {
        this.content = content;
        this.changed = true;
    }

    public synchronized void save() throws IOException {
        if (!this.changed) {
            System.out.println(Thread.currentThread().getName() + " balks");
            return;
        }
        doSave();
        this.changed = false;
    }

    private void doSave() throws IOException {
        System.out.println(Thread.currentThread().getName() + " calls doSave, content = " + content);
        Writer writer = new FileWriter(filename);
        writer.write(content);
        writer.close();
    }
}
