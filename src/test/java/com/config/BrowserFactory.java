package com.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	
	public static WebDriver create(String browser,boolean headless) {
		return switch (browser.toLowerCase()) {
		
		case "chrome" -> chrome(headless);
		case "firefox" -> firefox(headless);
		case "edge" -> edge(headless);
		default -> throw new IllegalArgumentException("Unknown browser: "+ browser);
		
		};
	}
	
	private static WebDriver chrome(boolean headless) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opts = new ChromeOptions();
		if(headless) opts.addArguments("--headless=new","--no-sandbox","--disable-dev-shm-usage","--window-size=1920,1080");
		return new ChromeDriver(opts);
		
	}
	
	
	private static WebDriver firefox(boolean headless) {
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions opts = new FirefoxOptions();
		if(headless) opts.addArguments("--headless");
		return new FirefoxDriver(opts);
	}
	
	private static WebDriver edge(boolean headless) {
		WebDriverManager.edgedriver().setup();
		EdgeOptions opts = new EdgeOptions();
		if(headless) opts.addArguments("--headless=new");
		return new EdgeDriver(opts);
	}
	
	
	

}
