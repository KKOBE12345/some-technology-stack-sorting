package com.kobe.easyexcel.dto;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: AllPrpject
 * @description
 * @author: George
 * @create: 2022-05-09 01:30
 **/
public class ExcelWriteTest {

    @Test
    public void simpleWriteTestXlsx(){
        // 写法1
        String fileName = "h:/excel200921/simpleWrite.xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, ExcelStudentDTO.class).sheet("第一次的学生模板").doWrite(data());
    }

    @Test
    public void simpleWriteTestXls(){
        // 写法1
        String fileName = "h:/excel200921/simpleWrite.xls";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, ExcelStudentDTO.class).excelType(ExcelTypeEnum.XLS).sheet("xls模板").doWrite(data());
    }

    private List<ExcelStudentDTO> data() {
        List<ExcelStudentDTO> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            ExcelStudentDTO data = new ExcelStudentDTO();
            data.setName("你的名字" + i+"科比+乔丹");
            data.setBirthday(new Date());
            data.setSalary(0.56);
            list.add(data);
        }
        return list;
    }
}
