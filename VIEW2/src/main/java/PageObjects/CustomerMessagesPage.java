package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerMessagesPage 
{
	
	 	WebDriver driver;

	    @FindBy(xpath="//div[@id='listMessages']/div[1]/div[1]")
	    WebElement customerMessagePageFirstMessageInTable; 
	    
	    @FindBy(id="txtSearch")
	    WebElement customerMessagePageSearchTextBox;
	    
	    
	    public CustomerMessagesPage(WebDriver driver)
	    {

	        this.driver = driver;

	        //This initElements method will create all WebElements

	        PageFactory.initElements(driver, this);
	      
	    }   
	    
	  // Verify Message Page Opens Properly 
	    public boolean verifyMessagePageDisplayedProperly()
	    {
	    	if(customerMessagePageFirstMessageInTable.getText().toString().equals("") && customerMessagePageSearchTextBox.isDisplayed())
	    	{
	    		return true;
	    	}
	    	if(customerMessagePageFirstMessageInTable.getText()!="" && customerMessagePageSearchTextBox.isDisplayed())
	    	{
	    		return true;
	    	}
	    	return false;
	    }

}
