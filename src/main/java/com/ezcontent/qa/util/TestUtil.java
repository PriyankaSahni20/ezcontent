package com.ezcontent.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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
  public static String TESTDATA_SHEET_PATH = "/Users/priyanka.sahni/eclipse-workspace/com.ezcontent/src/main/java/com/ezcontent/qa/testdata/ezcontent_login_cred_dev.xlsx";
  static Workbook book;
  static Sheet sheet;


	// Method for Action class for mouse hover 
	public static void mousehover(WebDriver driver , WebElement value) {
	    new Actions(driver).moveToElement(value).build().perform(); 
	}
	
	// Method for Action class for mouse hover and click o particular element
	public static void mouseHoverandClick(WebDriver driver , WebElement value) {
		 new Actions(driver).moveToElement(value).click().build().perform(); 
		}	
	
	// Method for Select class for drop down selection by index
	public static void dropdownValueSelectionByIndex(WebDriver driver ,WebElement value , int indexvalue) {
		new Select(value).selectByIndex(indexvalue);
	}
	
	// Method for Select class for drop down selection by visible text
	public static void dropdownValueSelectionByVisibleText(WebDriver driver ,WebElement value , String visibleValue) {
	   Select selectDropdownValue = new Select(value);
		selectDropdownValue.selectByVisibleText(visibleValue);
	}
	
	// Method for Select class for drop down selection by visible value
	public static void dropdownValueSelectionByValue(WebDriver driver , WebElement value , String selectvalue) {
		Select selectDropdownValue = new Select(value);
		selectDropdownValue.selectByValue(selectvalue);
	}
	
	// Method for Select class for drop down de select
	public static void deselectValue(WebDriver driver ,WebElement value) {
		Select selectDropdownValue = new Select(value);
		selectDropdownValue.deselectAll();
	}
	
	// Method for Select class for drop down to select all values
     public static void multipleValue(WebDriver driver ,WebElement value) {
	 Select selectDropdownvalue = new Select(value);
	 selectDropdownvalue.isMultiple();
     }
 
    // Method to Switch by frame WebElement
    public static void switchFrameByWebElement(WebDriver driver ,WebElement frameElement) {
   	driver.switchTo().frame(frameElement);
    }

    // Method to Switch by frame index value
    public static void switchFramebyIndex(WebDriver driver ,int indexvalue) {
    driver.switchTo().frame(indexvalue);
     }
   
    //Method to Switch by frame
    public static void switchFrameById(WebDriver driver ,int id) {
	 driver.switchTo().frame(id);
	 }
 
    //Method to Switch by frame name
    public static void switchFrameByString(WebDriver driver ,String name) {
	driver.switchTo().frame(name);
    }
	
    // Method to click selected value
    public static void onClick(WebDriver driver ,WebElement value) {
    value.click();	
    }

    //Method to see displayed value
    public static void displayedValue(WebDriver driver ,WebElement value) {	
    value.isDisplayed();
    }

    //Method to scroll down
    public static void scroll(WebDriver driver ,int startdimension, int enddimension) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(" + String.valueOf(startdimension) + "," + String.valueOf(enddimension) + ")");
	}
	
	//Method to Switch back to the main window from iframe
	public static void switchBackToWindow(WebDriver driver) {
	driver.switchTo().defaultContent();
	}
		
	//Method to capture the screenshot 
	public static String screenshot(WebDriver driver , String testMethodName ) {
			String filePath = System.getProperty("user.dir")+File.separator+"Screenshots"+File.separator+testMethodName+timestamp()+ ".jpg";
			try
			{
			// Create reference of TakesScreenshot
			// ts is the object and we have typecasted this takescreenshot
			TakesScreenshot ts = ((TakesScreenshot)driver);  
			// Call method to capture screenshot
			File source = ts.getScreenshotAs(OutputType.FILE);
	        File target = new File(filePath);
			// Copy files to specific location here it will save all screenshot in our project home directory
		    FileUtils.copyFile(source, target);
			}
			catch (Exception e)
			{
			System.out.println("Exception while taking screenshot "+e.getMessage());
			}
		    return filePath;
		}
		
	//Method to Navigate to any URL
	public static void navigateToURL(WebDriver driver ,String url) {
	   driver.navigate().to(url);
		}	
		
	//Method to capture the timestamp
	public static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
		    }
		
    //Method to read the excel data
	public static Object[][] getTestData(String sheetName) throws org.apache.poi.openxml4j.exceptions.InvalidFormatException {
			FileInputStream file = null;
			try {
				file = new FileInputStream(TESTDATA_SHEET_PATH);
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
				}
			}
			return data;
		}
	
//	Method to delete the content
//	public static void deleteContent() throws Exception {
//		driver.findElement(By.xpath("//a[@class='nav-link'][contains(text(),'Delete')]")).click();
//		Wait.Pause(driver, 5000);
//		driver.findElement(By.xpath("//input[@id='edit-submit']")).click();
//	}
//	
	
}


