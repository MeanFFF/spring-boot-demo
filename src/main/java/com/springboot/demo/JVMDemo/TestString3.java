package com.springboot.demo.JVMDemo;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-31 14:04:30
 * @since 1.0
 */
public class TestString3 {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        String a = "AAA";
        String b = new String(a);
        System.out.println(b == b.intern());
    }
}
