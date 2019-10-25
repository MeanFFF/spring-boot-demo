package com.springboot.demo.leetcode.q118;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-25 10:23:35
 * @since 1.0
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        // 行数为0时
        if (numRows == 0) {
            return lists;
        }
        // 行数1时
        lists.add(new ArrayList<>());
        lists.get(0).add(1);
        // 行数大于1时，下一行的数字等于1 1，中间包了前一行两个数相加的数字
        for (int i = 1; i < numRows; i++) {
            lists.add(new ArrayList<>());
            List<Integer> pre = lists.get(i-1);
            lists.get(i).add(1);
            for (int j = 1; j < pre.size(); j ++) {
                int temp = pre.get(j - 1) + pre.get(j);
                lists.get(i).add(temp);
            }
            lists.get(i).add(1);
        }

        return lists;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List list = solution.generate(4);
        System.out.println(list);
    }
}
