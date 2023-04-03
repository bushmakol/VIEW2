package Tietoevry.VIEW;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AbstractComponents.Constants;
import PageObjects.CustomerDashboardPage;
import PageObjects.CustomerSelectCustomerPage;
import PageObjects.CustomerServiceDeskPage;
import PageObjects.CustomerWebServiceStatisticsPage;
import testcomponents.BaseTest;

public class CustomerWebServiceStatisticsPageTests extends BaseTest
{

	/**
	 * 
	 * Verify Customer API and Event Page Is Displayed Properly
	 * 
	 */

	@Parameters({"browser"})
	@Test(priority=1,enabled= true, groups= {"smoke","regression"})
	public void test_Verify_Customer_Web_Service_Statistics_Page_Opens_Correctly() throws EncryptedDocumentException, InterruptedException, IOException 
	{

		CustomerSelectCustomerPage objSelectCustomer = objCloudCustomerLogin.loginToCustomerSectionCloud((objExcel.getExcelData(1, 1, "CustomerWebServiceStatisticPage")), objExcel.getExcelData(1, 2, "CustomerWebServiceStatisticPage"));
		CustomerDashboardPage objCustomerDashboard= objSelectCustomer.selectCustomerFromListOfCustomers(objExcel.getExcelData(1, 3, "CustomerWebServiceStatisticPage"));
		objCustomerDashboard.closeActiveRibbonOnDashboard();
		CustomerWebServiceStatisticsPage objWebServiceStatistics= objCustomerDashboard.navigateToWebServiceStatisticsPage();
		Assert.assertTrue(objWebServiceStatistics.verifyWebServiceStatisticsPageDisplayedProperly(), "Issues in Web ServiceStatistics Page");

	}

}

