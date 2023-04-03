package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminCloudLoginPage 
{

	WebDriver driver;


	@FindBy(xpath="//div[@class='idp']/img[@alt='Cloudservices']")
	WebElement adminLoginPageCloudLogo;

	@FindBy(id="userNameInput")
	WebElement adminLoginPageUserName;

	@FindBy(id="passwordInput")
	WebElement adminLoginPagePassword;

	@FindBy(id="submitButton")
	WebElement adminLoginPageSignInButton;

	@FindBy(id="errorText")
	WebElement adminLoginPageError;

	@FindBy(xpath="//a[contains(text(),'Forgot your password?')]")
	WebElement adminLoginPageForgotPassword;




	public AdminCloudLoginPage(WebDriver driver){

		this.driver = driver;

		//This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}   

	//Select CloudServices Option on CloudLogin Page
	public void navigateToCloudServicesPage()
	{
		adminLoginPageCloudLogo.click();
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
	public AdminDashboardPage loginToAdminSection(String strUserName,String strPassword)
	{

		try 
		{
			this.navigateToCloudServicesPage();
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}


		this.setUserName(strUserName);
		this.setPassword(strPassword);
		this.clickLoginButton();
		AdminDashboardPage objAdminDashboard = new AdminDashboardPage(driver);
		return objAdminDashboard;
	}

	//Get Error Message
	public String getErrorMessage(String strErrorMessage)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@id='errorText' and text()="+"'"+strErrorMessage+"']")));
		return adminLoginPageError.getText().toString();
	}

}