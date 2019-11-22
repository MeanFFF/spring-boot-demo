package com.springboot.demo.transactional.aop;

import com.springboot.demo.transactional.utils.MyTransactional;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Component
@Aspect
@Slf4j
public class TransAop {
    @Autowired
    private MyTransactional myTransactional;

    @Pointcut("execution(* com.springboot.demo.transactional.service.impl.TransServiceImpl.hello())")
    public void transPoint() {}

    @Around("transPoint()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        TransactionStatus transactionStatus = myTransactional.begin();
        Object result = null;
        try {
            result = joinPoint.proceed();
            myTransactional.commit(transactionStatus);
            return result;
        } catch (Exception e) {
            myTransactional.rollback(transactionStatus);
            return "";
        }
    }
}
