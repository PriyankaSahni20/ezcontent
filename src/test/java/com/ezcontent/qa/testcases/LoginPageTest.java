package com.ezcontent.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.ezcontent.qa.pages.LoginPage;
import com.ezcontent.qa.util.TestUtil;
import com.ezcontent.qa.util.Wait;


public class LoginPageTest extends LoginPage {

	String sheetName = "loginCred";
	
	@Test(priority=1)
	public void loginPageTitle() {
	logger = extent.createTest("loginPageTitle");
	String title =loginPage.validateLoginPageTitle(); 
	Assert.assertEquals(title, prop.getProperty("logintitle"), "Log in Title not matched");
	}
	
//	@Test(priority=2)
//	public void drupalLogoImage()
//	{
//	 logger = extent.createTest("drupalLogoImage");	
//	 boolean flag = loginPage.validateDrupalLogo();
//	 Assert.assertTrue(flag);
//	}
	
	@Test(priority=2)
	public void srijanLogoImage() {
	 logger = extent.createTest("srijanLogoImage");	
	 boolean flag = loginPage.validateSrijanLogo();
	 Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void emailHelpText() {
		logger = extent.createTest("emailHelpText");
		String text = loginPage.validateEmailHelptText();
		Assert.assertEquals(text , "Enter your email address.");
	}
	
	@Test(priority=4)
	public void passwordHelpText() {
		logger = extent.createTest("passwordHelpText");
		String text =loginPage.validatePasswordHelpText();
		Assert.assertEquals(text, "Enter the password that accompanies your email address.");
	}
	
	@DataProvider
	public Object[][] getLoginTestData() throws InvalidFormatException{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
//		Object[][] data = new Object[2][2];
//		data[0][0] ="vaibhav.jain@srijan.net";
//		data[0][1] = "EZadmin@123";
//		data[1][0] ="editor@example.com";
//		data[1][1] = "editor";
//		return data;
	}
	
	@Test(priority=5 , dataProvider="getLoginTestData")
	public void login(String username, String password)
	{
		logger = extent.createTest("login");
//	loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
//	loginPage.login("vaibhav.jain@srijan.net", "EZadmin@123");
	    loginPage.login(username , password);
		System.out.println(username);
		System.out.println(password);
		logger = extent.createTest("navigatetoDashboard");
		String text = loginPage.getDashboardUserName();
		Assert.assertNotNull(text, "Username is available");
	    logger = extent.createTest("navigatetoDashboard");
			try {
				Wait.Pause(driver, 5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		loginPage.logOut();
		TestUtil.navigateToURL(driver, prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.navigate().to("http://ezcontent53esqcn36d.devcloud.acquia-sites.com/user/login");
	}	
}
