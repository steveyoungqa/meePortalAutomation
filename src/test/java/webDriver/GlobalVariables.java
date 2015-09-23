package webDriver;

import java.util.Set;


import cucumber.api.Scenario;

public class GlobalVariables {

	// WebDriver
	public static String seleniumHub;
	public static String mainWindowHandle;
	public static Set<String> allWindowHandles;

	// General purpose
	public static Scenario scenario;
	public static String lineBreak = System.getProperty("line.separator");
	
	// MEE Portal
	public static String currentEnvironment;
}


