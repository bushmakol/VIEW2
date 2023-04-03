package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.CommonFunctions;

public class CustomerScorecardPage 
{

	WebDriver driver;

	@FindBy(id="Question_1")
	WebElement customerScorecardPageFirstQuestion;

	@FindBy(id="SubmitFeedBack")
	WebElement customerScorecardPageSubmitButton; 


	public CustomerScorecardPage(WebDriver driver)
	{

		this.driver = driver;

		//This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}   


	//Verify Monitoring Page elements are displayed 
	public boolean verifyScorecardPageOpensProperly()
	{
		try 
		{
			if(customerScorecardPageFirstQuestion.isDisplayed())
			{
				return true;
			}

		} 
		catch (Exception e) 
		{
			return false;
		}
		return false;
	}
}
