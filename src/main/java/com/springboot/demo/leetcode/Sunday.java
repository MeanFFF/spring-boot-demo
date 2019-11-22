package com.springboot.demo.leetcode;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-29 13:39:22
 * @since 1.0
 */
public class Sunday {

    public int match(String haystack, String needle) {
        if (haystack.equals("") && needle.equals("")) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        int j, pos = 0, i = pos;
        int n = needle.length();
        while (i < haystack.length() && i - pos <= needle.length()) {
            if (pos + n > haystack.length()) {
                return -1;
            }
            if (haystack.charAt(i) != needle.charAt(i - pos)) {
                int temp = pos + n;
                if (temp >= haystack.length()) {
                    pos = temp;
                    break;
                }
                j = check(needle, haystack.charAt(temp));
                if (j == -1) {
                    pos = pos + n + 1;
                } else {
                    pos = pos + n - j;
                }
                i = pos;
            } else {
                i ++;
            }
        }

        return pos >= haystack.length() ? -1 : pos;
    }

    public int check(String target, char ch) {
        char[] chars = target.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Sunday sunday = new Sunday();
        int result = sunday.match("mississippi", "sippia");
        System.out.println(result);
    }
}
