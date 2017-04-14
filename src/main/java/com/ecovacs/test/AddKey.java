package com.ecovacs.test;

import com.ecovacs.test.common.ExcelManage;
import com.ecovacs.test.common.TranslateIntl;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ecosqa on 17/3/15.
 *
 */
public class AddKey {
    private static Map<String, String> readExcel(String strFile, String strColName){
        Map<String, String> tranMap = new HashMap<String, String>();
        XSSFWorkbook workBook;
        try{
            InputStream inputstream = AddKey.class.getClassLoader().getResourceAsStream(strFile);
            workBook = new XSSFWorkbook(inputstream);
            XSSFSheet sheet = workBook.getSheetAt(0);

            int iRowSize = sheet.getLastRowNum();
            int iColNum = TranslateIntl.getInstance().getColNum(sheet, strColName);
            if(iColNum == -1){
                System.out.println("Can not get the language, Column--" + strColName);
                return tranMap;
            }

            tranMap.put("language", strColName);

            for(int i = 1; i < iRowSize; i++){//headline(i = 0)
                if(0 != TranslateIntl.getInstance().getCellValue(sheet.getRow(i).getCell(0)).length()){
                    tranMap.put(
                            TranslateIntl.getInstance().getCellValue(sheet.getRow(i).getCell(iColNum)).trim(),
                            TranslateIntl.getInstance().getCellValue(sheet.getRow(i).getCell(0)).trim());
                }
            }
            workBook.close();
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("*******resource********" + AddKey.class.getClassLoader().getResource("/").getPath());
        }
        return tranMap;
    }

    private static void addKey(Map<String, String> tranMap, String strFile, String strSheetName){
        try {
            InputStream stream = AddKey.class.getClassLoader().getResourceAsStream(strFile);
            XSSFWorkbook workbook = new XSSFWorkbook(stream);

            /*XSSFCellStyle style = workbook.createCellStyle();
            style.setFillForegroundColor(HSSFColor.RED.index);
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);*/

            Sheet sheet = workbook.getSheet(strSheetName);
            int colNum=sheet.getRow(0).getPhysicalNumberOfCells();
            sheet.getRow(0).createCell(colNum).setCellValue("Key");
            int iNum = sheet.getLastRowNum() + 1;
            int iNumCN = TranslateIntl.getInstance().getColNum(sheet, "Chinese");
            for(int i = 1; i < iNum; i++){
                Row row = sheet.getRow(i);
                String strValue = tranMap.get(TranslateIntl.getInstance().getCellValue(row.getCell(iNumCN)).trim());
                if (strValue == null || strValue.length() <= 0){
                    continue;
                }
                if (strValue.length() != 0){
                    row.createCell(colNum).setCellValue(strValue);
                }
                System.out.println("i = " + i);
            }
            //row.getCell(4).setCellStyle(style);
            ExcelManage.getInstance().saveExcel(workbook, strFile);
            workbook.close();
            stream.close();

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void main(String args[]) {
        Map<String, String> tranMap = readExcel("Random_translate.xlsx", "Chinese");
        addKey(tranMap, "DM80i.xlsx", "version2.0");
    }
}
