package stepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.Language;
import enums.MeePortal;
import findBy.Errors;
import org.junit.Assert;
import pageObject.LoginPage;
import pageObject.SignInPage;
import supportMethods.SessionUtilities;
import webDriver.Driver;

public class LoginStepDefs {
	
	
	@Given("^I have clicked on the login button$")
	public void i_have_clicked_on_the_login_button() throws Throwable {
//		SessionUtilities.ApplicationUpdateMessageCheck();
		SignInPage signIn = new SignInPage();
		signIn.LandingPagePortal();
		signIn.Login.get(0).click();
	}

	@When("^I enter incorrect user credentials$")
	public void i_enter_incorrect_user_credentials() throws Throwable {

		LoginPage login = new LoginPage();
		login.UsernameApp().sendKeys("hjbfdhjbfhjbfsd");
		login.PasswordApp().sendKeys("dsadasasd");
		login.LoginButton().click();
	}

	@Then("^A message is displayed informing the user that the login process has failed$")
	public void a_message_is_displayed_informing_the_user_that_the_login_process_has_failed() throws Throwable {
		if (!Errors.incorrectLoginDetails().isDisplayed()) {
			Assert.fail("Error not shown.");
		}
	}

	@When("^I select language \"(.*?)\"$")
	public void i_select_language(String language) throws Throwable {
        int languageValue = Language.valueOf(language).getLanguageValue();
        LoginPage.LanguageSelector().selectByIndex(languageValue);
	}

	@When("^I click the forgot username link$")
	public void i_click_the_forgot_username_link() throws Throwable {
		LoginPage login = new LoginPage();
		login.ForgotUsername().click();
	}
	
	@When("^I click the forgot password link$")
	public void i_click_the_forgot_password_link() throws Throwable {
		LoginPage login = new LoginPage();
		login.ForgotPassword().click();
	}
	
	@When("^I click the forgot username and password link$")
	public void i_click_the_forgot_username_and_password_link() throws Throwable {
		LoginPage login = new LoginPage();
		login.ForgotUsernameAndPassword().click();
	}


	@When("^I log in as username \"(.*?)\" and password \"(.*?)\"$")
	public void i_log_in_as_username_and_password(String username, String password) {
		SessionUtilities.Login(username, password);
	}
	

	@Then("^A \"(.*?)\" is displayed$")
	public void a_is_displayed(String error) throws Throwable {
		String[] errorsExpected = error.split(", ");
		for (String errorExpected : errorsExpected) {
			if (!LoginPage.errorMessage(errorExpected).isDisplayed()) {
				Assert.fail("Error message for " + errorExpected + "not found.");
			}
		}
	}

	@Then("^to user is navigated to the correct \"(.*?)\"$")
	public void to_user_is_navigated_to_the_correct(String link) throws Throwable {
		Thread.sleep(500);
		String expectedUrl = MeePortal.getUrl() + link;
		Assert.assertEquals("Incorrect URL.",  expectedUrl, Driver.getCurrentUrl());
	}

	@Then("^I am logged into MEE$")
	public void iAmLoggedIntoMEE() throws Throwable {
		LoginPage login = new LoginPage();
		if (!login.LogoutButton().isDisplayed()) {
			Assert.fail("Login not successfull!! Logout button not displayed");
		}
        if (!login.DownloadTitle().isDisplayed()) {
            Assert.fail("Login not successfull!! Download link title not displayed");
        }
	}

    @Then("^I log out of MEE$")
    public void iLogOutOfMEE() throws Throwable {
        LoginPage login = new LoginPage();
        login.LogoutButton().click();
    }
}
