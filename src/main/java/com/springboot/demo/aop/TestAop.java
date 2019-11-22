package com.springboot.demo.aop;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
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
        nameMatchMethodPointcutAdvisor.setAdvice(new PerformanceMethodInterceptor());

        // 1. 声明Advisor
        DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor();
        // 2. 声明Pointcut
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedName("hello");
        // 3. 声明Advice
        PerformanceMethodInterceptor advice = new PerformanceMethodInterceptor();
        // 4. 设置Pointcut
        defaultPointcutAdvisor.setPointcut(pointcut);
        // 5. 设置Advice
        defaultPointcutAdvisor.setAdvice(advice);

        // 1. 声明ProxyFactory
        ProxyFactory proxyFactory = new ProxyFactory();
        // 2. 设置目标对象
        proxyFactory.setTarget(new Subject());
        // 3. 设置Aspect
        proxyFactory.addAdvisor(nameMatchMethodPointcutAdvisor);
        // 4. 设置代理接口类型
        proxyFactory.setInterfaces(new Class[]{ISubject.class});
        // 4. 获取织入后的代理对象
        ISubject subject = (ISubject) proxyFactory.getProxy();
        System.out.println(subject.getClass().getName());
        // 5. 调用方法
        subject.hello();
    }
}
