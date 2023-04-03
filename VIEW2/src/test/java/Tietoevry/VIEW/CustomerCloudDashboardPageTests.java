package Tietoevry.VIEW;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AbstractComponents.Constants;
import PageObjects.CustomerDashboardPage;
import PageObjects.CustomerSelectCustomerPage;
import testcomponents.BaseTest;

public class CustomerCloudDashboardPageTests extends BaseTest
{

	@Parameters({"browser"})
	@Test(priority=1,enabled= true, groups= {"smoke","regression"})
	public void test_Verify_Cloud_CustomerDashborad_Page_Displayed_Correctly() throws EncryptedDocumentException, InterruptedException, IOException 
	{
		CustomerSelectCustomerPage objSelectCustomer = objCloudCustomerLogin.loginToCustomerSectionCloud((objExcel.getExcelData(1, 1, "CustomerCloudDashboardPage")), objExcel.getExcelData(1, 2, "CustomerCloudDashboardPage"));
		CustomerDashboardPage objCustomerDashboard= objSelectCustomer.selectCustomerFromListOfCustomers(objExcel.getExcelData(1, 3, "CustomerCloudDashboardPage"));
		objCustomerDashboard.closeActiveRibbonOnDashboard();
		Assert.assertTrue(objCustomerDashboard.verifyCustomerdashboardPageIsDisplayed(), "CustomerDasboard is Not Displayed Properly");
	}

}

