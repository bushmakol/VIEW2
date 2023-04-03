package Tietoevry.VIEW;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.AdminDashboardPage;
import testcomponents.BaseTest;

/**
 * 
 * This tests https://viewqa.evry.com/EvryUser
 * Verify Admin Login Page Logo, ViewinfoEmail Presence
 * Verify Admin Login without Password
 * Verify Admin Login with Invalid Password
 * Verify Admin Login without UserName
 * Verify Admin Login with Invalid UserName
 * Verify Admin LoginPage ForgotPassword Functionality
 * Verify Admin Section Valid Login
 * 
 */


public class AdminCloudLoginPageTests extends BaseTest
{
	/**
	 * 
	 * Verify Error Message when trying to login without Password
	 * 
	 */
	@Test(priority = 1,enabled=true, groups= {"regression"})
	public void test_Admin_Login_Without_Password() throws EncryptedDocumentException, InterruptedException, IOException
	{
		
		objAdminLogin.loginToAdminSection(objExcel.getExcelData(2, 1, "AdminCloudLoginPageTests"), objExcel.getExcelData(2, 2, "AdminCloudLoginPageTests"));
		String errorMessage = objAdminLogin.getErrorMessage("Enter your password.");
		Assert.assertEquals(errorMessage, "Enter your password.");
	}

	/**
	 * 
	 * Verify Error Message when trying to login with Invalid Password
	 * 
	 */
	@Test(priority = 2,enabled=true, groups= {"regression"})
	public void test_Admin_Login_With_Invalid_Password() throws EncryptedDocumentException, InterruptedException, IOException 
	{
		
		objAdminLogin.loginToAdminSection(objExcel.getExcelData(3, 1, "AdminCloudLoginPageTests"), objExcel.getExcelData(3, 2, "AdminCloudLoginPageTests"));
		Assert.assertEquals(objAdminLogin.getErrorMessage("Incorrect user ID or password. Type the correct user ID and password, and try again."), "Incorrect user ID or password. Type the correct user ID and password, and try again.");
	}

	/**
	 * 
	 * Verify Error Message when trying to login without Username
	 * 
	 */
	@Test(priority = 3,enabled=true, groups= {"regression"})
	public void test_Admin_Login_Without_UserName() throws EncryptedDocumentException, InterruptedException, IOException 
	{
		
		objAdminLogin.loginToAdminSection(objExcel.getExcelData(4, 1, "AdminCloudLoginPageTests"), objExcel.getExcelData(4, 2, "AdminCloudLoginPageTests"));
		Assert.assertEquals(objAdminLogin.getErrorMessage("Enter your user ID in the format \"domain\\user\" or \"user@domain\"."), "Enter your user ID in the format \"domain\\user\" or \"user@domain\".");
	}

	
	/**
	 * 
	 * Verify Error Message when trying to login with Invalid Username
	 * 
	 */
	@Test(priority = 4,enabled=true, groups= {"regression"})
	public void test_Admin_Login_With_Invalid_UserName() throws EncryptedDocumentException, InterruptedException, IOException 
	{
		objAdminLogin.loginToAdminSection(objExcel.getExcelData(5, 1, "AdminCloudLoginPageTests"), objExcel.getExcelData(5, 2, "AdminCloudLoginPageTests"));
		Assert.assertEquals(objAdminLogin.getErrorMessage("Incorrect user ID or password. Type the correct user ID and password, and try again."), "Incorrect user ID or password. Type the correct user ID and password, and try again.");
	}
	
	/**
	 * 
	 * Verify Valid Login Into Admin Section by verifying precence of EVRY logo in footer of Dashboard page.
	 * 
	 */
	@Test(priority = 5, enabled=true, groups= {"smoke","regression"})
	public void test_Admin_Valid_Login() throws EncryptedDocumentException, InterruptedException, IOException 
	{
	
		AdminDashboardPage objAdminDashboard =objAdminLogin.loginToAdminSection(objExcel.getExcelData(7, 1, "AdminCloudLoginPageTests"), objExcel.getExcelData(7, 2, "AdminCloudLoginPageTests"));
		Assert.assertTrue(objAdminDashboard.checkAdminDasboardTietoEvryLogoPresence());
	}
	
}