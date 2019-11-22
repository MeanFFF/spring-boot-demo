package com.springboot.demo.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author liugangping
 * @date 2019-10-19 21:06:15
 */
public class PerformanceMethodInterceptor implements MethodInterceptor  {
    private static final Logger log = LoggerFactory.getLogger(PerformanceMethodInterceptor.class);
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("this is before advice function");
        try {
            // this is method process
            invocation.proceed();
            log.info("this is after returning advice function");
        } catch (Exception e) {
            log.info("this is after throwing advice function");
        }
        return null;
    }
}
