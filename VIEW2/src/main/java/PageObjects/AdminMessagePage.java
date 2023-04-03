package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import AbstractComponents.CommonFunctions;
import org.openqa.selenium.JavascriptExecutor;
import java.lang.*;

public class AdminMessagePage {

	WebDriver driver;



	@FindBy(id="AddMessage")
	WebElement adminMessagePageAddNewMessageButton;  


	//------Admin Message Page---------

	//Title of Latest Admin Message In Table
	@FindBy(xpath="//div[@class='divTableBody']/div[1]/div[1]")
	WebElement adminMessageLatestTitleInTable;

	//Title of Second Latest Admin Message In Table
	@FindBy(xpath="//div[@class='divTableBody']/div[2]/div[1]")
	WebElement adminMessageSecondLatestTitleInTable;




	//-------Add New Message Pop Up Fields------------------------
	@FindBy(id="InternalMessage_Div")
	WebElement adminMessagePopUpInternalAdminMessageIcon;

	@FindBy(id="ExternalMessage_Div")
	WebElement adminMessagePopUpExternalCustomerMMessageIcon;

	@FindBy(id="NewsBulletin_Div")
	WebElement adminMessagePopUpNewsBulletinIcon;

	@FindBy(id="GlobalAlert_Div")
	WebElement adminMessagePopUpGlobalAlertMessageIcon;




	//------- Internal Admin Message Pop Up Fields--------------------
	@FindBy(id="Title")
	WebElement adminMessageInternalAdminMessagePopUpTitleTextBox;

	@FindBy(id="cke_Description")
	WebElement adminMessageInternalAdminMessagePopUpContentTextBox;

	@FindBy(id="EndDate_Internal")
	WebElement adminMessageInternalAdminMessagePopUpEndDate;

	@FindBy(xpath="//section[@id='Admin_Messages']//div[contains(@class,'control__indicator')]")
	WebElement adminMessageInternalAdminMessagePopUpAlertRadioButton;

	@FindBy(className = "ui-datepicker-month")
	WebElement adminMessageInternalAdminMessagePopUpEndDateMonth;

	@FindBy(id="saveMessage")
	WebElement adminMessageInternalAdminMessagePopUpSaveButton;


	//Title of latest Admin Message In Ribbon
	@FindBy(id="adminmsgDl")
	WebElement adminMessageLatestTitleInRibbon;

	//Close Button in Admin Message In Ribbon
	@FindBy(xpath="//img[contains(@class,'ribbon_close')]")
	WebElement adminMessageCloseButtonInRibbon;

	//Admin Message Dot In Header
	@FindBy(id="adminMsglink")
	WebElement adminMessageInternalAdminMessageDotInHeader;




	//-----Global Alert Message Pop Up Fields-----------------------------


	@FindBy(id="GlobalDesc")
	WebElement adminGlobalAlertMessageTextBox;

	@FindBy(id="EndDate_Global")
	WebElement adminMessageGlobalAlertMessagePopUpEndDate;

	@FindBy(className = "ui-datepicker-month")
	WebElement adminMessageGlobalAlertMessagePopUpEndDateMonth;

	@FindBy(id="save_GlobalAlert")
	WebElement adminGlobalAlertPublishButton;

	@FindBy(xpath="//div[@class='divTableBody']/div[1]/div[1]")
	WebElement adminGlobalAlertActiveMessage;

	@FindBy(id="editNews")
	WebElement adminGlobalAlertEditButton;

	@FindBy(xpath="//div[@class='divTableCell msgType GlobalAlert']/following-sibling::div/a[@id='StopMessage']")
	WebElement adminGlobalAlertStopButton;

	//Title of First Old Global Alert
	@FindBy(xpath="//div[@id='oldNewsList']/div[1]/div[1]")
	WebElement adminLastestStoppedGlobalAlertMessage;

	//Ok Button in Stop Global Alert Pop Up
	@FindBy(id="btnDeleteConfirm")
	WebElement adminStopGlobalAlertConfirmButton;



	//-------------- New Bulletin  Pop Up Fields----------------


	@FindBy(id="lblExport")
	WebElement adminBulletinPageNewMessageButton;

	@FindBy(xpath="//div[@class='control__indicator alltitle']")
	WebElement adminBulletinAddNewMessagePopUpAllBARadioButton;

	@FindBy(id="txtNews_NewsBulletin")
	WebElement adminBulletinAddNewMessagePopUpEnglishTextBox;

	@FindBy(id="btnDeleteConfirm")
	WebElement adminBulletinStopNewsPopSubmitButton;

