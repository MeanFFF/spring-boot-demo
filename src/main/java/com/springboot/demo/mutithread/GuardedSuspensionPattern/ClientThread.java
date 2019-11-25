package com.springboot.demo.mutithread.GuardedSuspensionPattern;

public class ClientThread extends Thread {
    private RequestQueue requestQueue;

    public ClientThread(RequestQueue requestQueue) {
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            Request request = requestQueue.getRequest();
            System.out.println(Thread.currentThread().getName() + " handles " + request);
        }
    }
}
