package stepDefinition;

import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import pageObject.LoginPage;
import supportMethods.HttpsClient;
import webDriver.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HttpsRequests {
	
	WebDriver chromeDriver = Driver.getCurrentDriver();

	HttpsClient https;
	String userId;
	JSONObject registeredUser;

	@Given("^The user \"(.*?)\" \"(.*?)\" exists$")
	public void the_user_exists(String username, String password) throws Throwable {
		https = new HttpsClient();
		userId = https.getUserId(username, password);
	}
	
	@When("^I delete the user$")
	public void i_delete_the_user() throws Throwable {
		String authorisation = https.getAdminAccessToken("admin", "password");
		https.delete(userId, "application/json", authorisation);
	}

	@Then("^I get the response code (\\d+)$")
	public void i_get_the_response_code(int responseCode) throws Throwable {
		Assert.assertEquals("incorrect response code", responseCode, https.getResponseCode());
	}

	@Given("^I register a user \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\"$")
	public void i_register_a_user(String firstName, String lastName, String email, String dateOfBirth, String country, String language) throws Throwable {
		https = new HttpsClient();
		registeredUser = https.registerUser(firstName, lastName, email, dateOfBirth, country, language);
	}

	@When("^navigate to the callback URL$")
	public void navigate_to_the_callback_URL() throws Throwable {
		chromeDriver.get(registeredUser.getString("url"));
	}

	@Then("^my user account is active$")
	public void my_user_account_is_active() throws Throwable {
		LoginPage loginPage = new LoginPage();
		loginPage.FromRegisterSuccessToLogin().click();
		loginPage.UsernamePortal().sendKeys(registeredUser.getString("username"));
		loginPage.PasswordPortal().sendKeys(registeredUser.getString("password"));
		loginPage.LoginButton().click();
	}
}