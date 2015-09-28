package stepDefinition;

import org.junit.Assert;

import pageObject.LoginPage;
import supportMethods.SessionUtilities;
import webDriver.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.SampleUrls;

public class SampleLoginStepDefs {

	@Given("^I have open the application$")
	public void i_have_open_the_application() throws Throwable {

		Driver.chromiumDriver();
	}

	@When("^I login$")
	public void i_login() throws Throwable {

		SessionUtilities.Login("username", "password");
	}

	@Then("^I am presented with the welcome page$")
	public void i_am_presented_with_the_welcome_page() throws Throwable {

		//Check element is present
	}
	
	@Given("^I have opened a \"(.*?)\"$")
	public void i_have_opened_a(String environment) throws Throwable {
		
		Driver.ChromeDriver();
		Environment.environment = environment;
		Driver.loadPage(SampleUrls.getUrl());
		Thread.sleep(2000);
		Assert.assertEquals("Incorrect URL.", SampleUrls.getUrl(), Driver.getCurrentUrl());
	}
	

	@When("^I check for something$")
	public void i_check_for_something() throws Throwable {

		LoginPage login = new LoginPage();
		login.ForgotPassword().isDisplayed();
	}

	@Then("^something is present$")
	public void something_is_present() throws Throwable {


		//Check element is present
		
	}
	
}
