package com.qa.Utils;

import org.testng.ITestResult;

import com.qa.Base.TestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;

public class AppiumUtils extends TestBase {
	
	public static void getDriver(ITestResult result) {
		// To obtain Android or IOS driver
				try {
					driver = (AppiumDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
				} catch (Exception e) {
					e.printStackTrace();
				} 
	}
	
	public static void preSetup(String AppPackage, String AppActivity)  {
		//Navigate to particular page
		Activity activity = new Activity(AppPackage, AppActivity);
		((StartsActivity) driver).startActivity(activity);
	}

}
