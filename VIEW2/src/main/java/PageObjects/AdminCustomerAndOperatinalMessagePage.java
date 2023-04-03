package PageObjects;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AbstractComponents.CommonFunctions;

public class AdminCustomerAndOperatinalMessagePage
{
	WebDriver driver;

	@FindBy(id="AddOperationaMessage")
	WebElement adminMessagePageAddNewMessageButton;

	@FindBy(id="OpMsg_Radio")
	WebElement adminMessagePageMessageTypeOPMessageRadioButton;

	@FindBy(id="CustMsg_Radio")
	WebElement adminMessagePageMessageTypeCustomerMessageRadioButton;

	@FindBy(id="CustDescription")
	WebElement adminMessagePageCustomerMessagePopUpTextbox;

	@FindBy(id="PublishMessage")
	WebElement adminMessagePageCustomerMessagePopUpPublisButton;




	@FindBy(id="txtMessage")
	WebElement adminMessageEnglishMessageTextBox;

	@FindBy(id="txtMessageNb")
	WebElement customerMessageNorwegianMessageTextBox;

	@FindBy(xpath="//div[@id='adminCustMsgList']/div[1]/div[1]")
	WebElement adminCustomerMessagePageFirstMessage;

	@FindBy(xpath="//span[contains(text(),'No active message exists.')]")
	WebElement customerMessageNoActiveMessageLabel;

	@FindBy(xpath="//a[contains(text(),'STOP')]")
	WebElement adminCustomerMessageActiveMessageStopButton;

	@FindBy(xpath="//div[1]/div/a[@id='DeleteMessage']")
	WebElement AdminMessagePageOperationalMessageDeleteButton;

	@FindBy(id="btnStopMessage")
	WebElement customerMessageStopActiveMessageConfirmButton;

	@FindBy(id="btnDeleteConfirm")
	WebElement OperationalMessageStopActiveMessageConfirmButton;

	@FindBy(id="AddOperationaMessage")
	WebElement operationalMessagePageAddnewMessageButton;

	@FindBy(id="Title")
	WebElement operationalMessagePopUpTitleTextBox;

	@FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr']")
	WebElement operationalMessagePopUpContentEdtiableTextBox;

	@FindBy(id="messageStatus")
	WebElement operationalMessagePopUpStatusDropDown;

	@FindBy(xpath="//label[contains(text(),'Add the message with ribbon alert')]")
	WebElement operationalMessagePopUpAlertCheckBox;

	@FindBy(id="saveMessage")
	WebElement operationalMessagePopUpSaveButton;

	@FindBy(xpath="//div[@class='divTableBody']/div[1]/div[1]")
	WebElement MessagePageLatestAddedMessageTitle;


	@FindBy (id="OpMsg_Starthour")
	WebElement operationalMessagePopUpHourDropdown;

	public AdminCustomerAndOperatinalMessagePage(WebDriver driver)
	{
		//super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}   

	//Method To PostCustomer Message
	public String postCustomerMessage() throws InterruptedException
	{
		String strRandomMessage = "Test Customer Message" + CommonFunctions.getRandomString();
		adminMessagePageAddNewMessageButton.click();
		adminMessagePageMessageTypeCustomerMessageRadioButton.click();
		adminMessagePageCustomerMessagePopUpTextbox.sendKeys(strRandomMessage);
		adminMessagePageCustomerMessagePopUpPublisButton.click();
		Thread.sleep(5000);
		
		return strRandomMessage;

	}

	//Method To First Message in Table
	public String getFirstMessageFromTable()
	{
		return adminCustomerMessagePageFirstMessage.getText();
	}



	//Method to Verify No active Customer Message Exist
	public boolean verifyNoActiveCustomerMessageExist()
	{
		if(customerMessageNoActiveMessageLabel.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	//Method to stop Active Customer Message
	public void stopActiveCustomerMessage() throws InterruptedException
	{

		try
		{
			adminCustomerMessageActiveMessageStopButton.click();
			CommonFunctions.waitExplicitlyForElemetToBeClickable(driver, customerMessageStopActiveMessageConfirmButton);
			customerMessageStopActiveMessageConfirmButton.click();
			Thread.sleep(1000);
		} 
		catch (Exception e)
		{
			
		}

	}
	public void postAdminAlertOperationalMessage(String strOpMessageTitle,String strOpMessageContent) throws InterruptedException
	{
		adminMessagePageAddNewMessageButton.click();
		adminMessagePageMessageTypeOPMessageRadioButton.click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//tr//td/a[text()="+5+"]")).click();
		//System.out.println( Integer.valueOf(new SimpleDateFormat("mm").format(Calendar.getInstance().getTime())));
		//System.out.println( Integer.valueOf(new SimpleDateFormat("hh").format(Calendar.getInstance().getTime())));
		CommonFunctions.waitExplicitlyForElemetToBeClickable(driver, operationalMessagePopUpHourDropdown);
		int hourFromDropDown= Integer.valueOf(CommonFunctions.getSelectedValueFromDropDown(driver.findElement(By.id("OpMsg_Starthour"))));
		if(hourFromDropDown!=23)
		{
			if(hourFromDropDown<=8)
			{
				CommonFunctions.selectFromDropDownByName(operationalMessagePopUpHourDropdown,"0"+(hourFromDropDown+1)+"" );

			}
			else
			{
				CommonFunctions.selectFromDropDownByName(operationalMessagePopUpHourDropdown,(hourFromDropDown+1)+"" );

			}

		}
		else
		{
			CommonFunctions.selectFromDropDownByName(driver.findElement(By.id("OpMsg_Starthour")),"00" );
		}

		operationalMessagePopUpTitleTextBox.sendKeys(strOpMessageTitle);
		CommonFunctions.scrollPageToElement(driver, operationalMessagePopUpSaveButton);
		//Wait for RichText Editor To Load
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
		driver.switchTo().frame(0);
		operationalMessagePopUpContentEdtiableTextBox.sendKeys(strOpMessageContent);
		driver.switchTo().defaultContent();
		operationalMessagePopUpAlertCheckBox.click();
		operationalMessagePopUpSaveButton.click();
		Thread.sleep(2000);
	}

	
	//Method to get latest Operational Message from Op Message Page In Admin Section 
	public String getLatestMessage()
	{
		return MessagePageLatestAddedMessageTitle.getText().trim();
	}
	
	
	//Method to get latest Operational Message from Op Message Page In Admin Section 
		public String getStoppedDateOfCustomerMessage(String customerMessage)
		{
			return driver.findElement(By.xpath("//div[text()='"+customerMessage+"']/following-sibling::div[3]")).getText().trim();
		}
	
	
	//Method to stop Latest Active OP Message
	public void stopLatestActiveOperationalMessage() throws InterruptedException
	{

		try
		{
			AdminMessagePageOperationalMessageDeleteButton.click();
			OperationalMessageStopActiveMessageConfirmButton.click();
			Thread.sleep(1000);
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
