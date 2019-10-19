package com.springboot.demo.aop;

import java.io.Serializable;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-17 15:44:40
 * @since 1.0
 */
public class Subject implements ISubject {
    @Override
    public void hello() {
        System.out.println("gogogo");
        throw new RuntimeException();
    }
}
