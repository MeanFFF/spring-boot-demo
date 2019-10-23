package com.springboot.demo;

import com.springboot.demo.amqp.MqSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-23 16:42:18
 * @since 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestMq {
    @Autowired
    private MqSender mqSender;
    @Test
    public void send() {
        for (int i = 0; i < 10; i++) {
            mqSender.send(1);
        }
    }
}
