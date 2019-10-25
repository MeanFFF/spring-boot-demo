package com.springboot.demo.leetcode.q119;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-25 11:00:30
 * @since 1.0
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> cur = null;
        List<Integer> pre = new ArrayList<>();
        pre.add(1);
        if (rowIndex == 0) {
            return pre;
        }
        while (rowIndex > 0) {
            cur = new ArrayList<>();
            cur.add(1);
            for (int i = 1; i < pre.size(); i ++) {
                int temp = pre.get(i) + pre.get(i - 1);
                cur.add(temp);
            }
            cur.add(1);
            pre = cur;
            rowIndex --;
        }
        return cur;
    }

    public List<Integer> getRow2(int rowIndex) {
        List<Integer> cur = new ArrayList<>();
        long res;
        int n = rowIndex;
        if (rowIndex == 0) {
            return cur;
        }
        cur.add(1);
        for (int i = 1; i < rowIndex; i ++) {
            res = 1;
            for (int j = 0; j < i; j++) {
                res = res * (n - j) / (j + 1);
            }
            cur.add((int) res);
        }
        cur.add(1);
        return cur;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List list = solution.getRow2(4);
        System.out.println(list);
    }
}
