package com.sat.testUtil;

import org.apache.log4j.Logger;

public class Log {



// Initialize Log4j logs
private static final Logger LOGGER = Logger.getLogger(Log.class.getName());



// This is to print log for the beginning of the test case, as we usually run so
// many test cases as a test suite
public static void startTestCase(String sTestCaseName) {



LOGGER.info("****************************************************************************************");
LOGGER.info("*************************************************************************************");
LOGGER.info("$$$$$$$$$$$$$$$$$$$$$ " + sTestCaseName + " $$$$$$$$$$$$$$$$$$$$$$$$$");
LOGGER.info("**********************************************************************************************");
LOGGER.info("*********************************************************************************");
}



// This is to print log for the ending of the test case
public static void endTestCase() {
LOGGER.info("XXXXXXXXXXXXXXXXXXXXXXX " + "-E---N---D-" + " XXXXXXXXXXXXXXXXXXXXXX");
LOGGER.info("X");
LOGGER.info("X");
LOGGER.info("X");
LOGGER.info("X");
}



// Need to create these methods, so that they can be called
public static void info(String message) {
LOGGER.info(message);
}



public static void warn(String message) {
LOGGER.warn(message);
}



public static void error(String message) {
LOGGER.error(message);
}



public static void fatal(String message) {
LOGGER.fatal(message);
}



public static void debug(String message) {
LOGGER.debug(message);
}



public static void info(Throwable cause) {




}



public static void error(String string, Throwable cause) {




}
}