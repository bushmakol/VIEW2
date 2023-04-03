package Tietoevry.VIEW;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AbstractComponents.Constants;
import PageObjects.CustomerDashboardPage;
import PageObjects.CustomerDocumentsPage;
import PageObjects.CustomerMonitoringPage;
import PageObjects.CustomerSelectCustomerPage;
import testcomponents.BaseTest;

public class CustomerMonitoringPageTests extends BaseTest
{

	@Parameters({"browser"})
	@Test(priority=1,enabled= true, groups= {"overview","regression"})
	public void test_Verify_Customer_Monitoring_Page_Opens_Correctly() throws EncryptedDocumentException, InterruptedException, IOException 
	{
		CustomerSelectCustomerPage objSelectCustomer = objCloudCustomerLogin.loginToCustomerSectionCloud((objExcel.getExcelData(1, 1, "CustomerMonitoringPage")), objExcel.getExcelData(1, 2, "CustomerMonitoringPage"));
		CustomerDashboardPage objCustomerDashboard= objSelectCustomer.selectCustomerFromListOfCustomers(objExcel.getExcelData(1, 3, "CustomerMonitoringPage"));
		objCustomerDashboard.closeActiveRibbonOnDashboard();
		CustomerMonitoringPage objMonitoring  = objCustomerDashboard.navigateToMonitoringPage();
		Assert.assertTrue(objMonitoring.verifyMonitoringPageOpensProperly(), "Monitoring Page Not Displayed Properly");
	}

}

