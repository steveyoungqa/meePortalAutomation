package supportFactory;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;

import enums.Browser;
import webDriver.GlobalVariables;

public class BrowserFactory {
	
	public static Browser browser() {
		
		return Browser.valueOf(GlobalVariables.config.get("browser"));
	}

	public static DesiredCapabilities selectBrowser(DesiredCapabilities caps) {
		
		switch (browser()) {
		case AmazonKindleFire2:
			caps.setCapability("browserName", "android");
			caps.setCapability("device", "Amazon Kindle Fire 2");
			break;
		case AmazonKindleFireHD8_9:
			caps.setCapability("browserName", "android");
			caps.setCapability("device", "Amazon Kindle Fire HD 8.9");
			break;
		case AmazonKindleFireHDX7:
			caps.setCapability("browserName", "android");
			caps.setCapability("device", "Amazon Kindle Fire HDX 7");
			break;
		case Chrome46:
			caps.setCapability("browserName", "chrome");
			caps.setCapability("version", "46.0");
			break;
		case Chrome:
			caps.setCapability("browserName", "chrome");
			break;
		case Chrome45:
			caps.setCapability("browserName", "chrome");
			caps.setCapability("version", "45.0");
			break;
		case Chrome44:
			caps.setCapability("browserName", "chrome");
			caps.setCapability("version", "44.0");
			break;
		case Edge:
			caps.setCapability("browser", "Edge");
			caps.setCapability("version", "12.0");
			caps.setCapability("browserstack.ie.enablePopups", "true");
			break;
		case Firefox:
			 caps.setCapability("browserName", "firefox");
			break;
		case GoogleNexus4:
			caps.setCapability("browserName", "android");
			caps.setCapability("device", "Google Nexus 4");
			break;
		case GoogleNexus5:
			caps.setCapability("browserName", "android");
			caps.setCapability("device", "Google Nexus 5");
			break;
		case GoogleNexus7:
			caps.setCapability("browserName", "android");
			caps.setCapability("device", "Google Nexus 7");
			break;
		case HTCOneM8:
			caps.setCapability("browserName", "android");
			caps.setCapability("device", "HTC One M8");
			break;
		case HTCOneX:
			caps.setCapability("browserName", "android");
			caps.setCapability("device", "HTC One X");
			break;
		case IE10:
			caps.setCapability("browserName", "internet explorer");
			caps.setCapability("version", "10.0");
			caps.setCapability("browserstack.ie.enablePopups", "true");
			break;
		case IE11:
			caps.setCapability("browserName", "internet explorer");
			caps.setCapability("version", "11.0");
			caps.setCapability("browserstack.ie.enablePopups", "true");
			break;
		case IE8:
			caps.setCapability("browserName", "internet explorer");
			caps.setCapability("version", "8.0");
			caps.setCapability("browserstack.ie.enablePopups", "true");
			break;
		case IE9:
			caps.setCapability("browserName", "internet explorer");
			caps.setCapability("version", "9.0");
			caps.setCapability("browserstack.ie.enablePopups", "true");
			break;
		case MotorolaRazr:
			caps.setCapability("browserName", "android");
			caps.setCapability("device", "Motorola Razr");
			break;
		case MotorolaRazrMaxxHD:
			caps.setCapability("browserName", "android");
			caps.setCapability("device", "Motorola Razr Maxx HD");
			break;
		case Opera12_15:
			caps.setCapability("browserName", "opera");
			caps.setCapability("version", "12.15");
			break;
		case Opera12_16:
			caps.setCapability("browserName", "opera");
			caps.setCapability("version", "12.16");
			break;
		case Safari5_1:
			caps.setCapability("browserName", "safari");
			caps.setCapability("version", "5.1");
			break;
		case Safari6:
			caps.setCapability("browserName", "safari");
			caps.setCapability("version", "6.0");
			break;
		case Safari6_2:
			caps.setCapability("browserName", "safari");
			caps.setCapability("version", "6.2");
			break;
		case Safari7_1:
			caps.setCapability("browserName", "safari");
			caps.setCapability("version", "7.1");
			break;
		case Safari8:
			caps.setCapability("browserName", "safari");
			caps.setCapability("version", "8.0");
			break;
		case Safari9:
			caps.setCapability("browserName", "safari");
			caps.setCapability("version", "9.0");
			break;
		case SamsungGalaxyNote10_1:
			caps.setCapability("browserName", "android");
			caps.setCapability("device", "Samsung Galaxy Tab 4 10.1");
			break;
		case SamsungGalaxyNote2:
			caps.setCapability("browserName", "android");
			caps.setCapability("device", "Samsung Galaxy Note 2");
			break;
		case SamsungGalaxyNote3:
			caps.setCapability("browserName", "android");
			caps.setCapability("device", "Samsung Galaxy Note 3");
			break;
		case SamsungGalaxyS3:
			caps.setCapability("browserName", "android");
			caps.setCapability("device", "Samsung Galaxy S3");
			break;
		case SamsungGalaxyS4:
			caps.setCapability("browserName", "android");
			caps.setCapability("device", "Samsung Galaxy S4");
			break;
		case SamsungGalaxyS5:
			caps.setCapability("browserName", "android");
			caps.setCapability("device", "Samsung Galaxy S5");
			break;
		case SamsungGalaxyS5Mini:
			caps.setCapability("browserName", "android");
			caps.setCapability("device", "Samsung Galaxy S5 Mini");
			break;
		case SamsungGalaxyTab3:
			caps.setCapability("browserName", "android");
			caps.setCapability("deviceName", "SamsungGalaxyTab3");
			break;
		case SamsungGalaxyTab410_1:
			caps.setCapability("browserName", "android");
			caps.setCapability("device", "Samsung Galaxy Tab 4 10.1");
			break;
		case SonyTipo:
			caps.setCapability("browserName", "android");
			caps.setCapability("device", "Sony Xperia Tipo");
			break;
		case iPad4:
			caps.setCapability("browserName", "iPad");
			caps.setCapability("device", "iPad 4th Gen");
			break;
		case iPadAir:
			caps.setCapability("browserName", "iPad");
			caps.setCapability("device", "iPad Air");
			break;
		case iPadMiniRetina:
			caps.setCapability("browserName", "iPad");
			caps.setCapability("device", "iPad mini Retina");
			break;
		case iPhone5:
			caps.setCapability("browserName", "iPhone");
			caps.setCapability("device", "iPhone 5");
			break;
		case iPhone5C:
			caps.setCapability("browserName", "iPhone");
			caps.setCapability("device", "iPhone 5C");
			break;
		case iPhone5S:
			caps.setCapability("browserName", "iPhone");
			caps.setCapability("device", "iPhone 5S");
			break;
		case PhantomJS:
			caps.setCapability("browserName", "phantomjs");
			break;
		default:
			throw new WebDriverException("No browser specified");
		}
		
		return caps;
	}
}
