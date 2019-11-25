package com.springboot.demo.mutithread.immutablepattern;

/**
 * @author gangping.liu
 * @date 2019/11/22
 */
public class PrintPersonThread extends Thread {
    private Person person;

    public PrintPersonThread(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(person.toString());
        }
    }
}
