package com.springboot.demo.scheduling.inter;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;


/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-09-30 14:17:02
 * @since 1.0
 */
@Component
public class DynamicScheduleTask implements SchedulingConfigurer {
    @Mapper
    public interface CronMapper{
        /**
         * description 获取数据库中的cron
         * @author liugangping
         * @date 2019/9/30 14:42
         * @param
         * @return java.lang.String
         **/
        @Select("select cron from t_schedule_cron where cron_id = 1")
        String getCron();
    }

    @Autowired
    @SuppressWarnings("all")
    CronMapper cronMapper;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        // 定时任务要执行的内容
        Runnable task = ()-> System.out.println("执行动态定时任务: " + LocalDateTime.now().toLocalTime());
        // 设置执行周期
        Trigger trigger = triggerContext -> {
            String cron = cronMapper.getCron();
            // 合法性校验.
            if (StringUtils.isEmpty(cron)) {
                // Omitted Code ..
                cron = "0/5 * * * * ?";
            }
            // 返回执行周期(Date)
            return new CronTrigger(cron).nextExecutionTime(triggerContext);
        };
        // 注册一个任务
        scheduledTaskRegistrar.addTriggerTask(task, trigger);
    }
}
