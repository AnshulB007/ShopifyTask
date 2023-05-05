package com.ab.utilities;

import java.io.File;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportCode {
	
	
	public static ExtentReports extentReport(){
		
		String extentPath = System.getProperty("user.dir")+"\\testoutputs\\extent.html";
	
		File path = new File(extentPath);
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setDocumentTitle("SauceLab Test Report");
		reporter.config().setReportName("Test Report");
		
		ExtentReports extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		
	
		
		extent.setSystemInfo("Tester", "Anshul");
			return extent;
	
		
		
	}

}
