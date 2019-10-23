package com.springboot.demo.amqp;

import org.apache.ibatis.annotations.*;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-23 17:29:40
 * @since 1.0
 */
@Mapper
public interface MqLogMapper {
    /**
     * description
     *
     * @param
     * @return java.lang.String
     * @author liugangping
     * @date 2019/9/30 14:42
     **/
    @Select("select id, status, retry_count retryCount, uni_id uniId from mq_log where uni_id = #{uniId}")
    MqLog getMqLog(@Param("uniId") long uniId);

    @Insert("insert into mq_log(status, retry_count, uni_id) values (#{status}, #{retryCount}, #{uniId})")
    Integer insertMqLog(MqLog mqLog);

    @Update("update mq_log set status = -1 where uni_id = #{uniId}")
    Integer updateMqLogStatus(@Param("uniId")long uniId);
}
