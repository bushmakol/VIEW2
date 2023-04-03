package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminRequestPage 
{

    WebDriver driver;
    
    

    public AdminRequestPage(WebDriver driver)
    {

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);
        
    }   
    
    
  //Method to Verify the Request is received in Request Page
    
    public boolean verifyEvryRoleChangeRequestRecieved(String strCustomerName, String strUserName)
    {
    	return driver.findElement(By.xpath("//div[text()='"+strCustomerName+"']/preceding-sibling::div/a[text()='"+strUserName+"']")).isDisplayed();
	}
    
    
    
  //Method to Verify the Request is received for Correct Evry Role
    
    public boolean verifyEvryRoleChangeRequestForCorrectRole(String strCustomerName, String strUserName,String strAppliedRoleName)
    {
    	int elementSelector=0;
    	switch(strAppliedRoleName)
    	{
    		case "Editor+":
    		elementSelector=3;
    		break;
    	
    		case "Editor":
    		elementSelector=4;
    		break;
    		
    		case "Publisher+":
        	elementSelector=5;
        	break;
    	}
    	return driver.findElement(By.xpath("//div[text()='"+strCustomerName+"']/preceding-sibling::div/a[text()='"+strUserName+"']/parent::*/parent::*/div["+elementSelector+"]/label/input[@checked='checked']")).isSelected();
	}

 
    
  //Method to Navigate To Evry User Page From the RequestPage
    
    public void navigateToEvryUserPageFromRequestPage(String strCustomerName, String strUserName)
    {
    	driver.findElement(By.xpath("//div[text()="+strCustomerName+"]/preceding-sibling::div/a[text()="+strUserName+"]")).click();
	}
}
