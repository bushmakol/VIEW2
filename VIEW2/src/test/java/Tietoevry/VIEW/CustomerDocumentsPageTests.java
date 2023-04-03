package Tietoevry.VIEW;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.CustomerDashboardPage;
import PageObjects.CustomerDocumentsPage;
import PageObjects.CustomerSelectCustomerPage;
import testcomponents.BaseTest;

public class CustomerDocumentsPageTests extends BaseTest
{

	@Parameters({"browser"})
	@Test(priority=1,enabled= true, groups= {"smoke","regression"})
	public void test_Verify_Documents_Page_Opens_Correctly() throws EncryptedDocumentException, InterruptedException, IOException 
	{
		CustomerSelectCustomerPage objSelectCustomer = objCloudCustomerLogin.loginToCustomerSectionCloud((objExcel.getExcelData(1, 1, "CustomerDocumentsPage")), objExcel.getExcelData(1, 2, "CustomerDocumentsPage"));
		CustomerDashboardPage objCustomerDashboard= objSelectCustomer.selectCustomerFromListOfCustomers(objExcel.getExcelData(1, 3, "CustomerDocumentsPage"));
		objCustomerDashboard.closeActiveRibbonOnDashboard();
		CustomerDocumentsPage objDocumentsPage = objCustomerDashboard.navigateToDocumentsPage();
		Assert.assertTrue(objDocumentsPage.verifyDocumentsPageDisplayedProperly(), "Documents Page Not Opened Properly");
	}

}

