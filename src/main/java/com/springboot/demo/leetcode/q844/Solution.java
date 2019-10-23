package com.springboot.demo.leetcode.q844;

import java.util.Stack;

/**
 * description
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * 可以使用string builder来模拟栈
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-23 14:02:59
 * @since 1.0
 */
public class Solution {
    public boolean backspaceCompare(String S, String T) {
        StringBuilder str = new StringBuilder();
        for (char ch : S.toCharArray()) {
            if (ch == '#') {
                if (str.length() != 0) {
                    str.deleteCharAt(str.length()-1);
                }
            } else {
                str.append(ch);
            }
        }
        String s = str.toString();
        str = new StringBuilder();
        for (char ch : T.toCharArray()) {
            if (ch == '#') {
                if (str.length() != 0) {
                    str.deleteCharAt(str.length()-1);
                }
            } else {
                str.append(ch);
            }
        }
        return s.contentEquals(str);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean result = solution.backspaceCompare("a##b", "b");
        System.out.println(result);
    }
}
