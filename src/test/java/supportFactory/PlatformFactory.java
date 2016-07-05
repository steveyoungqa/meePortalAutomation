package supportFactory;

import enums.Platform;
import testRunner.TestRunner;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PlatformFactory {

	public static Platform platform;

	static Platform desiredPlatform() {

		return Platform.valueOf(TestRunner.config.get("platform"));
	}

	public static Boolean isDesktop() {

		switch (desiredPlatform()) {
			case iOS:
				return false;
			case Android:
				return false;
			default:
				return true;
		}
	}


	public static DesiredCapabilities selectPlatform(DesiredCapabilities caps) {

		switch (desiredPlatform()) {
			case Android:
				caps.setCapability("platform", "ANDROID");
				caps.setCapability("deviceOrientation", "landscape");
				break;
			case OSX:
				caps.setCapability("os", "OS X");
				caps.setPlatform(org.openqa.selenium.Platform.MAC);
				break;
			case OSX10_11:
				caps.setCapability("os", "OS X");
				caps.setCapability("os_version", "El Capitan");
				caps.setPlatform(org.openqa.selenium.Platform.MAC);
				break;
			case OSX10_10:
				caps.setCapability("os", "OS X");
				caps.setCapability("os_version", "Yosemite");
				caps.setPlatform(org.openqa.selenium.Platform.YOSEMITE);
				break;
			case OSX10_6:
				caps.setCapability("os", "OS X");
				caps.setCapability("os_version", "Snow Leopard");
				caps.setPlatform(org.openqa.selenium.Platform.SNOW_LEOPARD);
				break;
			case OSX10_7:
				caps.setCapability("os", "OS X");
				caps.setCapability("os_version", "Lion");
				caps.setPlatform(org.openqa.selenium.Platform.MAC);
				break;
			case OSX10_8:
				caps.setCapability("os", "OS X");
				caps.setCapability("os_version", "Mountain Lion");
				caps.setPlatform(org.openqa.selenium.Platform.MOUNTAIN_LION);
				break;
			case OSX10_9:
				caps.setCapability("os", "OS X");
				caps.setCapability("os_version", "Mavericks");
				caps.setPlatform(org.openqa.selenium.Platform.MAVERICKS);
				break;
			case Windows:
				caps.setCapability("os", "Windows");
				caps.setPlatform(org.openqa.selenium.Platform.WINDOWS);
				break;
			case Windows10:
				caps.setCapability("os", "Windows");
				caps.setCapability("os_version", "10");
				caps.setPlatform(org.openqa.selenium.Platform.WINDOWS);
				break;
			case Windows7:
				caps.setCapability("os", "Windows");
				caps.setCapability("os_version", "7");
				caps.setPlatform(org.openqa.selenium.Platform.VISTA);
				break;
			case Windows8:
				caps.setCapability("os", "Windows");
				caps.setCapability("os_version", "8");
				caps.setPlatform(org.openqa.selenium.Platform.WIN8);
				break;
			case Windows8_1:
				caps.setCapability("os", "Windows");
				caps.setCapability("os_version", "8.1");
				caps.setPlatform(org.openqa.selenium.Platform.WIN8_1);
				break;
			case WindowsXP:
				caps.setCapability("os", "Windows");
				caps.setCapability("os_version", "XP");
				caps.setPlatform(org.openqa.selenium.Platform.XP);
				break;
			case iOS:
				caps.setCapability("platform", "MAC");
				caps.setCapability("deviceOrientation", "landscape");
				break;
			case Ubuntu14_04:
				caps.setCapability("os", "Ubuntu");
				caps.setCapability("os_version", "14.04");
				caps.setPlatform(org.openqa.selenium.Platform.LINUX);
				break;
			default:
				throw new WebDriverException("No platform specified");
		}

		platform = desiredPlatform();

		return caps;
	}


}
