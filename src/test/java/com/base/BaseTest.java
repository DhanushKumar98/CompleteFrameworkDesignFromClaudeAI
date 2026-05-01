package com.base;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.Listeners.TestListener;
import com.config.ConfigReader;
import com.config.DriverManager;



@Listeners(TestListener.class)
public class BaseTest {
	
	// Explore driver for page object and test classes
	protected WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		DriverManager.initDriver();  // MUST BE FIRST
		
		driver = DriverManager.getDriver();
		
		driver.manage().window().maximize();
		driver.get(ConfigReader.get("base.url"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		// Always quit to free browser process and clear ThrealLocal
		DriverManager.quit();
	}
}
