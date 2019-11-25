package com.springboot.demo.mutithread.GuardedSuspensionPattern;

/**
 * @author gangping.liu
 * @date 2019/11/22
 */
public class Request {
    private String name;

    public Request(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                '}';
    }
}
