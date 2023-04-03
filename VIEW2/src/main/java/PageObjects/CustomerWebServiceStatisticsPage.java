package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.lang.*;

import AbstractComponents.CommonFunctions;

public class CustomerWebServiceStatisticsPage 
{

	WebDriver driver;

	@FindBy(id="btnExprtToCSV")
	WebElement customerWebServiceStatisticsPageDownloadAsCSVButton; 

	@FindBy(xpath="//div[@id=\"tblServices\"]/div[2]/div[1]/div[1]")
	WebElement customerWebServiceStatisticPageNoRecordFoundText;

	@FindBy(xpath="//p[text() = \"No services found\"]")
	WebElement customerServiceStatisticsPageNoServiceFoundPopUpMessage;

	@FindBy(xpath="//button[@id ='btnCloseErrorMsgDtl']")
	WebElement customerServiceStatisticsPageNoServiceFoundPopUpMessageCloseButton;



	public CustomerWebServiceStatisticsPage(WebDriver driver)
	{

		this.driver = driver;

		//This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}   


	public boolean verifyWebServiceStatisticsPageDisplayedProperly() throws InterruptedException
	{
		Thread.sleep(2000);
		try 
		{
			if(customerWebServiceStatisticsPageDownloadAsCSVButton.isDisplayed())
			{
				List<WebElement> listOfElements = driver.findElements(By.xpath("//div[@id='tblYearlyData']/div[2]/div[1]/div"));
				for(int i=1;i<listOfElements.size();i++)
				{
					listOfElements.get(i).click();
					Thread.sleep(1000);
					try 
					{
						if(customerWebServiceStatisticPageNoRecordFoundText.getText()!=null)
						{
							return true;
						}
					} 
					catch (Exception e) 
					{

					}

				}
			}
			else
			{
				if(customerServiceStatisticsPageNoServiceFoundPopUpMessage.isDisplayed())
				{
					customerServiceStatisticsPageNoServiceFoundPopUpMessageCloseButton.click();
					return true;
				}
				return false;
			}
		} 
		catch (Exception e) 
		{
			if(customerServiceStatisticsPageNoServiceFoundPopUpMessage.isDisplayed())
			{
				customerServiceStatisticsPageNoServiceFoundPopUpMessageCloseButton.click();
				return true;
			}
			return false;
		}
		
		return false;
	}

}
