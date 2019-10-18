package com.springboot.demo.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-17 15:47:46
 * @since 1.0
 */
public class SubjectBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("hello this is before advice");
    }
}
