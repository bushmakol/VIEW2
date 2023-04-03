package PageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.lang.*;


public class AdminDashboardPage 
{

    WebDriver driver;

    @FindBy(id="QAAdmin_Inner")
    WebElement adminQADashboardPageLogo; 
    
    @FindBy(id="TestAdmin_Inner")
    WebElement adminTestDashboardPageLogo;  
    
    @FindBy(id="my_Profileimage")
    WebElement adminDashboardPageProfilePic;
    
    @FindBy(id="SpanUserName")
    WebElement adminDashboardPageUserName;
    
    @FindBy(id="anchChangewd")
    WebElement adminDashboardPageChangePassword;
    
    @FindBy(id = "Log_out")
    public static WebElement adminDashboardPageLogOut;
    
    @FindBy(id ="txtCustomerSearch")
    WebElement adminDashboardPageSearchCustomer;
    
    @FindBy(id= "activeSessions")
    WebElement adminDashboardPageNumberOfLoggedInUsers;
    
    @FindBy(xpath = "//p[contains(text(),'New')")
    WebElement adminDashboardPageAddNewCustomerBrick;
    
    @FindBy(xpath = "//a[@title='List of customers']")
    WebElement adminDashboardPageCutomerListBrick;
    
    @FindBy(xpath ="//p[contains(text(),'Permissions')]")
    WebElement adminDashboardPagePermissionsBrick;
    
    @FindBy(xpath ="//p[contains(text(),'Roles')]")
    WebElement adminDashboardPageRolesBrick;
    
    @FindBy(xpath ="//p[contains(text(),'Bulletin')]")
    WebElement adminDashboardPageBulletinBrick;
    
    @FindBy(xpath ="//p[contains(text(),'Icon mgmt')]")
    WebElement adminDashboardPageFunctionalIconManagementBrick;
    
    @FindBy(xpath ="//p[contains(text(),'Request')]")
    WebElement adminDashboardPageRegistrationRequestBrick;
    
    @FindBy(xpath ="//p[contains(text(),'Global alert')]")
    WebElement adminDashboardPageGlobalAlertBrick;
    
    //@FindBy(xpath ="//p[contains(text(),'Logging')]")
    //WebElement adminDashboardPageAdminLoggingBrick;
    
    @FindBy(xpath ="//p[contains(text(),'Messages')]")
    WebElement adminDashboardPageMessageBrick;
    
    @FindBy(id="Admin_footerLogo")
    WebElement adminDashboardPageFooterTietoEvryLogo;
    
    @FindBy(xpath ="//a[@title='Global Statistics']")
    WebElement adminDashboardPageFooterGlobalStatisticsButton;
    
    @FindBy(xpath ="//a[@title='Service Status']")
    WebElement adminDashboardPageFooterServiceStatusButton;
    
    @FindBy(id="HelpEditDesc")
    WebElement adminDashboardPageFooterHelpEditButton;
    
    @FindBy(xpath ="//a[@title='Release Notes']")
    WebElement adminDashboardPageFooterReleaseNotesButton;
 
    @FindBy(xpath ="//a[text()='Feedback']")
    WebElement adminDashboardPageFeedbackButton;
    
