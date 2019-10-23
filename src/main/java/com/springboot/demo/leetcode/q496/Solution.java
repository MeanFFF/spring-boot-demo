package com.springboot.demo.leetcode.q496;

import java.util.Arrays;
import java.util.Stack;

/**
 * description num1和num2中的元素都是唯一的
 * 先利用单调栈，获取num2中所有下一个比它大的元素，在数组中的下标为这个元素，值为下一个比它更大的元素
 * 利用num1中的值作为下标，获取值
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-23 10:48:31
 * @since 1.0
 */
public class Solution {
    private Stack<Integer> stack;

    public Solution() {
        stack = new Stack<Integer>();
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] temp = new int[10000];
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            temp[nums2[i]] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = temp[nums1[i]];
        }
        return nums1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2});
        System.out.println(Arrays.toString(result));
    }
}
