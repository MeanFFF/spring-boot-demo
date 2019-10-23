package com.springboot.demo.amqp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-23 17:02:26
 * @since 1.0
 */
@RestController
public class MqController {
    @Autowired
    private MqService mqService;
    @RequestMapping("/mqtest")
    public String trustyMq() {
        mqService.testService();
        return null;
    }
}
