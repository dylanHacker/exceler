package com.dylan.exceler.application;

import com.dylan.exceler.interfaces.http.config.CommonConfig;
import com.dylan.exceler.interfaces.http.config.FileUtil;
import com.dylan.exceler.interfaces.http.dto.ProcessParam;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
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
    private Logger logger = LoggerFactory.getLogger(ExcelerServiceImpl.class);
    private int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    FileUtil fileUtil = new FileUtil();

    @Override
    public String makeMonthlyReport(ProcessParam processParam) {

        String url = processParam.getUrl();
        short startMonth = processParam.getStartMonth();
        short endMonth = processParam.getEndMonth();
        String key = url.split("/")[url.split("/").length - 1];
        String filePath = fileUtil.DownloadFile(key, "resource/");
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
            workbook.getSheetAt(0).createRow(0).createCell(1).setCellValue("月汇总报表");
            workbook.getSheetAt(1).createRow(0).createCell(1).setCellValue("联营店应交款日报表");
            // 处理生成日报表
            int totalDay = getTotalDay(startMonth, endMonth);
//            for (int i = 0; i < totalDay; i++) {
            workbook.getSheetAt(1).createRow(1).createCell(0).setCellValue("月份：");
            workbook.getSheetAt(1).getRow(1).createCell(1).setCellValue(getMonth(startMonth, totalDay) + "月");
            workbook.getSheetAt(1).getRow(1).createCell(2).setCellValue("日期：");
            logger.error("getMonth(startMonth, totalDay) " + getMonth(startMonth, totalDay));
            logger.error("getDay(startMonth, totalDay) " + getDay(startMonth, totalDay));
            Date date = new Date();
            date.setYear(2017);
            date.setMonth(1);
            date.setDate(15);
            //new Date(2017, getMonth(startMonth, totalDay), getDay(startMonth, totalDay))
            workbook.getSheetAt(1).getRow(1).createCell(3).setCellValue(date);


//            }
            excelFile.delete();
            logger.error("excelFile " + excelFile.exists());
            File tmpFile = new File("resource/tmp.xlsx");
            OutputStream fileOutputStream = new FileOutputStream(tmpFile);
            workbook.write(fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            long time = System.currentTimeMillis();
            fileUtil.UploadFile("resource/tmp.xlsx", String.valueOf(time) + ".xlsx");
            return commonConfig.pre_url + time;
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
            sum += monthDays[i - 1];
        }

        return sum;
    }

    private int getMonth(int start, int day) {
        for (int i = start; i <= 12; i++) {
            if (day <= monthDays[i - 1]) {
                return i;
            } else {
                day -= monthDays[i - 1];
            }
        }
        return start;
    }

    private int getDay(int start, int day) {
        for (int i = start; i <= 12; i++) {
            if (day <= monthDays[i - 1]) {
                return day;
            } else {
                day -= monthDays[i - 1];
            }
        }
        return start;
    }
}
