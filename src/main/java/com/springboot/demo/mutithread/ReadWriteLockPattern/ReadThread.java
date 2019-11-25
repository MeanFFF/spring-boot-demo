package com.springboot.demo.mutithread.ReadWriteLockPattern;

import java.util.Arrays;

public class ReadThread extends Thread {
    private Data data;

    public ReadThread(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            while (true) {
                char[] readBuf = data.read();
                System.out.println(Thread.currentThread().getName() + " reads " + Arrays.toString(readBuf));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
