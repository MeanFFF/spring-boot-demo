package com.springboot.demo.leetcode.q155;

import java.util.Stack;

/**
 * description
 * 存入时，将当前值与当前最小值一起存入；弹出时相应弹出
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-23 11:20:50
 * @since 1.0
 */
class MinStack {
    private Stack<Integer> stack;
    private Integer min = null;
    // pre

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (min == null || min > x) {
            min = x;
        }
        stack.push(x);
        stack.push(min);
    }

    /**
     * description
     * 当最小值弹出的时候，
     * min还是已经弹出的最小值；
     * 将min置为当前队列中最小值
     * @author liugangping
     * @date 2019/10/23 13:59
     **/
    public void pop() {
        stack.pop();
        stack.pop();
        // 清空min
        if (stack.isEmpty()) {
            min = null;
        } else {
            min = getMin();
        }
    }

    public int top() {
        int temp = stack.pop();
        int peek = stack.peek();
        stack.push(temp);
        return peek;
    }

    public int getMin() {
        return stack.peek();
    }

    /**
     * [“ MinStack”，
     * “ push[2147483646]”，
     * “ push[2147483646]”，
     * “ push[2147483647]”，
     * “ r1 top[2147483647]”，
     * “ pop”，
     * “ r2 getMin[2147483646]”，
     * “ pop”，
     * “ r3 getMin[2147483646]”，
     * “ pop”，
     * “ push[2147483647]”，
     * “ r4 top” ，
     * “ r5 getMin[2147483647]”，
     * “ push[-2147483648]”，
     * “ r6 top[-2147483648]”，
     * “ r7 getMin[-2147483648]”，
     * “ pop”，
     * “ r8 getMin[2147483647]”]
     */
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-10);
        minStack.push(14);
        minStack.push(-20);
        minStack.pop();
        minStack.push(10);
        minStack.push(-7);
        System.out.println(minStack.getMin());
    }
}
