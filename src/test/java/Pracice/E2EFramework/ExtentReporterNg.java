package Pracice.E2EFramework;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNg {
public static ExtentReports extent;
	
	
	public static ExtentReports getReport() {
		
		String path=System.getProperty("user.dir")+"\\Reports\\Extent.html";
		 ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Test Report");
		reporter.config().setDocumentTitle("Extent Test Report");
		extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester Name", "Ashvin Gajera");
		
		
		return extent;

}
}