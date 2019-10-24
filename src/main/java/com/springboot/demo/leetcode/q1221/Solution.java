package com.springboot.demo.leetcode.q1221;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-24 16:01:41
 * @since 1.0
 */
public class Solution {
    public int balancedStringSplit(String s) {
        int num = 0;
        int res = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'R') {
                num ++;
            } else {
                num --;
            }
            if (num == 0) {
                res += 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.balancedStringSplit("RLRRLLRLRL");

    }
}
