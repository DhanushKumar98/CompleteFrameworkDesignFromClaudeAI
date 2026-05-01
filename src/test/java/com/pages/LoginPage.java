package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	private By loginBtn = By.id("login-button");
	
	
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
	public String getErrorMessage() {
		return errorMessage.getText();
	}
	
	public boolean isErrorVisible() {
		return errorMessage.isDisplayed();
	}
	
	
	public boolean isLoginBtnDisplayed() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		          
		 try {
			 return wait.until(
				ExpectedConditions.presenceOfElementLocated(loginBtn)
					 ).isDisplayed();
		 }catch(TimeoutException e) {
			 return false;
		 }
		 
		 
		 
	}
		
	
	
	
	
	
	

}
