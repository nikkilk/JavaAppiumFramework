package com.qa.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AndroidBase extends TestBase {
	public static UiAutomator2Options option;


	public static void appiumConfigure() {
		try {
			input = new FileInputStream("./src/main/java/com/qa/Config/AndroidConfig.properties");
			prop.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String device = prop.getProperty("Device");
/*		if(device.equalsIgnoreCase("emulator")) {
			startEmulator();
		}
*/		option = new UiAutomator2Options();
		option.setDeviceName(prop.getProperty("DeviceName"));
		option.setApp(new File(prop.getProperty("AppPath")).getAbsolutePath());
		try {
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), option);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}

	public static void startEmulator() {
		try {
			Runtime.getRuntime().exec("./src/main/resources/StartEmulator.bat");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
