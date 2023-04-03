package Tietoevry.VIEW;

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
import PageObjects.AdminGlobalAlertPage;
import PageObjects.AdminCloudLoginPage;
import PageObjects.CustomerDashboardPage;
import PageObjects.CustomerSelectCustomerPage;
import testcomponents.BaseTest;
import AbstractComponents.CommonFunctions;
import AbstractComponents.Constants;
import AbstractComponents.ExcelData;

public class AdminSupportBrickTest extends BaseTest

{
	/**
	 * 
	 * Verify User Is able to Navigate through Support brick as Admin CustomerUser
	 * 
	 */
	@Test(priority=0,enabled= true ,groups = {"regression","smoke"})
	public void test_Navigation_From_Support_Brick_As_CustomerAdmin() throws EncryptedDocumentException, InterruptedException, IOException 
	{
		AdminDashboardPage objAdminDashboard =objAdminLogin.loginToAdminSection(objExcel.getExcelData(1, 1, "AdminSupportBrickTest"), objExcel.getExcelData(1, 2, "AdminSupportBrickTest"));
		objAdminDashboard.closeAdminRibbonIfExists();
		AdminCustomerProfilePage objAdminCustomerProfile =objAdminDashboard.selectCustomerFromAdminDashborad(objExcel.getExcelData(1, 3, "AdminSupportBrickTest"));
		CustomerDashboardPage objCustomerDashboard=objAdminCustomerProfile.navigateFromSupportAsCustomerAdmin();
		CommonFunctions.navigateToNewTab(driver);
		objCustomerDashboard.closeActiveRibbonOnDashboard();
		Assert.assertTrue(objCustomerDashboard.verifyCustomerdashboardPageIsDisplayed(), "Unable to Open Dashboard Page");
	}


	/**
	 * 
	 * Verify User Is able to Navigate through Support brick as SuperUser
	 * 
	 */
	@Test(priority=0,enabled= true ,groups = {"regression"})
	public void test_Navigation_From_Support_Brick_As_SuperUser() throws EncryptedDocumentException, InterruptedException, IOException 
	{

		AdminDashboardPage objAdminDashboard =objAdminLogin.loginToAdminSection(objExcel.getExcelData(2, 1, "AdminSupportBrickTest"), objExcel.getExcelData(2, 2, "AdminSupportBrickTest"));
		objAdminDashboard.closeAdminRibbonIfExists();
		AdminCustomerProfilePage objAdminCustomerProfile =objAdminDashboard.selectCustomerFromAdminDashborad(objExcel.getExcelData(2, 3, "AdminSupportBrickTest"));
		CustomerDashboardPage objCustomerDashboard=objAdminCustomerProfile.navigateFromSupportAsSuperUser();
		CommonFunctions.navigateToNewTab(driver);
		objCustomerDashboard.closeActiveRibbonOnDashboard();
		Assert.assertTrue(objCustomerDashboard.verifyCustomerdashboardPageIsDisplayed(), "Unable to Open Dashboard Page");
	}


	/**
	 * 
	 * Verify User Is able to Navigate through Support brick as User
	 * 
	 */
	@Test(priority=0,enabled= true ,groups = {"regression"})
	public void test_Navigation_From_Support_Brick_As_User() throws EncryptedDocumentException, InterruptedException, IOException 
	{
		AdminDashboardPage objAdminDashboard =objAdminLogin.loginToAdminSection(objExcel.getExcelData(3, 1, "AdminSupportBrickTest"), objExcel.getExcelData(3, 2, "AdminSupportBrickTest"));
		objAdminDashboard.closeAdminRibbonIfExists();
		AdminCustomerProfilePage objAdminCustomerProfile =objAdminDashboard.selectCustomerFromAdminDashborad(objExcel.getExcelData(3, 3, "AdminSupportBrickTest"));
		CustomerDashboardPage objCustomerDashboard=objAdminCustomerProfile.navigateFromSupportAsUser();
		CommonFunctions.navigateToNewTab(driver);
		objCustomerDashboard.closeActiveRibbonOnDashboard();
		Assert.assertTrue(objCustomerDashboard.verifyCustomerdashboardPageIsDisplayed(), "Unable to Open Dashboard Page");
	}



}
