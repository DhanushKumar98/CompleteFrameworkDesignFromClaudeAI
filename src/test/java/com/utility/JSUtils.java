package com.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSUtils {
	
	 public static void jsClick(WebDriver driver, WebElement element) {

	        if (element == null) {
	            throw new RuntimeException("Element is null - cannot perform JS click");
	        }

	        JavascriptExecutor js = (JavascriptExecutor) driver;

	        // Scroll into view first
	        js.executeScript("arguments[0].scrollIntoView(true);", element);

	        // Click using JS
	        js.executeScript("arguments[0].click();", element);
	    }

}
