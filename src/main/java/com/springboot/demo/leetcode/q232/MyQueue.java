package com.springboot.demo.leetcode.q232;

import java.util.Stack;

/**
 * description
 * 利用两个栈实现队列，
 * 栈1负责push，栈2负责pop
 * 当栈2为空的时候，才将栈1的元素移到栈2
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-23 11:02:45
 * @since 1.0
 */
class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        // 当栈2为空的时候，才将栈1的元素移到栈2
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        int peek = this.pop();
        stack2.push(peek);
        return peek;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        queue.push(3);
    }
}

