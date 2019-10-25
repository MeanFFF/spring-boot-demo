package com.springboot.demo.leetcode.q171;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-25 09:41:11
 * @since 1.0
 */
public class Solution {
    public int titleToNumber(String s) {
        int n = s.length();
        int res = s.charAt(0) - 'A' + 1;
        for (int i = 1; i < n; i++) {
            res = res * 26 + (s.charAt(i) - 'A' + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int a = solution.titleToNumber("AAA");
        System.out.println(a);
    }
}
