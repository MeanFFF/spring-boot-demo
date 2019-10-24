package com.springboot.demo.leetcode.q1217;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-24 16:41:54
 * @since 1.0
 */
public class Solution {
    public int minCostToMoveChips(int[] chips) {
        int res = 0;
        int even = 0;
        int n = chips.length;
        for (int i = 0; i < n; i++) {
            if (chips[i] % 2 == 1) {
                res ++;
            } else {
                even ++;
            }
        }
        return Math.min(res, even);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.minCostToMoveChips(new int[]{1,2,3});
        System.out.println(res);
    }
}
