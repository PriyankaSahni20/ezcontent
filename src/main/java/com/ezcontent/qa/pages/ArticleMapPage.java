package com.ezcontent.qa.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ezcontent.qa.base.TestBase;
import com.ezcontent.qa.util.TestUtil;
import com.ezcontent.qa.util.Wait;

public class ArticleMapPage extends TestBase {
  @FindBy(xpath="//a[@class='toolbar-icon toolbar-icon-system-admin-content']")
  WebElement content;
  @FindBy(xpath="//a[@class='toolbar-icon toolbar-icon-admin-toolbar-tools-add-content']")
  WebElement addContent;
  @FindBy(xpath="//a[@class='toolbar-icon toolbar-icon-node-add-article']")
  WebElement article;
  @FindBy(xpath="//h1[@class='js-quickedit-page-title page-title']")
  WebElement createArticle;
  @FindBy(xpath="//fieldset[@class='required-fields field-group-fieldset fieldset js-form-item form-item js-form-wrapper form-wrapper']//span[@class='fieldset__label']")
  List <WebElement> subSections;
  @FindBy(xpath="//label[@class='form-item__label js-form-required form-required']")
  WebElement titleFieldLabel;
  @FindBy(xpath="//input[@id='edit-title-0-value']")
  WebElement titleField;
  @FindBy(xpath="//label[@for='edit-field-short-title-0-value']")
  WebElement subTitleFieldLabel;
  @FindBy(xpath="//input[@id='edit-field-short-title-0-value']")
  WebElement subTitleField;
  @FindBy(xpath="//label[@for='edit-field-subhead-0-value']")
  WebElement subheadLabel;
  @FindBy(xpath="//input[@id='edit-field-subhead-0-value']")
  WebElement subheadField;
  @FindBy(xpath="//label[@for='edit-field-author-target-id']")
  WebElement authorLabel;
  @FindBy(xpath="//input[@id='autocomplete-deluxe-input']")
  WebElement authorField;
  @FindBy(className="ui-menu-item")
  WebElement selectFemaleUser;
  @FindBy(xpath="//label[@for='edit-field-summary-0-value']")
  WebElement summaryLabel;
  @FindBy(xpath="//textarea[@id='edit-field-summary-0-value']")
  WebElement summaryField;
  @FindBy(xpath="//summary[text()='Thumbnail']")
  WebElement thumbnailLabel;
  @FindBy(xpath="//input[@class='button js-form-submit form-submit entity-browser-processed']")
  WebElement selectImagesButton;
  @FindBy(xpath="//iframe[@class='entity-browser-modal-iframe']")
  WebElement iframeImage;
  @FindBy(xpath="//img[@class='image-style-media-entity-browser-thumbnail']")
  WebElement selectImage;
  @FindBy(xpath="//input[@class='is-entity-browser-submit button button--primary js-form-submit form-submit']")
  WebElement clickOnSelectImageButton;
  @FindBy(xpath="//input[@type='submit' and @name='button_add_modal']")
   WebElement addParagraph;
  @FindBy(xpath="//div[@class='paragraphs-add-dialog js-hide ui-dialog-content ui-widget-content']/ul/li/input[@value='Map']")
  WebElement selectMap;
  @FindBy(xpath="//label[text()='Google Map']")
  WebElement googleMapLabel;
  @FindBy(xpath="//input[@name='field_content[0][subform][field_map][0][value]']")
  WebElement googleMapField;
  @FindBy(xpath="//details[@class='required-fields field-group-details js-form-wrapper form-wrapper claro-details']/summary")
   WebElement taxonomy;	
  @FindBy(xpath="//label[text() = 'Tags']")
  WebElement tagsLabel;
  @FindBy(xpath="//input[@id='autocomplete-deluxe-input--2']")
  WebElement tagsField;
  @FindBy(xpath="//span[@class='autocomplete-deluxe-highlight-char']")
  WebElement selectTrumpTag;
  @FindBy(xpath="//label[@for='edit-field-yoast-seo-0-yoast-seo-focus-keyword']")
  WebElement focusKeywordLabel ;
  @FindBy(xpath="//input[@id='edit-field-yoast-seo-0-yoast-seo-focus-keyword']")
  WebElement focusKeyword ;
  @FindBy(xpath="//select[@id='edit-moderation-state-0-state']")
  WebElement dropdown;
  @FindBy(xpath="//input[@id='edit-submit']")
  WebElement published;
  @FindBy(xpath="//span[@class='field field--name-title field--type-string field--label-hidden quickedit-field']")
  WebElement articleCreated;
  @FindBy(xpath="//summary[@class='claro-details__summary claro-details__summary--accordion-item']")
   List<WebElement> articleContentList;
  @FindBy(xpath="//label[text()='Info Title']")
  WebElement infoTitleLabel;
  @FindBy(xpath="//input[@name='field_content[0][subform][field_title][0][value]']")
  WebElement infoTitleField;
  @FindBy(xpath="//label[text()='Short title']")
  WebElement shortTitleLabel;
  @FindBy(xpath="//input[@name='field_content[0][subform][field_short_title][0][value]']")
  WebElement shortTitleField;
  @FindBy(xpath="//label[text()='Info Body']")
  WebElement infoBodyLabel;
  @FindBy(xpath="//div[@class='cke_contents cke_reset']//iframe")
  WebElement infoBodyFieldIframe;
  @FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
  WebElement infoBodyField;
  @FindBy(xpath="//label[text()='URL']")
  WebElement urlLabel;
  @FindBy(xpath="//input[@name='field_content[0][subform][field_link][0][uri]']")
  WebElement urlField;
  @FindBy(xpath="//label[text()='Link text']")
  WebElement linkTextLabel;
  @FindBy(xpath="//input[@name='field_content[0][subform][field_link][0][title]']")
  WebElement linkTextField;
  
  
  public ArticleMapPage() {
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
    return article.isDisplayed();
   }
  public String mousehoverOnArticle() {
  	TestUtil.mouseHoverandClick(driver, article);
    return createArticle.getText();
   }
  public List<String> verifySubSections() { 
  	List<String> options = new ArrayList<String>();
  	{ 
  	for (WebElement webElement : subSections) 
  		 options.add(webElement.getText());
  	  }
      return options;
      }
  public boolean enterTitleFieldData() {
		titleField.sendKeys("This is the Title field");
    return titleFieldLabel.isDisplayed();
	}
	public boolean subTitleFieldLabel() {
		subTitleField.sendKeys("This is the sub title field");
    return subTitleFieldLabel.isDisplayed();
	}
  public boolean enterSubheadFieldData() {
  	subheadField.sendKeys("This is the sub head field");
  	JavascriptExecutor js = (JavascriptExecutor) driver;  
    js.executeScript("window.scrollBy(0,200)","");
    return subheadLabel.isDisplayed();
  }
  public boolean enterAuthorFieldData()  {
    authorField.sendKeys("Femal");
    Wait.visibiltyOfElement(driver, 10, selectFemaleUser);
    TestUtil.mouseHoverandClick(driver, selectFemaleUser);
    return authorLabel.isDisplayed();
  }
  public String enterSummaryFieldData() {
  	summaryField.sendKeys("This is the Summary Field");
    return summaryLabel.getText();
  }
  public String thumbnailLabel() {
    return thumbnailLabel.getText();
  }
  public void selectImages() throws InterruptedException {
    JavascriptExecutor js = (JavascriptExecutor) driver;  
    js.executeScript("window.scrollBy(0,400)","");
    Wait.Pause(driver, 2000);
    TestUtil.mouseHoverandClick(driver, selectImagesButton);
    Wait.visibiltyOfElement(driver, 20, iframeImage);
    TestUtil.switchFrameByWebElement(driver, iframeImage);
    Wait.Pause(driver, 4000);
    TestUtil.mouseHoverandClick(driver, selectImage); 
    clickOnSelectImageButton.click(); 
    TestUtil.switchBackToWindow(driver);
  }
  public void addParagraph() throws InterruptedException {
   JavascriptExecutor js = (JavascriptExecutor) driver;  
    js.executeScript("window.scrollBy(0,300)","");
    Wait.Pause(driver, 1000);
    TestUtil.mouseHoverandClick(driver, addParagraph);
    selectMap.click();
    }
  public String enterinfoTitleFieldData() {
	  Wait.visibiltyOfElement(driver, 10, infoTitleField);
	  infoTitleField.sendKeys("This is the info title field");
	  return infoTitleLabel.getText();
  }
  public String entershortTitleFieldData() {
	  shortTitleField.sendKeys("This is the short title field");
	  return shortTitleLabel.getText();
  }
  public String enterInfoBodyFieldData() {
	  JavascriptExecutor js = (JavascriptExecutor) driver;  
	    js.executeScript("window.scrollBy(0,400)","");
	  TestUtil.switchFrameByWebElement(driver, infoBodyFieldIframe);
	  Wait.visibiltyOfElement(driver, 10, infoBodyField);
	  infoBodyField.sendKeys("This is the info body field");
	  TestUtil.switchBackToWindow(driver);
	  return infoBodyLabel.getText();	
  }
   public String entergoogleMapFieldData() {
	  Wait.visibiltyOfElement(driver, 10,googleMapField );
	  googleMapField.sendKeys("This is the google map field");
	  return googleMapLabel.getText();
  }
   public String enterUrlFieldData() {
	  urlField.sendKeys("/node");
	  return urlLabel.getText();
  }
  public String enterLinkTextFieldData() {
	  linkTextField.sendKeys("This is the link text field");
	  return linkTextLabel.getText();
  }
  public boolean enterTagsFieldData() {
	  JavascriptExecutor js = (JavascriptExecutor) driver;  
		 js.executeScript("window.scrollBy(0,200)","");
		 Wait.visibiltyOfElement(driver, 10, taxonomy);
	     TestUtil.mouseHoverandClick(driver, taxonomy);
		 tagsField.sendKeys("trump");
	     tagsField.sendKeys(Keys.RETURN);
	     return tagsLabel.isDisplayed();
    }
  public String enterFocusKeyword() {
	focusKeyword.sendKeys("This is the focus keyword");
	return focusKeywordLabel.getText();
	}
  public boolean advancedMenuItem () throws InterruptedException {
		boolean result = false;
	    List<WebElement> menus = articleContentList;
	    	for(int i =0;i< menus.size() ; i++) {
	      
	       if(menus.get(i).isDisplayed()); {
	       	 Wait.Pause(driver, 5000);
         TestUtil.mouseHoverandClick(driver, menus.get(i));
         System.out.println(menus.get(i).getText()); 
         result = true;  
	      }   	
	    }
	   if (result == false) {
	  	 System.out.println("Advanced Menu Item is not found");
	    }
	  return result;  
	  }
   public boolean saveArticleContents() {
	TestUtil.dropdownValueSelectionByValue(driver, dropdown, "published");
	TestUtil.onClick(driver, published);
	try {
		Wait.Pause(driver, 5000);
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	return articleCreated.isDisplayed();
	    }
   }
   
       

