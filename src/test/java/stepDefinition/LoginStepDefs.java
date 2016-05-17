package stepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.Language;
import enums.MeePortal;
import findBy.Errors;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.SystemDefaultCredentialsProvider;
import org.apache.http.impl.entity.StrictContentLengthStrategy;
import org.junit.Assert;
import org.openqa.selenium.By;
import pageObject.LoginPage;
import pageObject.Register;
import supportMethods.FileReader;
import webDriver.Driver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class LoginStepDefs {


    @Given("^I have clicked on the Landing Page login button$")
    public void i_have_clicked_on_the_login_button() throws Throwable {
        LoginPage login = new LoginPage();
        login.LoginLandingPage().click();
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
        FileReader.addData("language", language);
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
        LoginPage login = new LoginPage();
        login.UsernameField().sendKeys(username);
        login.PasswordField().sendKeys(password);
        login.LoginButton().click();
    }


    @Then("^A \"(.*?)\" is displayed$")
    public static void a_is_displayed(String error) throws Throwable {
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
        Assert.assertEquals("Incorrect URL.", expectedUrl, Driver.getCurrentUrl());
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

    @Then("^I press the Login button")
    public void iLogin() throws Throwable {
        LoginPage login = new LoginPage();
        login.LoginButton().click();
    }

    @Then("^I Login with the newly created username and password$")
    public void iLogInAsNewlyCreatedUsernameAndPassword() throws Throwable {
        LoginPage login = new LoginPage();
        String username = FileReader.readProperties().get("username");
        String password = FileReader.readProperties().get("password");
        login.UsernameField().sendKeys(username);
        login.PasswordField().sendKeys(password);
        login.LoginButton().click();
    }

    @And("^I close the browser$")
    public void iCloseTheBrowser() throws Throwable {
        Driver.close();
    }

    @And("^I enter the newly created Email address$")
    public void iEnterTheNewlyCreatedEmailAddress() throws Throwable {
        Register register = new Register();
        String forgotEmail = FileReader.readProperties().get("emailAddress");
        register.EmailAddress().sendKeys(forgotEmail);

    }

    @And("^a Success screen that the email has been sent is shown$")
    public void aSuccessScreenThatTheEmailHasBeenSentIsShown() throws Throwable {
        Register register = new Register();
        register.ForgotEmailSent().isDisplayed();

    }

    @Then("^I Login with the forgotten details$")
    public void iLoginWithTheForgottenDetails() throws Throwable {
        Register register = new Register();
        LoginPage login = new LoginPage();
        register.MailinatorGoHereToLoginLink().click();
        String username = FileReader.readProperties().get("ForgotUsername");
        String password = FileReader.readProperties().get("password");
        login.UsernameField().sendKeys(username);
        login.PasswordField().sendKeys(password);
        login.LoginButton().click();


    }

    @Then("^I enter then newly created Username$")
    public void iEnterThenNewlyCreatedUsername() throws Throwable {
        LoginPage login = new LoginPage();
        String username = FileReader.readProperties().get("username");
        login.UsernameField().sendKeys(username);

    }

    @And("^a Success screen that the password reset link has been sent is shown$")
    public void aSuccessScreenThatThePasswordResetLinkHasBeenSentIsShown() throws Throwable {
        Register register = new Register();
        register.ResetPasswordSent().isDisplayed();
    }


    @And("^a Success screen that the email with the username and password has been sent is shown$")
    public void aSuccessScreenThatTheEmailWithTheUsernameAndPasswordHasBeenSentIsShown() throws Throwable {
        Register register = new Register();
        register.ForgotEmailUserAndPassword().isDisplayed();
    }

    @And("^I select the Profile icon$")
    public void iSelectTheProfileIcon() throws Throwable {
        Register register = new Register();
        register.ProfileIcon().click();
    }

    @And("^I select the Add Resource icon$")
    public void iSelectTheAddResourceIcon() throws Throwable {
        Register register = new Register();
        register.AddResourceIcon().click();

    }

    @Then("^I Login with the username and edited password$")
    public void iLoginWithTheUsernameAndEditedPassword() throws Throwable {
        LoginPage login = new LoginPage();
        String username = FileReader.readProperties().get("username");
        String password = FileReader.readProperties().get("resetPassword");
        login.UsernameField().sendKeys(username);
        login.PasswordField().sendKeys(password);
        login.LoginButton().click();
    }

    @Then("^I should be redirected to the Download App page$")
    public void iShouldBeRedirectedToTheDownloadAppPage() throws Throwable {
        LoginPage login = new LoginPage();
        login.DownloadTitle().isDisplayed();
    }

    @And("^I confirm the Download is functioning for \"([^\"]*)\"$")
    public void iConfirmTheDownloadIsFunctioningFor(String Platform) throws Throwable {
        String link = "";
        String type = "";
        Integer size = 0;
//        LoginPage login = new LoginPage();
//
        if (Platform.equals("Windows")) {
             link = "https://mee-cdn-test.ws.macmillaneducation.com/Releases/MEE-latest.exe";
             type = "application/octet-stream";
             size = 29455520;
        }
        if (Platform.equals("MAC")) {
            link = "https://mee-cdn-test.ws.macmillaneducation.com/Releases/MEE-latest.dmg";
            type = "application/x-apple-diskimage";
            size = 40586626;
        }
        if (Platform.equals("Linux32")) {
            link = "https://mee-cdn-test.ws.macmillaneducation.com/Releases/MEE-latest32.deb";
            type = "application/x-debian-package";
            size = 46613672;
        }
        if (Platform.equals("Linux64")) {
            link = "https://mee-cdn-test.ws.macmillaneducation.com/Releases/MEE-latest64.deb";
            type = "application/x-debian-package";
            size = 44405482;
        }

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpHead request = new HttpHead(link);
        HttpResponse response = httpClient.execute(request);
        String contentType = response.getFirstHeader("Content-Type").getValue();
        int contentLength = Integer.parseInt(response.getFirstHeader("Content-Length").getValue());
        System.out.println("\n" + "Content Type: " + contentType);
        System.out.println("\n" + "Content Length: " + contentLength);
        assertThat(contentType, is(type));
        assertThat(contentLength, is((size)));
    }

    @Then("^I enter an incorrect Access code$")
    public void iEnterAnIncorrectAccessCode() throws Throwable {
        Register register = new Register();
        register.AccessCodeField().sendKeys("MAXP123234345435657");
    }

    @And("^I have clicked on the Access code Next button$")
    public void iHaveClickedOnTheAcessCodeNextButton() throws Throwable {
        Register register = new Register();
        register.AccessCodeNextButton().click();
    }

    @And("^I click on the Close form icon$")
    public void iClickOnTheCloseFormIcon() throws Throwable {
        LoginPage login = new LoginPage();
        login.CloseForm().click();
    }
}
