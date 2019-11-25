package com.springboot.demo.mutithread.singlethreadpattern;

/**
 * @author gangping.liu
 * @date 2019/11/22 13:23:25
 */
public class Client {
    public static void main(String[] args) {
        /*
          共享资源分为两种：
          1. SafeMethod——从多个线程同时调用也不会发生问题的方法
          2. UnsafeMethod——从多个线程同时调用会发生问题，这类方法需要加以防护，指定只能由单线程访问区域，即临界区（critical section）。
          这里的Gate属于第二种
         */
        Gate gate = new Gate();
        new UserThread("hello", "hello", gate).start();
        new UserThread("gogo", "gogo", gate).start();
        new UserThread("kk", "kk", gate).start();
    }
}
