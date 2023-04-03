package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminLoginPage 
{

    WebDriver driver;

    @FindBy(id="QAAdmin_Login")
    WebElement adminQALoginPageLogo;   
    
    @FindBy(id="TestAdmin_Login")
    WebElement adminTestLoginPageLogo;
    
    @FindBy(id="txtUsername")
    WebElement adminLoginPageUserName;
    
    @FindBy(id="txtPassword")
    WebElement adminLoginPagePassword;
    
    @FindBy(id="btnSubmit")
    WebElement adminLoginPageSignInButton;
    
    @FindBy(id="linkForgotPwd")
    WebElement adminLoginPageForgotPassword;
    
    @FindBy(className="infolink")
    WebElement adminLoginPageEmailID;
    
    @FindBy(xpath = "//div[@id='lblErrorMsgUsername']")
    WebElement adminLoginPageErrorMessage;
    
    @FindBy(xpath = "//div[@id='lblErrorMsgUsername' and text()='Please enter password']")
    WebElement adminLoginPageMissingPasswordErrorMessage;
    
    @FindBy(xpath = "//div[@id='lblErrorMsgUsername' and text()='Please enter username']")
    WebElement adminLoginPageMissingUsernameErrorMessage;
    
    @FindBy(id="txtEmailId")
    WebElement adminLoginPageForgotPasswordEmail;
    
    @FindBy(id="btnSendPwd")
    WebElement adminLoginPageForgotPasswordSendBtn;
    
    
    public AdminLoginPage(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }   
    
    
    //Set user name 
    public void setUserName(String strUserName)
    {
    	adminLoginPageUserName.sendKeys(strUserName);
    }
    
    //Set Password 
    public void setPassword(String strPassword)
    {
    	adminLoginPagePassword.sendKeys(strPassword);
    }
    
    //Click on Login Button
    public void clickLoginButton()
    {
    	adminLoginPageSignInButton.click();
    }
    
    //Login Method to Admin Section
    public void loginToAdminSection(String strUserName,String strPassword)
    {
    	this.setUserName(strUserName);
    	this.setPassword(strPassword);
    	this.clickLoginButton();
    }
    
    //Get Error Message
    public String getErrorOrSucessMessages(String strErrororSucessMessage)
    {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='lblErrorMsgUsername' and text()="+"'"+strErrororSucessMessage+"']")));
    	return adminLoginPageErrorMessage.getText().toString();
    }
    
    //checking presence of AdminLogo
    public boolean checkAdminLoginPageLogoPresence()    
    {
    	boolean flag= false;
    	if(driver.getCurrentUrl().contains("test"))
    	{
    		if(adminTestLoginPageLogo.isDisplayed())
    		{
    			flag = true;
    		}
    	}
    	else if (driver.getCurrentUrl().contains("viewqa")) 
    	{
    		if(adminQALoginPageLogo.isDisplayed())
    		{
    			flag = true;
    		}
		}
    	return flag;
    }
    
  //checking presence of AdminEmail
    public boolean checkAdminEmailPresence()    
    {
    	return adminLoginPageEmailID.isDisplayed();
    }
    
    //checking presence of AdminLogo
    public void setForgotPasswordEmail(String strEmail)    
    {
    	adminLoginPageForgotPassword.click();
    	adminLoginPageForgotPasswordEmail.sendKeys(strEmail);
    	adminLoginPageForgotPasswordSendBtn.click();
    }
    
   
}