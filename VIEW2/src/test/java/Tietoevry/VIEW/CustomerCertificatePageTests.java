package Tietoevry.VIEW;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AbstractComponents.Constants;
import PageObjects.CustomerCertificatesPage;
import PageObjects.CustomerDashboardPage;
import PageObjects.CustomerSelectCustomerPage;
import PageObjects.CustomerServiceDeskPage;
import testcomponents.BaseTest;

public class CustomerCertificatePageTests extends BaseTest
{

	@Parameters({"browser"})
	@Test(priority=1,enabled= true, groups= {"smoke","regression"})
	public void test_Verify_Customer_Certificate_Page_Displayed_Properly() throws EncryptedDocumentException, InterruptedException, IOException 
	{
		CustomerSelectCustomerPage objSelectCustomer = objCloudCustomerLogin.loginToCustomerSectionCloud((objExcel.getExcelData(1, 1, "CustomerCertificatePage")), objExcel.getExcelData(1, 2, "CustomerCertificatePage"));
		CustomerDashboardPage objCustomerDashboard= objSelectCustomer.selectCustomerFromListOfCustomers(objExcel.getExcelData(1, 3, "CustomerCertificatePage"));
		objCustomerDashboard.closeActiveRibbonOnDashboard();
		CustomerCertificatesPage objCustomerCertificates= objCustomerDashboard.navigateToCertificatePage();
		Assert.assertTrue(objCustomerCertificates.verifyCertificatePageDisplayedProperly(), "Certificate Page Not Displayed Properly");
	}

}

