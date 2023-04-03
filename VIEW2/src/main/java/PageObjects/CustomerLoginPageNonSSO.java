package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerLoginPageNonSSO 
{
	WebDriver driver;

    @FindBy(id="txtUsername")
    WebElement customerNonSSOLoginPageUserNameTextbox;  
    
    @FindBy(id="txtPassword")
    WebElement customerNonSSOLoginPagePassswordTextbox;   
    
    @FindBy(id="btnSubmit")
    WebElement customerNonSSOLoginPageLogInButton;   
    
    
   

	public  CustomerLoginPageNonSSO(WebDriver driver)
    {

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }   
    
    
    
    //Set user name 
    public void setUserName(String strUserName)
    {
    	customerNonSSOLoginPageUserNameTextbox.sendKeys(strUserName);
    }
    
    //Set Password
    public void setPassword(String strPassword)
    {
    	customerNonSSOLoginPagePassswordTextbox.sendKeys(strPassword);
    }
    
    //Login to CustomerDashboard Non SSo
    public void customerLogin(String strUserName,String strPassword)
    {
    	customerNonSSOLoginPageUserNameTextbox.sendKeys(strUserName); 
    	customerNonSSOLoginPagePassswordTextbox.sendKeys(strPassword);
    	customerNonSSOLoginPageLogInButton.click();
    	
    }
}
