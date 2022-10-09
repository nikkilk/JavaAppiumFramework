package com.qa.Utils;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.qa.Base.TestBase;

public class ExtentReport extends TestBase {
	public static ExtentSparkReporter reporter;
	public static ExtentReports report = new ExtentReports();
	public static ExtentTest extent;

	public static ExtentReports extentReport() {
		reporter = new ExtentSparkReporter("ExtentReports/Report_" + TestUtils.getDate() + ".html");

		reporter.config().setTimeStampFormat("yyyy-MM-dd hh-mm-ss");
		reporter.config().setDocumentTitle("Appium Automation Test Report");
		reporter.config().setReportName("Appium Automation Test Report");
		reporter.config().setEncoding("UTF-8");
		reporter.config().setTheme(Theme.STANDARD);

		// Rearrange tabs order in extent report
		List<ViewName> defaultOrder = Arrays.asList(ViewName.DASHBOARD, ViewName.CATEGORY, ViewName.TEST,
				ViewName.DEVICE, ViewName.AUTHOR);
		reporter.viewConfigurer().viewOrder().as(defaultOrder);
		report.attachReporter(reporter);
		return report;
	}
	
	
	// Add browser details in Extent Report
		public static void systemInfo() {
			test("Browser Launched");
			test("Browser Name: " + name);
//			test("Browser Version: " + version);
			ExtentReport.extent.info("Browser Version: " + ((RemoteWebDriver)driver).getCapabilities().getBrowserVersion());
			test("Language: " + prop.getProperty("Language"));
			test("Login: "+prop.getProperty("LoginType"));
//			test("Navigating to: " + driver.getCurrentUrl());
		}

}
