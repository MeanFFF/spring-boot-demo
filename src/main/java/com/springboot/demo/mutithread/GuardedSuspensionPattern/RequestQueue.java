package com.springboot.demo.mutithread.GuardedSuspensionPattern;

import java.util.LinkedList;

/**
 * GuardedObject (被防卫的对象)参与者
 * @author gangping.liu
 * @date 2019/11/22
 */
public class RequestQueue {
    private LinkedList<Request> requests = new LinkedList<>();

    /**
     * 被防卫的方法（guardedMethod）
     * 当线程执行guardedMethod时，只要满足警戒条件，就能继续执行，否则线程会进入wait set区等待。
     * 警戒条件是否成立随着GuardedObject的状态而变化。
     * GuardedObject 参与者除了guardedMethod外，可能还有用来更改实例状态的的方法stateChangingMethod。
     * @return Request
     */
    public synchronized Request getRequest() {
        /*
        使用while 而不使用if，因为while 可以使从wait set中唤醒的方法再次判断条件
        而if 继续向下执行，会产生问题
         */
        while (requests.size() <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return requests.getFirst();
    }

    /**
     * stateChangingMethod(状态改变方法)
     * 有请求了，唤醒其他线程来处理这个请求
     * @param request
     */
    public synchronized void putRequest(Request request) {
        requests.add(request);
        notifyAll();
    }
}
