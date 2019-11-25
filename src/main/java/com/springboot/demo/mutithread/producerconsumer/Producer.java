package com.springboot.demo.mutithread.producerconsumer;

/**
 * @author gangping.liu
 * @date 2019/11/25
 */
public class Producer extends Thread {
    private Channel channel;

    public Producer(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10000; i++) {
                String data = Thread.currentThread().getName() + i + " data";
                channel.put(data);
                System.out.println("producer put : " + data);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
