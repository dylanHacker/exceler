package com.dylan.exceler.interfaces.http.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @Author: chenyj
 * @Description:
 * @Date: Create in 2017-10-25 10:54
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class ProcessRes {
    /**
     * excel文件阿里云地址
     **/
    private String url;

    /**
     * 状态位
     **/
    private int status;
    /**
     * 消息体
     **/
    private String msg;
}
