package testcomponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	public static ExtentReports getReportObject()
	{
		String path= System.getProperty("user.dir")+"//ExtentReports//index.html";
		  ExtentSparkReporter report  = new ExtentSparkReporter(path);
		  report.config().setReportName("Bush Test");
		  report.config().setDocumentTitle("Automation Report");
		  
		  ExtentReports extent = new ExtentReports();
		  extent.attachReporter(report);
		  extent.setSystemInfo("Tester","Bush Makol");
		  return extent;
	}

}
