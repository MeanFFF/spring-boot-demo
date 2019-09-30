package com.springboot.demo.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-09-30 15:19:41
 * @since 1.0
 */
@Slf4j
@Service
public class AsyncService {
    @Async("asyncThreadPoolTackExecutor")
    public Future<String> task() throws InterruptedException {
        log.error("this is task1, thread is {}", Thread.currentThread().getName());
        Thread.sleep(1000);
        return new AsyncResult<>("hello everyone");
    }

    @Async("asyncThreadPoolTackExecutor")
    public Future<Boolean> task1() throws InterruptedException {
        log.error("this is task1, thread is {}", Thread.currentThread().getName());
        Thread.sleep(1000);
        return new AsyncResult<>(true);
    }

    @Async("asyncThreadPoolTackExecutor")
    public Future<Boolean> task2() throws InterruptedException {
        log.error("this is task2, thread is {}", Thread.currentThread().getName());
        Thread.sleep(700);
        return new AsyncResult<>(true);
    }

    @Async("asyncThreadPoolTackExecutor")
    public Future<Boolean> task3() throws InterruptedException {
        log.error("this is task3, thread is {}", Thread.currentThread().getName());
        Thread.sleep(900);
        return new AsyncResult<>(true);
    }
}
