package com.springboot.demo.leetcode.q3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-24 11:31:17
 * @since 1.0
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (allUnique(s, i, j)) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        HashSet<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    /**
     * description 滑动窗口：判断新元素，如果新元素没有出现过，则向右扩界
     * 如果出现过，则向左缩界，直到set中不包含这个元素；进行下一步
     * @author liugangping
     * @date 2019/10/24 13:49
     * @param [s]
     * @return int
     **/
    public int lengthOfLongestSubstring1(String s) {
        int i = 0, j = 0, n = s.length(), ans = 0;
        HashSet<Character> set = new HashSet<>();
        char ch;
        while (i < n && j < n) {
             ch = s.charAt(j);
            if (!set.contains(ch)) {
                set.add(ch);
                ans = Math.max(ans, set.size());
                j++;
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.lengthOfLongestSubstring2("asdffdas");
        System.out.println(result);
    }
}
