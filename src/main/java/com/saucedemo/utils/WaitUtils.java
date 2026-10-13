
package com.saucedemo.utils;

public class WaitUtils {

	public static void pause(long milliseconds) {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			throw new RuntimeException("Wait interrupted", e);
		}
	}
}
