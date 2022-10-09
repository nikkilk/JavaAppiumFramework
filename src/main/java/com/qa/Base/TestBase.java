package com.qa.Base;

import java.io.FileInputStream;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.yaml.snakeyaml.Yaml;

import com.qa.Utils.ExtentReport;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class TestBase {
	public static AppiumDriver driver;
	public static AppiumDriverLocalService service;
	public static Properties prop = new Properties();
	public static FileInputStream input;
	public static Yaml yaml = new Yaml();
	public static Map<String, Object> yamlMap;
	public static final Logger log = LogManager.getLogger(TestBase.class.getName());
	public static String name;
	public static String version;
	
	
	private void selectDriver() {
		try {
			input = new FileInputStream("./src/main/java/com/qa/Config/Config.properties");
			prop.load(input);
		} catch (Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
		String platform = prop.getProperty("Platform");
		if(platform.equalsIgnoreCase("android")) {
			AndroidBase.appiumConfigure();
		} else if(platform.equalsIgnoreCase("ios")) {
			IOSBase.appiumConfigure();
		}
		
//		AppiumDriver edriver = (AppiumDriver) new EventFiringDecorator(new WebEventListener()).decorate(driver);
//		 driver = edriver;
	}
	
	@BeforeSuite
	public void configPropReader() {
		selectDriver();
		ExtentReport.extentReport();
		
	}
	
	private void startAppiumServer() {
/*		try {
			Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
		service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users/nikki/.appium/node_modules/appium/build/lib/main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
*/	}
	
	
	@BeforeClass
	public void init() {
		startAppiumServer();
		
	}
	
	public static void test(String data) {
//		ExtentReport.extent.info(data);
		System.out.println(data);
		Reporter.log(data);
		log.info(data);
	}
	
	
	
	@AfterClass(alwaysRun =true)
	public void tearDown() {
		driver.quit();
		service.stop();
	}
	
	

}
