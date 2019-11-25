package com.springboot.demo.mutithread.BalkingPattern;


import java.io.IOException;
import java.util.Random;

public class SaverThread extends Thread {
    private Data data;
    private Random random;

    public SaverThread(Data data) {
        this.data = data;
        random = new Random();
    }

    @Override
    public void run() {
        try {
            while (true) {
                data.save();
                Thread.sleep(random.nextInt(1000));
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
