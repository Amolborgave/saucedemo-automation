
package com.saucedemo.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.saucedemo.utils.WaitUtils;

public class LoginPage {

	private final WebDriver driver;
	private final WebDriverWait wait;

	private final By username = By.id("user-name");

	private final By password = By.id("password");

	private final By loginButton = By.id("login-button");

	private final By errorMessage = By.cssSelector("[data-test='error']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void enterUsername(String user) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(user);
	}

	public void enterPassword(String pass) {
		driver.findElement(password).sendKeys(pass);
	}

	public void clickLogin() {
		driver.findElement(loginButton).click();
	}

	public void login(String user, String pass) {
		WaitUtils.pause(1000);
		enterUsername(user);
		WaitUtils.pause(1000);
		enterPassword(pass);
		WaitUtils.pause(1000);
		clickLogin();
	}

	public String getErrorMessage() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
	}
}
