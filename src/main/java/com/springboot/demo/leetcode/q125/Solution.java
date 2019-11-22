package com.springboot.demo.leetcode.q125;


/**
 * description 先转换，再验证是否是回文
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-29 10:21:13
 * @since 1.0
 */
public class Solution {
    public boolean isPalindrome(String s) {
        char[] chs = s.toCharArray();
        int cns = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] >= 'a' && chs[i] <= 'z' || chs[i] >= '0' && chs[i] <= '9') {
                chs[cns++] = chs[i];
            } else if (chs[i] >= 'A' && chs[i] <= 'Z') {
                chs[cns++] = (char) (chs[i] + 32);
            }
        }
        for (int i = 0; i < cns / 2; i++) {
            if (chs[i] != chs[cns - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean result = solution.isPalindrome("helleh");
        System.out.println(result);
    }
}
