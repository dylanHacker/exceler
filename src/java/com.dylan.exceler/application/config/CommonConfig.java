package com.dylan.exceler.application.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author: chenyj
 * @Description:
 * @Date: Create in 2017-10-25 11:09
 */
@ToString
@Configuration
//@ConfigurationProperties(prefix = "envconfig")
public class CommonConfig {

    /**
     * 阿里云SDK配置
     **/
    @Value("${envconfig.access_key_id}")
    public String access_key_id;

    @Value("${envconfig.access_key_secret}")
    public String access_key_secret;

    @Value("${envconfig.end_point}")
    public String end_point;

    @Value("${envconfig.bucket_name}")
    public String bucket_name;

    @Value("${envconfig.pre_url}")
    public String pre_url;

    @Value("${envconfig.tmp_folder}")
    public String tmp_folder;

    public String getAccess_key_id() {
        return access_key_id;
    }

    public String getAccess_key_secret() {
        return access_key_secret;
    }

    public String getEnd_point() {
        return end_point;
    }

    public String getBucket_name() {
        return bucket_name;
    }

    public String getPre_url() {
        return pre_url;
    }

    public String getTmp_folder() {
        return tmp_folder;
    }

    public void setAccess_key_id(String access_key_id) {
        this.access_key_id = access_key_id;
    }

    public void setAccess_key_secret(String access_key_secret) {
        this.access_key_secret = access_key_secret;
    }

    public void setEnd_point(String end_point) {
        this.end_point = end_point;
    }

    public void setBucket_name(String bucket_name) {
        this.bucket_name = bucket_name;
    }

    public void setPre_url(String pre_url) {
        this.pre_url = pre_url;
    }

    public void setTmp_folder(String tmp_folder) {
        this.tmp_folder = tmp_folder;
    }
}
