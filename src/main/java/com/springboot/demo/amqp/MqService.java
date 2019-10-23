package com.springboot.demo.amqp;

import cn.hutool.core.lang.Snowflake;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-23 17:03:39
 * @since 1.0
 */
@Service
public class MqService {
    @Autowired
    private MqSender mqSender;

    @Autowired
    @SuppressWarnings("all")
    MqLogMapper mqLogMapper;

    public void testService() {
        System.out.println("this is a joke");

        long uniId = new Snowflake(12L, 31L).nextId();
        MqLog mqLog = insertMqLog(uniId);
        mqSender.send(mqLog);
    }

    private MqLog insertMqLog(long uniId) {
        MqLog mqLog = new MqLog();
        mqLog.setStatus(0);
        mqLog.setUniId(uniId);
        mqLog.setRetryCount(0);
        mqLogMapper.insertMqLog(mqLog);
        return mqLog;
    }
}
