package com.springboot.demo.mutithread.immutablepattern;

/**
 * @author gangping.liu
 * @date 2019/11/22
 */
public class Client {
    public static void main(String[] args) {
        Person person = new Person("nick", 12);
        new PrintPersonThread(person).start();
        new PrintPersonThread(person).start();
        new PrintPersonThread(person).start();
    }
}
