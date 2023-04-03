package Tietoevry.VIEW;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.AdminDashboardPage;
import testcomponents.BaseTest;



public class AdminDashboardPageTests extends BaseTest
{
	
	@Test(priority=1,enabled= true, groups= {"smoke","regression"})
	public void test_Verify_Admin_Dashborad_Page_Displayed_Correctly() throws EncryptedDocumentException, InterruptedException, IOException 
	{
		
		AdminDashboardPage objAdminDashboard =objAdminLogin.loginToAdminSection(objExcel.getExcelData(1, 1, "AdminDashboardPageTests"), objExcel.getExcelData(1, 2, "AdminDashboardPageTests"));
		objAdminDashboard.closeAdminRibbonIfExists();
		Assert.assertTrue(objAdminDashboard.checkAdminDasboardViewLogoPresence());
		Assert.assertTrue(objAdminDashboard.checkAdminDasboardCustomerListsPresence());
		Assert.assertTrue(objAdminDashboard.checkAdminDasboardTietoEvryLogoPresence());
		Assert.assertTrue(objAdminDashboard.checkAdminDasboardGlobalStatisticsPresence());
	}

	@Test(priority=2,enabled= true,groups = {"regression"})
	public void test_Verify_Admin_Search_And_Open_Customer() throws EncryptedDocumentException, InterruptedException, IOException 
	{
		
		AdminDashboardPage objAdminDashboard =objAdminLogin.loginToAdminSection(objExcel.getExcelData(3, 1, "AdminDashboardPageTests"), objExcel.getExcelData(3, 2, "AdminDashboardPageTests"));
		objAdminDashboard.selectCustomerFromAdminDashborad(objExcel.getExcelData(3, 3, "AdminDashboardPageTests"));
	}
}
