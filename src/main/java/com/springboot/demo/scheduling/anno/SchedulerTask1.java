package com.springboot.demo.scheduling.anno;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * description 注解定时任务1
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-09-30 13:44:22
 * @since 1.0
 */
@Component
public class SchedulerTask1 {
    private int count = 0;

    @Scheduled(fixedDelay = 6000)
    public void process() throws InterruptedException {
        System.out.println("this method start===========");
        System.out.println("sleep 2 s");
        Thread.sleep(2000);
        System.out.println("this is scheduler task running  "+(count++));
    }
}
