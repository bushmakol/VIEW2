package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerCertificatesPage 
{
	
	 	WebDriver driver;

	    @FindBy(id="ErrorMsgPopupHeadingNew")
	    WebElement customerCertificatePageNoServiceFoundPopUpMessage; 
	   
	    @FindBy(id="btnCloseErrorMsgDtl")
	    WebElement customerCertificatePageNoServiceFoundPopUpCloseButton; 
	    
	    @FindBy(xpath="//div[@id='listCertificates']/div[1]/div[1]")
	    WebElement customerCertificatePageFirstDomainName;
	    
	    
	    public CustomerCertificatesPage(WebDriver driver)
	    {

	        this.driver = driver;

	        //This initElements method will create all WebElements

	        PageFactory.initElements(driver, this);
	      
	    }   
	    
	  // Verify Certificate Page Opens Properly 
	    public boolean verifyCertificatePageDisplayedProperly()
	    {
	    	if(customerCertificatePageFirstDomainName.getText() !="")
	    	{
	    		return true;
	    	}
	    	if(customerCertificatePageNoServiceFoundPopUpMessage.isDisplayed())
	    	{
	    		customerCertificatePageNoServiceFoundPopUpCloseButton.click();
	    		return true;
	    	}
	    	return false;
	    }

}