	@FindBy(id="txtNewsNb_NewsBulletin")
	WebElement adminBulletinAddNewMessagePopUpNorwegianTextBox;

	@FindBy(id="save_NewsBulletin")
	WebElement adminBulletinAddNewMessagePopUpSubmitButton;

	@FindBy(id="EndDate_News")
	WebElement adminMessageNewsPopUpEndDate;

	@FindBy(className = "ui-datepicker-month")
	WebElement adminMessageNewsPopUpEndDateMonth;

	@FindBy(xpath="//div[@id=\"activenewsList\"]/div/div[1]")
	public
	WebElement adminBulletinPageActiveNewsTitle;

	@FindBy(xpath="//div[contains(text(),'Bulletin')]/following-sibling::div/a[@id='StopMessage']")
	WebElement adminBulletinPageFirstActiveNewsTitleStopButton;








	public AdminMessagePage(WebDriver driver)
	{

		this.driver = driver;

		//This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}   
	//-----Internal Admin Message Methods
	//Create Admin Message With Alert 
	public void createAdminMessageWithAlert(String strAdminMessageTitle,String strAdminMessageContent,String strDate) throws InterruptedException
	{

		adminMessagePageAddNewMessageButton.click();
		adminMessagePopUpInternalAdminMessageIcon.click();
		adminMessageInternalAdminMessagePopUpTitleTextBox.sendKeys(strAdminMessageTitle);
		//Wait for RichText Editor To Load
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//html//body")).sendKeys(strAdminMessageContent);
		driver.switchTo().defaultContent();
		adminMessageInternalAdminMessagePopUpEndDate.click();
		// Selecting Next Month by Default in the Calendar
		CommonFunctions.selectFromDropDownByIndex(adminMessageInternalAdminMessagePopUpEndDateMonth, 1);
		//Selecting the required date
		driver.findElement(By.xpath("//tr//td/a[text()="+strDate+"]")).click();
		// Wait for Calendar overlay to Settle Back
		Thread.sleep(3000);
		// This  will scroll down the page
		js.executeScript("arguments[0].scrollIntoView();",adminMessageInternalAdminMessagePopUpAlertRadioButton );
		adminMessageInternalAdminMessagePopUpAlertRadioButton.click();
		adminMessageInternalAdminMessagePopUpSaveButton.click();

	}

	//Create Admin Message Without Alert 
	public void createAdminMessageWithoutAlert(String strAdminMessageTitle,String strAdminMessageContent,String strDate) throws InterruptedException
	{

		adminMessagePageAddNewMessageButton.click();
		adminMessagePopUpInternalAdminMessageIcon.click();
		adminMessageInternalAdminMessagePopUpTitleTextBox.sendKeys(strAdminMessageTitle);
		//Wait for RichText Editor To Load
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//html//body")).sendKeys("Test");
		driver.switchTo().defaultContent();
		adminMessageInternalAdminMessagePopUpEndDate.click();
		// Selecting Next Month by Default in the Calendar
		CommonFunctions.selectFromDropDownByIndex(adminMessageInternalAdminMessagePopUpEndDateMonth, 1);
		//Selecting the required date
		driver.findElement(By.xpath("//tr//td/a[text()="+strDate+"]")).click();
		Thread.sleep(3000);
		adminMessageInternalAdminMessagePopUpSaveButton.click();
	}

	//Get Latest Admin Message Title from Ribbon
	public String getLatestAdminMessageTitleFromRibbon()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			js.executeScript("arguments[0].scrollIntoView();",adminMessageLatestTitleInRibbon );
			return adminMessageLatestTitleInRibbon.getText();
		}
		catch (Exception e) 
		{
			js.executeScript("arguments[0].scrollIntoView();",adminMessageInternalAdminMessageDotInHeader );
			adminMessageInternalAdminMessageDotInHeader.click();
			return adminMessageLatestTitleInRibbon.getText();
		}

	}

	//Get Latest Admin Message Title from Ribbon
	public String getLatestAdminMessageTitleFromTable() throws InterruptedException
	{
		Thread.sleep(3000);
		return adminMessageLatestTitleInTable.getText();
	}

	//Get Second Latest Admin Message Title from Ribbon
	public String getSecondLatestAdminMessageTitleFromTable() throws InterruptedException
	{
		Thread.sleep(2000);
		return adminMessageSecondLatestTitleInTable.getText();
	}





	//------Global Alert Message Methods
	//Adding Global Alert Message
	public void addGlobalAlertMessage(String strGlobalAlertEnglisMessage, String strGlobalAlertNorwegianMessage,String strDate) throws InterruptedException
	{
		adminMessagePageAddNewMessageButton.click();
		CommonFunctions.waitExplicitlyForElemetToBeClickable(driver, adminMessagePopUpGlobalAlertMessageIcon);

		adminMessagePopUpGlobalAlertMessageIcon.click();
		CommonFunctions.waitExplicitlyForElemetToBeClickable(driver, adminGlobalAlertPublishButton);
		//Thread.sleep(1000);
		adminGlobalAlertMessageTextBox.sendKeys(strGlobalAlertEnglisMessage);
		adminMessageGlobalAlertMessagePopUpEndDate.click();
		// Selecting Next Month by Default in the Calendar
		CommonFunctions.selectFromDropDownByIndex(adminMessageGlobalAlertMessagePopUpEndDateMonth, 1);
		//Selecting the required date
		driver.findElement(By.xpath("//tr//td/a[text()="+strDate+"]")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",adminGlobalAlertPublishButton );
		Thread.sleep(1000);
		adminGlobalAlertPublishButton.click();
		Thread.sleep(4000);
	}

	//Stopping Global Alert Message If ANY
	public void stopActiveGlobalAlertMessageIfAny()
	{
		try 
		{
			CommonFunctions.waitExplicitlyForElemetToBeClickable(driver, adminGlobalAlertStopButton);
			adminGlobalAlertStopButton.click();
			adminStopGlobalAlertConfirmButton.click();
		} catch (Exception e) 
		{
			
		}
	}

	//Stopping Global Alert Message
	//    public void stopActiveGlobalAlertMessage() throws InterruptedException
	//    {
	//        	adminGlobalAlertStopButton.click();
	//        	adminStopGlobalAlertConfirmButton.click();
	//        	Thread.sleep(1000);
	//    }
	//    
	//Stopping Global Alert Message
	public String  getLatestTileInTableAfterStopingMessage() throws InterruptedException
	{
		//String strMessage="";

		if(getSecondLatestAdminMessageTitleFromTable().equals(""))
		{
			return "No message available";
		}
		else
		{
			return getSecondLatestAdminMessageTitleFromTable();
		}
	}

	//Editing Active Global Alert Message
	public void editActiveGlobalAlertMessage(String strGlobalAlertEnglisMessage, String strGlobalAlertNorwegianMessage)
	{
		adminGlobalAlertEditButton.click();
		adminGlobalAlertMessageTextBox.sendKeys(strGlobalAlertEnglisMessage);
		adminGlobalAlertPublishButton.click();
	}

	//Get Active Global Alert Message
	public String getActiveGlobalAlert()
	{
		return adminGlobalAlertActiveMessage.getText();
	}

	//Get Latest Stopped Global Alert Message
	public String getLatestMessageTitelFromTablet()
	{
		return adminMessageLatestTitleInTable.getText();
	}




	//--------News Bulletin Methods-----------

	//Method To Add New news for All business areas
	public void addNewNews(String strEnglishNews, String strNorwegianNews,String strDate) throws InterruptedException
	{
		adminMessagePageAddNewMessageButton.click();
		adminMessagePopUpNewsBulletinIcon.click();
		adminBulletinAddNewMessagePopUpAllBARadioButton.click();
		adminBulletinAddNewMessagePopUpEnglishTextBox.sendKeys(strEnglishNews);
		adminBulletinAddNewMessagePopUpNorwegianTextBox.sendKeys(strNorwegianNews);
		adminMessageNewsPopUpEndDate.click();
		// Selecting Next Month by Default in the Calendar
		CommonFunctions.selectFromDropDownByIndex(adminMessageNewsPopUpEndDateMonth, 1);
		//Selecting the required date
		driver.findElement(By.xpath("//tr//td/a[text()="+strDate+"]")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",adminGlobalAlertPublishButton );
		Thread.sleep(1000);
		adminBulletinAddNewMessagePopUpSubmitButton.click();

	}

	//Method To close all Active News If Any
	public void closeAllActiveNewsIfAny() throws InterruptedException
	{
		try 
		{
			java.util.List<WebElement> lst = driver.findElements(By.xpath("//div[contains(text(),'Bulletin')]/following-sibling::div/a[@id='StopMessage']"));
			for (int i=0; i<lst.size();i++)
			{
				adminBulletinPageFirstActiveNewsTitleStopButton.click();
				adminBulletinStopNewsPopSubmitButton.click();
				Thread.sleep(1000);
			}
		}
		catch (Exception e) 
		{
			//do nothing if no news
		}

	}  

}
