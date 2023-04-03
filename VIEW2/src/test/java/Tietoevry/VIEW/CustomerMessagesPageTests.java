package Tietoevry.VIEW;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AbstractComponents.Constants;
import PageObjects.CustomerAPIAndEventCataloguePage;
import PageObjects.CustomerDashboardPage;
import PageObjects.CustomerMessagesPage;
import PageObjects.CustomerSelectCustomerPage;
import testcomponents.BaseTest;

public class CustomerMessagesPageTests extends BaseTest
{

	@Parameters({"browser"})
	@Test(priority=1,enabled= true, groups= {"smoke","regression"})
	public void test_Verify_Customer_Message_Page_Opens_Correctly() throws EncryptedDocumentException, InterruptedException, IOException 
	{

		CustomerSelectCustomerPage objSelectCustomer = objCloudCustomerLogin.loginToCustomerSectionCloud((objExcel.getExcelData(1, 1, "CustomerMessagePage")), objExcel.getExcelData(1, 2, "CustomerMessagePage"));
		CustomerDashboardPage objCustomerDashboard= objSelectCustomer.selectCustomerFromListOfCustomers(objExcel.getExcelData(1, 3, "CustomerMessagePage"));
		objCustomerDashboard.closeActiveRibbonOnDashboard();
		CustomerMessagesPage objMessagese = objCustomerDashboard.navigateToMessagesPage();
		Assert.assertTrue(objMessagese.verifyMessagePageDisplayedProperly(), "Message Page Not Displayed Properly");
	}

}

