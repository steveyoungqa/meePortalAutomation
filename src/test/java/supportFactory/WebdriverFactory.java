package supportFactory;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import supportMethods.BrowserStack;
import testRunner.TestRunner;
import webDriver.Driver;

import java.net.URL;

public class WebdriverFactory {

	private static class BrowserCleanup implements Runnable {
		public void run() {
			System.out.println("Cleaning up the browser");
			try { 
				Driver.webdriver.quit();
			} catch (NullPointerException e) {
				System.out.println("Browser already shut down.");
			}
		}
	}

	public static void removeGridTest () {

	}

	public static WebDriver createWebdriver() {
		caps = new DesiredCapabilities();
		if (BrowserStack.useBrowserStack()) {
			caps.merge(BrowserStack.setBrowserCapabilities());
			caps.merge(BrowserStack.setProjectDetails());
			BrowserStack.setSeleniumHub();
		}		
			
		PlatformFactory.selectPlatform(caps);
		BrowserFactory.selectBrowser(caps);
		WebdriverFactory.caps.merge(additionalCapabilities);
		
		String seleniumHub = TestRunner.config.get("seleniumHub");
					
		try {
			return new RemoteWebDriver(new URL(seleniumHub), caps);
		} catch (WebDriverException e) {
			Driver.writeToReport("WebDriverException: " + e.getMessage());
			Assert.fail(e.getMessage());
		}
		catch (Exception e) {
			Driver.writeToReport(e.getMessage());
		} 
		finally {
			Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
		}
		return null;
	}

	public static DesiredCapabilities caps;
	public static DesiredCapabilities additionalCapabilities = new DesiredCapabilities();

}
