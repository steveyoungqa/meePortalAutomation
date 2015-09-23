package stepDefinition;

import org.openqa.selenium.WebDriverException;

import webDriver.Driver;
import webDriver.GlobalVariables;
import webDriver.ReadFiles;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Hooks {
	@Before
	public void before(Scenario scenario) {
		GlobalVariables.scenario = scenario;
		ReadFiles.readConfig("src/test/resources/config.txt");
	}
	
	@After
	public void after(Scenario scenario) {
		try
		{
			if (scenario.isFailed())
			{
                Driver.embedScreenshot();
            }
		}
		catch (WebDriverException somePlatformsDontSupportScreenshots)
		{
			System.err.println(somePlatformsDontSupportScreenshots.getMessage());
		}
	}	
	
	@After
	public void shutdown() {
		if (!(Driver.chromiumDriver == null)) {
			System.out.println("Shutting down MEE.");
			Driver.chromiumDriver().quit();
			Driver.chromiumDriver = null;
		}
		if (!(Driver.chromeDriver == null)) { 
			System.out.println("Shutting down Chrome.");
			Driver.ChromeDriver().quit();
			Driver.chromeDriver = null;
		}
		Driver.currentDriver = null;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
