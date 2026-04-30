package com.config;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	
	//ThreadLocal ensure each thread owns its own WebDriver
	
	private static final ThreadLocal<WebDriver> t1 = new ThreadLocal<>();
	
	public static WebDriver getDriver() {
		if(t1.get() == null) {
			t1.set(BrowserFactory.create(
					ConfigReader.get("browser"),
					ConfigReader.getBool("headless")));
		}
		return t1.get();
	}
	
	//Must be Called in @AfterMethod to prevent memory leaks
	public static void quit() {
		if(t1.get() != null) {
			t1.get().quit();
			t1.remove();  // Create - remove from thread pool
		}
	}
}
