package com.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.HomePage;
import com.pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test(groups = { "smoke", "regression" }, priority = -1)
	public void validLoginRedirectsToHome() throws InterruptedException {

		LoginPage login = new LoginPage(driver);

		HomePage home = login.loginValid("standard_user", "secret_sauce");

		Assert.assertTrue(home.isDisplayed(), "Home page should load after valid login");
		
		// Execute Logout here
		LoginPage loginPage = home.logout();
		
		
		// Optional Validate after logout
		Assert.assertTrue(loginPage.isLoginBtnDisplayed(), "User should be redirected to login page after logout");
		
		
		
	}

	@Test(groups = { "regression" }, dataProvider = "invalidCreds")
	public void invalidLoginShowsError(String user, String pass,String expectedError) {

		LoginPage login = new LoginPage(driver);

		login.loginInvalid(user, pass);

		Assert.assertTrue(login.isErrorVisible(), "Error message should appear");
		Assert.assertEquals(login.getErrorMessage(),expectedError,"Error message mismatch");
	}

	@DataProvider(name = "invalidCreds")
	public Object[][] invalidCreds() {
		return new Object[][] { 
			
			// username , password ,expectedError
			
			{ "wrong@test.com", "Secret123",
			"Epic sadface: Username and password do not match any user in this service" }, 
			{ "standard_user", "wrongpass",
			"Epic sadface: Username and password do not match any user in this service" }, 
			{ "", "",
			"Epic sadface: Username is required" } };
	}
}