    @FindBy(className ="ribbon_close")
    WebElement adminDashboardPageAdminMessageRibbonCloseButton;
    
    
    public AdminDashboardPage(WebDriver driver)
    {

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);
        

    }   
    
    
    // Method to click on Admin logo
    public void clickOnAdminLogo() 
    {
    	if(driver.getCurrentUrl().contains("test"))
    	{
    		adminTestDashboardPageLogo.click();
    	}
    	else if (driver.getCurrentUrl().contains("viewqa")) 
    	{
    		adminQADashboardPageLogo.click();
    	}	
    	
	}
    
    //Method for checking presence of EVRY Logo IN Footer
    public boolean checkAdminDasboardTietoEvryLogoPresence()    
    {
    	return adminDashboardPageFooterTietoEvryLogo.isDisplayed();
    }
    
    
    //Method for checking presence of VIEW2 Logo In Header
    public boolean checkAdminDasboardViewLogoPresence()    
    {
    	boolean flag= false;
    	if(driver.getCurrentUrl().contains("test"))
    	{
    		if(adminTestDashboardPageLogo.isDisplayed())
    		{
    			flag =true;
    		}
    	}
    	else if (driver.getCurrentUrl().contains("viewqa")) 
    	{
    		if(adminQADashboardPageLogo.isDisplayed())
    		{
    			flag =true;
    		}
		}
    	return flag;
    }
    
    //Method for checking presence of GlobalStats In Footer
    public boolean checkAdminDasboardGlobalStatisticsPresence()    
    {
    	return adminDashboardPageFooterGlobalStatisticsButton.isDisplayed();
    }
    
    //Method for checking presence of Customer List Brick
    public boolean checkAdminDasboardCustomerListsPresence()    
    {
    	return adminDashboardPageCutomerListBrick.isDisplayed();
    }
    
    //Method to select a customer from Dashborad page by searching and then clicking on the customer
    public AdminCustomerProfilePage selectCustomerFromAdminDashborad(String strCustomerName)
    {
    	adminDashboardPageSearchCustomer.sendKeys(strCustomerName);
    	List<WebElement> customerList = driver.findElements(By.className("ellipsis"));
    	for(int i=0;i<customerList.size();i++)
    	{
    		if(customerList.get(i).getAttribute("title").equals(strCustomerName))
    		{
    			customerList.get(i).click();
    			AdminCustomerProfilePage objAdminCustomerProfile = new AdminCustomerProfilePage(driver);
    			return objAdminCustomerProfile;
    		}
    	}
		return null;
    }
    
    //Method to search a customer 
    public boolean searchCustomer(String strCustomerName) 
    {
    	adminDashboardPageSearchCustomer.sendKeys(strCustomerName);
    	List<WebElement> customerList = driver.findElements(By.className("ellipsis"));
    	for(int i=0;i<customerList.size();i++)
    	{
    		if(customerList.get(i).getAttribute("title").equals(strCustomerName))
    		{
    			return true;
    		}
    	}
		return false;
	}
    
    //Method to Logout from the Application from The Header
    public void adminSectionLogout() throws InterruptedException 
    {
    	closeAdminRibbonIfExists();
    	adminDashboardPageLogOut.click();
	}
    
    
    //Method to Navigate to global Statistic Page
    public void navigateToGlobalStatisticPage() 
    {
    	adminDashboardPageFooterGlobalStatisticsButton.click();
	}
    
    //Method to Navigate to Registration Request Page
    public void navigateToRegistrationRequestPage() 
    {
    	adminDashboardPageRegistrationRequestBrick.click();
	}
    
    //Method to Navigate to Service Status Page
    public AdminServiceStatusPage navigateToServiceStatusPage() 
    {
    	AdminServiceStatusPage objAdminServiceStatus = new AdminServiceStatusPage(driver);
    	adminDashboardPageFooterServiceStatusButton.click();
    	return objAdminServiceStatus;
	}
    
    
    //Method to Navigate to Help Pop up
    public void navigateToHelpPopUp() 
    {
    	adminDashboardPageFooterHelpEditButton.click();
	}
    
    
    //Method to Navigate to Release Notes Page
    public void navigateToReleaseNotesPage() 
    {
    	adminDashboardPageFooterReleaseNotesButton.click();
	}
    
    //Method to Navigate to Admin Message Page
    public AdminMessagePage navigateToAdminMessagePage()
    {
    	AdminMessagePage objAdminMessage = new AdminMessagePage(driver);
    	adminDashboardPageMessageBrick.click();
    	return objAdminMessage;
	}
    
    //Method to Navigate to Admin Message Page
    public void navigateToGlobalAlertPage()
    {
    	adminDashboardPageGlobalAlertBrick.click();
	}
    
  //Method to Navigate to Admin Message Page
    public void navigateToBulletinPage()
    {
    	adminDashboardPageBulletinBrick.click();
	}
    
    // Close the Admin Message Ribbon If a Message Exists
    public void closeAdminRibbonIfExists() throws InterruptedException
    {
    	if (driver.findElements(By.className("ribbon_close")).size()>0)
    	{
    		adminDashboardPageAdminMessageRibbonCloseButton.click();
    		Thread.sleep(1500);
    	}
//    	try 
//    	{
//			if(adminDashboardPageAdminMessageRibbonCloseButton.isDisplayed())
//			{
//				adminDashboardPageAdminMessageRibbonCloseButton.click();
//				Thread.sleep(1500);
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			//e.printStackTrace();
//		}
    }
   

}