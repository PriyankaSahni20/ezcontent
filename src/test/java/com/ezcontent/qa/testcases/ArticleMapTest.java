package com.ezcontent.qa.testcases;

import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.ezcontent.qa.pages.ArticleMapPage;


public class ArticleMapTest extends ArticleMapPage {

	
	@Test(priority=1)
	public void loginTest() {	
	logger = extent.createTest("loginTest");
	loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=2)
	public void verifyContent() {
	logger = extent.createTest("verifyContent");		
	String contentTitle= articlemapPage.contentHeading();
	Assert.assertEquals(contentTitle,prop.getProperty("contentHeading"));
	}
	@Test(priority=3)
	public void Content(){
	logger = extent.createTest("Content");	
	String content=articlemapPage.mousehoverOnContent();
	Assert.assertEquals(content, prop.getProperty("addContentHeading"));
	}
	@Test(priority=4)
	public void addContent() {
	logger = extent.createTest("addContent");	
	boolean addContent = articlemapPage.mousehoverOnAddContent();
	Assert.assertTrue(addContent);
	}
    @Test(priority=5)
	public void article() {
    logger = extent.createTest("article");
    log.info("Navigated to Article Page");
	String article = articlemapPage.mousehoverOnArticle();
	Assert.assertEquals(article, prop.getProperty("articleHeading"));
	}
   @Test(priority = 6)
	public void verifySections() {
	logger = extent.createTest("verifySections");	
	List<String> expectedlist = articlemapPage.verifySubSections();
    System.out.println(expectedlist);	
    List<String> actualList = Arrays.asList("Basic","Teaser" ,"Content");
    Assert.assertEquals(actualList, expectedlist);
	}
	@Test(priority =7)
	public void titleField(){
	logger = extent.createTest("titleField");	
	boolean title = articlemapPage.enterTitleFieldData();
	Assert.assertTrue(title);
	}	
	@Test(priority = 8)
	public void subTitleField() {
	logger = extent.createTest("subTitleField");	
	boolean subTitle = articlemapPage.subTitleFieldLabel();
	Assert.assertTrue(subTitle);
	}
	@Test(priority = 9)
	public void subHeadField() {
	logger = extent.createTest("subHeadField");	
	boolean subhead = articlemapPage.enterSubheadFieldData();
	Assert.assertTrue(subhead);
	}
	@Test(priority = 10)
	public void authorField() throws InterruptedException{
	logger = extent.createTest("authorField");	
	boolean author = articlemapPage.enterAuthorFieldData();
	Assert.assertTrue(author);
	}
	@Test(priority=11)
	public void summaryField() {
	logger = extent.createTest("summaryField");	
	String SummaryLabel = articlemapPage.enterSummaryFieldData();
	Assert.assertEquals(SummaryLabel, prop.getProperty("labelSummary"));
	}
	@Test(priority = 12)
	public void thumbnailFieldLabel() {
	logger = extent.createTest("thumbnailFieldLabel");	
	String thumbnail = articlemapPage.thumbnailLabel();
	Assert.assertEquals(thumbnail, prop.getProperty("labelThumbnail"));
	}
	@Test(priority=13)
	public void selectImages() throws InterruptedException {
	logger = extent.createTest("selectImages");	
	articlemapPage.selectImages();
	}
    @Test(priority=14)
	public void addParagraphField() throws InterruptedException {
    logger = extent.createTest("addParagraphField");	
	articlemapPage.addParagraph();
    }	
    @Test(priority=15)
	public void infoTitleField() {
    logger = extent.createTest("infoTitleField");		
	String infoTitle = articlemapPage.enterinfoTitleFieldData();
	Assert.assertEquals(infoTitle, prop.getProperty("labelInfoTitle"));
	}
    @Test(priority=16)
	public void shortTitleField() {
    logger = extent.createTest("shortTitleField");	
	String shortTitle = articlemapPage.entershortTitleFieldData();
	Assert.assertEquals(shortTitle, prop.getProperty("labelShortTitle"));
	}
	@Test(priority=17)
	public void infoBodyField() {
	logger = extent.createTest("infoBodyField");	
	String infoBody = articlemapPage.enterInfoBodyFieldData();
	Assert.assertEquals(infoBody, prop.getProperty("labelInfoBody"));
	}
    @Test(priority=18)
	public void googleMapField() {
    logger = extent.createTest("googleMapField");	
	String googleMap = articlemapPage.entergoogleMapFieldData();
	Assert.assertEquals(googleMap, prop.getProperty("labelGoogleMap"));
	}
    @Test(priority=19)
	public void urlField() {
    logger = extent.createTest("urlField");	
	String url = articlemapPage.enterUrlFieldData();
	Assert.assertEquals(url, prop.getProperty("labelUrl"));
	}
	@Test(priority=20)
	public void linkTextField() {
	logger = extent.createTest("linkTextField");	
	String linkText = articlemapPage.enterLinkTextFieldData();
	Assert.assertEquals(linkText, prop.getProperty("labelLinkText"));
	}
	 @Test(priority=21 , dependsOnMethods = {"addParagraphField" ,"googleMapField" })
    public void tagsField() {
	logger = extent.createTest("tagsField");	
   boolean tagsLabel = articlemapPage.enterTagsFieldData();
   Assert.assertTrue(tagsLabel);
   }
   @Test(priority=22)
   public void focusKeywordField() {
	logger = extent.createTest("focusKeywordField");	
    String focusKeyword = articlemapPage.enterFocusKeyword();
	Assert.assertEquals(focusKeyword, prop.getProperty("labelFocusKeyword"));
    }   
    @Test(priority = 23)
 	public void verifyRightSideLabels() throws InterruptedException {
    logger = extent.createTest("verifyRightSideLabels");	
 	boolean fields =articlemapPage.advancedMenuItem();
 	Assert.assertTrue(fields);
	}
    @Test(priority=24)
    public void saveArticleContent() {
    logger = extent.createTest("saveArticleContent");	
    log.info("Artcile map content created");
    boolean articleCreated =articlemapPage.saveArticleContents();
	Assert.assertTrue(articleCreated);
    }
//    @Test(priority=25)
//    public void deleteArticleContent() throws Exception {
//    logger = extent.createTest("deleteArticleContent");	
//    log.info("Deleting the created content");
//    TestUtil.deleteContent();
//    }
   


}




 