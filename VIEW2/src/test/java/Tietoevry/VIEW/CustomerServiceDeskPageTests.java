package Tietoevry.VIEW;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AbstractComponents.Constants;
import PageObjects.AdminCloudLoginPage;
import PageObjects.CustomerCloudLoginPage;
import PageObjects.CustomerDashboardPage;
import PageObjects.CustomerSelectCustomerPage;
import PageObjects.CustomerServiceDeskPage;
import testcomponents.BaseTest;

public class CustomerServiceDeskPageTests extends BaseTest
{

	@Parameters({"browser"})
	@Test(priority=1,enabled= true, groups= {"smoke","regression"})
	public void test_Verify_Customer_ServiceDesk_Page_Opens_Correctly() throws EncryptedDocumentException, InterruptedException, IOException 
	{
		
		CustomerSelectCustomerPage objSelectCustomer = objCloudCustomerLogin.loginToCustomerSectionCloud((objExcel.getExcelData(1, 1, "CustomerServiceDeskPage")), objExcel.getExcelData(1, 2, "CustomerServiceDeskPage"));
		CustomerDashboardPage objCustomerDashboard= objSelectCustomer.selectCustomerFromListOfCustomers(objExcel.getExcelData(1, 3, "CustomerServiceDeskPage"));
		objCustomerDashboard.closeActiveRibbonOnDashboard();
		CustomerServiceDeskPage objServiceDesk= objCustomerDashboard.navigateToServiceDeskPage();
		Assert.assertTrue(objServiceDesk.verifyServiceDeskPageDisplayedProperly(), "ServiceDesk Page Not Displayed Properly");
	}


	@Parameters({"browser"})
	@Test(priority=2,enabled= true, groups= {"regression"}, dependsOnMethods ="test_Verify_Customer_ServiceDesk_Page_Opens_Correctly")
	public void test_Verify_Customer_ServiceDesk_Page_Create_New_Ticket() throws EncryptedDocumentException, InterruptedException, IOException 
	{
		CustomerSelectCustomerPage objSelectCustomer = objCloudCustomerLogin.loginToCustomerSectionCloud((objExcel.getExcelData(1, 1, "CustomerServiceDeskPage")), objExcel.getExcelData(1, 2, "CustomerServiceDeskPage"));
		CustomerDashboardPage objCustomerDashboard= objSelectCustomer.selectCustomerFromListOfCustomers(objExcel.getExcelData(1, 3, "CustomerServiceDeskPage"));
		objCustomerDashboard.closeActiveRibbonOnDashboard();
		CustomerServiceDeskPage objServiceDesk= objCustomerDashboard.navigateToServiceDeskPage();
		Assert.assertTrue(objServiceDesk.verifyCreateNewTicket(), "Ticket Not Created Successfully");
	}
	
}

