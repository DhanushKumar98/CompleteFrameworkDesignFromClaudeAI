package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.utility.WaitUtils;

public class BasePage {
	
	protected WebDriver driver;
	protected WaitUtils wait;
	
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WaitUtils(driver);
		// Initialises all @FindBy fields in the subclass
		PageFactory.initElements(driver, this);
	}
	
	
	protected void click(WebElement element) {
		wait.forClickable(element).click();
	}
	
	protected void type(WebElement element, String text) {
		wait.forVisible(element);
		element.clear();
		element.sendKeys(text);
	}
	
	protected String getText(WebElement element) {
		return wait.forVisible(element).getText();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
