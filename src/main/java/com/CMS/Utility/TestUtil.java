package com.CMS.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

public class TestUtil extends TestBase {
	public static long PAGE_LOAD_TIMEOUT = 60;
	public static long IMPLICIT_WAIT = 30;
	public static String TEST_DATA_SHEET_PATH = System.getProperty("user.dir") + TestBase.prop.getProperty("excelfile");
	static Workbook book;
	static Sheet sheet;
	public static String decodedString;
	public static String fileName;

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TEST_DATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		String exceptionScreenshotPath = TestBase.prop.getProperty("exceptionScreenshot");
		FileUtils.copyFile(scrFile,
				new File(currentDir + exceptionScreenshotPath + System.currentTimeMillis() + ".png"));
	}
//
//	public static String decoder(String encodedString) {
//		try {
//			byte[] decodedStringBytes = Base64.decodeBase64(encodedString);
//			decodedString = new String(decodedStringBytes);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//		return decodedString;
//	}
//
	public static void deleteFolder(String path) {
		try {
			File f = new File(path);
			if (f.exists() && f.isDirectory()) {
				FileUtils.deleteDirectory(new File(path));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void deleteDownloadFolder() throws FileNotFoundException {

		for (File file : folder.listFiles()) {
			file.delete();
		}
		folder.delete();
		ObjectRepo.test.log(Status.PASS, "************Folder Deleted****************");
	}

	public static boolean checkFileExist(String path) {
		try {
			File f = new File(path);
			if (!f.exists()) {
				return false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return true;
	}

	public static String getFileName(String fullPath) {
		try {
			Path path = Paths.get(fullPath);
			Path name = path.getFileName();
			fileName = name.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return fileName;
	}

	public static String getFilePath(String folderPath, String fileName) {
		String[] pathnames;
		String fullFileName = null;

		File f = new File(folderPath);
		pathnames = f.list();

		// For each pathname in the pathnames array
		for (String pathname : pathnames) {
			// Print the names of files and directories
			if (pathname.contains(fileName)) {
				pathname = fullFileName;
			}
		}
		return fullFileName;

	}
	
	public static String getRandomAlphaNumericString(int n) 
    { 
  
        // length is bounded by 256 Character 
        byte[] array = new byte[256]; 
        new Random().nextBytes(array); 
  
        String randomString 
            = new String(array, Charset.forName("UTF-8")); 
  
        // Create a StringBuffer to store the result 
        StringBuffer r = new StringBuffer(); 
  
        // remove all spacial char 
        String  AlphaNumericString 
            = randomString 
                  .replaceAll("[^A-Za-z0-9]", ""); 
  
        // Append first 20 alphanumeric characters 
        // from the generated random String into the result 
        for (int k = 0; k < AlphaNumericString.length(); k++) { 
  
            if (Character.isLetter(AlphaNumericString.charAt(k)) 
                    && (n > 0) 
                || Character.isDigit(AlphaNumericString.charAt(k)) 
                       && (n > 0)) { 
  
                r.append(AlphaNumericString.charAt(k)); 
                n--; 
            } 
        } 
  
        // return the resultant string 
        return r.toString(); 
    }
	
	public static String reportDateConvert(String reportNaming) throws ParseException
	{
		String s= reportNaming;
		String f = s.split("\\[") [1].replace("]", "");
		Date d = new SimpleDateFormat("dd MMM yyyy").parse(f);
		String ss = new SimpleDateFormat("MM-dd-yyyy").format(d);
		return ss;
	}
	
	public static String reportDateConvertFrench(String reportNaming) throws ParseException
	{
		boolean isFrenchlanguage = true;
		String s= reportNaming;
		String f = s.split("\\[") [1].replace("]", "");
		Date d = isFrenchlanguage?  new SimpleDateFormat("dd MMM yyyy", Locale.FRENCH).parse(f): new SimpleDateFormat("dd MMM yyyy").parse(f);
		String ss = new SimpleDateFormat("MM-dd-yyyy").format(d);
		return ss;
	}
}
