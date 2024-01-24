package com.CMS.Utility;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetDataInExcel {
	
	public void getDataFromCMS(String data) {
	try (Workbook workbook = new XSSFWorkbook()) {
        Sheet sheet = workbook.createSheet("Sheet1");
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue(data);

        // Specify the path where you want to save the Excel file
        String filePath = "System.getProperty(\"user.dir\")\\Downloads\\CMS_Module\\CMS_Module\\GetData";

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
            System.out.println("Data has been saved to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
	}

}
