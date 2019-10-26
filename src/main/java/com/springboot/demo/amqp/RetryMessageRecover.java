package com.springboot.demo.amqp;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.retry.MessageRecoverer;
import org.springframework.retry.interceptor.MethodInvocationRecoverer;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-26 10:35:58
 * @since 1.0
 */
public class RetryMessageRecover implements MessageRecoverer, MethodInvocationRecoverer<Object> {
    @Override
    public void recover(Message message, Throwable cause) {

    }

    @Override
    public Object recover(Object[] objects, Throwable throwable) {
        return null;
    }
}
