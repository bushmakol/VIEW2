package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerSelectCustomerPage 
{

	WebDriver driver;

	@FindBy(id="QAAdmin_Inner")
	WebElement adminQADashboardPageLogo; 


	public CustomerSelectCustomerPage(WebDriver driver)
	{

		this.driver = driver;

		//This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}   


	//Select Customer from Customer List
	public CustomerDashboardPage selectCustomerFromListOfCustomers(String strCustomerName)   
	{
    	CustomerDashboardPage objCustomerDashboard = new CustomerDashboardPage(driver);
    	if(driver.findElements(By.xpath("//div[contains(text(),'"+strCustomerName+"')]")).size()>0)
    	{
    		driver.findElement(By.xpath("//div[contains(text(),'"+strCustomerName+"')]")).click();
    	}
    	
//		try 
//		{
//			driver.findElement(By.xpath("//div[contains(text(),'"+strCustomerName+"')]")).click();
//		} catch (Exception e) 
//		{
//		}
		return objCustomerDashboard;
	}


}
