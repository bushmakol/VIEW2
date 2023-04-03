package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.lang.*;

import AbstractComponents.CommonFunctions;

public class CustomerServiceDeskPage 
{

	WebDriver driver;

	@FindBy(id="btnTicketSearch")
	WebElement customerServiceDeskPageSearchButton; 

	@FindBy(id="btnSearch")
	WebElement customerServiceDeskPageAddNewTicketButton; 

	@FindBy(id="custSelect1")
	WebElement customerServiceDeskAddNewTicketPageCategoryDropdown;

	@FindBy(id="fetchValue")
	WebElement customerServiceDeskAddNewTicketPageServiceDropdown;

	@FindBy(xpath="//ul[@id='custSelect2']/li[1]")
	WebElement customerServiceDeskAddNewTicketPageServiceDropdownFirstElements;

	@FindBy(id="custSelect3")
	WebElement customerServiceDeskAddNewTicketPageAreaDropdown;

	@FindBy(id="getPriorityValue")
	WebElement customerServiceDeskAddNewTicketPagePriorityElement;

	@FindBy(css ="li[value='5']")
	WebElement customerServiceDeskAddNewTicketPagePriorityElementLastPriority;

	@FindBy(id="next")
	WebElement customerServiceDeskAddNewTicketPageAddNewTicketButton;

	@FindBy(id="txtAnswer")
	WebElement customerServiceDeskAddNewTicketPageAnswerQuestionsPopUpTextBox;

	@FindBy(id="btnOK")
	WebElement customerServiceDeskAddNewTicketPageAnswerQuestionsPopUpNextButton;

	@FindBy(id="title")
	WebElement customerServiceDeskAddNewTicketPageTitleTextBox;

	@FindBy(id="description")
	WebElement customerServiceDeskAddNewTicketPageDescriptionTextBox;

	@FindBy(id="submittBtn")
	WebElement customerServiceDeskAddNewTicketPageSubmitButton;

	@FindBy(id="SuccessMsgPopupContentNew")
	WebElement customerServiceDeskAddNewTicketPageSuccessPopUpSuccessMessage;

	@FindBy(id="btnCloseSuccessMsg")
	WebElement customerServiceDeskAddNewTicketPageSuccessPopUpCloseButton;

	@FindBy(xpath="//div[@id='ticketLists']//div[1]/div[2][starts-with(@id,'RequestId')]")
	WebElement customerServiceDeskPageFirstTicketInTable;

	@FindBy(xpath="//span[normalize-space()='Ticket ID']")
	WebElement customerServiceDeskPageTicketIDColumnHeader;


	public CustomerServiceDeskPage(WebDriver driver)
	{

		this.driver = driver;

		//This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}   


	//Verify ServiceDesk Page elements are displayed 
	public boolean verifyServiceDeskPageDisplayedProperly()
	{
		CommonFunctions.waitExplicitlyForElemetToBeClickable(driver,customerServiceDeskPageFirstTicketInTable);
		if(customerServiceDeskPageSearchButton.isDisplayed()&&customerServiceDeskPageAddNewTicketButton.isDisplayed()&&customerServiceDeskPageTicketIDColumnHeader.isDisplayed())
		{
			return true;
		}

		return false;

	}

	public boolean verifyCreateNewTicket() throws InterruptedException
	{
		Thread.sleep(2000);
		CommonFunctions.waitExplicitlyForElemetToBeClickable(driver, customerServiceDeskPageAddNewTicketButton);
		customerServiceDeskPageAddNewTicketButton.click();
		CommonFunctions.waitExplicitlyForElemetToBeClickable(driver, customerServiceDeskAddNewTicketPageCategoryDropdown);
		CommonFunctions.selectFromDropDownByIndex(customerServiceDeskAddNewTicketPageCategoryDropdown, 1);
		CommonFunctions.waitExplicitlyForElemetToBeClickable(driver, customerServiceDeskAddNewTicketPageServiceDropdown);
		customerServiceDeskAddNewTicketPageServiceDropdown.click();
		customerServiceDeskAddNewTicketPageServiceDropdownFirstElements.click();
		if(driver.findElements(By.id("custSelect3")).size()>0)
		{
			CommonFunctions.selectFromDropDownByIndex(customerServiceDeskAddNewTicketPageAreaDropdown, 1);
		}
		CommonFunctions.waitExplicitlyForElemetToBeClickable(driver, customerServiceDeskAddNewTicketPagePriorityElement);
		customerServiceDeskAddNewTicketPagePriorityElement.click();
		Thread.sleep(1000);
		customerServiceDeskAddNewTicketPagePriorityElementLastPriority.click();
		Thread.sleep(1000);
		if(driver.findElements(By.id("next")).size()>0)
		{
			customerServiceDeskAddNewTicketPageAddNewTicketButton.click();
		}

		try 
		{
			while(driver.findElements(By.id("txtAnswer")).size()>0)
			{
				CommonFunctions.waitExplicitlyForElemetToBeClickable(driver, customerServiceDeskAddNewTicketPageAnswerQuestionsPopUpTextBox);
				customerServiceDeskAddNewTicketPageAnswerQuestionsPopUpTextBox.sendKeys("Test");
				customerServiceDeskAddNewTicketPageAnswerQuestionsPopUpNextButton.click();
			}
		} catch (Exception e) 
		{
		}
		CommonFunctions.waitExplicitlyForElemetToBeClickable(driver, customerServiceDeskAddNewTicketPageTitleTextBox);

		customerServiceDeskAddNewTicketPageTitleTextBox.sendKeys("Test");
		CommonFunctions.scrollPageToElement(driver, customerServiceDeskAddNewTicketPageSubmitButton);
		customerServiceDeskAddNewTicketPageSubmitButton.click();
		CommonFunctions.waitExplicitlyForElemetToBeClickable(driver, customerServiceDeskAddNewTicketPageSuccessPopUpCloseButton);
		String strTicketCreatedSuccessMessage = customerServiceDeskAddNewTicketPageSuccessPopUpSuccessMessage.getText();
		customerServiceDeskAddNewTicketPageSuccessPopUpCloseButton.click();
		if(strTicketCreatedSuccessMessage.equals("Ticket submitted successfully"))
		{
			return true;
		}
		return false;
	}

}
