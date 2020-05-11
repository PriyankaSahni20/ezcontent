package com.ezcontent.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ezcontent.qa.base.TestBase;
import com.ezcontent.qa.util.TestUtil;


public class ContentLiveBlogPage extends TestBase{

	  @FindBy(xpath="//a[@class='toolbar-icon toolbar-icon-system-admin-content']")
	  WebElement content;
	  @FindBy(xpath="//a[@class='toolbar-icon toolbar-icon-admin-toolbar-tools-add-content']")
	  WebElement addContent;
	  @FindBy(xpath="//a[@class='toolbar-icon toolbar-icon-node-add-liveblog']")
	  WebElement liveBlog;
	  @FindBy(xpath="//h1[@class='js-quickedit-page-title page-title']")
	  WebElement createLiveBlog;
	  @FindBy(xpath="//label[@class='form-item__label js-form-required form-required']")
	  WebElement titleLabel;
	  @FindBy(xpath="//input[@id='edit-title-0-value']")
	  WebElement title;
	  @FindBy(xpath="//label[text()='Short title']")
	  WebElement shortTitleLabel;
	  @FindBy(xpath="//input[@id='edit-field-short-title-0-value']")
	  WebElement shortTitle;
	  @FindBy(xpath="//span[@class='fieldset__label']")
	  WebElement eventStatus;
	  @FindBy(xpath="//input[@id='edit-field-start-date-0-value-date']")
	  WebElement startDate;
	  @FindBy(xpath="//input[@id='edit-field-end-date-0-value-date']")
	  WebElement endDate;
	  @FindBy(xpath="//input[@id='edit-field-status-value']")
	  WebElement liveChecked;
	  @FindBy(xpath="//input[@id='edit-status-value']")
	  WebElement publishedChecked;
	  @FindBy(xpath="//input[@id='edit-submit']")
	  WebElement saveButton;
	  @FindBy(xpath="//h1[@class='js-quickedit-page-title title']")
      WebElement createdSuccessfully;	
	  @FindBy(xpath="//summary[text()='Simple XML Sitemap']")
	  WebElement simpleXMLSiteMapLabel;
	  @FindBy(xpath="//summary[text()='URL alias']")
	  WebElement urlAliasLabel;
	  @FindBy(xpath="//summary[text()='Authoring information']")
	  WebElement authoringInformationLabel;
	  @FindBy(xpath="//summary[text()='Promotion options']")
	  WebElement promotionOptionsLabel;
	  @FindBy(xpath="//label[text()='Revision log message']")
	  WebElement revisionLogMessageLabel;
	  @FindBy(xpath="//label[@for='edit-meta-changed']")
	  WebElement lastSavedLabel;
	  @FindBy(xpath="//label[@for='edit-meta-author']")
	  WebElement authorLabel;
	  public ContentLiveBlogPage() {
		  	PageFactory.initElements(driver, this); 
		  }
		  public String contentHeading() {
		    TestUtil.mousehover(driver, content);
		    return content.getText();
		  }
		  public String mousehoverOnContent() {
		  	TestUtil.mousehover(driver, content);
		    return addContent.getText();
		  }
		  public boolean mousehoverOnAddContent() {
		  	TestUtil.mousehover(driver, addContent);
		    return liveBlog.isDisplayed();
		  }
		  public String mousehoverOnLiveBlog() {
		  	TestUtil.mouseHoverandClick(driver, liveBlog);
		    return createLiveBlog.getText();
		  }
		  public String titleField() {
			title.sendKeys("This is the title field");
			return titleLabel.getText();
		  }
		  public String shortTitleField() {
			shortTitle.sendKeys("This is the short title field");
			return shortTitleLabel.getText();
		  }
	      public String eventStatusField() {
	    	TestUtil.scroll(driver, 0, 400);  
            startDate.sendKeys("28/05/2020");
	    	endDate.sendKeys("30/05/2020");
	        return eventStatus.getText();
	      }
	      public void liveChecked() {
	          liveChecked.isSelected();
	      }
	      public void publishedChecked() {
	    	  publishedChecked.isSelected();
	      }
	      public boolean saveContentLiveBlog() {
	    	  TestUtil.onClick(driver, saveButton);
	    	  return createdSuccessfully.isDisplayed();
	      }
	      public boolean simpleXMLSiteField() {
	    	  TestUtil.mouseHoverandClick(driver, simpleXMLSiteMapLabel);
	    	  return simpleXMLSiteMapLabel.isDisplayed();
	      }
	      public boolean urlAliasField() {
	    	  TestUtil.mouseHoverandClick(driver, urlAliasLabel);
	    	  return urlAliasLabel.isDisplayed();
	      }
	      public boolean authoringInformationField() {
	    	  TestUtil.mouseHoverandClick(driver, authoringInformationLabel);
	    	  return authoringInformationLabel.isDisplayed();
	      }
	      public boolean promotionOptionsField() {
	    	  TestUtil.mouseHoverandClick(driver, promotionOptionsLabel);
	    	  return promotionOptionsLabel.isDisplayed();
	      }
	      public boolean revisionLogMessageField() {
	    	  return revisionLogMessageLabel.isDisplayed();
	      }
	      public boolean lastSavedField() {
	    	  return lastSavedLabel.isDisplayed();
	      }
	      public boolean authorField() {
	    	  return authorLabel.isDisplayed();
	      }
	      
	      
}
	     
	     



