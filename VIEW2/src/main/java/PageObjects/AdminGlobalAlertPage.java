package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminGlobalAlertPage 
{
	WebDriver driver;

    @FindBy(id="txtMessage")
    WebElement adminGlobalAlertEnglishMessageTextBox;
    
    @FindBy(id="txtMessageNb")
    WebElement adminGlobalAlertNorwegianMessageTextBox;
    
    @FindBy(id="PublishMessage")
    WebElement adminGlobalAlertPublishButton;
    
    @FindBy(xpath="//div[@id='activenewsList']/div/div[1]")
    WebElement adminGlobalAlertActiveMessage;
    
    @FindBy(id="editNews")
    WebElement adminGlobalAlertEditButton;
    
    @FindBy(id="stopNews")
    WebElement adminGlobalAlertStopButton;
    
    //Title of First Old Global Alert
    @FindBy(xpath="//div[@id='oldNewsList']/div[1]/div[1]")
    WebElement adminLastestStoppedGlobalAlertMessage;
    
    //Ok Button in Stop Global Alert Pop Up
    @FindBy(id="btnStop")
    WebElement adminStopGlobalAlertConfirmButton;
    
    public AdminGlobalAlertPage(WebDriver driver)
    {

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }   
    
    //Adding Global Alert Message
    public void addGlobalAlertMessage(String strGlobalAlertEnglisMessage, String strGlobalAlertNorwegianMessage)
    {
    	adminGlobalAlertEnglishMessageTextBox.sendKeys(strGlobalAlertEnglisMessage);
    	adminGlobalAlertNorwegianMessageTextBox.sendKeys(strGlobalAlertNorwegianMessage);
    	adminGlobalAlertPublishButton.click();
    }

    //Stopping Global Alert Message If ANY
    public void stopActiveGlobalAlertMessageIfAny()
    {
    	
        	try 
        	{
				adminGlobalAlertStopButton.click();
				adminStopGlobalAlertConfirmButton.click();
			} 
        	catch (Exception e) 
        	{
				
			}
    	
    }
    
   //Stopping Global Alert Message
    public void stopActiveGlobalAlertMessage()
    {
        	adminGlobalAlertStopButton.click();
        	adminStopGlobalAlertConfirmButton.click();
    }
    
    //Editing Active Global Alert Message
    public void editActiveGlobalAlertMessage(String strGlobalAlertEnglisMessage, String strGlobalAlertNorwegianMessage)
    {
    	adminGlobalAlertEditButton.click();
    	adminGlobalAlertEnglishMessageTextBox.sendKeys(strGlobalAlertEnglisMessage);
    	adminGlobalAlertNorwegianMessageTextBox.sendKeys(strGlobalAlertNorwegianMessage);
    	adminGlobalAlertPublishButton.click();
    }
    
    //Get Active Global Alert Message
    public String getActiveGlobalAlert()
    {
    	return adminGlobalAlertActiveMessage.getText();
    }
    
    //Get Latest Stopped Global Alert Message
    public String getLatestStoppedGlobalAlert()
    {
    	return adminLastestStoppedGlobalAlertMessage.getText();
    }
}

