package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerMyProfilePage 
{
	
	 	WebDriver driver;

	    @FindBy(id="emailId")
	    WebElement customerMyProfilePageUserEmailId;
	    
	    
	    public CustomerMyProfilePage(WebDriver driver)
	    {

	        this.driver = driver;

	        //This initElements method will create all WebElements

	        PageFactory.initElements(driver, this);
	      
	    }   
	    

	    public boolean verifyMyProfilePageDisplayedProperly(String emailId)
	    {
	    	if(customerMyProfilePageUserEmailId.getText().trim().toString().equals(emailId))
	    	{
	    		return true;
	    	}
	    	return false; 
	    }

}
