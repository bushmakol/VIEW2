package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.lang.*;

public class CustomerDashboardPage 
{

    WebDriver driver;
    
    @FindBy(id="QACust_InnerNew")
    WebElement customerDashboardHeaderLogo;
    
    @FindBy(id="manageLogout")
     public static WebElement customerDashboardLogOutButton;

    @FindBy(id="imgTietoEvry")
    WebElement customerDashboardFooterLogo;
    
    @FindBy(id="btnFeedback")
    WebElement customerDashboardFooterFeedbackLink;
    
    @FindBy(xpath="//li[@id='1']//img")
    WebElement customerDashboardFirstBrick;
    
    @FindBy(xpath="//div[@id='notifier']//span[@data-title='Close']")
    WebElement CustomerDashBoardAlertRibbonCloseButton;
    
    @FindBy(id="notificationdiv")
    WebElement CustomerDashBoardRibbon;
    
    @FindBy(id="customerMsgLink")
    WebElement CustomerDashBoardCustomerMessageDot;
    
    @FindBy(id="fsMsgLink")
    WebElement CustomerDashBoardOperationalMessageDot;
    
    @FindBy(id="FSMsg")
    WebElement CustomerDashBoardOperationalAlertRibbonOperationalMessage;
    
    @FindBy(id="customerlMsg")
    WebElement CustomerDashBoardCustomerAlertRibbonCustomerMessage;
    
    
    public CustomerDashboardPage(WebDriver driver)
    {

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);
        
    }   
    
    
    // Method to Verify Customer Dashboard page Opened 
    public boolean verifyCustomerdashboardPageIsDisplayed()
    {
    	if(customerDashboardFirstBrick.isDisplayed()&&customerDashboardLogOutButton.isDisplayed())
    	{
    		JavascriptExecutor js = (JavascriptExecutor) driver;
    		js.executeScript("arguments[0].scrollIntoView();",customerDashboardFooterLogo );
    		if(customerDashboardFooterFeedbackLink.isDisplayed())
    		{
    			return true;
    		}
    	}
    	
    	return false;
    }
    
        
    //Method To get CustomerMessage text from Ribbon
    public String getCustomerMessageFromRibbon()
    {
    	CustomerDashBoardCustomerMessageDot.click();
    	return CustomerDashBoardCustomerAlertRibbonCustomerMessage.getText();	
    }
    
    
    //Method To get Operational Alert text from Ribbon
    public String getOperationalAlertMessageFromRibbon()
    {
    	CustomerDashBoardOperationalMessageDot.click();
    	return CustomerDashBoardOperationalAlertRibbonOperationalMessage.getText();	
    }
    
  //Method To Close  Alert Ribbon If Alert Exists
    public void closeActiveRibbonOnDashboard()
    {
    	if (driver.findElements(By.xpath("//div[@id='notifier']//span[@data-title='Close']")).size()>0)
    	{
    		CustomerDashBoardAlertRibbonCloseButton.click();
    	}
//    	try 
//    	{
//			if(CustomerDashBoardAlertRibbonCloseButton.isDisplayed())
//			{
//				CustomerDashBoardAlertRibbonCloseButton.click();
//				Thread.sleep(1000);
//			}
//		} 
//    	catch (Exception e) 
//    	{
//			
//		}
    }
    
  //Method Navigate to open a Brick/Page
    public void navigateToPage(String strBrickName)
    {
    	String strXpath="//div[@data-title='"+strBrickName+"']";
    	try 
    	{
			driver.findElement(By.xpath(strXpath)).click();
		} 
    	catch (Exception e) 
    	{
            JavascriptExecutor js = (JavascriptExecutor) driver;
        	js.executeScript("arguments[0].scrollIntoView();",customerDashboardFooterLogo );
        	driver.findElement(By.xpath(strXpath)).click();
		}
    }
    
    
  //Method Navigate to Messages Page
    public CustomerMessagesPage navigateToMessagesPage()
    {
    	String strXpath="//div[@data-title='Messages']";
		CustomerMessagesPage objMessages = new CustomerMessagesPage(driver);

    	try 
    	{
			driver.findElement(By.xpath(strXpath)).click();
			return objMessages;
		} 
    	catch (Exception e) 
    	{
            JavascriptExecutor js = (JavascriptExecutor) driver;
        	js.executeScript("arguments[0].scrollIntoView();",customerDashboardFooterLogo );
        	driver.findElement(By.xpath(strXpath)).click();
        	return objMessages;
		}
		
    }
    
  //Method Navigate to MyProfile Page
    public CustomerMyProfilePage navigateToMyProfilePage()
    {
    	String strXpath="//div[@data-title='My Profile']";
		CustomerMyProfilePage objMyProfile = new CustomerMyProfilePage(driver);

    	try 
    	{
			driver.findElement(By.xpath(strXpath)).click();
			return objMyProfile;
		} 
    	catch (Exception e) 
    	{
            JavascriptExecutor js = (JavascriptExecutor) driver;
        	js.executeScript("arguments[0].scrollIntoView();",customerDashboardFooterLogo );
        	driver.findElement(By.xpath(strXpath)).click();
        	return objMyProfile;
		}
		
    }
    
  //Method Navigate to ServiceDesk Page
    public CustomerServiceDeskPage navigateToServiceDeskPage()
    {
    	String strXpath="//div[@data-title='ServiceDesk']";
		CustomerServiceDeskPage objServiceDeskPage = new CustomerServiceDeskPage(driver);

    	try 
    	{
			driver.findElement(By.xpath(strXpath)).click();
			return objServiceDeskPage;
		} 
    	catch (Exception e) 
    	{
            JavascriptExecutor js = (JavascriptExecutor) driver;
        	js.executeScript("arguments[0].scrollIntoView();",customerDashboardFooterLogo );
        	driver.findElement(By.xpath(strXpath)).click();
        	return objServiceDeskPage;
		}
		
    }
    
  //Method Navigate to API and Event Catalogue Page
    public CustomerAPIAndEventCataloguePage navigateToAPIandEventCataloguePage()
    {
    	String strXpath="//div[@data-title='API and Event Catalogue']";
		CustomerAPIAndEventCataloguePage objAPIandEventCataloguePage = new CustomerAPIAndEventCataloguePage(driver);

    	try 
    	{
			driver.findElement(By.xpath(strXpath)).click();
			return objAPIandEventCataloguePage;
		} 
    	catch (Exception e) 
    	{
            JavascriptExecutor js = (JavascriptExecutor) driver;
        	js.executeScript("arguments[0].scrollIntoView();",customerDashboardFooterLogo );
        	driver.findElement(By.xpath(strXpath)).click();
        	return objAPIandEventCataloguePage;
		}
		
    }
    
    //Method Navigate to Documents page
    public CustomerDocumentsPage navigateToDocumentsPage()
    {
    	String strXpath="//div[@data-title='Documents']";
		CustomerDocumentsPage objDocumentsPage = new CustomerDocumentsPage(driver);

    	try 
    	{
			driver.findElement(By.xpath(strXpath)).click();
			return objDocumentsPage;
		} 
    	catch (Exception e) 
    	{
            JavascriptExecutor js = (JavascriptExecutor) driver;
        	js.executeScript("arguments[0].scrollIntoView();",customerDashboardFooterLogo );
        	driver.findElement(By.xpath(strXpath)).click();
        	return objDocumentsPage;
		}
		
    }
    
    
    //Method Navigate to SLA page
    public CustomerSlaReportPage navigateToSLAPage()
    {
    	String strXpath="//div[@data-title='SLA Report']";
		CustomerSlaReportPage objSLAPage = new CustomerSlaReportPage(driver);

    	try 
    	{
			driver.findElement(By.xpath(strXpath)).click();
			return objSLAPage;
		} 
    	catch (Exception e) 
    	{
            JavascriptExecutor js = (JavascriptExecutor) driver;
        	js.executeScript("arguments[0].scrollIntoView();",customerDashboardFooterLogo );
        	driver.findElement(By.xpath(strXpath)).click();
        	return objSLAPage;
		}
		
    }
    
    
    //Method Navigate to Web Service Statistics Page
    public CustomerWebServiceStatisticsPage navigateToWebServiceStatisticsPage()
    {
    	String strXpath="//div[@data-title='Web Service Statistics']";
		CustomerWebServiceStatisticsPage objWebServiceStatisticsPage = new CustomerWebServiceStatisticsPage(driver);

    	try 
    	{
			driver.findElement(By.xpath(strXpath)).click();
			return objWebServiceStatisticsPage;
		} 
    	catch (Exception e) 
    	{
            JavascriptExecutor js = (JavascriptExecutor) driver;
        	js.executeScript("arguments[0].scrollIntoView();",customerDashboardFooterLogo );
        	driver.findElement(By.xpath(strXpath)).click();
        	return objWebServiceStatisticsPage;
		}
    }
    
    
    //Method Navigate to Service Catalogue Page
    public CustomerServiceCataloguePage navigateToServiceCataloguePage()
    {
    	String strXpath="//div[@data-title='Service Catalogue']";
		CustomerServiceCataloguePage objServiceCataloguePage = new CustomerServiceCataloguePage(driver);

    	try 
    	{
			driver.findElement(By.xpath(strXpath)).click();
			return objServiceCataloguePage;
		} 
    	catch (Exception e) 
    	{
            JavascriptExecutor js = (JavascriptExecutor) driver;
        	js.executeScript("arguments[0].scrollIntoView();",customerDashboardFooterLogo );
        	driver.findElement(By.xpath(strXpath)).click();
        	return objServiceCataloguePage;
		}
    }
    
    
    //Method Navigate to Scorecard Page
    public CustomerScorecardPage navigateToScorecardPage()
    {
    	String strXpath="//div[@data-title='Scorecard']";
		CustomerScorecardPage objScorecardPage = new CustomerScorecardPage(driver);

    	try 
    	{
			driver.findElement(By.xpath(strXpath)).click();
			return objScorecardPage;
		} 
    	catch (Exception e) 
    	{
            JavascriptExecutor js = (JavascriptExecutor) driver;
        	js.executeScript("arguments[0].scrollIntoView();",customerDashboardFooterLogo );
        	driver.findElement(By.xpath(strXpath)).click();
        	return objScorecardPage;
		}
    }
    
  //Method Navigate to User Page
    public CustomerUserPage navigateToUserPage()
    {
    	String strXpath="//div[@data-title='Users']";
		CustomerUserPage objUserPage = new CustomerUserPage(driver);

    	try 
    	{
			driver.findElement(By.xpath(strXpath)).click();
			return objUserPage;
		} 
    	catch (Exception e) 
    	{
            JavascriptExecutor js = (JavascriptExecutor) driver;
        	js.executeScript("arguments[0].scrollIntoView();",customerDashboardFooterLogo );
        	driver.findElement(By.xpath(strXpath)).click();
        	return objUserPage;
		}
    }
    
  //Method Navigate to Certificates Page
    public CustomerCertificatesPage navigateToCertificatePage()
    {
    	String strXpath="//div[@data-title='Certificates']";
		CustomerCertificatesPage objCertificates = new CustomerCertificatesPage(driver);

    	try 
    	{
			driver.findElement(By.xpath(strXpath)).click();
			return objCertificates;
		} 
    	catch (Exception e) 
    	{
            JavascriptExecutor js = (JavascriptExecutor) driver;
        	js.executeScript("arguments[0].scrollIntoView();",customerDashboardFooterLogo );
        	driver.findElement(By.xpath(strXpath)).click();
        	return objCertificates;
		}
    }
    
    //Method Navigate to Monitoring Page
    public CustomerMonitoringPage navigateToMonitoringPage()
    {
    	String strXpath="//div[@data-title='Monitoring']";
		CustomerMonitoringPage objMonitoring = new CustomerMonitoringPage(driver);

    	try 
    	{
			driver.findElement(By.xpath(strXpath)).click();
			return objMonitoring;
		} 
    	catch (Exception e) 
    	{
            JavascriptExecutor js = (JavascriptExecutor) driver;
        	js.executeScript("arguments[0].scrollIntoView();",customerDashboardFooterLogo );
        	driver.findElement(By.xpath(strXpath)).click();
        	return objMonitoring;
		}
    }
    //Method Navigate to PSD2 Report Page
    public CustomerPSD2ReportPage navigateToPSD2ReportPage()
    {
    	String strXpath="//div[@data-title='PSD2 Report']";
		CustomerPSD2ReportPage objPSD2ReportPage = new CustomerPSD2ReportPage(driver);

    	try 
    	{
			driver.findElement(By.xpath(strXpath)).click();
			return objPSD2ReportPage;
		} 
    	catch (Exception e) 
    	{
            JavascriptExecutor js = (JavascriptExecutor) driver;
        	js.executeScript("arguments[0].scrollIntoView();",customerDashboardFooterLogo );
        	driver.findElement(By.xpath(strXpath)).click();
        	return objPSD2ReportPage;
		}
    }
    
    
    
    //Method To navigate to Customer Dashboard page
    public void navigatetoDashboardpage()
    {
    	customerDashboardHeaderLogo.click();	
    }
    
  //Method To Logout
    public void logOutFromCustomerSection() throws InterruptedException
    {
		//CommonFunctions.waitExplicitlyForElemetToBeClickable(driver,customerDashboardLogOutButton);
		Thread.sleep(2000);
    	customerDashboardLogOutButton.click();	
    }
    
}
