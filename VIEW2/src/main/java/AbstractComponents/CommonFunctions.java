package AbstractComponents;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctions 
{
	public static void selectFromDropDownByIndex(WebElement element, int index)
	{
		Select sel= new Select(element);
		sel.selectByIndex(index);
	}
	
	public static void selectFromDropDownByName(WebElement element, String strName)
	{
		Select sel= new Select(element);
		sel.selectByVisibleText(strName);
	}
	public static void selectFromDropDownByValue(WebElement element, String strName)
	{
		Select sel= new Select(element);
		sel.selectByValue(strName);
	}
	
	public static String getSelectedValueFromDropDown(WebElement element)
	{
		Select sel= new Select(element);
		
		return sel.getFirstSelectedOption().getText();
	}
	public static void waitExplicitlyForTextInElementToBePresent(WebDriver driver,WebElement element,String strTextInElement)
	{
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(element, strTextInElement.trim()));
	}
	
	public static void waitExplicitlyForElemetToBeClickable(WebDriver driver,WebElement element)
	{
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public static void waitExplicitlyForElemetToBeClickableCloudUserPage(WebDriver driver,WebElement element)
	{
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(75));
        wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void navigateToNewTab(WebDriver driver)
	{
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
	}
	
	public static void navigateBackToOldTab(WebDriver driver)
	{
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.close();
		driver.switchTo().window(tabs.get(0));
	}
	
	public static String getCurrentDateTime()
	{
		DateFormat customFormat= new  SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		Date currentDate= new Date();
		return  customFormat.format(currentDate);
		
	}
	public static String getRandomString() 
	{
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 6) 
        { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
	public static void scrollPageToElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;		
        js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
}
