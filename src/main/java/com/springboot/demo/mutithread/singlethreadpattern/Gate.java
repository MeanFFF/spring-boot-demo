package com.springboot.demo.mutithread.singlethreadpattern;

/**
 * @author gangping.liu
 * @date 2019/11/22 13:14:55
 */
public class Gate {
    private int count = 0;
    private String username = "empty";
    private String address = "empty";

    /**
     * 临界资源，pass 可以被多个线程调用，改变Gate类的字段值
     * 要加锁
     * @param username 用户名
     * @param address 地址
     */
    public synchronized void pass(String username, String address) {
        count++;
        this.username = username; //线程2 gogo
        this.address = address; // 线程1 kk
        check();
    }

    private void check() {
        if (!username.equals(address)) {
            System.out.println("**** block *****" + toString());
        }
    }

    @Override
    public String toString() {
        return "Gate{" +
                "count=" + count +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
