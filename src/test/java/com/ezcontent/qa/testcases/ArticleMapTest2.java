package com.ezcontent.qa.testcases;
import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.ezcontent.qa.pages.ArticleMapPage2;

public class ArticleMapTest2 extends ArticleMapPage2 {
	
	
  
	@Test(priority=1)
	public void loginTest() {	
		logger = extent.createTest("loginTest");
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=2)
	public void verifyContent() {
		logger = extent.createTest("verifyContent");
	String contentTitle= articlemapPage2.contentHeading();
	Assert.assertEquals(contentTitle,prop.getProperty("contentHeading"));
	}
	
	@Test(priority=3)
	public void Content(){
		logger = extent.createTest("Content");
	String content=articlemapPage2.mousehoverOnContent();
	Assert.assertEquals(content, prop.getProperty("addContentHeading"));
	}
	
	@Test(priority=4)
	public void addContent() {
		logger = extent.createTest("addContent");
    boolean addContent = articlemapPage2.mousehoverOnAddContent();
    Assert.assertTrue(addContent);
	}
	
	@Test(priority=5)
	public void article() {
		log.info("Navigating to Article Page");
		logger = extent.createTest("article");
	String article = articlemapPage2.mousehoverOnArticle();
	Assert.assertEquals(article, prop.getProperty("articleHeading"));
	}
	
	@Test(priority = 6)
	public void verifySections() {
		logger = extent.createTest("verifySections");
		List<String> expectedlist = articlemapPage2.verifySubSections();
		System.out.println(expectedlist);	
		List<String> actualList = Arrays.asList("Basic","Teaser" ,"Content");
		Assert.assertEquals(actualList, expectedlist);
	}

	@Test(priority =7)
	public void titleField(){
		logger = extent.createTest("titleField");
	boolean title = articlemapPage2.enterTitleFieldData();
	Assert.assertTrue(title);
	}	
	
	@Test(priority = 8)
	public void subTitleField() {
		logger = extent.createTest("subTitleField");
	boolean subTitle = articlemapPage2.subTitleFieldLabel();
	Assert.assertTrue(subTitle);
		}
	
	@Test(priority = 9)
	public void subHeadField() {
		logger = extent.createTest("subHeadField");
	boolean subhead = articlemapPage2.enterSubheadFieldData();
	Assert.assertTrue(subhead);
	}
	
	@Test(priority = 10)
	public void authorField() throws InterruptedException{
		logger = extent.createTest("authorField");
	boolean author = articlemapPage2.enterAuthorFieldData();
	Assert.assertTrue(author);
	}
	
	@Test(priority=11)
	public void summaryField(){
		logger = extent.createTest("summaryField");
	String SummaryLabel = articlemapPage2.enterSummaryFieldData();
	Assert.assertEquals(SummaryLabel, prop.getProperty("labelSummary"));
	}
	
	@Test(priority = 12)
	public void thumbnailFieldLabel(){
		logger = extent.createTest("thumbnailFieldLabel");
	String thumbnail = articlemapPage2.thumbnailLabel();
	Assert.assertEquals(thumbnail, prop.getProperty("labelThumbnail"));
	}
	
	@Test(priority=13)
	public void selectImages() throws InterruptedException {
		logger = extent.createTest("selectImages");
	articlemapPage2.selectImages();
	}

	@Test(priority=14)
	public void addParagraphField() throws InterruptedException {
		logger = extent.createTest("addParagraphField");
	articlemapPage2.addParagraph();
	}
	
	@Test(priority=15)
	public void infoTitleField() {
		logger = extent.createTest("infoTitleField");
	String infoTitle = articlemapPage2.enterinfoTitleFieldData();
	Assert.assertEquals(infoTitle, prop.getProperty("labelInfoTitle"));
	}
	
	@Test(priority=16)
	public void shortTitleField() {
		logger = extent.createTest("shortTitleField");
	String shortTitle = articlemapPage2.entershortTitleFieldData();
	Assert.assertEquals(shortTitle, prop.getProperty("labelShortTitle"));
	}
	
	@Test(priority=17)
	public void infoBodyField() {
		logger = extent.createTest("infoBodyField");
	String infoBody = articlemapPage2.enterInfoBodyFieldData();
	Assert.assertEquals(infoBody, prop.getProperty("labelInfoBody"));
	}
	
	@Test(priority=18)
	public void googleMapField() {
		logger = extent.createTest("googleMapField");
	String googleMap = articlemapPage2.entergoogleMapFieldData();
	Assert.assertEquals(googleMap, prop.getProperty("labelGoogleMap"));
	}
	
	@Test(priority=19)
	public void urlField() {
		logger = extent.createTest("urlField");
	String url = articlemapPage2.enterUrlFieldData();
	Assert.assertEquals(url, prop.getProperty("labelUrl"));
	}
	
	@Test(priority=20)
	public void linkTextField() {
		logger = extent.createTest("linkTextField");
	String linkText = articlemapPage2.enterLinkTextFieldData();
	Assert.assertEquals(linkText, prop.getProperty("labelLinkText"));
	}
	
 // @Test(priority=21 , dependsOnMethods = {"addParagraphField" ,"googleMapField" })
	@Test(priority=21)
    public void tagsField() {
		logger = extent.createTest("tagsField");
    boolean tagsLabel = articlemapPage2.enterTagsFieldData();
    Assert.assertTrue(tagsLabel);
    }

   @Test(priority=22)
   public void focusKeywordField() {
	   logger = extent.createTest("focusKeywordField");
    String focusKeyword = articlemapPage2.enterFocusKeyword();
	Assert.assertEquals(focusKeyword, prop.getProperty("labelFocusKeyword"));
    }
   
   @Test(priority=23)
   public void verifyRightSideLabels() {
    	logger = extent.createTest("verifyRightSideLabels");
   boolean lastSavedLabel = articlemapPage2.lastSavedField();
   Assert.assertTrue(lastSavedLabel);
   boolean authorLabel1 = articlemapPage2.authorField1();
   Assert.assertTrue(authorLabel1);
   boolean revisionLabel = articlemapPage2.revisionLogMessageField();
   Assert.assertTrue(revisionLabel);
   boolean menuSettingsLabel = articlemapPage2.menuSettingsField();
   Assert.assertTrue(menuSettingsLabel);
   boolean metaTagsLabel = articlemapPage2.metaTagsField();
   Assert.assertTrue(metaTagsLabel);
   boolean simpleXMLSiteLabel = articlemapPage2.simpleXMLSiteField();
   Assert.assertTrue(simpleXMLSiteLabel);
   boolean schedulingOptionsLabel = articlemapPage2.schedulingOptionsField();
   Assert.assertTrue(schedulingOptionsLabel);
   boolean urlAliasLabel = articlemapPage2.urlAliasField();
   Assert.assertTrue(urlAliasLabel);
   boolean authoringInformationLabel = articlemapPage2.authoringInformationField();
   Assert.assertTrue(authoringInformationLabel);
   boolean promotionsOptionsLabel = articlemapPage2.promotionOptionsField();
   Assert.assertTrue(promotionsOptionsLabel);
   }
	
   @Test(priority=24)
   public void SaveArticleContent() {
	   logger = extent.createTest("SaveArticleContent");
    boolean articleCreated =articlemapPage2.verifySaveArticleContent();
	Assert.assertTrue(articleCreated);
   }

//	@Test(priority = 4)
//	public void verifylist() throws InterruptedException {
//		boolean flagActual = articlemapPage.list();
//		Assert.assertTrue(flagActual);
//	}
	
	}




 