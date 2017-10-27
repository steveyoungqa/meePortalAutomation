package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.NewPortalLanguage;
import org.apache.commons.lang.RandomStringUtils;
import pageObject.Gmail;
import pageObject.LoginPage;
import pageObject.NewPortal;
import pageObject.Register;
import supportMethods.FileReader;

import static org.apache.commons.lang.RandomStringUtils.randomNumeric;

public class NewMeePortalStepDefs {

    private static String windowHandleBefore = "";

    @Then("^I enter a unique Username$")
    public void iEnterAUniqueUsername() throws Throwable {
        Register register = new Register();
        register.Username().clear();
        String username = RandomStringUtils.randomAlphabetic(7) + randomNumeric(3) +"Username";
        FileReader.addData("uniqueUsername", username);
        register.Username().sendKeys(username);
    }

    @And("^I enter a unique Password$")
    public void iEnterAUniquePassword() throws Throwable {
        Register register = new Register();
        register.Password().clear();
        String password = RandomStringUtils.randomAlphabetic(7) + randomNumeric(3);
        FileReader.addData("uniquePassword", password);
        register.Password().sendKeys(password);
    }

    @And("^I enter a confirmation of the unique Password$")
    public void iEnterAConfirmationOfTheUniquePassword() throws Throwable {
        Register register = new Register();
        String passwordConfirm = FileReader.readProperties().get("uniquePassword");
        register.ConfirmPassword().clear();
        register.ConfirmPassword().sendKeys(passwordConfirm);
    }

    @When("^I select language \"([^\"]*)\" on New Mee Portal$")
    public void iSelectLanguageOnNewMeePortal(String language) throws Throwable {
        int languageValue = NewPortalLanguage.valueOf(language).getLanguageValue();
        FileReader.addData("language", language);
        LoginPage.NewLanguageSelector().selectByIndex(languageValue);
    }

    @Then("^I should be logged into the New Mee Portal$")
    public void iShouldBeLoggedIntoTheNewMeePortal() throws Throwable {
        NewPortal portal = new NewPortal();
        portal.LoggedIn().isDisplayed();
    }

    @And("^I click on the link to confirm the New Portal Gmail email address$")
    public void iClickOnTheLinkToConfirmTheGmailEmailAddress() throws Throwable {
        Gmail gmail = new Gmail();
        String language = FileReader.readProperties().get("language");

        switch (language) {
            case "English":
                gmail.GmailMacmillanEmail().click();
                break;
        }
        //TO DO - ALL OTHER LANGUAGES
    }

    @And("^the Email should contain the users Registration credentials$")
    public void theEmailShouldContainTheUsersRegistrationCredentials() throws Throwable {
        String username = FileReader.readProperties().get("uniqueUsername");
        String first = FileReader.readProperties().get("firstname");
        String surname = FileReader.readProperties().get("surname");
        Register register = new Register();
        register.message(username).isDisplayed();
        register.message(first).isDisplayed();
        register.message(surname).isDisplayed();
    }

    @Then("^I log out of the New MEE Portal$")
    public void iLogOutOfTheNewMEEPortal() throws Throwable {
        NewPortal portal = new NewPortal();
        portal.LogOutButton().click();
    }

    @Then("^I follow the Gmail link to the Login Page$")
    public void iFollowTheGmailLinkToTheLoginPage() throws Throwable {
        Gmail gmail = new Gmail();
        gmail.GmailClickEmailLink().click();
    }

    @And("^I enter Registered credentials to the Login Page$")
    public void iLoginToTheNewPortalWithTheNewlyCreatedUsernameAndPassword() throws Throwable {
        Register register = new Register();
        String username = FileReader.readProperties().get("uniqueUsername");
        register.Username().clear();
        register.Username().sendKeys(username);
        String password = FileReader.readProperties().get("uniquePassword");
        register.Password().clear();
        register.Password().sendKeys(password);
    }
}
