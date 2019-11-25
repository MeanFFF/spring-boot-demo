package com.springboot.demo.mutithread.jmm;

/**
 * @author gangping.liu
 * @date 2019/11/25 13:33:25
 */
public class NotSafeThreadDemo {
    public static void main(String[] args) {
        WrapObject wrapObject = new WrapObject();
        wrapObject.a = 30;
        final int tag = 30;
        System.out.println(tag + "--main-->" + wrapObject.a);
        new Thread(() ->{
            System.out.println(tag +"--join-->"+wrapObject.a);
        }).start();
    }

    static class WrapObject{
        public int a = 10;
    }
}
