package com.ezcontent.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ezcontent.qa.pages.ContentLiveBlogPage;


public class ContentLiveBlogTest extends ContentLiveBlogPage {
	
		@Test(priority=1)
		public void loginTest() {
			logger = extent.createTest("loginTest");	
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		}
		
 	    @Test(priority=2)
 	    public void navigatetoContentLiveBlogPage() {
 	    	log.info("Navigating to Live Blog Page");
 	    	logger = extent.createTest("navigatetoContentLiveBlogPage");
 	    String content	= contentliveblogPage.contentHeading();
 	    Assert.assertEquals(content, prop.getProperty("contentHeading"));
 	    String addContent = contentliveblogPage.mousehoverOnContent();
 	    Assert.assertEquals(addContent, prop.getProperty("addContentHeading"));
 	    boolean liveBlog = contentliveblogPage.mousehoverOnAddContent();
 	    Assert.assertTrue(liveBlog);
 	    String createLiveBlog = contentliveblogPage.mousehoverOnLiveBlog();
 	    Assert.assertEquals(createLiveBlog, prop.getProperty("liveBlogHeading"));
 	    }
 	    
 	    @Test(priority=3)
 	    public void titleFieldData() {
 	    	logger = extent.createTest("titleFieldData");
 	    String title = contentliveblogPage.titleField();
 	    Assert.assertEquals(title, prop.getProperty("labelTitle"));
 	    }
 	    
 	    @Test(priority=4)
 	    public void shortTitleFieldData() {
 	    	logger = extent.createTest("shortTitleFieldData");
 	    String shortTitle = contentliveblogPage.shortTitleField();
	    Assert.assertEquals(shortTitle, prop.getProperty("labelShortTitle"));
 	    }
 	 
 	    @Test(priority=5)
 	    public void eventStatusFieldData() {
 	    	logger = extent.createTest("eventStatusFieldData");
 	    String eventStatus = contentliveblogPage.eventStatusField();
 	    Assert.assertEquals(eventStatus, prop.getProperty("eventStatus"));
 	    }
 	    
 	    @Test(priority=6)
 	    public void verifyLiveChecked() {
 	    	logger = extent.createTest("verifyLiveChecked");
 	    contentliveblogPage.liveChecked();	
 	    }
        
 	    @Test(priority=7)
	    public void verifyPublishedChecked() {
 	    	logger = extent.createTest("verifyPublishedChecked");
	    contentliveblogPage.publishedChecked();	
	    }
 	    
 	    
 	    @Test(priority=8)
	    public void verifyRightSideLabels() {
 	    	logger = extent.createTest("verifyRightSideLabels");
	    boolean simpleXMLSiteLabel = contentliveblogPage.simpleXMLSiteField();
	    Assert.assertTrue(simpleXMLSiteLabel);
	    boolean urlAliasLabel = contentliveblogPage.urlAliasField();
	    Assert.assertTrue(urlAliasLabel);
	    boolean authoringInformationLabel = contentliveblogPage.authoringInformationField();
	    Assert.assertTrue(authoringInformationLabel);
	    boolean promotionsOptionsLabel = contentliveblogPage.promotionOptionsField();
	    Assert.assertTrue(promotionsOptionsLabel);
	    boolean revisionLabel = contentliveblogPage.revisionLogMessageField();
	    Assert.assertTrue(revisionLabel);
	    boolean lastSavedLabel = contentliveblogPage.lastSavedField();
	    Assert.assertTrue(lastSavedLabel);
	    boolean authorLabel = contentliveblogPage.authorField();
	    Assert.assertTrue(authorLabel);
	    }
 	    
 	    @Test(priority=9)
	    public void liveBlogCreated() {
 	    	logger = extent.createTest("liveBlogCreated");
	    boolean liveBlogcontent = contentliveblogPage.saveContentLiveBlog();	
	    Assert.assertTrue(liveBlogcontent);
	    }
 	    
 	 

}