package com.qa.Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.Base.TestBase;

public class TestUtils extends TestBase {
	public static SimpleDateFormat sdf;
	public static String absolutePath;
	
	
	public static String getDate() {
		sdf = new SimpleDateFormat("DD-MM-YYYY-hh-mm-ss");
		String date = sdf.format(new Date());
		return date;
	}
	
	
	public static String takeScreenshot(String SubFolder, String MethodName) {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("src/main/java/com/qa/" + SubFolder + "/" + MethodName + "_" + getDate() + ".png");
		try {
			FileUtils.copyFile(srcFile, destFile);
			System.out.println("Screenshot Taken");
			return destFile.toString();
		} catch (IOException e) {
			System.out.println("Exception is "+e.getMessage());
			absolutePath = destFile.getAbsolutePath();
		}
		return MethodName;
	}

}
