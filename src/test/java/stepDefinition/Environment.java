package stepDefinition;

import cucumber.api.java.en.Given;

public class Environment {
	public static String environment;
	@Given("^I am using the \"(.*?)\" environment of MEE$")
	public void i_am_using_the_environment_of_MEE(String environment) throws Throwable {
		Environment.environment = environment;
	}
}
