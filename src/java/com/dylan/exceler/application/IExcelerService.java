package com.dylan.exceler.application;

import com.dylan.exceler.interfaces.http.dto.ProcessParam;

/**
 * @Author: chenyj
 * @Description:
 * @Date: Create in 2017-10-25 11:07
 */
public interface IExcelerService {

    /**
     * 处理表格，生成日报表和月汇总表
     **/
    String makeMonthlyReport(ProcessParam processParam);

    /**
     * 处理表格，计算4费用表格
     **/
    String makeFourFeesTable(ProcessParam processParam);
}
