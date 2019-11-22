package com.springboot.demo.JVMDemo;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-31 10:57:39
 * @since 1.0
 */
public class TestString2 {
    public static void test() {
        String a1 = "AA";
        System.out.println(a1 == a1.intern()); //true
        String a2 = new String("B") + new String("B");
        a2.intern();
        String a3 = new String("B") + new String("B");
        System.out.println(a2 == a3.intern());//true
        System.out.println(a3 == a3.intern());//false
        String a4 = new String("C") + new String("C");
        System.out.println(a4 == a4.intern()); //true
    }

    public static void main(String[] args) {
//        String a = "aa";
//        String b = "bb";
//        // 只会创建堆对象，优化为了StringBuilder
//        String s = a + b;
//        s.intern();
//        String s2 = "aabb";
//        System.out.println(s == s2);

        TestString2.test();
    }
}
