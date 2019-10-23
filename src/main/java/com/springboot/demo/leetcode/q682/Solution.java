package com.springboot.demo.leetcode.q682;

import java.util.Stack;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-23 09:52:43
 * @since 1.0
 */
public class Solution {
    private Stack<Integer> stack;

    public Solution() {
        stack = new Stack<Integer>();
    }

    /**
     * description
     * 1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
     * 2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
     * 3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
     * 4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
     *
     * @author liugangping
     * @date 2019/10/23 10:09
     * @param ops: 操作符
     * @return int
     **/
    public int calPoints(String[] ops) {
        int result = 0;
        for (String op : ops) {
            switch (op) {
                case "+" :
                    int s1 = stack.pop();
                    int s2 = stack.peek();
                    stack.push(s1);
                    stack.push(s1 + s2);
                    result += s1 + s2;
                    break;
                case "D" :
                    int score = stack.peek();
                    stack.push(score * 2);
                    result += score * 2;
                    break;
                case "C" :
                    int s3 = stack.pop();
                    result -= s3;
                    break;
                default:
                    int s4 = Integer.valueOf(op);
                    stack.push(s4);
                    result += s4;
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"5","2","C","D","+"};
        Solution solution = new Solution();
        int result = solution.calPoints(strings);
        System.out.println(result);
    }
}
