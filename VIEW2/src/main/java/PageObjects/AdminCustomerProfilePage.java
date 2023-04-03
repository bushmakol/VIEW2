package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbstractComponents.CommonFunctions;
import java.lang.*;

public class AdminCustomerProfilePage 
{

    WebDriver driver;

    @FindBy(id="lnkChangeRole")
    WebElement adminCustomerProfilePageApplyForNewRoleButton;
   
    @FindBy(xpath="//label[contains(text(),'Editor+')]")
    WebElement adminCustomerProfilePageChangeCustomerRolePopUpEditorPlusCheckBox;
    
    @FindBy(id="Editor")
    WebElement adminCustomerProfilePageChangeCustomerRolePopUpEditorCheckBox;
    
    @FindBy(id="PublisherPlus")
    WebElement adminCustomerProfilePageChangeCustomerRolePopUpPublisherPlusCheckBox;
    
    @FindBy(id="btnChangeRole")
    WebElement adminCustomerProfilePageChangeCustomerRolePopUpChangeButton;
    
    @FindBy(id="btnYes")
    WebElement adminCustomerProfilePageAlreadyAppliedForNewRoleSubmitButton;
    
    @FindBy(id="btnConfirm")
    WebElement adminCustomerProfilePageChangeCustomerRolePopUpConfirmButton;
    
    @FindBy(xpath="//div/p[contains(text(),'Your role:')]/strong")
    WebElement adminCustomerProfilePageCurrentEvryRole;
    		
    @FindBy(xpath="//a[@title='Support']")
    WebElement adminCustomerProfileSupportBrick;
    
    @FindBy(id="btnNoComment")
    WebElement adminCustomerProfileSupportPopUpNoCommentButton;
    
    @FindBy(id="customerAdmin")
    WebElement adminCustomerProfileSupportPopUpAdminBrick;

    @FindBy(id="superUser")
    WebElement adminCustomerProfileSupportPopUpSuperUserBrick;
    
    @FindBy(id="user")
    WebElement adminCustomerProfileSupportPopUpUserBrick;
    
    @FindBy(id="btnConfirmSupport")
    WebElement adminCustomerProfileSupportConfirmPopUpOkButton;
    
    @FindBy(id="addEditCustomerDomain")
    WebElement adminCustomerProfileDomianBrick;
    
    @FindBy(id="customerMessageLi")
    WebElement adminCustomerProfileCustomerMessageBrick;
    
    @FindBy(xpath="//a[contains(text(),'Operational message')]")
    WebElement adminCustomerProfileOperationalMessageBrick;
    
    @FindBy(xpath="//a[contains(text(),'Links')]")
    WebElement adminCustomerProfileLinksBrick;
    
    @FindBy(xpath="//a[contains(text(),'Customer users')]")
    WebElement adminCustomerProfileUsersBrick;
    
    @FindBy(xpath="//a[contains(text(),'Documents')]")
    WebElement adminCustomerProfileDocumentsBrick;
    
    @FindBy(xpath="//a[contains(text(),'FAQ / Wiki')]")
    WebElement adminCustomerProfileFAQWikiBrick;
    
    @FindBy(xpath="//a[text()='Statistics']")
    WebElement adminCustomerProfileStatisticsBrick;
    
    @FindBy(xpath="//a[contains(text(),'EVRY Users')]")
    WebElement adminCustomerProfileEvryUserBrick;
    
    @FindBy(xpath="//a[text()='Roles overview']")
    WebElement adminCustomerProfileRolesBrick;
    
    @FindBy(xpath="//a[contains(text(),'Icon Management')]")
    WebElement adminCustomerProfileLocalIconManagementBrick;
    
    @FindBy(xpath="//a[contains(text(),'Logging')]")
    WebElement adminCustomerProfileLoggingBrick;
    
    @FindBy(xpath="//a[@class='deactivate']")
    WebElement adminCustomerProfileDeactivateCustomerBrick;
    
    @FindBy(id="lnkChangeCustomerType")
    WebElement adminCustomerProfileChangeCustomerBrick;
    
    
    public AdminCustomerProfilePage(WebDriver driver)
    {

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }   
    
    
    //Method To Apply for New Evry Role For A Customer
    public void ApplyforNewEvryRole(String strNewRole) throws InterruptedException
    {
    	adminCustomerProfilePageApplyForNewRoleButton.click();
    	Thread.sleep(3000);
    	//WebDriverWait wait= new WebDriverWait(driver,5);
    	
			switch (strNewRole) 
			{
			case "Editor+":
		    	//wait.until(ExpectedConditions.elementToBeClickable(adminCustomerProfilePageChangeCustomerRolePopUpEditorPlusCheckBox));
				adminCustomerProfilePageChangeCustomerRolePopUpEditorPlusCheckBox.click();
				break;
			case "Editor":
		    	//wait.until(ExpectedConditions.elementToBeClickable(adminCustomerProfilePageChangeCustomerRolePopUpEditorCheckBox));
				adminCustomerProfilePageChangeCustomerRolePopUpEditorCheckBox.click();
				break;
			case "Publisher+":
		    	//wait.until(ExpectedConditions.elementToBeClickable(adminCustomerProfilePageChangeCustomerRolePopUpPublisherPlusCheckBox));
				adminCustomerProfilePageChangeCustomerRolePopUpPublisherPlusCheckBox.click();
				break;
			}
	    	
    	adminCustomerProfilePageChangeCustomerRolePopUpChangeButton.click();
    	adminCustomerProfilePageChangeCustomerRolePopUpConfirmButton.click(); 
    	
    	if(adminCustomerProfilePageAlreadyAppliedForNewRoleSubmitButton.isDisplayed())
    	{
    		adminCustomerProfilePageAlreadyAppliedForNewRoleSubmitButton.click();
    	}
    	
    }
    
