package stepDefinition;

import cucumber.api.java.en.Given;

public class Environment {
	public static String environment;
	@Given("^I am using the \"(.*?)\" environment of Chromium$")
	public void i_am_using_the_environment_of_Chromium(String environment) throws Throwable {
		Environment.environment = environment;
	}
}
