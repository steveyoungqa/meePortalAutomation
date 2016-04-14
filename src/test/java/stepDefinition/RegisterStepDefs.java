package stepDefinition;

import com.sun.tools.internal.xjc.reader.xmlschema.BindYellow;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.deps.com.thoughtworks.xstream.mapper.SystemAttributeAliasingMapper;
import enums.Month;
import gherkin.lexer.Th;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObject.LoginPage;
import pageObject.Register;
import supportMethods.FileReader;
import webDriver.Driver;

import java.io.FileWriter;
import java.util.ArrayList;


public class RegisterStepDefs {
    @And("^I have clicked on the Register button$")
    public void iHaveClickedOnTheRegisterButton() throws Throwable {
        LoginPage login = new LoginPage();
        login.RegisterLandingPage().click();
    }

    @Then("^I register a first name of \"([^\"]*)\" and surname of \"([^\"]*)\"$")
    public void iRegisterAFirstNameOfAndSurnameOf(String first, String last) throws Throwable {
        Register register = new Register();
        register.FirstName().sendKeys(first);
        register.Surname().sendKeys(last);
    }

    @And("^I select a Country of residence of \"([^\"]*)\"$")
    public void iSelectACountryOfResidenceOf(String country) throws Throwable {
        Register.CountrySelector().selectByValue(country);
    }

    @Then("^I select a date of birth of \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void iSelectADateOfBirthOf(String day, String month, String year) throws Throwable {
        Register.DaySelector().selectByValue(day);
        int monthValue = Month.valueOf(month).getMonthValue();
        Register.MonthSelector().selectByIndex(monthValue);
        Register.YearSelector().selectByValue(year);
    }

    @And("^I have clicked on the Next button$")
    public void iHaveClickedOnTheNextButton() throws Throwable {
        Register register = new Register();
        register.NextButton().click();
    }

    @Then("^I enter an email address and confirmation of \"([^\"]*)\"$")
    public void iEnterAnEmailAddressAndConfirmationOf(String email) throws Throwable {
        Register register = new Register();
        register.EmailAddress().sendKeys(email);
        register.ConfirmEmail().sendKeys(email);
    }

    @And("^I select the marketing checkbox$")
    public void iSelectTheMarketingCheckbox() throws Throwable {
        Register register = new Register();
        register.OptInCheckbox().click();
    }

    @Then("^I select the Submit button$")
    public void iSelectTheSubmitButton() throws Throwable {
        Register register = new Register();
        register.SubmitButton().click();
    }

    @Then("^I select the Back button$")
    public void iSelectTheBackButton() throws Throwable {
        Register register = new Register();
        register.BackButton().click();
    }

    @Then("^I enter a unique email address$")
    public void iEnterAnEmailAddressOf() throws Throwable {
        String email = "";
        Register register = new Register();
        email = RandomStringUtils.randomAlphabetic(10)+RandomStringUtils.randomNumeric(2)+"SPRINGER@mailinator.com";
        FileReader.addData("emailAddress", email);
        System.out.println("Unique Test Email address used: "+email);
        register.Email().sendKeys(email);
    }

    @Then("^I enter a confirmation of the unique email address$")
    public void iEnterAConfirmationEmailAddressOf() throws Throwable {
        String emailConfirm = "";
        Register register = new Register();
        emailConfirm = FileReader.readProperties().get("emailAddress");
        register.EmailConfirm().sendKeys(emailConfirm);
    }


    @And("^I select the Opt In checkbox$")
    public void iSelectTheOptInCheckbox() throws Throwable {
        Register register = new Register();
        register.optInCheckbox().click();
    }

    @Then("^I select the Help icon$")
    public void iSelectTheHelpIcon() throws Throwable {
        Register register = new Register();
        register.helpIcon().click();
    }

    @Then("^I select the Terms of Use link$")
    public void iSelectTheTermsOfUseLink() throws Throwable {
        Register register = new Register();
        register.TermsLink().click();
    }

    @Then("^I select the Privacy Policy link$")
    public void iSelectThePrivacyPolicyLink() throws Throwable {
        Register register = new Register();
        register.PrivacyPolicy().click();
    }

    @Then("^I should see the Email sent confirmation page$")
    public void iShouldSeeTheEmailSentConfirmationPage() throws Throwable {
        Register register = new Register();
        register.MailNotification().isDisplayed();
    }

    @Then("^I check the Mailinator account for the email$")
    public void iCheckTheMailinatorAccountForTheEmail() throws Throwable {
        Register register = new Register();
        String email = FileReader.readProperties().get("emailAddress");
        Driver.loadPage("https://www.mailinator.com/");
        register.MailinatorInboxField().sendKeys(email);
        register.MailinatorGoButton().click();
        Thread.sleep(1000);
    }

    @Then("^I should see the Registration Completed screen$")
    public void iShouldSeeTheRegistrationCompletedScreen() throws Throwable {
        Register register = new Register();
        String windowHandleBefore= Driver.getWindowHandle();
        Driver.switchToWindow(windowHandleBefore);
        for (String winHandle : Driver.getWindowHandles()){
            Driver.switchToWindow(winHandle);
        }
        Thread.sleep(1000);
        register.RegistrationComplete().isDisplayed();
    }

    @And("^I select the Close button$")
    public void iSelectTheCloseButton() throws Throwable {
        Register register = new Register();
        register.CloseButton().click();
    }

    @And("^I click on the link to confirm the email address$")
    public void iClickOnTheLinkToConfirmTheEmailAddress() throws Throwable {
        Register register = new Register();
        register.MailinatorEmailLink().click();
        Driver.switchToFrame("publicshowmaildivcontent");
        register.MailinatorClickEmailLink().click();
    }

    @And("^I store the Username and Password$")
    public void iStoreTheUsernameAndPassword() throws Throwable {
        Register register = new Register();
        String username=Driver.findElement(By.xpath("//html/body/p[4]/span[1]")).getText().replace("Username: ", "");
        String password=Driver.findElement(By.xpath("//html/body/p[4]/span[2]")).getText().replace("Password: ", "");
        FileReader.addData("username", username);
        FileReader.addData("password", password);
        System.out.println("\n"+"Username from Email= "+username);
        System.out.println("\n"+"Password from Email= "+password);
    }

}
