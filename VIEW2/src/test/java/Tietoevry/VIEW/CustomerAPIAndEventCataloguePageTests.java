package Tietoevry.VIEW;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AbstractComponents.Constants;
import PageObjects.CustomerAPIAndEventCataloguePage;
import PageObjects.CustomerDashboardPage;
import PageObjects.CustomerSelectCustomerPage;
import PageObjects.CustomerServiceDeskPage;
import testcomponents.BaseTest;

public class CustomerAPIAndEventCataloguePageTests extends BaseTest
{

	@Parameters({"browser"})	
	@Test(priority=1,enabled= true, groups= {"smoke","regression"})
	public void test_Verify_Customer_ApiAndEventCatalogue_Page_Opens_Correctly() throws EncryptedDocumentException, InterruptedException, IOException 
	{

		CustomerSelectCustomerPage objSelectCustomer = objCloudCustomerLogin.loginToCustomerSectionCloud((objExcel.getExcelData(1, 1, "CustomerAPIAndEventEnginePage")), objExcel.getExcelData(1, 2, "CustomerAPIAndEventEnginePage"));
		CustomerDashboardPage objCustomerDashboard= objSelectCustomer.selectCustomerFromListOfCustomers(objExcel.getExcelData(1, 3, "CustomerAPIAndEventEnginePage"));
		objCustomerDashboard.closeActiveRibbonOnDashboard();
		CustomerAPIAndEventCataloguePage objAPIandEventCataloguePage = objCustomerDashboard.navigateToAPIandEventCataloguePage();
		Assert.assertTrue(objAPIandEventCataloguePage.verifyAPIAndEventCataloguePageOpensProperly(), "APIEventEngine Page Not Displayed Properly");
	}

}

