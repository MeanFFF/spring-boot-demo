package com.springboot.demo.aop;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-17 15:43:14
 * @since 1.0
 */
public class TestAop {
    public static void main(String[] args) {
        // 设置Aspect，Spring AOP中的Advisor只能有一个Pointcut和一个Advice
        NameMatchMethodPointcutAdvisor nameMatchMethodPointcutAdvisor = new NameMatchMethodPointcutAdvisor();
        // 1. 设置Pointcut
        nameMatchMethodPointcutAdvisor.setMappedName("hello");
        // 2. 设置Advice
        nameMatchMethodPointcutAdvisor.setAdvice(new ExceptionBarrierThrowsAdvice());

        ProxyFactory proxyFactory = new ProxyFactory();
        // 1. 设置目标对象
        proxyFactory.setTarget(new Subject());
        // 2. 设置Aspect
        proxyFactory.setInterfaces(ISubject.class);
        proxyFactory.addAdvisor(nameMatchMethodPointcutAdvisor);
        ISubject subject = (ISubject) proxyFactory.getProxy();
        System.out.println("this is subject : " + subject.getClass().getName());
        subject.hello();
    }
}
