package com.springboot.demo.leetcode.q13;

import java.util.HashMap;
import java.util.Stack;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-29 09:45:01
 * @since 1.0
 */
public class Solution {
    /**
     * description
     * I    1
     * V    5
     * X    10
     * L    50
     * C    100
     * D    500
     * M    1000
     * IV   4
     * IX   9
     * XL   40
     * XC   90
     * CD   400
     * CM   900
     * II   2
     * XX   20
     * @author liugangping
     * @date 2019/10/29 9:46
     * @param [s]
     * @return int
     **/
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] chars = s.toCharArray();
        int num = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (i < chars.length - 1 && map.get(chars[i]) < map.get(chars[i + 1])) {
                num -= map.get(chars[i]);
            } else {
                num += map.get(chars[i]);
            }
        }

        return num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.romanToInt("IV");
        System.out.println(result);
    }
}
