package com.springboot.demo.mutithread.GuardedSuspensionPattern;

public class ServerThread extends Thread {
    private RequestQueue requestQueue;

    public ServerThread(RequestQueue requestQueue) {
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            Request request = new Request("No." + i);
            System.out.println(Thread.currentThread().getName() + " requests " + request);
            requestQueue.putRequest(request);
        }
    }
}
