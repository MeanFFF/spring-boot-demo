package com.springboot.demo.mutithread.GuardedSuspensionPattern;

public class Client {
    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();
        new ServerThread(requestQueue).start();
        new ClientThread(requestQueue).start();
    }
}
