package Tietoevry.VIEW;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.CustomerDashboardPage;
import PageObjects.CustomerSelectCustomerPage;
import PageObjects.CustomerServiceCataloguePage;
import testcomponents.BaseTest;

public class CustomerServiceCataloguePageTests extends BaseTest
{

	@Parameters({"browser"})
	@Test(priority=1,enabled= true, groups= {"smoke","regression"})
	public void test_Verify_Customer_ServiceCatalogue_Page_Opens_Correctly() throws EncryptedDocumentException, InterruptedException, IOException 
	{
		CustomerSelectCustomerPage objSelectCustomer = objCloudCustomerLogin.loginToCustomerSectionCloud((objExcel.getExcelData(1, 1, "CustomerServiceCataloguePage")), objExcel.getExcelData(1, 2, "CustomerServiceCataloguePage"));
		CustomerDashboardPage objCustomerDashboard= objSelectCustomer.selectCustomerFromListOfCustomers(objExcel.getExcelData(1, 3, "CustomerServiceCataloguePage"));
		objCustomerDashboard.closeActiveRibbonOnDashboard();
		CustomerServiceCataloguePage objServiceCataloguePage= objCustomerDashboard.navigateToServiceCataloguePage();
		Assert.assertTrue(objServiceCataloguePage.verifyServiceCataloguePageDisplayedProperly(), "ServiceCatalogue Page Not Opened Properly");
	}

}

