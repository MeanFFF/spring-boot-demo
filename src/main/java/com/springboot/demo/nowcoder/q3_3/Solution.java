package com.springboot.demo.nowcoder.q3_3;

public class Solution {
    public boolean chkTransform(String str1, int lena, String str2, int lenb) {
        // write code here
        if (str1 == null || str2 == null || lena != lenb) {
            return false;
        }

        int[] map1 = new int[256];
        int[] map2 = new int[256];
        for(int i = 0; i < lena; i++) {
            map1[str1.charAt(i)]++;
            map2[str2.charAt(i)]--;
        }

        for (int j = 0; j < lena; j++) {
            if (map1[str1.charAt(j)] + map2[str1.charAt(j)] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean result = solution.chkTransform("abcc", 4, "accb", 4);
        System.out.println(result);
    }
}
