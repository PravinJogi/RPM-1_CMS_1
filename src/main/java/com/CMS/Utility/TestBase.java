package com.CMS.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.qa.testrailmanager.TestRailManager;

import io.github.bonigarcia.wdm.WebDriverManager;

//Donot Invoke Currently in dev-progress!!!
@Listeners(com.CMS.Utility.listeners.class)
public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	static String os;
	String configFilePath = System.getProperty("user.dir") + "/Config/Config.properties";
	static String url = "";
	protected static File folder;
	protected String testCaseId;

	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(configFilePath);
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public static void initialization() {
		
		url = prop.getProperty("ProjectUrl");
		String browserName = prop.getProperty("browser");
		checkUrl(url);
		if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			driver.get(url);
		} else if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
//			System.setProperty("webdriver.chrome.driver","/chromedriver_mac64/chromedriver");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			driver.get(url);
		} else if (browserName.equals("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			driver.get(prop.getProperty("ProjectUrl"));
		}
	}

	@AfterMethod
	public void addResultToTestrail(ITestResult result) {

//		if (result.getStatus() == ITestResult.SUCCESS) {
//			TestRailManager.addResultsForTestCase(testCaseId, TestRailManager.TEST_CASE_PASS_STATUS,
//					"testcase passed through script" + "  " + result.getName() + "  is passed");
//		} else if (result.getStatus() == ITestResult.FAILURE) {
//			TestRailManager.addResultsForTestCase(testCaseId, TestRailManager.TEST_CASE_FAIL_STATUS,
//					"testcase failed through script" + "  " + result.getName() + "is Failed");
//		}
//		driver.quit();
	}

	public String getScreenShotPath(String testCaseName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\Screenshots\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;

	}

	public static void checkUrl(String url) {
		if (url == null) {
			Reporter.log("Url is empty", true);
			Assert.fail("Url is empty");
		}
	}

	@AfterSuite
	public void mailReport() throws InterruptedException {
//		Mail ref = new Mail();
//		ref.mail();
	}

}
