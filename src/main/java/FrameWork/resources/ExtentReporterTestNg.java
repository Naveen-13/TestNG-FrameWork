package FrameWork.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterTestNg {
	
	public static ExtentReports config() {
		String path  = System.getProperty("user.dir") + "//reports//index.html";  
		ExtentSparkReporter reporter =  new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation");
		reporter.config().setDocumentTitle("Test Report");
		
		ExtentReports report =  new ExtentReports();
		report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Tester", " Naveen Bhat");
		return report;
	}

}
