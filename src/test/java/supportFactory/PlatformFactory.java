package supportFactory;

import enums.Platform;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;

import webDriver.GlobalVariables;

public class PlatformFactory {
	
	public static Platform platform() {
	
		return Platform.valueOf(GlobalVariables.config.get("platform"));
	}
	
	public static DesiredCapabilities selectPlatform(DesiredCapabilities caps) {
		
		switch (platform()) {
		case Android:
			caps.setCapability("platformName", "ANDROID");
			break;
		case OSX10_10:
			caps.setCapability("os", "OS X");
			caps.setCapability("os_version", "Yosemite");
			break;
		case OSX10_6:
			caps.setCapability("os", "OS X");
			caps.setCapability("os_version", "Snow Leopard");
			break;
		case OSX10_7:
			caps.setCapability("os", "OS X");
			caps.setCapability("os_version", "Lion");
			break;
		case OSX10_8:
			caps.setCapability("os", "OS X");
			caps.setCapability("os_version", "Mountain Lion");
			break;
		case OSX10_9:
			caps.setCapability("os", "OS X");
			caps.setCapability("os_version", "Mavericks");
			break;
		case Windows10:
			// Placeholder
			throw new WebDriverException("Microsoft Windows 10 is not currently supported");
		case Windows7:
			caps.setCapability("os", "Windows");
			caps.setCapability("os_version", "7");
			break;
		case Windows8:
			caps.setCapability("os", "Windows");
			caps.setCapability("os_version", "8");
			break;
		case Windows8_1:
			caps.setCapability("os", "Windows");
			caps.setCapability("os_version", "8.1");
			break;
		case WindowsXP:
			caps.setCapability("os", "Windows");
			caps.setCapability("os_version", "XP");
			break;
		case iOS:
			caps.setCapability("platform", "MAC");
			break;
		default:
			throw new WebDriverException("No platform specified");	
		}
		
		return caps;
	}

	
}
