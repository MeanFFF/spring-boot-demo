package com.springboot.demo.leetcode.q387;

/**
 * description 利用数组替换hash表，计算字符出现次数；再从头遍历，查找第一个出现次数为1的字符
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-29 10:42:42
 * @since 1.0
 */
public class Solution {
    public int firstUniqChar(String s) {
        int[] nums = new int[52];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > 'A' && chars[i] < 'Z') {
                chars[i] -= 'A';
            } else {
                chars[i] = (char) (chars[i] - 'a' + 26);
            }
            nums[chars[i]] ++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (nums[chars[i]] == 1) {
                return i;
            }
         }
        return -1;
    }

    public int firstUniqChar1(String s) {
        int[] nums = new int[255];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            nums[chars[i]] ++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (nums[chars[i]] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.firstUniqChar("loveleetcode");
        System.out.println(result);
    }
}
