package com.springboot.demo.leetcode.q1047;

import java.util.Stack;

/**
 * description
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-23 10:11:32
 * @since 1.0
 */
public class Solution {
    private Stack<Character> stack;

    public Solution() {
        stack = new Stack<Character>();
    }

    /**
     * description
     * 输入："abbaca"
     * 输出："ca"
     * @author liugangping
     * @date 2019/10/23 10:21
     * @param S：输入字符串
     * @return java.lang.String
     **/
    public String removeDuplicates(String S) {
        StringBuilder string = new StringBuilder();
        for (char ch : S.toCharArray()) {
            if (!stack.isEmpty() && ch == stack.peek()) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        stack.forEach(string::append);
        return string.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.removeDuplicates("abbaca");
        System.out.println(result);
    }
}
