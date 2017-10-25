package com.dylan.exceler.application;

import com.dylan.exceler.application.config.CommonConfig;
import com.dylan.exceler.infrastructure.persistence.FileUtil;
import com.dylan.exceler.interfaces.http.dto.ProcessParam;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: chenyj
 * @Description:
 * @Date: Create in 2017-10-25 11:07
 */
@Service
public class ExcelerServiceImpl implements IExcelerService {

    private CommonConfig commonConfig = new CommonConfig();
    private int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    @Override
    public String makeMonthlyReport(ProcessParam processParam) {

        String url = processParam.getUrl();
        short startMonth = processParam.getStartMonth();
        short endMonth = processParam.getEndMonth();
        String key = url.split("/")[url.split("/").length - 1];
        String filePath = FileUtil.DownloadFile(key, commonConfig.getTmp_folder());
        File excelFile = new File(filePath);
        String res = "";
        try {
            // 获取工作簿
            Workbook workbook = WorkbookFactory.create(excelFile);
            int sheetCount = workbook.getNumberOfSheets();
            List<Sheet> sheets = new ArrayList<>();
            for (int i = 0; i < sheetCount; i++) {
                sheets.add(workbook.getSheetAt(i));
            }
            sheets.get(0).createRow(0).createCell(1).setCellValue("月汇总报表");
            sheets.get(1).createRow(0).createCell(1).setCellValue("联营店应交款日报表");
            // 处理生成日报表
            int totalDay = getTotalDay(startMonth, endMonth);
            for (int i = 0; i < totalDay; i++) {
                sheets.get(1).createRow(1).createCell(0).setCellValue("月份：");
                sheets.get(1).getRow(1).createCell(1).setCellValue(getMonth(startMonth,totalDay) + "月");
                sheets.get(1).getRow(1).createCell(2).setCellValue("日期：");
                sheets.get(1).getRow(1).createCell(3).setCellValue(new Date(2017,getMonth(startMonth,totalDay),getDay(startMonth,totalDay)));



            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

        return res;
    }

    @Override
    public String makeFourFeesTable(ProcessParam processParam) {
        String res = "";
        return res;
    }

    private int getTotalDay(short start, short end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += monthDays[i];
        }

        return sum;
    }

    private int getMonth(int start, int day){
        for(int i = start;i<=12;i++){
            if(day <= monthDays[i]){
                return i;
            } else {
                day -= monthDays[i];
            }
        }
    }

    private int getDay(int start, int day){
        for(int i = start;i<=12;i++){
            if(day <= monthDays[i]){
                return day;
            } else {
                day -= monthDays[i];
            }
        }
    }
}
