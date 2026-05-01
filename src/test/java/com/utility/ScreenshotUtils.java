package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Allure;

public class ScreenshotUtils {
	
	private static final String DIR = "target/screenshots/";
	
	public static void capture(WebDriver driver, String testName) {
		
		  try {
		        String status = testName.contains("FAIL") ? "fail" : "pass";

		        String ts = LocalDateTime.now().format(
		                DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

		        String path = DIR + status + "/" + testName + "_" + ts + ".png";

		        File src = ((TakesScreenshot) driver)
		                .getScreenshotAs(OutputType.FILE);

		        File dest = new File(path);
		        dest.getParentFile().mkdirs(); // create folders

		        FileUtils.copyFile(src, dest);

		        Allure.addAttachment("Screenshot: " + testName,
		                "image/png",
		                new FileInputStream(dest),
		                ".png");

		    } catch (IOException e) {
		        System.err.println("Screenshot error: " + e.getMessage());
		    }
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		try {
//			
//			String ts = LocalDateTime.now().format(
//					DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
//			String path = DIR + testName + "_" + ts +".png";
//			
//			File src = ((TakesScreenshot)driver)
//					.getScreenshotAs(OutputType.FILE);
//			FileUtils.copyFile(src, new File(path));
//			
//			// Attach to Allure report inlin
//			Allure.addAttachment("Screenshot:","image/png",new FileInputStream(new File(path)),".png");
//		}catch(IOException e) {
//			System.err.println("Screenshot: "+e.getMessage());
//		}
	}
}
