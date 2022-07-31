package com.progressive.reporting;

import java.util.logging.Level;

import java.util.logging.Logger;

import org.testng.Reporter;

public class Loggers {

	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public static void getLog(String msg) {
		// Java console Log
		LOGGER.log(Level.INFO, msg);
		// TestNG Reporter Log
		Reporter.log(msg + "<br>");

	}

}
