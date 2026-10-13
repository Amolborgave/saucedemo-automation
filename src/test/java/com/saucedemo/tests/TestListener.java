
package com.saucedemo.tests;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.saucedemo.utils.Log;
import com.saucedemo.utils.ScreenshotUtils;

public class TestListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		Log.info("TEST STARTED: " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Log.info("TEST PASSED: " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Log.error("TEST FAILED: " + result.getName());

		if (result.getThrowable() != null) {
			Log.error("Failure reason: " + result.getThrowable().toString());
		}

		Object instance = result.getInstance();

		if (instance instanceof BaseTest) {
			BaseTest test = (BaseTest) instance;

			if (test.driver != null) {
				ScreenshotUtils.capture(test.driver, result.getName());
			}
		}
	}
}
