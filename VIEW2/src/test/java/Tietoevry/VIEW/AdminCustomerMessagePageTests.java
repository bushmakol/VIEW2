package Tietoevry.VIEW;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import PageObjects.AdminCustomerAndOperatinalMessagePage;
import PageObjects.AdminCustomerProfilePage;
import PageObjects.AdminDashboardPage;
import PageObjects.AdminCloudLoginPage;
import PageObjects.CustomerDashboardPage;
import AbstractComponents.CommonFunctions;
import AbstractComponents.Constants;
import AbstractComponents.ExcelData;
import testcomponents.BaseTest;

public class AdminCustomerMessagePageTests extends BaseTest
{
	String strCustomerMessage;

	@Test(priority=1,enabled=true ,groups = {"regression","smoke"})
	public void test_Add_New_Customer_Message() throws EncryptedDocumentException, InterruptedException, IOException 
	{
		
		AdminDashboardPage objAdminDashboard =objAdminLogin.loginToAdminSection(objExcel.getExcelData(1, 1, "AdminCustomerMessageTest"), objExcel.getExcelData(1, 2, "AdminCustomerMessageTest"));
		AdminCustomerProfilePage objAdminCustomerProfile = objAdminDashboard.selectCustomerFromAdminDashborad(objExcel.getExcelData(1, 3, "AdminCustomerMessageTest"));
		AdminCustomerAndOperatinalMessagePage objAdminCustomerMessage= objAdminCustomerProfile.navigateToCustomerMessagePage();
		objAdminCustomerMessage.stopActiveCustomerMessage();
		strCustomerMessage= objAdminCustomerMessage.postCustomerMessage();
		Assert.assertEquals(objAdminCustomerMessage.getFirstMessageFromTable(),strCustomerMessage , "Customer Message Not Added in Admin Section");
	}
	
	@Test(priority=2,enabled=true ,groups = {"regression","smoke"},dependsOnMethods = {"test_Add_New_Customer_Message"})
	public void test_Stop_NewlyAdded_Customer_Message() throws EncryptedDocumentException, InterruptedException, IOException 
	{
		AdminDashboardPage objAdminDashboard =objAdminLogin.loginToAdminSection(objExcel.getExcelData(1, 1, "AdminCustomerMessageTest"), objExcel.getExcelData(1, 2, "AdminCustomerMessageTest"));
		AdminCustomerProfilePage objAdminCustomerProfile =objAdminDashboard.selectCustomerFromAdminDashborad(objExcel.getExcelData(1, 3, "AdminCustomerMessageTest"));
		AdminCustomerAndOperatinalMessagePage objCustomerAndOperationalMessage= objAdminCustomerProfile.navigateToOperationalMessagePage();
		objCustomerAndOperationalMessage.stopActiveCustomerMessage();
		Assert.assertNotNull(objCustomerAndOperationalMessage.getStoppedDateOfCustomerMessage(strCustomerMessage));

	}

	/**
	 * 
	 * Verify Customer Message is Displayed in Customer Section
	 *  
	 */
	//	@Test(priority=0,enabled=false ,dependsOnMethods ="test_Add_New_Customer_Message",groups = {"regression"})
	//	  public void test_Customer_Message_Is_Displayed_In_Customer_Message() throws EncryptedDocumentException, InterruptedException, IOException 
	//	  {
	//		  objLogin.loginToAdminSection(objExcel.getExcelData(1, 1, "AdminCustomerMessageTest"), objExcel.getExcelData(1, 2, "AdminCustomerMessageTest"));
	//		  objDashboard.selectCustomerFromAdminDashborad(objExcel.getExcelData(1, 3, "AdminCustomerMessageTest"));
	//		  objCustomerProfile.navigateFromSupportAsCustomerAdmin();
	//		  CommonFunctions.navigateToNewTab(driver);
	//		  objCustomerDashboard.closeActiveRibbonOnDashboard();
	//		  Assert.assertEquals(objCustomerDashboard.getCustomerMessageFromRibbon(),objExcel.getExcelData(1,4, "AdminCustomerMessageTest") , "Customer Message Not Displayed Properly in Customer Section");
	//	  }

}
