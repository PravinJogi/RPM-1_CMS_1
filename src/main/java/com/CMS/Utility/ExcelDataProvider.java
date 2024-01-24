package com.CMS.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

     
public class ExcelDataProvider {
	     XSSFWorkbook wb;
	String Excelpath=System.getProperty("user.dir")+"\\TestData\\LoginTestData.xlsx";
	
	public ExcelDataProvider() throws IOException {
		File src=new File(Excelpath);
		FileInputStream file=new FileInputStream(src);
		wb=new XSSFWorkbook(file);
	}
	
	public String getStringData(String Sheetname,int row,int col) {
		return wb.getSheet(Sheetname).getRow(row).getCell(col).getStringCellValue();
	}
	public double getNumericData(String Sheetname,int row,int col) {
		return wb.getSheet(Sheetname).getRow(row).getCell(col).getNumericCellValue();
	}
	
}
