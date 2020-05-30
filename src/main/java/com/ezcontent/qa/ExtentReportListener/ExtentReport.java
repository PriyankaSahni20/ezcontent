package com.ezcontent.qa.ExtentReportListener;


import java.io.File;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.ezcontent.qa.base.TestBase;
import com.ezcontent.qa.util.TestUtil;

public class ExtentReport extends TestBase {

	
	
	public static void extentReportSetUp() {
	// reporter = new ExtentHtmlReporter("./Reports/ezcontent.html");
	reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+File.separator+"Reports"+File.separator+TestUtil.timestamp()+".html"); 
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	}
	
	public static void extentReportFlush() {
	extent.flush();
	}
	
}
