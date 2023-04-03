package AbstractComponents;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents 
{
	WebDriver driver;
	public AbstractComponents(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void explicitlyWaitForInvisibilityOfElement(By ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(ele));
	}
	
	public void scrollToElement(WebElement element)
	{
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",element );
	}
	
	
	

}
