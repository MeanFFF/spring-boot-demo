package com.springboot.demo.mutithread.BalkingPattern;

public class Client {
    public static void main(String[] args) {
        Data data = new Data("data.txt", "this is content");
        // 修改线程
        new ChangerThread(data).start();
        // 保存线程
        new SaverThread(data).start();
    }
}
