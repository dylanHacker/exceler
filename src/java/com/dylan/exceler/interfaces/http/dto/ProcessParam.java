package com.dylan.exceler.interfaces.http.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @Author: chenyj
 * @Description:
 * @Date: Create in 2017-10-25 10:53
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class ProcessParam {

    /**
     * excel文件阿里云地址
     **/
    private String url;

    /**
     * 开始统计的月份
     **/
    private short startMonth;

    /**
     * 结束统计的月份
     **/
    private short endMonth;
}
