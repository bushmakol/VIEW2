package Tietoevry.VIEW;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AbstractComponents.Constants;
import PageObjects.CustomerDashboardPage;
import PageObjects.CustomerScorecardPage;
import PageObjects.CustomerSelectCustomerPage;
import PageObjects.CustomerServiceCataloguePage;
import PageObjects.CustomerUserPage;
import testcomponents.BaseTest;

public class CustomerScorecardPageTests extends BaseTest
{

	@Parameters({"browser"})
	@Test(priority=1,enabled= true, groups= {"smoke","regression"})
	public void test_Verify_Customer_Scorecard_Page_Opens_Correctly() throws EncryptedDocumentException, InterruptedException, IOException 
	{
		CustomerSelectCustomerPage objSelectCustomer = objCloudCustomerLogin.loginToCustomerSectionCloud((objExcel.getExcelData(1, 1, "CustomerScorecardPage")), objExcel.getExcelData(1, 2, "CustomerScorecardPage"));
		CustomerDashboardPage objCustomerDashboard= objSelectCustomer.selectCustomerFromListOfCustomers(objExcel.getExcelData(1, 3, "CustomerScorecardPage"));
		objCustomerDashboard.closeActiveRibbonOnDashboard();
		CustomerScorecardPage objScorecardPage = objCustomerDashboard.navigateToScorecardPage();
		Assert.assertTrue(objScorecardPage.verifyScorecardPageOpensProperly(), "Scorecard Page Not Opened Properly");
	}

}

