package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.base.BasePage;

public class LoginPage extends BasePage{
	
	//@FindBy - PageFactory injects these automatically in BasePage
	@FindBy(id = "user-name")
	private WebElement usernameField;
	
	@FindBy(id = "password")
	private WebElement passwordField;
	
	@FindBy(css = "#login-button")
	private WebElement loginButton;
	
	@FindBy(xpath = "//h3[contains(.,'Epic sadface:')]")
	private WebElement errorMessage;
	
	
	public LoginPage(WebDriver driver) {
		super(driver);    // calls PageFactory.initElements
	}
	
	
	public HomePage loginValid(String user, String pass) {
	    type(usernameField, user);
	    type(passwordField, pass);
	    click(loginButton);
	    return new HomePage(driver);
	}
	
	public LoginPage loginInvalid(String user, String pass) {
	    type(usernameField, user);
	    type(passwordField, pass);
	    click(loginButton);
	    return this;
	    
	}
	
	// Safe check (Important)
	public boolean getErrorVisible() {
		return driver.findElements(By.cssSelector("h3[data-test='error']")
				).size() > 0;
	}
	
	public boolean isErrorVisible() {
		try {
		return errorMessage.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	
	
	
	
	
	

}
