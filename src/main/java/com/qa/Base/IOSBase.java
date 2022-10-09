package com.qa.Base;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

public class IOSBase extends TestBase {
	public static XCUITestOptions option;
	
	public static void appiumConfigure() {
		try {
			input = new FileInputStream("/src/main/java/com/qa/Config/IOSConfig.properties");
			prop.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		option = new XCUITestOptions();
		option.setDeviceName(prop.getProperty("DeviceName"));
		option.setApp(prop.getProperty("AppPath"));
		option.setPlatformVersion(prop.getProperty("PlatfoemVersion"));
		option.setWdaLaunchTimeout(Duration.ofSeconds(20));
		
		String device = prop.getProperty("Device");
		if(device.equalsIgnoreCase("real")) {
			option.setCapability("xcodeOrgId","xxxxxxxx");
			option.setCapability("xcodeSigningId","iPhone Developer");
			option.setCapability("udid","xxxxxxxx");
			option.setCapability("updateWDABundleId","xxxxxxx");
		}
		try {
			driver = new IOSDriver(new URL("http://127.0.0.1:4723"), option);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

}
