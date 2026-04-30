package com.utility;

import java.time.Duration;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	
	private final WebDriverWait wait;
	private static final int TIMEOUT = 15;
	
	public WaitUtils(WebDriver driver) {
		wait = new WebDriverWait(driver,Duration.ofSeconds(TIMEOUT));
	}
	
	public WebElement forVisible(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));	
	}
	
	public WebElement forClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void forUrl(String urlFragment) {
		wait.until(ExpectedConditions.urlContains(urlFragment));
	}
	
	public boolean forInvisibility(WebElement element) {
		return wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	
//	// Fluent Wait - polls every 500ms, ignores stale element 
//	public WebElement forStable(WebElement element) {
//		return new FluentWait<>(element)
//				.withTimeout(Duration.ofSeconds(TIMEOUT))
//				.pollingEvery(Duration.ofMillis(500))
//				.ignoring(StaleElementReferenceException.class)
//				.until(WebElement::isDisplayed,element);
//	}
	
		public WebElement forStable(WebElement element) {
	    return new FluentWait<>(element)
	            .withTimeout(Duration.ofSeconds(TIMEOUT))
	            .pollingEvery(Duration.ofMillis(500))
	            .ignoring(StaleElementReferenceException.class)
	            .until(e -> e.isDisplayed() ? e : null);
	}
	
		
	

}
