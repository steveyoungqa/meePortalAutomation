package webDriver;

import java.util.Map;
import cucumber.api.Scenario;

public class GlobalVariables {

	public static Map<String, String> config;
	
	public static String mainWindowHandle;

	// General purpose
	public static Scenario scenario;
	public static String lineBreak = System.getProperty("line.separator");
}


