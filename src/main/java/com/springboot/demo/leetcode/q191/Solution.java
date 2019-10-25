package com.springboot.demo.leetcode.q191;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-25 14:11:10
 * @since 1.0
 */
public class Solution {
    public int hammingWeight(int n) {
        int num = 0;
        while (n != 0) {
            num += n & 1;
            n >>>= 1;
        }
        return num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int res = solution.hammingWeight(-3);
        System.out.println(res);
    }
}
