
package com.saucedemo.utils;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {

	private static final Logger logger = Logger.getLogger("SauceDemoAutomation");

	static {
		try {
			File folder = new File("test-output");
			if (!folder.exists() && !folder.mkdirs()) {
				throw new IOException("Could not create test-output directory");
			}

			FileHandler fileHandler = new FileHandler("test-output/automation.log", true);

			fileHandler.setFormatter(new SimpleFormatter());
			logger.addHandler(fileHandler);
			logger.setUseParentHandlers(true);

		} catch (IOException e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static void info(String message) {
		logger.info(message);
	}

	public static void error(String message) {
		logger.severe(message);
	}
}
