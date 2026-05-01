package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BasePage;
import com.utility.JSUtils;

public class HomePage extends BasePage {

	@FindBy(xpath = "//span[contains(text(),'Products')]")
	private WebElement ProductsTitle;

	@FindBy(css = "#react-burger-menu-btn")
	private WebElement menuBtn;

	@FindBy(xpath = "//a[contains(.,'Logout')]")
	private WebElement logOutBtn;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public boolean isDisplayed() {
		return wait.forVisible(ProductsTitle).isDisplayed();
	}

	public LoginPage logout() {
		click(menuBtn);
		
		new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.visibilityOf(logOutBtn));
		
		JSUtils.jsClick(driver,logOutBtn);
		
		//driver.navigate().refresh();
		
		new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.urlContains("saucedemo"));
		
		return new LoginPage(driver);
	}
	
}