    //Method To Apply for New Evry Role For A Customer
    public void ApplyforNewEvryRoleForAlreadyApliedForUser(String strNewRole)
    {
    	adminCustomerProfilePageApplyForNewRoleButton.click();
    	switch (strNewRole) 
    	{
		case "Editor+":
			adminCustomerProfilePageChangeCustomerRolePopUpEditorPlusCheckBox.click();
			break;
		case "Editor":
			adminCustomerProfilePageChangeCustomerRolePopUpEditorCheckBox.click();
			break;
		case "Publisher+":
			adminCustomerProfilePageChangeCustomerRolePopUpPublisherPlusCheckBox.click();
			break;
		}
    	adminCustomerProfilePageChangeCustomerRolePopUpChangeButton.click(); 	
    	adminCustomerProfilePageAlreadyAppliedForNewRoleSubmitButton.click();
    }
    
    //Method To get Current EvryRole
    public String getCurrentEvryRole()
    {
    	return adminCustomerProfilePageCurrentEvryRole.getText();
    }
    
    //Method To Navigate as Admin from Support Brick
    public CustomerDashboardPage navigateFromSupportAsCustomerAdmin()
    {
    	CustomerDashboardPage objCustomerDashboard = new CustomerDashboardPage(driver);
    	adminCustomerProfileSupportBrick.click();
    	try 
    	{
    		adminCustomerProfileSupportPopUpNoCommentButton.click();
		} catch (Exception e) 
    	{
		}
    	adminCustomerProfileSupportPopUpAdminBrick.click();
    	CommonFunctions.waitExplicitlyForElemetToBeClickable(driver, adminCustomerProfileSupportConfirmPopUpOkButton);
    	adminCustomerProfileSupportConfirmPopUpOkButton.click();
    	return objCustomerDashboard;
    }
    
    
  //Method To Navigate as SuperUser from Support Brick
    public CustomerDashboardPage navigateFromSupportAsSuperUser()
    {
    	CustomerDashboardPage objCustomerDashboard = new CustomerDashboardPage(driver);
    	adminCustomerProfileSupportBrick.click();
    	try 
    	{
    		adminCustomerProfileSupportPopUpNoCommentButton.click();
		} catch (Exception e) 
    	{
		}
    	adminCustomerProfileSupportPopUpSuperUserBrick.click();
    	CommonFunctions.waitExplicitlyForElemetToBeClickable(driver, adminCustomerProfileSupportConfirmPopUpOkButton);
    	adminCustomerProfileSupportConfirmPopUpOkButton.click();
    	return objCustomerDashboard;

    }
    
    //Method To Navigate as User from Support Brick
    public CustomerDashboardPage navigateFromSupportAsUser()
    {
    	CustomerDashboardPage objCustomerDashboard = new CustomerDashboardPage(driver);
    	adminCustomerProfileSupportBrick.click();
    	try 
    	{
    		adminCustomerProfileSupportPopUpNoCommentButton.click();
		} catch (Exception e) 
    	{
		}
    	adminCustomerProfileSupportPopUpUserBrick.click();
    	CommonFunctions.waitExplicitlyForElemetToBeClickable(driver, adminCustomerProfileSupportConfirmPopUpOkButton);
    	adminCustomerProfileSupportConfirmPopUpOkButton.click();
    	return objCustomerDashboard;

    }
    
    
    //Method To Navigate to Customer Message Page
    public AdminCustomerAndOperatinalMessagePage navigateToCustomerMessagePage()
    {
    	adminCustomerProfileCustomerMessageBrick.click();
    	AdminCustomerAndOperatinalMessagePage objAdminCustomerAndOperationalMessage = new AdminCustomerAndOperatinalMessagePage(driver);
    	return objAdminCustomerAndOperationalMessage;
    }
    
    //Method To Navigate to Operational Message Page
    public AdminCustomerAndOperatinalMessagePage navigateToOperationalMessagePage()
    {
    	adminCustomerProfileCustomerMessageBrick.click();
    	AdminCustomerAndOperatinalMessagePage objAdminCustomerAndOperationalMessage = new AdminCustomerAndOperatinalMessagePage(driver);
    	//adminCustomerProfileOperationalMessageBrick.click();
    	return objAdminCustomerAndOperationalMessage;
    }
}
