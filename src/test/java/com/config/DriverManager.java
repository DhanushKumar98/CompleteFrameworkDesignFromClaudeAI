package com.config;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	// ThreadLocal ensure each thread owns its own WebDriver

	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static void initDriver() {
		if (driver.get() == null) {
			driver.set(BrowserFactory.create(ConfigReader.get("browser"), ConfigReader.getBool("headless")));
		}
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}

	// Must be Called in @AfterMethod to prevent memory leaks
	public static void quit() {
		if (driver.get() != null) {
			driver.get().quit();
			driver.remove(); // Create - remove from thread pool
		}
	}
}
