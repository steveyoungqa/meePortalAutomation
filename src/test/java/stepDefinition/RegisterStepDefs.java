package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import enums.Month;
import pageObject.LoginPage;
import pageObject.Register;


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

    @Then("^I enter an email address of \"([^\"]*)\"$")
    public void iEnterAnEmailAddressOf(String email) throws Throwable {
        Register register = new Register();
        register.Email().sendKeys(email);
    }

    @Then("^I enter a confirmation email address of \"([^\"]*)\"$")
    public void iEnterAConfirmationEmailAddressOf(String email) throws Throwable {
        Register register = new Register();
        register.EmailConfirm().sendKeys(email);
    }

    @And("^I select the Submit button$")
    public void iSelectTheSubmitButton() throws Throwable {
        Register register = new Register();
        register.SubmitButton().click();
    }

    @And("^I select the Opt In checkbox$")
    public void iSelectTheOptInCheckbox() throws Throwable {
        Register register = new Register();
        register.optInCheckbox().click();
    }

    @And("^I select the Back button$")
    public void iSelectTheBackButton() throws Throwable {
        Register register = new Register();
        register.BackButton().click();
    }
}
