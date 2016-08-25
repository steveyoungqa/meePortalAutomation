package supportFactory;

import gherkin.lexer.Th;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import supportMethods.BrowserStack;
import supportMethods.FileReader;
import testRunner.TestRunner;
import webDriver.Driver;

import java.net.URL;

public class WebdriverFactory {

	public static class BrowserCleanup implements Runnable {
		public void run() {
			System.out.println("Cleaning up the browser");
			try { 
				Driver.webdriver.quit();
			} catch (NullPointerException e) {
				System.out.println("Browser already shut down.");
			}
		}
	}

	public static WebDriver createWebdriver() throws Throwable {

		String browser = FileReader.readProperties().get("browser");
		Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
		return null;
	}



}
