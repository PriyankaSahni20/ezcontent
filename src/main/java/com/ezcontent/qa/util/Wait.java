package com.ezcontent.qa.util;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Wait {
	//default constructr cannot handle io exception thrown by impliict super  constructor  to handle this use expliict constructor
	
	// declare the variable as public static so it can be used anywhere
//			public static long PAGE_LOAD_TIMEOUT = 20;
//			public static long IMPLICIT_WAIT = 10; 
	
//	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);


//	public Wait() throws IOException {
//		super();
//		// TODO Auto-generated constructor stub
//	}

	public static void implicit(WebDriver driver , int Time) {
		driver.manage().timeouts().implicitlyWait(Time, TimeUnit.SECONDS);
	}
	
	
	public static void Pause(WebDriver driver ,long millis) throws InterruptedException
	{
		Thread.sleep(millis);
	}
	
	public static void pageLoad(WebDriver driver ,long pageLoadTime)
	{
		driver.manage().timeouts().pageLoadTimeout(pageLoadTime, TimeUnit.SECONDS);
	}
	
	public static void visible(WebDriver driver ,WebElement element, int timeout)
	{
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		}
		
	
	public static  void clickable(WebDriver driver,WebElement element, int timeout)
	{
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));		
	}
		
	public static void selected(WebDriver driver,WebElement element , int timeout)
	{
		new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeSelected(element));
			}
	
   	
	public static void texttobevisible(WebDriver driver,WebElement element , int timeout , String value)

	{
		new WebDriverWait(driver,timeout).until(ExpectedConditions.textToBePresentInElementValue(element, value));
	}
	
	public static void visibiltyOfElement(WebDriver driver,long timeout,WebElement element)
	{
		

		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
	}
	
	

}
