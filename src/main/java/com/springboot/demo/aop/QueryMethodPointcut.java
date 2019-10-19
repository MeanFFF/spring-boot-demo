package com.springboot.demo.aop;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-19 16:05:41
 * @since 1.0
 */
public class QueryMethodPointcut extends StaticMethodMatcherPointcut {
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return method.getName().startsWith("get") && method.getName().endsWith("dao");
    }
}
