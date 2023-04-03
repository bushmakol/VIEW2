package testcomponents;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import AbstractComponents.Constants;
import AbstractComponents.ExcelData;
import PageObjects.AdminCloudLoginPage;
import PageObjects.AdminCustomerAndOperatinalMessagePage;
import PageObjects.AdminDashboardPage;
import PageObjects.AdminCustomerProfilePage;
import PageObjects.CustomerAPIAndEventCataloguePage;
import PageObjects.CustomerCertificatesPage;
import PageObjects.CustomerCloudLoginPage;
import PageObjects.CustomerDashboardPage;
import PageObjects.CustomerDocumentsPage;
import PageObjects.CustomerLoginPageNonSSO;
import PageObjects.CustomerMessagesPage;
import PageObjects.CustomerMonitoringPage;
import PageObjects.CustomerPSD2ReportPage;
import PageObjects.CustomerSelectCustomerPage;
import PageObjects.CustomerServiceCataloguePage;
import PageObjects.CustomerServiceDeskPage;
import PageObjects.CustomerSlaReportPage;
import PageObjects.CustomerUserPage;
import PageObjects.CustomerWebServiceStatisticsPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	public static WebDriver driver;
	public static ExcelData objExcel;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	
	public static CustomerDashboardPage objCustomerDashboard; 
	public static CustomerSelectCustomerPage objSelectCustomer; 
	public static CustomerWebServiceStatisticsPage objWebServiceStatistic; 
	public static CustomerSlaReportPage objSlaReport;
	public static CustomerAPIAndEventCataloguePage objApiEventEngine; 
	public static CustomerLoginPageNonSSO objNonSsoCustomerLogin; 
	public static CustomerPSD2ReportPage objPSD2Report;
	public static CustomerServiceCataloguePage objServiceCatalogue; 
	public static CustomerMonitoringPage objMonitoring;
	public static CustomerMessagesPage objCustomerMessage;
	public static CustomerDocumentsPage objCustomerDocuments;
	public static CustomerCertificatesPage objCustomerCertificate;

	public static AdminCloudLoginPage objAdminLogin;
	public static CustomerCloudLoginPage objCloudCustomerLogin; 
	
	

	@Parameters({"browser","URL"})
	@BeforeMethod (alwaysRun = true)
	public void setup(String browser,String URL)
	{
		
		if (browser.equalsIgnoreCase("firefox"))
		{
//			FirefoxOptions options = new FirefoxOptions();
//			options.addArguments("--remote-allow-origins=*");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}
//		else if (browser.equalsIgnoreCase("chrome"))
//		{
//			ChromeOptions options = new ChromeOptions(); 
//			options.addArguments("--remote-allow-origins=*");
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver(options);
//		}
		else if (browser.contains("chrome"))
		{
			ChromeOptions options = new ChromeOptions(); 
			options.addArguments("--remote-allow-origins=*");
			if(browser.contains("headless"))
			{
				options.addArguments("headless");
			}
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			if(browser.contains("headless"))
			{
				driver.manage().window().setSize(new Dimension(1440,900));
			}
		}
		else if (browser.equalsIgnoreCase("edgeChromium"))
		{
			WebDriverManager.chromiumdriver().setup();
			driver = new EdgeDriver();
			
//			ChromeOptions chromeOptions = new ChromeOptions();
//			chromeOptions.setBinary(Constants.edgeChromiumDriverPath);
//			EdgeOptions edgeOptions = new EdgeOptions().merge(chromeOptions);
//			System.setProperty("webdriver.ie.driver",Constants.edgeChromiumDriverPath);
//			driver = new EdgeDriver(edgeOptions);
		}
		
		
		objExcel = new ExcelData();

		objCloudCustomerLogin = new CustomerCloudLoginPage(driver);
		objCustomerDashboard = new CustomerDashboardPage(driver);
		objSelectCustomer = new CustomerSelectCustomerPage(driver);
		objWebServiceStatistic = new CustomerWebServiceStatisticsPage(driver);
		objSlaReport = new CustomerSlaReportPage(driver);
		objNonSsoCustomerLogin = new CustomerLoginPageNonSSO(driver);
		objServiceCatalogue = new CustomerServiceCataloguePage(driver);
		objApiEventEngine = new CustomerAPIAndEventCataloguePage(driver);
		objMonitoring = new CustomerMonitoringPage(driver);
		objCustomerMessage = new CustomerMessagesPage(driver);
		objCustomerDocuments = new CustomerDocumentsPage(driver);
		objCustomerCertificate = new CustomerCertificatesPage(driver);

		objAdminLogin = new AdminCloudLoginPage(driver);
		
		
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		
	}


	@AfterSuite(alwaysRun = true)
	public void terminateTest()
	{
		//extent.flush();
		driver.quit();

	}

	@AfterMethod (alwaysRun = true)
	public void getResults(ITestResult result) throws IOException
	{

		try {
			if(driver.getCurrentUrl()!=null)
			{
				
				if (driver.findElements(By.id("manageLogout")).size()>0)
				{
					//customer section logout
					CustomerDashboardPage.customerDashboardLogOutButton.click();
				}
				else
				{
					//admin section logout
					AdminDashboardPage.adminDashboardPageLogOut.click();
				}
			}
		} catch (Exception e) 
		{
		}
		driver.close();
	}
	
	public String takeScreenShot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot screenShot = (TakesScreenshot)driver;
		File source = screenShot.getScreenshotAs(OutputType.FILE);
		File dest = new File (System.getProperty("user.dir")+"//ExtentReports//screenshots//"+ testCaseName+".png");
		FileUtils.copyFile(source, dest);
		return System.getProperty("user.dir")+"//ExtentReports//screenshots//"+testCaseName+".png";
	}
	
	
}
