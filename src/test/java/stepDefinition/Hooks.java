package stepDefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriverException;

import webDriver.Driver;
import webDriver.GlobalVariables;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import supportMethods.FileReader;


public class Hooks {
	
	private static Boolean runOnce = false;
	
	@Before
	public void readConfigFileAtStart() throws FileNotFoundException, IOException {
		if (!runOnce) {
			GlobalVariables.config = FileReader.readProperties();
			runOnce = true;
		}
	}
	
	@Before
	public void before(Scenario scenario) {
		
		GlobalVariables.scenario = scenario;
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

}
