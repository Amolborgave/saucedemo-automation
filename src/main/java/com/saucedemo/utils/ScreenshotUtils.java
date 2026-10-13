
package com.saucedemo.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

	public static String capture(WebDriver driver, String testName) {

		try {
			Path folder = Paths.get("test-output", "screenshots");
			Files.createDirectories(folder);

			String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

			String safeName = testName.replaceAll("[^a-zA-Z0-9_-]", "-");

			Path destination = folder.resolve(safeName + "_" + timestamp + ".png");

			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			Files.copy(source.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);

			Log.info("Screenshot saved: " + destination);
			return destination.toString();

		} catch (IOException | RuntimeException e) {
			Log.error("Screenshot capture failed: " + e.getMessage());
			return null;
		}
	}
}
