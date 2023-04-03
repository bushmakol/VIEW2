package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.CommonFunctions;

public class CustomerPSD2ReportPage
{
	 	WebDriver driver;
	 	
	    @FindBy(id="drpdwnMonth")
	    WebElement customerPSDReportPageMonthDropdown; 
	    
	    @FindBy(xpath="//div[@id=\"psdReportingTable\"]/div[1]/div[1]")
	    WebElement customerPSDReportPageFirstRowFirstCellText;
	    
	    @FindBy(id="downloadCsv")
	    WebElement customerPSD2ReportPageDownloadAsCSVButton;
	    
	    public CustomerPSD2ReportPage(WebDriver driver)
		{

			this.driver = driver;

			//This initElements method will create all WebElements

			PageFactory.initElements(driver, this);

		}   

	    
  
	  // Verify PSD2 Report Page Opens Properly 
	    public boolean verifyPSD2ReportPageDisplayedProperly()
	    {
	    	CommonFunctions.waitExplicitlyForElemetToBeClickable(driver, customerPSD2ReportPageDownloadAsCSVButton);
	    	if(customerPSDReportPageMonthDropdown.isDisplayed()&&customerPSDReportPageFirstRowFirstCellText.isDisplayed()&&customerPSD2ReportPageDownloadAsCSVButton.isDisplayed())
	    	{
	    		return true;
	    	}
	    	return false;
	    	
	    }
	    	

}
