package com.springboot.demo.mutithread.producerconsumer;

/**
 * @author gangping.liu
 * @date 2019/11/25
 */
public class Client {
    public static void main(String[] args) {
        Channel channel = new Channel(100);
        new Producer(channel).start();
        new Consumer(channel).start();
    }
}
