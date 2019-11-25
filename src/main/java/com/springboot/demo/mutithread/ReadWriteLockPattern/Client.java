package com.springboot.demo.mutithread.ReadWriteLockPattern;

public class Client {
    public static void main(String[] args) {
        Data data = new Data(10);
        new ReadThread(data).start();
        new ReadThread(data).start();
        new ReadThread(data).start();
        new ReadThread(data).start();
        new WriteThread(data, "ABCDEFGHIJKLMNOPQRSTUVWXYZ").start();
        new WriteThread(data, "abcdefghijklmnopqrstuvwxyz").start();
    }
}
