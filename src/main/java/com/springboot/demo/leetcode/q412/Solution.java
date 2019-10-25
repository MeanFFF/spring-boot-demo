package com.springboot.demo.leetcode.q412;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-25 13:39:54
 * @since 1.0
 */
public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(i + "");
            }
        }
        return list;
    }

    public List<String> fizzBuzz1(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean mod3 = (i % 3 == 0);
            boolean mod5 = (i % 5 == 0);
            StringBuilder str = new StringBuilder();
            if (mod3) {
                str.append("Fizz");
            }

            if (mod5) {
                str.append("Buzz");
            }

            if (str.length() == 0) {
                str.append(i);
            }
            list.add(str.toString());
        }
        return list;
    }

    public List<String> fizzBuzz2(int n) {
        Map<Integer, String> map = new HashMap<Integer, String>(16);
        map.put(3, "Fizz");
        map.put(5, "Buzz");
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            StringBuilder str = new StringBuilder();
            for (Integer key : map.keySet()) {
                if (i % key == 0) {
                    str.append(map.get(key));
                }
            }
            if (str.length() == 0) {
                str.append(i);
            }
            list.add(str.toString());
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> list = solution.fizzBuzz2(15);
        System.out.println(list);
    }
}
