package obsolete;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjects.AdminDashboardPage;
import PageObjects.AdminGlobalAlertPage;
import PageObjects.AdminLoginPage;
import AbstractComponents.Constants;
import AbstractComponents.ExcelData;


public class AdminGlobalAlertPageTests 
{
	WebDriver driver;
	AdminLoginPage objLogin;
	AdminDashboardPage objDashboard;
	AdminGlobalAlertPage objGlobalAlert;
	ExcelData objExcel;
	
	@BeforeMethod(groups= {"smoke","regression"})
	public void initalizeWebdriver()
	{
	
		//System.setProperty("webdriver.chrome.driver",Constants.chromeDriverPath);
		driver = new ChromeDriver();
		objLogin = new AdminLoginPage(driver);
		objDashboard = new AdminDashboardPage(driver);
		objGlobalAlert = new AdminGlobalAlertPage(driver);
		objExcel = new ExcelData();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Constants.viewTestAdminURL);
		driver.manage().window().maximize();
		
	}
	
	@AfterMethod (groups= {"smoke","regression"})
	public void terminateTest()
	{
		driver.close();
		driver.quit();
	}
	
	/**
	 * 
	 * Verify Global Alert is Created Successfully
	 * 
	 */
  @Test(priority=0,enabled= true ,groups = {"regression"})
  public void test_Create_Global_Alert_Message() throws EncryptedDocumentException, InterruptedException, IOException 
  {

	  driver.get(Constants.viewQAAdminURL);
	  objLogin.loginToAdminSection(objExcel.getExcelData(1, 1, "AdminGlobalAlertPage"), objExcel.getExcelData(1, 2, "AdminGlobalAlertPage"));
	  objDashboard.navigateToGlobalAlertPage();
	  objGlobalAlert.stopActiveGlobalAlertMessageIfAny();
	  objGlobalAlert.addGlobalAlertMessage(objExcel.getExcelData(1, 3, "AdminGlobalAlertPage"), objExcel.getExcelData(1, 4, "AdminGlobalAlertPage"));
	  Assert.assertEquals(objGlobalAlert.getActiveGlobalAlert(),  objExcel.getExcelData(1, 3, "AdminGlobalAlertPage"), "The Active News Does Not Match The Added News");
	  
  }
  
  
    /**
	 * 
	 * Verify Global Alert is Stopped Successfully
	 * 
	 */
  @Test(priority=1,enabled= true ,groups = {"regression"},dependsOnMethods ="test_Create_Global_Alert_Message" )
  public void test_Stop_Global_Alert_Message() throws EncryptedDocumentException, InterruptedException, IOException 
  {
	  driver.get(Constants.viewQAAdminURL);
	  objLogin.loginToAdminSection(objExcel.getExcelData(1, 1, "AdminGlobalAlertPage"), objExcel.getExcelData(1, 2, "AdminGlobalAlertPage"));
	  objDashboard.navigateToGlobalAlertPage();
	  objGlobalAlert.stopActiveGlobalAlertMessage();
	  Assert.assertEquals(objGlobalAlert.getLatestStoppedGlobalAlert(),  objExcel.getExcelData(1, 3, "AdminGlobalAlertPage"), "The Latest Stopped News Does Not Match The Added News");
	  
  }
}
