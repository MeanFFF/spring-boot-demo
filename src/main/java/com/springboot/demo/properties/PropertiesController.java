package com.springboot.demo.properties;

import com.springboot.demo.properties.Bean.MyProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-09-30 17:22:14
 * @since 1.0
 */
@RestController
public class PropertiesController {
    @Autowired
    private MyProperties myProperties;

    @RequestMapping("/testMyProperties")
    public String testMyProperties() {
        System.out.println("hello " + myProperties.getId() + " your name is : " + myProperties.getUsername());
        System.out.println("detail is :" + myProperties.getDetail());
        return "hello";
    }
}
