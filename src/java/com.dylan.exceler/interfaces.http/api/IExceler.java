package com.dylan.exceler.interfaces.http.api;

/**
 * @Author: chenyj
 * @Description:
 * @Date: Create in 2017-10-25 10:45
 */
public class IExceler {

    public static final String API_VERSION_V1 = "/api/v1";

    /**
     * 生成月报表
     *
     * type: POST
     **/
    public static final String API_MONTHLY_REPORT = API_VERSION_V1 + "/monthlyReport";

    public static final String API_FOUR_FEE_TABLE = API_VERSION_V1 + "/fourFeeTable";
}
