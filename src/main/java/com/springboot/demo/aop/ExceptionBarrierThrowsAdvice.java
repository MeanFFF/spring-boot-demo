package com.springboot.demo.aop;

import org.omg.CORBA.portable.ApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-19 16:47:48
 * @since 1.0
 */
public class ExceptionBarrierThrowsAdvice implements ThrowsAdvice {
    private static final Logger log = LoggerFactory.getLogger(ExceptionBarrierThrowsAdvice.class);
    public void afterThrowing(RuntimeException e) {
        log.info("this is RuntimeException");
        e.printStackTrace();
    }

    public void afterThrowing(Throwable e) {
        log.info("this is Throwable");
        e.printStackTrace();
    }

    public void afterThrowing(Method method, Object[] args, Object target, ApplicationException e) {
        log.info("this is ApplicationException");
        e.printStackTrace();
    }
}
