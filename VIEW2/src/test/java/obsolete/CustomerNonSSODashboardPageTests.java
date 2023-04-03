package obsolete;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import AbstractComponents.Constants;
import testcomponents.BaseTest;

public class CustomerNonSSODashboardPageTests extends BaseTest
{

	/**
	 * 
	 * Verify Customer  Dashboard Page is displayed correctly by verifying the presence of:
	 * Customer Section Logo
	 * A brick in Dashboard
	 * Feedback Link
	 * Evry Logo In Footer
	 * 
	 */
	
	@Parameters({"browser"})
	@Test(priority=1,enabled= true, groups= {"smoke","regression","overview"})
	public void test_Verify_NonSso_CustomerDashborad_Page_Displayed_Correctly() throws EncryptedDocumentException, InterruptedException, IOException 
	{
		driver.get(Constants.viewQACloudCustomerURL);
		test= extent.createTest("test_Verify_NonSso_CustomerDashborad_Page_Displayed_Correctly");
		driver.get(Constants.viewQANonSSOCustomerURL);
		objNonSsoCustomerLogin.customerLogin((objExcel.getExcelData(1, 1, "CustomerDashboardPage")), objExcel.getExcelData(1, 2, "CustomerDashboardPage"));
		objSelectCustomer.selectCustomerFromListOfCustomers(objExcel.getExcelData(1, 3, "CustomerDashboardPage"));
		objCustomerDashboard.closeActiveRibbonOnDashboard();
		Assert.assertTrue(objCustomerDashboard.verifyCustomerdashboardPageIsDisplayed(), "CustomerDasboard is Not Displayed Properly");
	}

}

