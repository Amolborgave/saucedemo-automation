
package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test
	public void validLoginTest() {
		LoginPage loginPage = new LoginPage(driver);

		loginPage.login("standard_user", "secret_sauce");

		Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html"),
				"Login failed: inventory page was not opened.");
	}

	/*
	 * @Test public void screenshotVerificationTest() {
	 * Assert.fail("Intentional failure to test screenshot capture"); }
	 */

	@Test
	public void invalidLoginTest() {
		LoginPage loginPage = new LoginPage(driver);

		loginPage.login("wrong_user", "wrong_password");

		Assert.assertTrue(loginPage.getErrorMessage().contains("Username and password do not match"),
				"Expected invalid-login error was not displayed.");
	}
}
