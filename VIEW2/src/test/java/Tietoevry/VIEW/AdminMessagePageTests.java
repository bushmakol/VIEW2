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

import PageObjects.AdminDashboardPage;
import PageObjects.AdminCloudLoginPage;
import PageObjects.AdminMessagePage;
import PageObjects.CustomerDashboardPage;
import PageObjects.CustomerLoginPageNonSSO;
import PageObjects.CustomerSelectCustomerPage;
import testcomponents.BaseTest;
import AbstractComponents.CommonFunctions;
import AbstractComponents.Constants;
import AbstractComponents.ExcelData;

public class AdminMessagePageTests extends BaseTest 
{
	//--------Global Alert Message Tests--------
		
	  @Test(priority = 1, enabled= true ,groups = {"regression"})
	  public void test_Create_Global_Alert_Message() throws EncryptedDocumentException, InterruptedException, IOException 
	  {
		  AdminDashboardPage objAdminDashboard = objAdminLogin.loginToAdminSection(objExcel.getExcelData(3, 1, "AdminMessagePageTests"), objExcel.getExcelData(3, 2, "AdminMessagePageTests"));
		  AdminMessagePage objAdminMessagePage = objAdminDashboard.navigateToAdminMessagePage();
		  objAdminMessagePage.stopActiveGlobalAlertMessageIfAny();
		  objAdminMessagePage.addGlobalAlertMessage(objExcel.getExcelData(4, 6, "AdminMessagePageTests"), objExcel.getExcelData(4, 7, "AdminMessagePageTests"),objExcel.getExcelData(4, 5, "AdminMessagePageTests"));
		  Assert.assertEquals(objAdminMessagePage.getActiveGlobalAlert(),  objExcel.getExcelData(4, 6, "AdminMessagePageTests"), "The Active Global Alert Does Not Match The Added Global Alert");
	  }
	  
	  
	   
	  @Test(priority=2,enabled= true ,groups = {"regression"},dependsOnMethods ="test_Create_Global_Alert_Message" )
	  public void test_Stop_Global_Alert_Message() throws EncryptedDocumentException, InterruptedException, IOException 
	  {
		  AdminDashboardPage objAdminDashboard = objAdminLogin.loginToAdminSection(objExcel.getExcelData(3, 1, "AdminMessagePageTests"), objExcel.getExcelData(3, 2, "AdminMessagePageTests"));
		  AdminMessagePage objAdminMessagePage = objAdminDashboard.navigateToAdminMessagePage();
		  String strSecondActiveMessageTitleInTable=objAdminMessagePage.getLatestTileInTableAfterStopingMessage();
		  objAdminMessagePage.stopActiveGlobalAlertMessageIfAny();
		  Assert.assertEquals(strSecondActiveMessageTitleInTable, objAdminMessagePage.getLatestAdminMessageTitleFromTable() , "The Global Alert Not Stopped");
	  }
	
	
		//------Internal Admin Message Tests-----
	
	@Test(priority = 3, enabled=false,groups = {"regression"})
	public void test_Create_Internal_Admin_Message_With_Alert() throws EncryptedDocumentException, InterruptedException, IOException
	{
		AdminDashboardPage objAdminDashboard = objAdminLogin.loginToAdminSection(objExcel.getExcelData(1, 1, "AdminMessagePageTests"), objExcel.getExcelData(1, 2, "AdminMessagePageTests"));
		AdminMessagePage objAdminMessagePage = objAdminDashboard.navigateToAdminMessagePage();
		objAdminMessagePage.createAdminMessageWithAlert(objExcel.getExcelData(1, 3, "AdminMessagePageTests"), objExcel.getExcelData(1, 4, "AdminMessagePageTests"), objExcel.getExcelData(1, 5, "AdminMessagePageTests"));
		Assert.assertEquals(objAdminMessagePage.getLatestAdminMessageTitleFromRibbon(), objExcel.getExcelData(1, 3, "AdminMessagePageTests"));
	}
	

	@Test(priority = 4, enabled=false,groups = {"regression"})
	public void test_Create_Internal_Admin_Message_Without_Alert() throws EncryptedDocumentException, InterruptedException, IOException
	{
		AdminDashboardPage objAdminDashboard = objAdminLogin.loginToAdminSection(objExcel.getExcelData(2, 1, "AdminMessagePageTests"), objExcel.getExcelData(2, 2, "AdminMessagePageTests"));
		AdminMessagePage objAdminMessagePage = objAdminDashboard.navigateToAdminMessagePage();
		objAdminMessagePage.createAdminMessageWithoutAlert(objExcel.getExcelData(2, 3, "AdminMessagePage"), objExcel.getExcelData(2, 4, "AdminMessagePageTests"), objExcel.getExcelData(2, 5, "AdminMessagePageTests"));
		Assert.assertEquals(objAdminMessagePage.getLatestAdminMessageTitleFromTable(), objExcel.getExcelData(2, 3, "AdminMessagePageTests"));
	}


	

}

