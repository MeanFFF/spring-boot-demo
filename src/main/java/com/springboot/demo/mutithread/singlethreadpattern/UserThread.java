package com.springboot.demo.mutithread.singlethreadpattern;

/**
 * @author gangping.liu
 * @date 2019/11/22 13:25:55
 */
public class UserThread extends Thread {
    private String username;
    private String address;
    private Gate gate;

    public UserThread(String username, String address, Gate gate) {
        this.username = username;
        this.address = address;
        this.gate = gate;
    }

    @Override
    public void run() {
        System.out.println("begin");
        while (true) {
            gate.pass(username, address);
        }
    }
}
