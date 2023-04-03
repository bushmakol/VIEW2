package PageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerDocumentsPage 
{

	WebDriver driver;

	@FindBy(xpath="//div[@id='listMessages']/div[1]/div[1]")
	WebElement customerDocumentsPageMainCategories; 

	@FindBy(xpath= "//p[@id='ErrorMsgPopupHeadingNew' and text()='No records found']")
	WebElement customerDocumentsPageNoRecordFoundPopUpMessage;

	@FindBy(id="btnCloseErrorMsgDtl")
	WebElement customerDocumentsPageNoRecordFoundPopUpCloseButton;

	public CustomerDocumentsPage(WebDriver driver)
	{

		this.driver = driver;

		//This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}   

	// Verify Message Page Opens Properly 
	public boolean verifyDocumentsPageDisplayedProperly()
	{
		List<WebElement> mainCategoryList = driver.findElements(By.xpath("//ol[@id='MainCategory']/li"));
		if(mainCategoryList.size()>0)
		{
			return true;
		}
		else
		{
			if(customerDocumentsPageNoRecordFoundPopUpMessage.isDisplayed())
			{
				customerDocumentsPageNoRecordFoundPopUpMessage.click();
				return true;
			}
			return false;
		}

	}}
