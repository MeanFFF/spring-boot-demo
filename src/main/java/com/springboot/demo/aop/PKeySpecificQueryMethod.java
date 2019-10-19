package com.springboot.demo.aop;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-19 16:09:39
 * @since 1.0
 */
public class PKeySpecificQueryMethod extends DynamicMethodMatcherPointcut {
    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        if (method.getName().startsWith("get") && method.getName().endsWith("dao")) {
           if (ArrayUtils.isEmpty(args)) {
               return StringUtils.equals("hello", args[0].toString());
           }
        }
        return false;
    }
}
