package com.springboot.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-09-30 17:10:31
 * @since 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestFilter {
    @Test
    public void test() {
        System.out.println("hello");
    }
}
