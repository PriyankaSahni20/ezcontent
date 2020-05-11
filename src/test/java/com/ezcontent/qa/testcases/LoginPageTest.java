package com.ezcontent.qa.testcases;



import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;


import com.ezcontent.qa.pages.LoginPage;







public class LoginPageTest extends LoginPage {

	//LoginPage loginPage;
	
	//String logintitle;
	// Wait waitobj;
	// HomePage homePage; // define the Homepage variable and create as refernece
//	
// public LoginPageTest() throws IOException {
//	 // call super class keyword
//	super(); // super class constructor called using super keyword
//	 // to call TestBase constructor/method where pur property in Testbase class are defined constructor we are using the super 
//	// to call objects of immediate parent class
//	
//	// In TestBase class we have TestBase constructor  , to call that we are using super keyword
// }
 
	
	
	
	

	@Test(priority=1)
	public void loginPageTitle()
	{
	logger = extent.createTest("loginPageTitle");
	String title =loginPage.validateLoginPageTitle(); // from loginpage we will call the validateLoginPageTitle
	Assert.assertEquals(title, "Log in" , "Log in Title not matched");
	// Log in Title not matched will display if the assertion gets failed
//	Assert.assertEquals(title, "logintitle");
	}
	
	@Test(priority=2)
	public void drupalLogoImage()
	{
	 logger = extent.createTest("drupalLogoImage");	
	 boolean flag = loginPage.validateDrupalLogo();
	 Assert.assertTrue(flag);
	}
	
	

	@Test(priority=3)
	public void emailHelpText()
	{
		logger = extent.createTest("emailHelpText");
		String text = loginPage.validateEmailHelptText();
		Assert.assertEquals(text , "Enter your email address1.");
	}
	
	
	@Test(priority=4)
	public void passwordHelpText()
	{
		logger = extent.createTest("passwordHelpText");
		String text =loginPage.validatePasswordHelpText();
		Assert.assertEquals(text, "Enter the password that accompanies your email address.");
	}
	
	
	
	@Test(priority=5)
	public void login()
	{
	//loginPage.login(us, pwd);
		// loginPage is returing the homepage so we define the login in this homepage
		// so store the homepage class object i.e refrnce of Homepage
		logger = extent.createTest("login");
	loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=6 , dependsOnMethods = {"emailHelpText"})
	public void navigatetoDashboard()
	{
		logger = extent.createTest("navigatetoDashboard");
	  String text = loginPage.getDashboardUserName();
	  Assert.assertEquals(text, "admin");
	  // throw new SkipException("Skipping this test with exception");
	}
	
	
	
	
	
	// testcases should be seperated ,  independent with each other
	// before each test case launch and close the browser and login
	// after each test case close the browser
	// we should recmmnd to use AfterMethod and BeforeMethod for the every tescases , as while running 100 of tc on single browser run , may  chrome get exhausted and return invalid result and page gets blank out
	
	
	
	
	
}
