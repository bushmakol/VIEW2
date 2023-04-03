package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerAPIAndEventCataloguePage 
{
	
	 	WebDriver driver;

	    @FindBy(id="REST")
	    WebElement customerAPIEventEnginePageRestCategory; 
	    
	    @FindBy(id="SOAP")
	    WebElement customerAPIEventEnginePageSoapCategory; 
	    
	    @FindBy(id="EVENT")
	    WebElement customerAPIEventEnginePageEventCategory; 
	    
	    @FindBy(id="txtSearch")
	    WebElement customerAPIEventEnginePageSearchTextBox;
	    
	    @FindBy(id="SubmitButton")
	    WebElement customerAPIEventEnginePageSearchButton;
	    
	    public CustomerAPIAndEventCataloguePage(WebDriver driver)
	    {

	        this.driver = driver;

	        //This initElements method will create all WebElements

	        PageFactory.initElements(driver, this);
	      
	    }   
	    
	    
	  //Verify APIAndEventEngine Page Opens Properly 
	    public boolean verifyAPIAndEventCataloguePageOpensProperly()
	    {
	    	Boolean flag=false;
	    	if(customerAPIEventEnginePageRestCategory.isDisplayed()&&customerAPIEventEnginePageSoapCategory.isDisplayed()&&customerAPIEventEnginePageEventCategory.isDisplayed())
	    		{
	    			customerAPIEventEnginePageRestCategory.click();
	    			if(customerAPIEventEnginePageSearchButton.isEnabled())
	    			{
	    				flag =true;
	    			}
	    		}
	    	return flag;
	    }

}
