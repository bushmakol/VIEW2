package Tietoevry.VIEW;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AbstractComponents.Constants;
import PageObjects.CustomerDashboardPage;
import PageObjects.CustomerSelectCustomerPage;
import PageObjects.CustomerUserPage;
import testcomponents.BaseTest;

public class CustomerCloudUserPageTests extends BaseTest
{


	@Parameters({"browser"})
	@Test(priority=1,enabled= true, groups= {"smoke","regression"})
	public void test_Verify_Cloud_Customer_User_Page_Displayed_Correctly() throws EncryptedDocumentException, InterruptedException, IOException 
	{
		CustomerSelectCustomerPage objSelectCustomer = objCloudCustomerLogin.loginToCustomerSectionCloud((objExcel.getExcelData(1, 1, "CustomerUserPage")), objExcel.getExcelData(1, 2, "CustomerUserPage"));
		CustomerDashboardPage objCustomerDashboard= objSelectCustomer.selectCustomerFromListOfCustomers(objExcel.getExcelData(1, 3, "CustomerUserPage"));
		objCustomerDashboard.closeActiveRibbonOnDashboard();
		CustomerUserPage objCustomerUserPage= objCustomerDashboard.navigateToUserPage();
		Assert.assertTrue(objCustomerUserPage.verifyUserPageDisplayedProperly(),"User Page not dispalyed properly");
	}
	
	@Parameters({"browser"})
	@Test(priority=1,enabled= true, groups= {"regression"},dependsOnMethods ="test_Verify_Cloud_Customer_User_Page_Displayed_Correctly" )
	public void test_Verify_Cloud_Customer_User_Page_Create_New_User() throws EncryptedDocumentException, InterruptedException, IOException 
	{
		CustomerSelectCustomerPage objSelectCustomer = objCloudCustomerLogin.loginToCustomerSectionCloud((objExcel.getExcelData(1, 1, "CustomerUserPage")), objExcel.getExcelData(1, 2, "CustomerUserPage"));
		CustomerDashboardPage objCustomerDashboard= objSelectCustomer.selectCustomerFromListOfCustomers(objExcel.getExcelData(1, 3, "CustomerUserPage"));
		objCustomerDashboard.closeActiveRibbonOnDashboard();
		CustomerUserPage objCustomerUserPage= objCustomerDashboard.navigateToUserPage();
		Assert.assertTrue(objCustomerUserPage.verifyCreateANewUserAndDeactivateTheUser(),"Issue in User page");
	}

}

