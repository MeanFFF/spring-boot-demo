package com.springboot.demo.async.controller;

import com.springboot.demo.async.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-09-30 15:18:41
 * @since 1.0
 */
@RestController
@RequestMapping("/")
public class TestController {
    @Autowired
    private AsyncService asyncService;

    @RequestMapping("test1")
    public String test1() throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();
        Future<Boolean> task1 = asyncService.task1();
        Future<Boolean> task2 = asyncService.task2();
        Future<Boolean> task3 = asyncService.task3();
        System.out.println(task1.get());
        while (!task1.isDone() || !task2.isDone() || !task3.isDone()) {
            if (task1.isDone() && task2.isDone() && task3.isDone()) {
                break;
            }
        }
        return String.valueOf((System.currentTimeMillis() - start));
    }

    @RequestMapping("test")
    public String test() throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();
        Future<String> task1 = asyncService.task();
        // task1.get()是阻塞的，只有当异步方法返回内容了，程序才会继续往下执行
        System.out.println(task1.get());
        return String.valueOf((System.currentTimeMillis() - start));
    }


}
