package stepDefinition;

import org.junit.Assert;

import pageObject.SampleGooglePageObject;
import webDriver.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SampleSearchStepDefs {

	@Given("^I am on \"(.*?)\"$")
	public void i_am_on(String url) throws Throwable {

		Driver.loadPage(url);
	}

	@When("^I search for \"(.*?)\"$")
	public void i_search_for(String searchText) throws Throwable {

		SampleGooglePageObject google = new SampleGooglePageObject();
		
		google.googleSearchField().sendKeys(searchText);
		google.googleSearchButton().click();
		
		Thread.sleep(1000);
	}

	@Then("^my web page title is \"(.*?)\"$")
	public void my_web_page_title_is(String expectedBrowserTitle) throws Throwable {
	    
		String browserTitle = Driver.getTitle();
		
		Assert.assertEquals(expectedBrowserTitle, browserTitle);
	}

}
