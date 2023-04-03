package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerSlaReportPage 
{
	
	 	WebDriver driver;

	    @FindBy(id="drpdwnService")
	    WebElement customerSlaReportPageReportDropdown; 
	   
	    @FindBy(id="selectPageSize")
	    WebElement customerSlaReportPageShowMoreDropdown; 
	    
	    @FindBy(xpath="//div[@id='slaReportingTable']//div[1]//div[7]")
	    WebElement customerSlaReportPageFirstRowDownloadCSVFileLink;
	    
	    @FindBy(id="btnCloseErrorMsgDtl")
	    WebElement customerSlaReportPageNoServicesFoundCloseButton;
	    
	    
	    public CustomerSlaReportPage(WebDriver driver)
	    {

	        this.driver = driver;

	        //This initElements method will create all WebElements

	        PageFactory.initElements(driver, this);
	      
	    }   
	    
	  // Verify SLA Report Page Opens Properly 
	    public boolean verifySlaReportPageDisplayedProperly()
	    {
	    	try 
	    	{
				customerSlaReportPageNoServicesFoundCloseButton.click();
				return true;
			} 
	    	catch (Exception e) 
	    	{
				if(customerSlaReportPageReportDropdown.isDisplayed()&&customerSlaReportPageFirstRowDownloadCSVFileLink.isDisplayed())
		    	{
		    		return true;
		    	}

		    		return false;
			}
	    		
	    }

}
