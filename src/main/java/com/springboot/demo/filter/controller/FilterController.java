package com.springboot.demo.filter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-09-30 16:28:51
 * @since 1.0
 */
@RestController
public class FilterController {

    @RequestMapping("/testFilter")
    public String testFilter() {
        System.out.println("这是一个方法");
        return "hello";
    }

}
