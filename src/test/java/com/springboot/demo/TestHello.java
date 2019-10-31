package com.springboot.demo;

import com.springboot.demo.leetcode.q387.Solution;
import org.junit.Test;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-29 15:41:43
 * @since 1.0
 */
public class TestHello {
    @Test
    public void testString() {
        String str1 = "str", str2 = "ing";
        String a = "str" + "ing";
        String b = "string";
        String c = str1 + str2;
        System.out.println(a == b);
        System.out.println(b == c);
    }

    @Test
    public void testInteger() {
        Integer num1 = 100;
        int num2 = 100;
        Long num3 = 200L;
        System.out.println(num1 + num2);  //200
        System.out.println(num3 == (num1 + num2));  //true
        System.out.println(num3.equals(num1 + num2));  //false
        System.out.println(num3.equals(200L));

        num1 = num1 + 1;
        System.out.println(num1);
    }

    @Test
    public void testCharacter() {
        Integer a = null;
        System.out.println(a);
    }

    @Test
    public void testClassLoader() {
        System.out.println(Solution.class.getClassLoader());
        System.out.println(String.class.getClassLoader());
    }
}
