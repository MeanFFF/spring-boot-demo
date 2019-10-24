package com.springboot.demo.leetcode.q1046;

import javax.validation.constraints.Min;
import java.util.*;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-24 16:52:28
 * @since 1.0
 */
public class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int stone : stones) {
            heap.offer(stone);
        }

        while (heap.size() > 2) {
            int x = heap.poll();
            int y = heap.poll();
            if (x != y) {
                heap.offer(x - y);
            }
        }

        return heap.size() == 0 ? 0 : heap.peek();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.lastStoneWeight(new int[]{1,2,3,4,5});
        System.out.println(res);
    }
}
