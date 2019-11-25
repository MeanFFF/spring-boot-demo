package com.springboot.demo.mutithread.BalkingPattern;

import java.io.IOException;
import java.util.Random;

/**
 * @author gangping.liu
 * @date 2019/11/25
 */
public class ChangerThread extends Thread {
    private Data data;
    private Random random;
    public ChangerThread(Data data) {
        this.data = data;
        random = new Random();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; true; i++) {
                data.change("No." + i);
                Thread.sleep(random.nextInt(1000));
//                data.save();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
