package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminOperationalMessagePage 
{
    WebDriver driver;
    
    @FindBy(id="AddOperationaMessage")
    WebElement operationalMessagePageAddnewMessageButton;
    
    @FindBy(id="Title")
    WebElement operationalMessagePopUpTitleTextBox;
    
    @FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr']")
    WebElement operationalMessagePopUpContentEdtiableTextBox;
    
    @FindBy(id="messageStatus")
    WebElement operationalMessagePopUpStatusDropDown;
    
    @FindBy(xpath="//label[contains(text(),'Add message with ribbon alert')]")
    WebElement operationalMessagePopUpAlertCheckBox;
    
    @FindBy(id="saveMessage")
    WebElement operationalMessagePopUpSaveButtonn;
    
    @FindBy(xpath="//div[@class='divTableBody']/div[1]/div[1]")
    WebElement operationalMessagePageLatestAddedMessageTitle;
    
    
    public AdminOperationalMessagePage(WebDriver driver)
    {

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);
        
    }   
    
    
    //Method to Post New Operational Message 
    public void postAdminAlertOperationalMessage(String strOpMessageTitle,String strOpMessageContent) throws InterruptedException
    {
    	operationalMessagePageAddnewMessageButton.click();
    	operationalMessagePopUpTitleTextBox.sendKeys(strOpMessageTitle);
    	//Wait for RichText Editor To Load
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
    	driver.switchTo().frame(0);
    	operationalMessagePopUpContentEdtiableTextBox.sendKeys(strOpMessageContent);
        driver.switchTo().defaultContent();
    	operationalMessagePopUpAlertCheckBox.click();
    	operationalMessagePopUpSaveButtonn.click();
    	Thread.sleep(2000);
    }
    
    //Method to get latest Operational Message from Op Message Page In Admin Section 
    public String getLatestAdminOperationalMessage()
    {
    	return operationalMessagePageLatestAddedMessageTitle.getText().trim();
    }
}












