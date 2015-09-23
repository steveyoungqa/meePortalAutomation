package factory;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import enums.Browser;

public class BrowserFactory {

	public static Platform systemPropertyPlatform;
		
	@SuppressWarnings("incomplete-switch")
	public DesiredCapabilities setBrowser(Browser browser) {
		systemPropertyPlatform = Platform.valueOf(System.getProperty("automation.platform", "WIN8_1"));
		System.out.println(systemPropertyPlatform.toString());
		DesiredCapabilities capabilities = new DesiredCapabilities();
		switch (browser) {
		case mee:
			capabilities = DesiredCapabilities.chrome();
			capabilities.setVersion("mee");
			if (systemPropertyPlatform.toString().equals("MAC")) {
				Map<String, Object> chromeOptions = new HashMap<String, Object>();
				chromeOptions.put("binary", "/Applications/MEE.app/Contents/MacOS/node-webkit");
				capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			}
			break;
		case chrome:
			capabilities = DesiredCapabilities.chrome();
			capabilities.setVersion("chrome");
			break;
		case firefox:
			capabilities = DesiredCapabilities.firefox();
			break;
		case safari:
			capabilities = DesiredCapabilities.safari();
			break;
		case internetexplorer:
			capabilities = DesiredCapabilities.internetExplorer();
			break;
		case android:
	         capabilities = new DesiredCapabilities();
	         capabilities.setCapability("deviceName", "Nexus 7");
	         capabilities.setCapability("automationName", "appium");
	         capabilities.setCapability("platformName", "ANDROID");
	         capabilities.setCapability("app-package", "com.macmillan.mee");
	         //TODO: get latest version of app
	         capabilities.setCapability("app", "C:\\Users\\william.pritchard\\Documents\\integration-tests\\mee\\selenium\\MEE-debug-1.1.22-testing.apk"); 
	         break;
		}
		return capabilities;
	}
}
