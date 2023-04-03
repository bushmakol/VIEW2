package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AbstractComponents.CommonFunctions;

public class CustomerCloudLoginPage 
{

    WebDriver driver;
    
    
    @FindBy(xpath="//div[@class='idp']/img[@alt='Cloudservices']")
    public WebElement customerLoginPageCloudLogo;
    
    @FindBy(xpath="//span[contains(text(),'Cloudservices')]")
    public WebElement customerLoginPageCloudLabel;
    

    @FindBy(id="userNameInput")
    WebElement customerLoginPageUserName;
    
    @FindBy(id="passwordInput")
    WebElement customerLoginPagePassword;
    
    @FindBy(id="submitButton")
    WebElement customerLoginPageSignInButton;
    
    @FindBy(id="errorText")
    WebElement customerLoginPageError;
    
    @FindBy(xpath="//a[contains(text(),'Forgot your password?')]")
    WebElement customerLoginPageForgotPassword;
    
   
    
    
    public CustomerCloudLoginPage(WebDriver driver)
    {

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }   
    
    //Select CloudServices Option on CloudLogin Page
    public void navigateToCloudServicesPage()
    {
    	customerLoginPageCloudLogo.click();
    }
    
    //Set user name 
    public void setUserName(String strUserName)
    {
    	customerLoginPageUserName.sendKeys(strUserName);
    }
    
    //Set Password 
    public void setPassword(String strPassword)
    {
    	customerLoginPagePassword.clear();
    	customerLoginPagePassword.sendKeys(strPassword);
    }
    
    //Click on Login Button
    public void clickLoginButton()
    {
    	customerLoginPageSignInButton.click();
    }
    
    //Login Method to Admin Section
    public CustomerSelectCustomerPage loginToCustomerSectionCloud(String strUserName,String strPassword)
    {
    	CustomerSelectCustomerPage ObjSelectCustomer = new CustomerSelectCustomerPage(driver);
    	
    	
    	try 
    	{
			this.navigateToCloudServicesPage();
		} 
    	catch (Exception e) 
    	{
			
		}
    	
    	this.setUserName(strUserName);
    	this.setPassword(strPassword);
    	this.clickLoginButton();
    	return ObjSelectCustomer;
    }
    
    //Get Error Message
    public String getErrorMessage(String strErrorMessage)
    {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@id='errorText' and text()="+"'"+strErrorMessage+"']")));
    	return customerLoginPageError.getText().toString();
    }
   
}