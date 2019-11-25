package com.springboot.demo.mutithread.ReadWriteLockPattern;

public class WriteThread extends Thread {
    private Data data;
    private String msg;
    private int index = 0;
    public WriteThread(Data data, String msg) {
        this.data = data;
        this.msg = msg;
    }

    @Override
    public void run() {
        try {
            while(true) {
                char c = nextVar();
                data.write(c);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private char nextVar() {
        char c = msg.charAt(index);
        index ++;
        if (index >= msg.length()) {
            index = 0;
        }
        return c;
    }
}
