package supportMethods;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;

import webDriver.GlobalVariables;

public class BrowserStack {
	public static Boolean useBrowserStack() {
		
		return Boolean.valueOf(GlobalVariables.config.get("useBrowserstack"));
	}
	
	public static void setSeleniumHub() {
		
		String browserstackUsername = System.getProperty("browserstackUsername", GlobalVariables.config.get("browserstackUsername"));
		
		if (browserstackUsername == null) {
			throw new WebDriverException("System property for browserstackUsername not set.");
		}
		
		String browserstackPassword = System.getProperty("browserstackPassword", GlobalVariables.config.get("browserstackPassword"));
		
		if (browserstackPassword == null) {
			throw new WebDriverException("System property for browserstackPassword not set.");
		}
		
		GlobalVariables.config.put("seleniumHub", "http://" + browserstackUsername + ":" + browserstackPassword + "@hub.browserstack.com/wd/hub");
	}
	
	public static DesiredCapabilities setBrowserCapabilities() {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		
		caps.setCapability("browserstack.local", "true");
		caps.setCapability("browserstack.debug", "true");
		caps.setCapability("resolution", System.getProperty("browserstackResolution", GlobalVariables.config.get("browserstackResolution")));
		
		return caps;
	}
	
	public static DesiredCapabilities setProjectDetails() {
		
		String project = System.getProperty("project", "Default Project Name");
		String build = System.getProperty("build", "Default Project Version");
		
		DesiredCapabilities caps = new DesiredCapabilities();
		
		caps.setCapability("project", project);
		caps.setCapability("build", build);
		
		return caps;
	}
}
