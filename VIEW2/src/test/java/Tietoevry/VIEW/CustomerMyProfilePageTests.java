package Tietoevry.VIEW;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.CustomerDashboardPage;
import PageObjects.CustomerMyProfilePage;
import PageObjects.CustomerSelectCustomerPage;
import testcomponents.BaseTest;

public class CustomerMyProfilePageTests extends BaseTest
{

	@Parameters({"browser"})
	@Test(priority=1,enabled= true, groups= {"smoke","regression"})
	public void test_Verify_Customer_MyProfile_Page_Opens_Correctly() throws EncryptedDocumentException, InterruptedException, IOException 
	{

		CustomerSelectCustomerPage objSelectCustomer = objCloudCustomerLogin.loginToCustomerSectionCloud((objExcel.getExcelData(1, 1, "CustomerMyProfilePage")), objExcel.getExcelData(1, 2, "CustomerMyProfilePage"));
		CustomerDashboardPage objCustomerDashboard= objSelectCustomer.selectCustomerFromListOfCustomers(objExcel.getExcelData(1, 3, "CustomerMyProfilePage"));
		objCustomerDashboard.closeActiveRibbonOnDashboard();
		CustomerMyProfilePage objMyProfile =objCustomerDashboard.navigateToMyProfilePage();
		Assert.assertTrue(objMyProfile.verifyMyProfilePageDisplayedProperly(objExcel.getExcelData(1, 1, "CustomerMyProfilePage")), "My Profile Page Not Displayed Properly");
	}

}

