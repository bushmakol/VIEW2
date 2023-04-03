package Tietoevry.VIEW;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.AdminCustomerAndOperatinalMessagePage;
import PageObjects.AdminCustomerProfilePage;
import PageObjects.AdminDashboardPage;
import testcomponents.BaseTest;
import java.lang.*;

public class AdminOperationalMessageTests extends BaseTest
{

	@Test(priority=1,enabled=true ,groups = {"regression"})
	public void test_Add_New_Alert_Operational_Message() throws EncryptedDocumentException, InterruptedException, IOException 
	{
		AdminDashboardPage objAdminDashboard =objAdminLogin.loginToAdminSection(objExcel.getExcelData(1, 1, "AdminOperationalMessageTests"), objExcel.getExcelData(1, 2, "AdminOperationalMessageTests"));
		AdminCustomerProfilePage objAdminCustomerProfile =objAdminDashboard.selectCustomerFromAdminDashborad(objExcel.getExcelData(1, 3, "AdminOperationalMessageTests"));
		AdminCustomerAndOperatinalMessagePage objCustomerAndOperationalMessage= objAdminCustomerProfile.navigateToOperationalMessagePage();
		objCustomerAndOperationalMessage.postAdminAlertOperationalMessage((objExcel.getExcelData(1, 4, "AdminOperationalMessageTests")), (objExcel.getExcelData(1, 5, "AdminOperationalMessageTests")));
		Assert.assertEquals(objCustomerAndOperationalMessage.getLatestMessage(), objExcel.getExcelData(1, 4, "AdminOperationalMessageTests"), "Op Message Posted Do not match the message in Table");
		Thread.sleep(1000);
		objCustomerAndOperationalMessage.stopLatestActiveOperationalMessage();
		
	}
	
	@Test(priority=2,enabled=true ,groups = {"regression"},dependsOnMethods = {"test_Add_New_Alert_Operational_Message"})
	public void test_Stop_NewlyAdded_Alert_Operational_Message() throws EncryptedDocumentException, InterruptedException, IOException 
	{
		AdminDashboardPage objAdminDashboard =objAdminLogin.loginToAdminSection(objExcel.getExcelData(1, 1, "AdminOperationalMessageTests"), objExcel.getExcelData(1, 2, "AdminOperationalMessageTests"));
		AdminCustomerProfilePage objAdminCustomerProfile =objAdminDashboard.selectCustomerFromAdminDashborad(objExcel.getExcelData(1, 3, "AdminOperationalMessageTests"));
		AdminCustomerAndOperatinalMessagePage objCustomerAndOperationalMessage= objAdminCustomerProfile.navigateToOperationalMessagePage();
		objCustomerAndOperationalMessage.stopLatestActiveOperationalMessage();
		Assert.assertFalse(objCustomerAndOperationalMessage.getLatestMessage().equalsIgnoreCase(objExcel.getExcelData(1, 4, "AdminOperationalMessageTests")), null);
	}

	
	@Test(priority=0,enabled=false ,groups = {"regression"} )
	public void test_Alert_Operational_Message_Is_Displayed_In_Customer_Section() throws EncryptedDocumentException, InterruptedException, IOException 
	{
		//objLogin.loginToAdminSection(objExcel.getExcelData(1, 1, "AdminOperationalMessage"), objExcel.getExcelData(1, 2, "AdminOperationalMessage"));
		//objDashboard.selectCustomerFromAdminDashborad(objExcel.getExcelData(1, 3, "AdminOperationalMessage"));
		//objCustomerProfile.navigateFromSupportAsCustomerAdmin();
		objCustomerDashboard.closeActiveRibbonOnDashboard();
		Assert.assertEquals(objCustomerDashboard.getOperationalAlertMessageFromRibbon(), objExcel.getExcelData(1, 4, "AdminOperationalMessageTests"), "Op Message Posted Do not match the message in Ribbon");
	}

}
