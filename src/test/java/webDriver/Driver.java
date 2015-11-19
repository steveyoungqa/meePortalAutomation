package webDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import supportFactory.BrowserFactory;
import supportFactory.PlatformFactory;
import supportMethods.BrowserStack;

public class Driver {

	public static WebDriver mDriver;
	public static DesiredCapabilities browser;
	public static Platform systemPlatform;
	public static DesiredCapabilities additionalCapabilities = new DesiredCapabilities();
	
	public static Boolean useBrowserStack() {
		return Boolean.valueOf(GlobalVariables.config.get("useBrowserstack"));
	}
	
	public synchronized static WebDriver getCurrentDriver() {
		
		if (mDriver == null) {
			browser = new DesiredCapabilities();
			if (BrowserStack.useBrowserStack()) {
				browser.merge(BrowserStack.setBrowserCapabilities());
				browser.merge(BrowserStack.setProjectDetails());
				BrowserStack.setSeleniumHub();
			}		
				
			PlatformFactory.selectPlatform(browser);
			BrowserFactory.selectBrowser(browser);
			browser.merge(additionalCapabilities);
			browser.setCapability("app", GlobalVariables.config.get("mobileApp"));
			
			String seleniumHub = GlobalVariables.config.get("seleniumHub");
						
			try {
				mDriver = new RemoteWebDriver(new URL(seleniumHub), browser);
			} catch (WebDriverException e) {
				Driver.writeToReport("WebDriverException: " + e.getMessage());
				Assert.fail(e.getMessage());
			}
			catch (Exception e) {
				Driver.writeToReport(e.getMessage());
			} 
			finally {
				Runtime.getRuntime().addShutdownHook(
						new Thread(new BrowserCleanup()));
			}
		}
		return mDriver;
	}
	
	private static class BrowserCleanup implements Runnable {
		public void run() {
			System.out.println("Cleaning up the browser");
			try { 
				quit();
			} catch (Exception e)
			{
				System.out.println("Browser already shut down.");
			}
		}
	}
	
	public static void quit() {
		getCurrentDriver().quit();
	}
	
	public static void close()
	{
		getCurrentDriver().close();
	}

	public static void loadPage(String url) {
		getCurrentDriver().get(url);
	}

	public static WebElement findElement(By element)  {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		getCurrentDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		try {
			new WebDriverWait(getCurrentDriver(), 5).until(ExpectedConditions.elementToBeClickable((By) element));
		} catch (Exception e) {
			
		}
		WebElement foundElement;

		try {
			foundElement = getCurrentDriver().findElement(element);
		} catch (Exception e) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			System.out.println("Waiting 5 seconds.");
			foundElement = getCurrentDriver().findElement(element);
		}
		return foundElement;
	}

	public static List<WebElement> findElements(By element) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		getCurrentDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		try {
			new WebDriverWait(getCurrentDriver(), 1).until(ExpectedConditions
					.presenceOfAllElementsLocatedBy((By) element));
		}
		catch (TimeoutException e)
		{ 
			System.out.println("Supressed: " + e.getMessage());
		}
		return getCurrentDriver().findElements(element);

	}

	public static String getCurrentUrl() {
		return getCurrentDriver().getCurrentUrl();

	}

	public static String getTitle() {
		return getCurrentDriver().getTitle();
	}

	public static String screenshot(String filename) throws IOException {
		File file = ((TakesScreenshot) getCurrentDriver())
				.getScreenshotAs(OutputType.FILE);
		String filePath = ("./screenshot/" + filename + ".jpg");
		FileUtils.copyFile(file, new File(filePath));
		return filePath;
	}

	public static void embedScreenshot() {
		
		byte[] screenshot = ((TakesScreenshot) getCurrentDriver()).getScreenshotAs(OutputType.BYTES);
		GlobalVariables.scenario.embed(screenshot, "image/png");
	}

	public static void writeToReport(String string) {
		GlobalVariables.scenario.write(string);
	}
	
	public static WebDriver switchToWindow(String window) {
		return getCurrentDriver().switchTo().window(window);
	}
	
	public static WebDriver switchToFrame(String name) {
		return getCurrentDriver().switchTo().frame(name);
	}

	public static WebDriver switchToFrame(int index) {
		return getCurrentDriver().switchTo().frame(index);
	}
	
	public static WebDriver switchToFrame(WebElement iframe) {
		return getCurrentDriver().switchTo().frame(iframe);
	}
	
	public static String getWindowHandle() {
		return getCurrentDriver().getWindowHandle();
	}
	
	public static Set<String> getWindowHandles() {
		return getCurrentDriver().getWindowHandles();
	}
	
	public static void nextTab()
	{
		ArrayList<String> tabs = new ArrayList<String> (Driver.getWindowHandles());
		int index = 0;
		for (String tab : tabs)
		{
			if (tab == GlobalVariables.mainWindowHandle)
			{
				index = tabs.indexOf(tab);
			}
		}
		Driver.switchToWindow(tabs.get(index + 1));
	}
	
	/**
	 * Designed when there are only two tabs. Avoids issues where the order of window handles differs between browsers
	 */
	public static void otherTab()
	{
		ArrayList<String> tabs = new ArrayList<String> (Driver.getWindowHandles());
		int index = 0;
		for (String tab : tabs)
		{
			if (tab != GlobalVariables.mainWindowHandle)
			{
				index = tabs.indexOf(tab);
			}
		}
		Driver.switchToWindow(tabs.get(index));
	}
	
	public static void mainTab()
	{
		ArrayList<String> tabs = new ArrayList<String> (Driver.getWindowHandles());
		int index = 0;
		for (String tab : tabs)
		{
			if (tab == GlobalVariables.mainWindowHandle)
			{
				index = tabs.indexOf(tab);
			}
		}
		Driver.switchToWindow(tabs.get(index));
	}
	
	public static Dimension getResolution()
	{
		return getCurrentDriver().manage().window().getSize();
	}

	public static void setResolution(int x, int y)
	{
		getCurrentDriver().manage().window().setSize(new Dimension(x, y));
	}
	
	public static void maximise()
	{
		getCurrentDriver().manage().window().maximize();
	}
	
	public static Actions actions()
	{
		return new Actions(getCurrentDriver());
	}
	
	public static void dragAndDrop(WebElement start, WebElement finish)  
	{
		Driver.actions().moveToElement(finish).perform();
		Driver.actions().moveToElement(start).perform();
		Driver.actions().clickAndHold(start).perform();
		Driver.actions().moveToElement(finish).perform();
		Driver.actions().moveToElement(finish).perform();
		Driver.actions().release(finish).perform();
	}
	
	public static Boolean waitForUrlToContain(String url, int time) {
		return new WebDriverWait(getCurrentDriver(), time).until(ExpectedConditions.urlContains(url));
	}
	
}
