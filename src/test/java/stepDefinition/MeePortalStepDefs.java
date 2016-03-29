package stepDefinition;

import cucumber.api.java.en.Given;
import enums.MeePortal;
import org.junit.Assert;
import webDriver.Driver;

public class MeePortalStepDefs {
	
	
	@Given("^I am on the MEE portal for \"(.*?)\"$")
	public void i_am_on_the_MEE_portal_for(String environment) throws Throwable {

//		Driver.ChromeDriver();
		Environment.environment = environment;
		Driver.loadPage(MeePortal.getUrl());
		Assert.assertEquals("Incorrect URL.", MeePortal.getUrl(), Driver.getCurrentUrl());
	}
}
