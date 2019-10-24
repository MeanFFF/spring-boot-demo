package com.springboot.demo.leetcode.q1029;

import java.util.Arrays;
import java.util.Comparator;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-24 17:22:10
 * @since 1.0
 */
public class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> o1[1] - o1[0] - (o2[1] - o2[0]));
        int total = 0;
        int n = costs.length / 2;

        for (int i = 0; i < n; ++i) {
            total += costs[i][1] + costs[i + n][0];
        }
        return total;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.twoCitySchedCost(new int[][]{{10,20}, {20,30}, {20,30}, {20,30}});
        System.out.println(res);
    }
}
