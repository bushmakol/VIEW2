package Tietoevry.VIEW;

import java.io.IOException;
import testcomponents.BaseTest;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AdminDashboardPage;
import PageObjects.AdminServiceStatusPage;

public class AdminServiceStatusPageTests extends BaseTest
{

	@Test(priority=0,enabled= true ,groups = {"regression"})
	public void test_All_Services_Up() throws EncryptedDocumentException, InterruptedException, IOException 
	{
		AdminDashboardPage objAdminDashboard =objAdminLogin.loginToAdminSection(objExcel.getExcelData(1, 1, "AdminServiceStatusPageTests"), objExcel.getExcelData(1, 2, "AdminServiceStatusPageTests"));
		AdminServiceStatusPage objServiceStatus=  objAdminDashboard.navigateToServiceStatusPage();
		Thread.sleep(1000);
		Assert.assertTrue(objServiceStatus.VerfiyAllServicesUp(), "Service(s) is/are Down.");
	}

}
