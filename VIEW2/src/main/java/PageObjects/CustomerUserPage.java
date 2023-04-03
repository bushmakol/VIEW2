package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.CommonFunctions;

public class CustomerUserPage 
{

	WebDriver driver;

	@FindBy(id="btnAddUser")
	WebElement customerUserPageAddNewUserButton; 

	@FindBy(id="txtsearch")
	WebElement customerUserPageSearchTextBox; 

	@FindBy(id="searchbtn")
	WebElement customerUserPageSearchButton;

	@FindBy(id="chkShowAll")
	WebElement customerUserPageShowAllRadioButton;
	
	@FindBy(id="btnUpdateUser")
	WebElement customerUserPageUpdateButton;
	
	@FindBy(xpath ="//select[@id='ddlStatus']")
	WebElement customerUserPageUserStatusDropDown;

	@FindBy(xpath="//div[@id='userTable']/div[1]/div[7]")
	WebElement customerUserPageFirstRecordEditButton;

	@FindBy(id="txtemailAddress")
	WebElement customerUserPageAddNewUserPopUpEmailAddressTextBox;

	@FindBy(id="txtFirstName")
	WebElement customerUserPageAddNewUserPopUpFirstNameTextBox;

	@FindBy(id="ddlGroup")
	WebElement customerUserPageAddNewUserPopUpUserGroupDropdown;

	@FindBy(id="txtLastName")
	WebElement customerUserPageAddNewUserPopUpEmailtxtLastNameTextBox;

	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement customerUserPageAddNewUserPopUpSaveButton;

	@FindBy(id="IamSurebtn")
	WebElement customerUserPageAddNewUserPopUpConfirmAddEditnewUserYesButton;

	@FindBy(id="SuccessMsgPopupContentNew")
	WebElement customerUserPageAddEditNewUserPopUpConfirmPopUpSuccessMessageText;

	@FindBy(id="btnCloseSuccessMsg")
	WebElement customerUserPageAddNewUserPopUpConfirmPopUpCloseButton;

	@FindBy(id="btnCloseErrorMsgDtl")
	WebElement customerUserPageAddNewUserPopUpInformationMissingPopUpCloseButton;

	public CustomerUserPage(WebDriver driver)
	{

		this.driver = driver;

		//This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}   


	//VerifyIf Edit Button is Present for First user from Table
	public boolean verifyUserDisplayedInTable()
	{
		return customerUserPageFirstRecordEditButton.isDisplayed();
	}

	//Verify user page elements are displayed 
	public boolean verifyUserPageDisplayedProperly()
	{
		CommonFunctions.waitExplicitlyForElemetToBeClickableCloudUserPage(driver, customerUserPageAddNewUserButton);
		if(customerUserPageFirstRecordEditButton.isDisplayed()&&customerUserPageSearchButton.isDisplayed()&&customerUserPageSearchTextBox.isDisplayed()&&customerUserPageShowAllRadioButton.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}


	public boolean verifyCreateANewUserAndDeactivateTheUser() throws InterruptedException
	{

		customerUserPageAddNewUserButton.click();
		CommonFunctions.waitExplicitlyForElemetToBeClickable(driver, customerUserPageAddNewUserPopUpEmailAddressTextBox);
		String customerDomain = customerUserPageAddNewUserPopUpEmailAddressTextBox.getAttribute("value");
		customerUserPageAddNewUserPopUpEmailAddressTextBox.clear();
		CommonFunctions.waitExplicitlyForElemetToBeClickable(driver, customerUserPageAddNewUserPopUpInformationMissingPopUpCloseButton);
		customerUserPageAddNewUserPopUpInformationMissingPopUpCloseButton.click();
		String emailAddress= "testuser" + CommonFunctions.getRandomString().toLowerCase() +customerDomain;
		customerUserPageAddNewUserPopUpEmailAddressTextBox.sendKeys(emailAddress);
		CommonFunctions.waitExplicitlyForElemetToBeClickable(driver, customerUserPageAddNewUserPopUpFirstNameTextBox);
		customerUserPageAddNewUserPopUpFirstNameTextBox.sendKeys("Test");
		customerUserPageAddNewUserPopUpEmailtxtLastNameTextBox.sendKeys("User");
		CommonFunctions.selectFromDropDownByName(customerUserPageAddNewUserPopUpUserGroupDropdown,"CustomerAdmin" );
		customerUserPageAddNewUserPopUpSaveButton.click();
		customerUserPageAddNewUserPopUpConfirmAddEditnewUserYesButton.click();
		CommonFunctions.waitExplicitlyForElemetToBeClickableCloudUserPage(driver, customerUserPageAddNewUserPopUpConfirmPopUpCloseButton);
		customerUserPageAddNewUserPopUpConfirmPopUpCloseButton.click();
		customerUserPageSearchTextBox.sendKeys(emailAddress);
		customerUserPageSearchButton.click();
		driver.findElement(By.xpath("//div[@id='"+emailAddress+"']/following-sibling::div[6]/span")).click();
		CommonFunctions.selectFromDropDownByIndex(customerUserPageUserStatusDropDown, 1);
		customerUserPageUpdateButton.click();
		customerUserPageAddNewUserPopUpConfirmAddEditnewUserYesButton.click();
		CommonFunctions.waitExplicitlyForElemetToBeClickableCloudUserPage(driver, customerUserPageAddNewUserPopUpConfirmPopUpCloseButton);
		String successMessage=customerUserPageAddEditNewUserPopUpConfirmPopUpSuccessMessageText.getText();
		if(successMessage.equalsIgnoreCase("Updated successfully"))
		{
			customerUserPageAddNewUserPopUpConfirmPopUpCloseButton.click();
			return true;
		}
		return false;		
	}

}
