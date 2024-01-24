package com.CMS.Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportNG {
	
	// Extent Test ---> call 
	// ExtentReports --> Attachment
	//ExtentSparkReporter ----> title, Report,Theme
	
	public static ExtentReports extent;
	
	public static ExtentReports extentreportGenrator() {
		String reportPath=System.getProperty("user.dir")+"\\Reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(reportPath);
		reporter.config().setDocumentTitle("Automation Reports");
		reporter.config().setReportName("Login Report");
		reporter.config().setTheme(Theme.DARK);
		
	    extent=new ExtentReports();
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Project Name", "Reg_Module2_reports");
		extent.setSystemInfo("OS",System.getProperty("os.name"));
		extent.setSystemInfo("QA", "EqanimQA");
		return extent;
		
	}
}
