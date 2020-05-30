package com.ezcontent.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.ezcontent.qa.ExtentReportListener.ExtentReport;
import com.ezcontent.qa.pages.ArticleMapPage;
import com.ezcontent.qa.pages.ArticleMapPage2;
import com.ezcontent.qa.pages.ContentLiveBlogPage;
import com.ezcontent.qa.pages.LoginPage;
import com.ezcontent.qa.util.TestUtil;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	

	public static WebDriver driver;
	public static Properties prop; 
	public static LoginPage loginPage;
	public static ArticleMapPage articlemapPage;
    public static ArticleMapPage2 articlemapPage2;
	public static ContentLiveBlogPage contentliveblogPage;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static ExtentHtmlReporter reporter;
	public static String filePath = System.getProperty("user.dir") + "/src/main/java/com/ezcontent/qa/config/config.properties";
	
	// to deliberately add logs
	public static Logger log = Logger.getLogger(TestBase.class);
		
    public TestBase()
	{
     try
    {
	    prop =new Properties();
		FileInputStream ip = new FileInputStream(filePath);
		prop.load(ip);
	}
	catch (FileNotFoundException e)
	{
		e.printStackTrace();
	}
	catch (IOException e)
	{
		e.printStackTrace();
	}
		
	}
	
	public static void intialization()
	{
		
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup(); 
			 driver = new ChromeDriver();
		}
		else if(browserName.equals("FF"))
		{
			WebDriverManager.firefoxdriver().setup(); 
			 driver = new FirefoxDriver(); 	
		}
		else
		{
			System.out.println("No browser value is given");
		}	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	    driver.get(prop.getProperty("url"));
	    log.info("entering application URL");
	}
	
	public void teardown()
	{
		driver.quit();
	}
	
	@BeforeClass
	public void setup() throws IOException {
		intialization();
		log.info("launching chrome broswer");
		loginPage = new LoginPage();
		articlemapPage = new ArticleMapPage();
	    articlemapPage2 = new ArticleMapPage2();
	    contentliveblogPage = new ContentLiveBlogPage();
	    ExtentReport.extentReportSetUp();
    }
	
	@AfterClass
	public void closeBrowser()
	{
		teardown();
		ExtentReport.extentReportFlush();
	}

	
	@AfterMethod
	public void extentRpt(ITestResult result) throws IOException {
		String screenShotPath = TestUtil.screenshot(driver, result.getMethod().getMethodName());
		// Here will compare if test is failing then only it will enter into if condition
		if(ITestResult.FAILURE==result.getStatus())
		{
		logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		}
		else if(ITestResult.SUCCESS==result.getStatus()) 
		{
		logger.pass(result.getName());
		}
		else if(ITestResult.SKIP==result.getStatus())
		{
		logger.skip(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());	;
		}	
	}
	
	}
	
	

