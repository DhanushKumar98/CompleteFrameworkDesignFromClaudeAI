package com.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.HomePage;
import com.pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test(groups = { "smoke", "regression" }, priority = -1)
	public void validLoginRedirectsToHome() {

		LoginPage login = new LoginPage(driver);

		HomePage home = login.loginValid("standard_user", "secret_sauce");

		Assert.assertTrue(home.isDisplayed(), "Home page should load after valid login");
	}

	@Test(groups = { "regression" }, dataProvider = "invalidCreds")
	public void invalidLoginShowsError(String user, String pass) {

		LoginPage login = new LoginPage(driver);

		login.loginInvalid(user, pass);

		Assert.assertTrue(login.isErrorVisible(), "Error message should appear for invalid credentials");
	}

	@DataProvider(name = "invalidCreds")
	public Object[][] invalidCreds() {
		return new Object[][] { 
			{ "wrong@test.com", "Secret123" }, 
			{ "standard_user", "wrongpass" }, 
			{ "", "" } };
	}
}
