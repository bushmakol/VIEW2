package Tietoevry.VIEW;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AbstractComponents.Constants;
import PageObjects.CustomerDashboardPage;
import PageObjects.CustomerMonitoringPage;
import PageObjects.CustomerPSD2ReportPage;
import PageObjects.CustomerSelectCustomerPage;
import testcomponents.BaseTest;

public class CustomerPSD2ReportPageTests extends BaseTest
{

	@Parameters({"browser"})
	@Test(priority=1,enabled= true, groups= {"smoke","regression"})
	public void test_Verify_Customer_PSD2_Report_Page_Opens_Correctly() throws EncryptedDocumentException, InterruptedException, IOException 
	{
		CustomerSelectCustomerPage objSelectCustomer = objCloudCustomerLogin.loginToCustomerSectionCloud((objExcel.getExcelData(1, 1, "CustomerPSD2ReportPage")), objExcel.getExcelData(1, 2, "CustomerPSD2ReportPage"));
		CustomerDashboardPage objCustomerDashboard= objSelectCustomer.selectCustomerFromListOfCustomers(objExcel.getExcelData(1, 3, "CustomerPSD2ReportPage"));
		objCustomerDashboard.closeActiveRibbonOnDashboard();
		CustomerPSD2ReportPage objPSD2ReportPage = objCustomerDashboard.navigateToPSD2ReportPage();
		Assert.assertTrue(objPSD2ReportPage.verifyPSD2ReportPageDisplayedProperly(), "PSD2 Report Page Not Opened Properly");
	}

}

