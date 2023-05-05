package com.ab.utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ab.bastTest.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListenerZ extends BaseTest implements ITestListener {

	ExtentTest test;
	public static Logger logger;
	ExtentReports extent = ExtentReportCode.extentReport();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); // Thread safe

	@Override
	public void onTestStart(ITestResult result) {
		logger = Logger.getLogger("I am a logger");
		logger.info("Test Execution Started");
		PropertyConfigurator.configure("Log4jfile.properties");
		test = extent.createTest(result.getMethod().getMethodName());

		extentTest.set(test);

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Passed");
		logger.info(result.getMethod().getMethodName() + "-> Test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String ssPath = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());

		} catch (Exception e) {

			e.printStackTrace();
		}
		ssPath = getScreenShot(driver, result.getMethod().getMethodName());

		System.out.println(ssPath);
		extentTest.get().addScreenCaptureFromPath(ssPath, result.getMethod().getMethodName());
		logger.info("test Failed ..Took ScreenShot");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.get().skip(result.getThrowable());
		logger.info(result.getMethod().getMethodName() + "-> Test skipped");
	}



	@Override
	public void onFinish(ITestContext context) {

		extent.flush();
		logger.info("Result locked in the report");
	}

}
