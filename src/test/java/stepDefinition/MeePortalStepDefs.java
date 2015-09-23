package stepDefinition;

import org.junit.Assert;

import webDriver.Driver;
import cucumber.api.java.en.Given;
import enums.SampleUrls;

public class MeePortalStepDefs {
	
	
	@Given("^I am on the MEE portal for \"(.*?)\"$")
	public void i_am_on_the_MEE_portal_for(String environment) throws Throwable {

		Driver.ChromeDriver();
		Environment.environment = environment;
		Driver.loadPage(SampleUrls.getUrl());
		Assert.assertEquals("Incorrect URL.", SampleUrls.getUrl(), Driver.getCurrentUrl());
	}
}
