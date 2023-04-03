package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerServiceCataloguePage 
{
	
	 	WebDriver driver;

	    @FindBy(id="txtSearch")
	    WebElement customerServiceCataloguePageSearchTextBox; 
	
	    @FindBy(id="SubmitButton")
	    WebElement customerServiceCataloguePageSearchButton;
	    
	    @FindBy(xpath="//section[@id='Portfolio']")
	    WebElement customerServiceCataloguePageMainCategorySection;
	    
	    @FindBy(id="btnCloseErrorMsgDtl")
	    WebElement customerServiceCataloguePageNoRecordsFoundPopUpCloseButton;
	    
	    public CustomerServiceCataloguePage(WebDriver driver)
	    {

	        this.driver = driver;

	        //This initElements method will create all WebElements

	        PageFactory.initElements(driver, this);
	      
	    }   
	    
	    
	  //Verify ServiceCatalouge Page Opens Properly 
	    public boolean verifyServiceCataloguePageDisplayedProperly()
	    {
	    	try 
	    	{
				customerServiceCataloguePageNoRecordsFoundPopUpCloseButton.click();
				return true;
			}
	    	catch (Exception e) 
	    	{
	    		if(customerServiceCataloguePageSearchTextBox.isDisplayed()&&customerServiceCataloguePageSearchButton.isDisplayed()&&customerServiceCataloguePageMainCategorySection.isDisplayed())
		    	{
		    		return true;
		    	}
		    	else
		    	{
		    		return false;
		    	}
			}	
	    }

}
