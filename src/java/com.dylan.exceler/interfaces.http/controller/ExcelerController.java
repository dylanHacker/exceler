package com.dylan.exceler.interfaces.http.controller;


import com.dylan.exceler.application.IExcelerService;
import com.dylan.exceler.interfaces.http.api.IExceler;
import com.dylan.exceler.interfaces.http.code.ResCode;
import com.dylan.exceler.interfaces.http.code.Tip;
import com.dylan.exceler.interfaces.http.dto.ProcessParam;
import com.dylan.exceler.interfaces.http.dto.ProcessRes;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: chenyj
 * @Description:
 * @Date: Create in 2017-10-25 10:48
 */
@RestController
@RequestMapping
public class ExcelerController {

    @Autowired
    private IExcelerService excelerService;

    @PostMapping(IExceler.API_MONTHLY_REPORT)
    public ResponseEntity<ProcessRes> monthlyReport(@RequestBody ProcessParam processParam) {

        String url = excelerService.makeMonthlyReport(processParam);
        ProcessRes processRes = new ProcessRes();
        if (StringUtils.isEmpty(url)) {
            processRes
                    .setUrl(Tip.FAILED)
                    .setStatus(ResCode.RES_ERROR)
                    .setMsg(Tip.FAILED);
        } else {
            processRes
                    .setUrl(processParam.getUrl())
                    .setStatus(ResCode.RES_OK)
                    .setMsg(Tip.COMPLETED);
        }
        return ResponseEntity.ok(processRes);
    }

    @PostMapping(IExceler.API_FOUR_FEE_TABLE)
    public ResponseEntity<ProcessRes> fourFeeTable(@RequestBody ProcessParam processParam) {

        String url = excelerService.makeFourFeesTable(processParam.getUrl());
        ProcessRes processRes = new ProcessRes();
        if(StringUtils.isEmpty(url)){
            processRes
                    .setUrl(Tip.FAILED)
                    .setStatus(ResCode.RES_ERROR)
                    .setMsg(Tip.FAILED);
        } else {
            processRes
                    .setUrl(url)
                    .setStatus(ResCode.RES_OK)
                    .setMsg(Tip.COMPLETED);
        }
        return ResponseEntity.ok(processRes);
    }

}
