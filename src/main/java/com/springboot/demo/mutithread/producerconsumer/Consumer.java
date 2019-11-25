package com.springboot.demo.mutithread.producerconsumer;

/**
 * @author gangping.liu
 * @date 2015/11/25
 */
public class Consumer extends Thread {
    private Channel channel;

    public Consumer(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10000; i++) {
                String data = channel.take();
                System.out.println("consumer take : " + data);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
