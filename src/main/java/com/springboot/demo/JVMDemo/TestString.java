package com.springboot.demo.JVMDemo;

import javax.validation.constraints.Max;
import java.util.Random;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-31 09:50:54
 * @since 1.0
 */
public class TestString {
    private static final int MAX = 1000 * 10000;
    private static final String[] arr = new String[MAX];

    public static void main(String[] args) {
        Integer[] DB_DATA = new Integer[10];
        Random random = new Random(10 * 10000);
        for (int i = 0; i < DB_DATA.length; i++) {
            DB_DATA[i] = random.nextInt();
        }
        long t = System.currentTimeMillis();
        /**
         *程序只用到了10个字符串；使用intern()重用，可以大大提高效率
         */
        for (int i = 0; i < MAX; i++) {
//            arr[i] = new String(String.valueOf(DB_DATA[i % DB_DATA.length]));
            arr[i] = String.valueOf(DB_DATA[i % DB_DATA.length]).intern();
        }
        System.out.println(System.currentTimeMillis() - t + "ms");
        System.gc();
    }
}
