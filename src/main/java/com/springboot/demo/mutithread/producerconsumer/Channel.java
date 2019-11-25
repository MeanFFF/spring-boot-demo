package com.springboot.demo.mutithread.producerconsumer;

/**
 * @author gangping.liu
 * @date 2019/11/25
 */
public class Channel {
    private String[] buffer;
    private int count;
    private int head;
    private int tail;

    public Channel(int count) {
        buffer = new String[count];
        head = 0;
        tail = 0;
    }

    public synchronized void put(String data) throws InterruptedException {
        while (count >= buffer.length) {
            System.out.println("wait to consume");
            wait();
        }
        buffer[tail++] = data;
        tail %= buffer.length;
        count ++;
        notifyAll();
    }

    public synchronized String take() throws InterruptedException {
        while (count <= 0) {
            System.out.println("wait for data");
            wait();
        }
        String data = buffer[head++];
        head %= buffer.length;
        count --;
        notifyAll();
        return data;
    }
}
