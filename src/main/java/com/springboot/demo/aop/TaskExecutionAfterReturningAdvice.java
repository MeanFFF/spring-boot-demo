package com.springboot.demo.aop;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-19 17:19:15
 * @since 1.0
 */
public class TaskExecutionAfterReturningAdvice implements AfterReturningAdvice {
    private SqlSessionTemplate sessionTemplate;
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        Class clazz = target.getClass();
        sessionTemplate.insert("OPERATION.insertHistory", clazz.getName());
    }

    public SqlSessionTemplate getSessionTemplate() {
        return sessionTemplate;
    }

    public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
        this.sessionTemplate = sessionTemplate;
    }
}
