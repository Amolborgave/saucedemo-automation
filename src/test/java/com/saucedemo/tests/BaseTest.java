package com.saucedemo.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.saucedemo.utils.ConfigReader;
import com.saucedemo.utils.Log;

public class BaseTest {

	protected WebDriver driver;

	@BeforeMethod
	public void setUp() {
		Log.info("Starting browser");

		driver = new ChromeDriver();
		driver.manage().window().maximize();

		String url = ConfigReader.getProperty("baseUrl");
		driver.get(url);

		Log.info("Opened website: " + url);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			Log.info("Closing browser");
			driver.quit();
		}
	}
}