package stepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.Language;
import enums.MeePortal;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
import pageObject.HelpPage;
import pageObject.LoginPage;
import pageObject.Register;
import supportMethods.FileReader;
import webDriver.Driver;
import org.openqa.selenium.JavascriptExecutor;

public class MeePortalStepDefs {

    private static String windowHandleBefore = "";

	@Given("^I am on the MEE portal for \"(.*?)\"$")
	public void i_am_on_the_MEE_portal_for(String environment) throws Throwable {

		EnvironmentStepDefs.environment = environment;
		Thread.sleep(5000);
		Driver.loadPage(MeePortal.getUrl());
		Assert.assertEquals("Incorrect URL.", MeePortal.getUrl(), Driver.getCurrentUrl());
	}

	@When("^I select language \"(.*?)\"$")
	public void i_select_language(String language) throws Throwable {
		int languageValue = Language.valueOf(language).getLanguageValue();
		FileReader.addData("language", language);
		LoginPage.LanguageSelector().selectByIndex(languageValue);
	}

    @Then("^I select the Help icon$")
    public void iSelectTheHelpIcon() throws Throwable {
        LoginPage login = new LoginPage();
        windowHandleBefore = Driver.getWindowHandle();
        login.helpIcon().click();
        for (String winHandle : Driver.getWindowHandles()) {
            Driver.switchToWindow(winHandle);
            System.out.println(winHandle);
        }
        Thread.sleep(3000);
    }

    @And("^I select all of the Help section links$")
    public void iSelectTheHelpSectionLink() throws Throwable {
        HelpPage helpPage = new HelpPage();

        WebElement links[] =
                {helpPage.SystemReqs(), helpPage.GetMoreHelp(),helpPage.HowAccess(),
                        helpPage.CloseMeeApp(), helpPage.HowMeeLinux(), helpPage.WhyResource(), helpPage.HowFindCode(),
                        helpPage.WhyNoDownload(), helpPage.ChangeLanguage(), helpPage.HowActivateCode(),
                        helpPage.HowLogin(), helpPage.UpdateLinux(), helpPage.HowRequestUserPass(), helpPage.HowChangeProfile(),
                        helpPage.RemoveResource(), helpPage.HowAccessResource(), helpPage.HowNewVersion()};

        int loopVal;
        int endVal = 17;

        for (loopVal = 0; loopVal < endVal; loopVal++) {
            Driver.scrollToElement(links[loopVal]);
            Thread.sleep(1000);
        }
    }

    @Then("^a message \"([^\"]*)\" is displayed$")
    public void aMessageIsDisplayed(String message) throws Throwable {
        Register register = new Register();
        register.message(message).isDisplayed();
    }

    @Then("^I select the Submit button$")
    public void iSelectTheSubmitButton() throws Throwable {
        Register register = new Register();
        WebElement submit = register.SubmitButton();
        Driver.scrollToElement(submit);
        submit.click();
    }

    @And("^I select the Close button$")
    public void iSelectTheCloseButton() throws Throwable {
        Register register = new Register();
        register.CloseButton().click();
    }

    @And("^I click on the Close form icon$")
    public void iClickOnTheCloseFormIcon() throws Throwable {
        LoginPage login = new LoginPage();
        login.CloseForm().click();
    }

	@Then("^I Pause for (\\d+) seconds$")
	public void iPauseForSeconds(int pause) throws Throwable {
		Thread.sleep(pause*1000);
	}

    @Then("^I switch Windows back to the MEE Portal$")
    public void iSwitchWindows() throws Throwable {
        Thread.sleep(5000);
        String windowHandleBefore = Driver.getWindowHandle();
        Driver.switchToWindow(windowHandleBefore);
        Thread.sleep(2000);
        for (String winHandle : Driver.getWindowHandles()) {
            Driver.switchToWindow(winHandle);
        }
    }

    @And("^I refresh the page$")
    public void iRefreshThePage() throws Throwable {
        Driver.refreshPage();
    }

    @And("^I select the main page language of \"([^\"]*)\"$")
    public void iSelectMainPageLanguageOf(String language) throws Throwable {
        int languageValue = Language.valueOf(language).getLanguageValue();
        LoginPage login = new LoginPage();
        login.topRightLanguageSelector().selectByIndex(languageValue);
    }

//    public static void scrollToTopOfPage() throws Throwable {
//        JavascriptExecutor jse = (JavascriptExecutor) ;
//        jse.executeScript("scrollBy(0, -6000);");
//        Thread.sleep(2000);
//    }
//
//    public static void scrollToBottomOfPage() throws Throwable {
//        JavascriptExecutor jse = (JavascriptExecutor) webdriver;
//        jse.executeScript("window.scrollTo(0,document.body.scrollHeight);");
//        Thread.sleep(2000);
//    }
//
//    public static void scrollToElement(WebElement element) throws Throwable {
//        Actions actions = new Actions(webdriver);
////        actions.moveToElement(element).perform();
//        actions.moveToElement(element).click(element).perform();
//        Thread.sleep(2000);
//    }
}
