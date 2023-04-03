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

import PageObjects.AdminCustomerProfilePage;
import PageObjects.AdminDashboardPage;
import PageObjects.AdminCloudLoginPage;
import PageObjects.AdminRequestPage;
import AbstractComponents.Constants;
import AbstractComponents.ExcelData;

public class AdminRequestPageTests 
{
	
	WebDriver driver;
	AdminCloudLoginPage objAdminLogin;
	AdminDashboardPage objAdminDashboard;
	AdminCustomerProfilePage objAdminCustomerProfile;
	AdminRequestPage objAdminRequest;
	ExcelData objExcel;
	
	
	
	@BeforeMethod( groups= {"smoke","regression"})
	public void initalizeWebdriver()
	{
	
		//System.setProperty("webdriver.chrome.driver",Constants.chromeDriverPath);
		driver = new ChromeDriver();
		objAdminLogin = new AdminCloudLoginPage(driver);
		objAdminDashboard = new AdminDashboardPage(driver);
		objAdminRequest = new AdminRequestPage(driver);
		objAdminCustomerProfile = new AdminCustomerProfilePage(driver);
		objExcel = new ExcelData();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Constants.viewTestAdminURL);
		driver.manage().window().maximize();
		
	}
	
	@AfterMethod( groups= {"smoke","regression"})
	public void terminateTest()
	{
		driver.close();
		driver.quit();
	}
	
	
	
	
	/**
	 * 
	 * Verify 
	 * prerequisites:
	 * 1-User Should be a non Admin or Helpdesk role user
	 * 2- User Role to be changed should not be same to the current role
	 */
	
	@Test(priority = 0, enabled=true,groups = {"regression"})
	public void test_Change_Evry_Role_Request() throws EncryptedDocumentException, InterruptedException, IOException
	{
		objAdminLogin.loginToAdminSection(objExcel.getExcelData(1, 1, "AdminRequestPage"), objExcel.getExcelData(1, 2, "AdminRequestPage"));
		objAdminDashboard.selectCustomerFromAdminDashborad(objExcel.getExcelData(1, 3, "AdminRequestPage"));
		objAdminCustomerProfile.ApplyforNewEvryRole(objExcel.getExcelData(1, 4, "AdminRequestPage"));
		
	}
	

	/**
	 * 
	 * Verify Admin Message with Alert is Created Successfully.
	 * prerequisites: 
	 * 1-User Should be a non Admin or Helpdesk role user
	 * 
	 */
	
	@Test(priority = 0,dependsOnMethods = "test_Create_Change_Evry_Role_Request", enabled=true,groups = {"regression"})
	public void test_Change_Evry_Role_Request_Recieved() throws EncryptedDocumentException, InterruptedException, IOException
	{
		objAdminLogin.loginToAdminSection(objExcel.getExcelData(2, 1, "AdminRequestPage"), objExcel.getExcelData(2, 2, "AdminRequestPage"));
		objAdminDashboard.navigateToRegistrationRequestPage();
		Assert.assertTrue(objAdminRequest.verifyEvryRoleChangeRequestRecieved(objExcel.getExcelData(2, 3, "AdminRequestPage"), objExcel.getExcelData(2, 5, "AdminRequestPage")));
		Assert.assertTrue(objAdminRequest.verifyEvryRoleChangeRequestForCorrectRole(objExcel.getExcelData(2, 3, "AdminRequestPage"), objExcel.getExcelData(2, 5, "AdminRequestPage"), objExcel.getExcelData(2, 4, "AdminRequestPage")));
	}
	
	
	
	
}
