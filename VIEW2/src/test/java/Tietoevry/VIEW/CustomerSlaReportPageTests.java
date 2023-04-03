package Tietoevry.VIEW;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AbstractComponents.Constants;
import PageObjects.CustomerDashboardPage;
import PageObjects.CustomerSelectCustomerPage;
import PageObjects.CustomerSlaReportPage;
import testcomponents.BaseTest;

public class CustomerSlaReportPageTests extends BaseTest
{

	@Parameters({"browser"})
	@Test(priority=1,enabled= true, groups= {"smoke","regression"})
	public void test_Verify_Customer_Sla_Report_Page_Opens_Correctly() throws EncryptedDocumentException, InterruptedException, IOException 
	{
		CustomerSelectCustomerPage objSelectCustomer = objCloudCustomerLogin.loginToCustomerSectionCloud((objExcel.getExcelData(1, 1, "CustomerSlaReportPage")), objExcel.getExcelData(1, 2, "CustomerSlaReportPage"));
		CustomerDashboardPage objCustomerDashboard= objSelectCustomer.selectCustomerFromListOfCustomers(objExcel.getExcelData(1, 3, "CustomerSlaReportPage"));
		objCustomerDashboard.closeActiveRibbonOnDashboard();
		CustomerSlaReportPage objSLAPage =objCustomerDashboard.navigateToSLAPage();
		Assert.assertTrue(objSLAPage.verifySlaReportPageDisplayedProperly(), "Sla Report Page Not Opened Properly");
	}

}

