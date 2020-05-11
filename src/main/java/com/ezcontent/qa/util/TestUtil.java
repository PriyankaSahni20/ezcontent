package com.ezcontent.qa.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.jsoup.Connection.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestUtil {
	

  public static Actions action;
  public static Select select; 

// Method for Action class for mouse hover 
	
	public static void mousehover(WebDriver driver , WebElement value)
	{
	//Actions action = new Actions(driver);
	
	 new Actions(driver).moveToElement(value).build().perform(); //Build().perform() is used to compile and execute the actions class.
	}
	
	// Method for Action class for mouse hover and click o particular element
	
		public static void mouseHoverandClick(WebDriver driver , WebElement value)
		{
		
		 new Actions(driver).moveToElement(value).click().build().perform(); //Build().perform() is used to compile and execute the actions class.
		}	
	

// Method for Select class for dropdown selection
	
	
	public static void dropdownValueSelectionByIndex(WebDriver driver ,WebElement value , int indexvalue)
	
	{
//		Select selectDropdownValue = new Select(value);
//		selectDropdownValue.selectByIndex(indexvalue);	
		new Select(value).selectByIndex(indexvalue);
	}
	
	
	public static void dropdownValueSelectionByVisibleText(WebDriver driver ,WebElement value , String visibleValue)
	
	{
		
		Select selectDropdownValue = new Select(value);
		selectDropdownValue.selectByVisibleText(visibleValue);
	}
	
	
	public static void dropdownValueSelectionByValue(WebDriver driver , WebElement value , String selectvalue)
	
	{
		Select selectDropdownValue = new Select(value);
		selectDropdownValue.selectByValue(selectvalue);
	}
	
	// Method to get the first value incase of dynamic values in the dd
   public static void firstValueSelection(WebDriver driver ,WebElement value)
	
	{
		Select selectDropdownValue = new Select(value);
		selectDropdownValue.getFirstSelectedOption();
	}
	
   
   public static void deselectValue(WebDriver driver ,WebElement value)
	
	{
		Select selectDropdownValue = new Select(value);
		selectDropdownValue.deselectAll();
	}
   
   public static void multipleValue(WebDriver driver ,WebElement value)
 {
	 Select selectDropdownvalue = new Select(value);
	 selectDropdownvalue.isMultiple();
 }
 
   public static void deselectvalue(WebDriver driver ,WebElement value , int indexvalue)
   {
	   Select deselectDropdownvalue = new Select(value);
	   deselectDropdownvalue.deselectByIndex(indexvalue);
   }
   
 
   

 //Switch by frame WebElement
   public static void switchFrameByWebElement(WebDriver driver ,WebElement frameElement)
   {
   	driver.switchTo().frame(frameElement);
   }


 // Method to Switch by frame index value
 public static void switchFramebyIndex(WebDriver driver ,int indexvalue)
 {
 driver.switchTo().frame(indexvalue);
 }
   
//Method to Switch by frame
 public static void switchFrameById(WebDriver driver ,int id)
 {
	 driver.switchTo().frame(id);

 }
 
//Method to Switch by frame name
public static void switchFrameByString(WebDriver driver ,String name)
{
	
	 driver.switchTo().frame(name);
}
	

// Method to click selected value

public static void onClick(WebDriver driver ,WebElement value)
{
  value.click();	
 
}

//Method to click selected value

public static void displayedValue(WebDriver driver ,WebElement value)
{	
value.isDisplayed();
}

// Method to navigate to url

public static void navigateToUrl(WebDriver driver ,String url)
{
  driver.navigate().to(url);
}

//scroll down
	public static void scroll(WebDriver driver ,int startdimension, int enddimension) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + String.valueOf(startdimension) + "," + String.valueOf(enddimension) + ")");

	}
	
	// Switch back to the main window from iframe
		public static void switchBackToWindow(WebDriver driver) {
			driver.switchTo().defaultContent();
		}
		
		// To capture the screenshot 
		public static String screenshot(WebDriver driver , String testMethodName ) {
			//String filePath = "./Screenshots/"+timestamp()+".jpg";
			String filePath = System.getProperty("user.dir")+File.separator+"Screenshots"+File.separator+testMethodName+timestamp()+ ".jpg";
			try
			{
			// Create refernce of TakesScreenshot
			TakesScreenshot ts = ((TakesScreenshot)driver);  // ts is the object and we have typecasted this takescreenshot
			// Call method to capture screenshot
			File source = ts.getScreenshotAs(OutputType.FILE);
			//File target = new File("./Screenshots/"+screenshotName+".png");
		//	String filePath = "./Screenshots/"+testMethodName+"_"+timestamp()+".jpg";
		
			File target = new File(filePath);
			
			// Copy files to specific location here it will save all screenshot in our project home directory
		    FileUtils.copyFile(source, target);
			}
			catch (Exception e)
			{
			 
			System.out.println("Exception while taking screenshot "+e.getMessage());
			}
			
			return filePath; 
			
			//getScreenshotAs(OutputType.FILE);
			
				
		}
		
		
		
		
		public static String takeScreenshot(WebDriver driver) {
			 TakesScreenshot scrShot = ((TakesScreenshot)driver); //coverting the webdriver object into screenshot and storing the value in the TakeScreenshot interface.
			 File srcFile =scrShot.getScreenshotAs(OutputType.FILE); // call the screenshot method to create image.
			 String destinationPath = System.getProperty("user.dir")+File.separator+"Screenshots"+File.separator+timestamp()+ ".jpg";
			 File desFile = new File(destinationPath); // create a destination location where screenshot will be captured
			 try {
				FileUtils.copyFile(srcFile, desFile); // copy the screenshot taken from source to destination
			} catch (IOException e) {
				System.out.println(e.getMessage());
				 
			}
			 return destinationPath ;
			
			}
		
		public static String timestamp() {
		    return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
		    // format - used to format the date into date/time string
		    // date - Allocates a Date object and initializes it so that it represents the time at which it was allocated
		// SimpleDateFormat - Constructs a SimpleDateFormat using the given pattern and the default date forma
		}
		
		
}


