package com.springboot.demo.leetcode.q1201;

import java.util.Stack;

/**
 * description 当栈为空时，可以找到原语
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-23 09:34:14
 * @since 1.0
 */
public class Solution {
    private Stack<Character> stack;

    public Solution() {
        stack = new Stack<Character>();
    }

    public String removeOuterParentheses(String S) {
        StringBuilder result = new StringBuilder();
        int pre = 0;
        for (int i = 0; i < S.length(); i ++) {
            char ch = S.charAt(i);
            if (ch == '(') {
                stack.push('(');
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    result.append(S.substring(pre + 1, i));
                    pre = i + 1;
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.removeOuterParentheses("(()())(()())");
        System.out.println(result);
    }
}
