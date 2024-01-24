package com.CMS.Utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class listeners extends TestBase implements ITestListener{

	ExtentReports extent=ExtentReportNG.extentreportGenrator();
	ThreadLocal<ExtentTest> extenttest=new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		ObjectRepo.test=extent.createTest(result.getTestClass().getName() +"=="+result.getMethod().getMethodName());
		extenttest.set(ObjectRepo.test);
	}

	public void onTestSuccess(ITestResult result) {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extenttest.get().log(Status.PASS, "Test Case Pass");
		extenttest.get().addScreenCaptureFromBase64String(getScreen(),"ScreenShot Pass");
		System.out.println("TestCase Passed");
	}

	public void onTestFailure(ITestResult result) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extenttest.get().log(Status.FAIL, "Test Case Fail");
		extenttest.get().addScreenCaptureFromBase64String(getScreen(),"ScreenShot Fail");
		System.out.println("TestCase failed");
	}

	public void onTestSkipped(ITestResult result) {
		extenttest.get().log(Status.SKIP, "Test Case Skip");
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
	public String getScreen() {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	}
	

}
