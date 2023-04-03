package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.CommonFunctions;

public class CustomerMonitoringPage 
{

	WebDriver driver;

	@FindBy(id="btnLineView")
	WebElement customerMonitoringPageLineViewButton; 

	@FindBy(id="screenFullExit")
	WebElement customerMonitoringPageFullViewButton; 

	@FindBy(xpath="//div[@id='page-content']//li[1]")
	WebElement customerMonitoringPageFirstService;

	@FindBy(id="btnCloseErrorMsgDtl")
	WebElement customerMonitoringPopUpCloseButton;


	public CustomerMonitoringPage(WebDriver driver)
	{

		this.driver = driver;

		//This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}   


	//Verify Monitoring Page elements are displayed 
	public boolean verifyMonitoringPageOpensProperly()
	{
		
		try 
		{
			CommonFunctions.waitExplicitlyForElemetToBeClickable(driver, customerMonitoringPageLineViewButton);
			if(customerMonitoringPageLineViewButton.isDisplayed()&&customerMonitoringPageFullViewButton.isDisplayed()&&customerMonitoringPageFirstService.isDisplayed())
			{
				customerMonitoringPageLineViewButton.click();
				return true;
			}
//			else if(driver.findElements(By.id("ErrorMsgPopupHeadingNew")).size()>0)
//			{
//				customerMonitoringPopUpCloseButton.click();
//				return true;
//			}
		} 
		catch (Exception e) 
		{
			if(driver.findElements(By.id("ErrorMsgPopupHeadingNew")).size()>0)
			{
				customerMonitoringPopUpCloseButton.click();
				return true;
			}
		}
		return false;
	}
}
