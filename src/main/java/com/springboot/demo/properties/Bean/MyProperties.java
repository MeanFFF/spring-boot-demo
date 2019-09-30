package com.springboot.demo.properties.Bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-09-30 17:15:25
 * @since 1.0
 */
@ConfigurationProperties(prefix="my.lgp")
@Data
public class MyProperties {
    private String username;
    private Long id;
    private String detail;
}
