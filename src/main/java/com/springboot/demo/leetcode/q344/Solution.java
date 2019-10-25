package com.springboot.demo.leetcode.q344;

import java.util.Arrays;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-25 09:31:14
 * @since 1.0
 */
public class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        for (int i = 0; i < n / 2; i++) {
            char temp = s[i];
            s[i] = s[n - i - 1];
            s[n - i - 1] = temp;
        }

        System.out.println(Arrays.toString(s));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.reverseString(new char[]{'a', 'b', 'c', 'd'});
    }
}
