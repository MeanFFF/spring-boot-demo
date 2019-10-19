package com.springboot.demo.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-17 15:47:46
 * @since 1.0
 */
public class SubjectBeforeAdvice implements MethodBeforeAdvice {
    private static final Logger log = LoggerFactory.getLogger(SubjectBeforeAdvice.class);
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        log.info("进入 {} 方法，参数是 {}", method.toString(), Arrays.toString(objects));
    }
}
