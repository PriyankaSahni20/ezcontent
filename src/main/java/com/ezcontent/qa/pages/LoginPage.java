package com.ezcontent.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ezcontent.qa.base.TestBase;
import com.ezcontent.qa.util.Wait;

public class LoginPage extends TestBase{


	
	@FindBy(xpath="//input[@id='edit-name']")
	WebElement username;
	@FindBy(name="pass")
	WebElement password;
	@FindBy(xpath="//input[@id='edit-submit']")
	WebElement loginBtn;
	@FindBy(xpath="//img[@src='http://ezcontent53esqcn36d.devcloud.acquia-sites.com/modules/contrib/gin_login/images/drupal.svg']")
	WebElement drupallogo;
	@FindBy(xpath="//img[@src='http://ezcontent53esqcn36d.devcloud.acquia-sites.com/themes/contrib/ezcontent_theme/logo.svg']")
	WebElement srijanLogo;
	@FindBy(xpath="//h1[@class='page-title user-form-page__page-title']")
	WebElement loginLabel;
	@FindBy(xpath="//div[@id='edit-name--description']")
	WebElement emailHelpText;
	@FindBy(xpath="//div[@id='edit-pass--description']")
	WebElement passwordHelpText;
	@FindBy(xpath="//a[@id='toolbar-item-user']")
	WebElement userNameDashboard;
	@FindBy(id = "toolbar-item-user")
	WebElement toolBarIcon;
	@FindBy(xpath="//li[@class='logout']")
	WebElement logout;
	
	

	public LoginPage() {
		// how to initialize page factory 
		PageFactory.initElements(driver, this); 
	}
	
	
	 // below are the actions we need to perform on the login page
	public String validateLoginPageTitle() {
		//return driver.getTitle();
		return loginLabel.getText();
	}
	public boolean validateDrupalLogo() {
		return drupallogo.isDisplayed();
	}
	public boolean validateSrijanLogo() {
		return srijanLogo.isDisplayed();
	}
	public String validateEmailHelptText() {
		return emailHelpText.getText();
	}
	public String validatePasswordHelpText() {
		return passwordHelpText.getText();
	}
	public void login(String us, String pwd) {
		username.sendKeys(us);
		password.sendKeys(pwd);
		Wait.clickable(driver, loginBtn,5);
		loginBtn.click();
	}
	public String getDashboardUserName() {
		 return userNameDashboard.getText();
    }
    public void logOut() {
			toolBarIcon.click();
			if (logout.isDisplayed())
			{
				logout.click();
			}	
			else {
				System.out.println("Failed");
			     }
			}
}
