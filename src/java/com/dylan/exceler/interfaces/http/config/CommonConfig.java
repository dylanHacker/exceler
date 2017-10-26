package com.dylan.exceler.interfaces.http.config;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author: chenyj
 * @Description:
 * @Date: Create in 2017-10-25 11:09
 */
@Configuration
//@EnableConfigurationProperties(CommonConfig.class)
//@Component
//@ConfigurationProperties(prefix = "envconfig")
public class CommonConfig {

    /**
     * 阿里云SDK配置
     **/
//    @Value("${envconfig.access_key_id}")
    public String access_key_id = "LTAI7HeQrl4Wwe6V";

//    @Value("${envconfig.access_key_secret}")
    public String access_key_secret = "4rOC2MgcW4MbrToWkAVQem2c2sGXzg";

//    @Value("${envconfig.end_point}")
    public String end_point = "oss-cn-shanghai.aliyuncs.com";

//    @Value("${envconfig.bucket_name}")
    public String bucket_name = "dylan-c";

//    @Value("${envconfig.pre_url}")
    public String pre_url = "http://dylan-c.oss-cn-shanghai.aliyuncs.com/";

//    @Value("${envconfig.tmp_folder}")
    public String tmp_folder = "../tmp/";

}
