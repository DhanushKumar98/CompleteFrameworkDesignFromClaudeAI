package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.base.BasePage;

public class HomePage extends BasePage {

	@FindBy(xpath = "//span[contains(text(),'Products')]")
	private WebElement ProductsTitle;

	@FindBy(css = "#react-burger-menu-btn")
	private WebElement menuBtn;

	@FindBy(id = "logout_sidebar_link")
	private WebElement logOutBtn;

	public HomePage(WebDriver driver) {
		super(driver);

	}

	public boolean isDisplayed() {
		return wait.forVisible(ProductsTitle).isDisplayed();
	}

	public LoginPage logout() {
		click(menuBtn);
		click(logOutBtn);
		return new LoginPage(driver);
	}
	

}
