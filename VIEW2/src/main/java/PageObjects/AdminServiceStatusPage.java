package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AdminServiceStatusPage
{
	 WebDriver driver;

	    @FindBy(id="lblExport")
	    WebElement adminBulletinPageNewMessageButton;
	    
	    

	    public AdminServiceStatusPage(WebDriver driver)
	    {

	        this.driver = driver;

	        //This initElements method will create all WebElements

	        PageFactory.initElements(driver, this);

	    }   
	    
	    
	  //Method To verify If any Service Is Down
	    public boolean VerfiyAllServicesUp()
	    {
	    	List<WebElement> lst = driver.findElements(By.xpath("//*[contains(@src,'ArrowDown')]"));
	    	if(lst.isEmpty())
	    	{
	    		return true;
	    	}
	    	else
	    	{
	    		return false;
	    	}
	    	
	    }
}
