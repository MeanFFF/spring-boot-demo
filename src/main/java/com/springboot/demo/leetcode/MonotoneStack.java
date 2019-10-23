package com.springboot.demo.leetcode;

import java.util.*;

/**
 * description
 * 元素倒着入栈
 * 1. 先与栈顶比较，如果栈顶元素较小则弹出；
 * 2. 获取现在的栈顶元素，如果栈为空，则返回-1
 * 3. 当前元素入栈
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-23 10:32:42
 * @since 1.0
 */
public class MonotoneStack {
    private Stack<Integer> stack;

    public MonotoneStack() {
        stack = new Stack<Integer>();
    }

    public int[] nextGreaterElement(int[] elements) {
        int[] result = new int[elements.length];
        for (int i = elements.length - 1; i >= 0; i --) {
            while (!stack.isEmpty() && stack.peek() <= elements[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(elements[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        MonotoneStack stack = new MonotoneStack();
        int[] result = stack.nextGreaterElement(new int[]{2, 1, 2, 4, 3});
        System.out.println(Arrays.toString(result));
    }
}
