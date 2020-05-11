package com.ezcontent.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ezcontent.qa.base.TestBase;
import com.ezcontent.qa.util.Wait;

// import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase{

	//Page Factory - Object Repo
	// findBy is the test annotations of page factory
	// Page Factory is an inbuilt Page Object Model concept for Selenium WebDriver but it is very optimized.
	// Here as well, we follow the concept of separation of Page Object Repository and Test Methods.
	// page factory is a class
	//  @findby is used to how to find elements
	
	@FindBy(xpath="//input[@id='edit-name']")
	WebElement username;
	
	
	@FindBy(name="pass")
	WebElement password;
	
	
	@FindBy(xpath="//input[@id='edit-submit']")
	WebElement loginBtn;
	
	//@FindBy(xpath="//a[@class='user-form-page__drupal-logo']")
	//@FindBy(xpath="//img[@src='https://ezcontent.srijan.net/modules/contrib/gin_login/images/drupal.svg']")
	
	@FindBy(xpath="//img[@src='http://ezcontent53esqcn36d.devcloud.acquia-sites.com/modules/contrib/gin_login/images/drupal1.svg']")
	WebElement drupallogo;
	
	@FindBy(xpath="//h1[@class='page-title user-form-page__page-title']")
	WebElement loginLabel;
	// we use annotations @FindBy to find WebElement
	
	@FindBy(xpath="//div[@id='edit-name--description']")
	WebElement emailHelpText;
	
	@FindBy(xpath="//div[@id='edit-pass--description']")
	WebElement passwordHelpText;
	
	
	@FindBy(xpath="//a[@id='toolbar-item-user']")
	WebElement userNameDashboard;
	
	
	//Intializing page objects
	// how to intialize these login page elements using page factory
	// create a contructor of LoginPage class
	public LoginPage() 
	{
		// this is the constructor block
		//initelements is used to intialize elements created above 
		//PageFactory is a method
		// driver is used to call the defined elements
		// this is pointing to current class objects
		
		//init
		PageFactory.initElements(driver, this); // how to intialize page factory 
	}
	
	
	 // below are the actions we need to perform on the login page
	// we have written String as the written type of gettitle is string
	public String validateLoginPageTitle()
	{
		//return driver.getTitle();
		
		
		return loginLabel.getText();
	}
	
	// we have written boolean as the written type of isdisplayed is boolean
	public boolean validateDrupalLogo()
	{
		return drupallogo.isDisplayed();
	}
	
	public String validateEmailHelptText()
	{
		return emailHelpText.getText();
	}
	
	public String validatePasswordHelpText()
	{
		return passwordHelpText.getText();
	}
	
	public void login(String us, String pwd)
	
	{
		username.sendKeys(us);
		password.sendKeys(pwd);
		Wait.clickable(driver, loginBtn,5);
		loginBtn.click();
		// login should written homepage class object as it is the landing page after login
		//return new HomePage(); // return homepage class object
	}
	
	 public String getDashboardUserName(){

         return userNameDashboard.getText();

        }
	
	
	// http://ezcontent53esqcn36d.devcloud.acquia-sites.com/user/login
	 // 
}
