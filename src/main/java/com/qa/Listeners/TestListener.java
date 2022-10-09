package com.qa.Listeners;

import static com.qa.Utils.ExtentReport.extent;
import static com.qa.Utils.ExtentReport.report;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.qa.Base.TestBase;
import com.qa.Utils.ExtentReport;
import com.qa.Utils.TestUtils;

public class TestListener extends TestBase implements ITestListener {
	static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	

	public void onStart(ITestContext context) {
		
	}

	public void onTestStart(ITestResult result) {
		// Adding System Properties in Extent Report
		String osName = System.getProperty("os.name");
		String userName = System.getProperty("user.name");
		extent = report.createTest(result.getMethod().getMethodName()).assignDevice(osName).assignAuthor(userName)
				.assignCategory(result.getTestClass().getName());

		ExtentReport.systemInfo();
		
		// Adds Test case start info in Extent Report
		test(result.getMethod().getMethodName() + " Testcase execution Started");
	}

	public void onTestSuccess(ITestResult result) {
		TestUtils.takeScreenshot("SuccessScreenshot/", result.getName());
		ExtentReport.extent.info(MarkupHelper.createLabel("TestCase " + result.getName(), ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult result) {
		TestUtils.takeScreenshot("FailureScreenshot/", result.getName());
		ExtentReport.extent.info(MarkupHelper.createLabel("TestCase " + result.getName(), ExtentColor.RED));
		ExtentReport.extent.fail(result.getName()+" Testcase FAILED due to below reason: "+result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(TestUtils.absolutePath).build());
	}

	public void onTestSkipped(ITestResult result) {
		TestUtils.takeScreenshot("SkippedScreenshot/", result.getName());
		ExtentReport.extent.info(MarkupHelper.createLabel("TestCase " + result.getName(), ExtentColor.GREY));
		ExtentReport.extent.skip(result.getName()+" Testcase SKIPPED due to below reason: "+result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(TestUtils.absolutePath).build());
	}

	public void onFinish(ITestContext context) {
		ExtentReport.report.flush();
	}

}
