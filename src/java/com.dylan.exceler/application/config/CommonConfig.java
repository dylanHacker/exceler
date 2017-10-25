package com.dylan.exceler.application.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: chenyj
 * @Description:
 * @Date: Create in 2017-10-25 11:09
 */
@Configuration
@Getter
public class CommonConfig {

    /**
     * 阿里云SDK配置
     **/
    @Value("{envconfig.access_key_id}")
    private String access_key_id;

    @Value("{envconfig.access_key_secret}")
    private String access_key_secret;

    @Value("{envconfig.end_point}")
    private String end_point;

    @Value("{envconfig.bucket_name}")
    private String bucket_name;

    @Value("{envconfig.pre_url}")
    private String pre_url;

    @Value("{envconfig.tmp_folder}")
    private String tmp_folder;
}
