package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import pageObject.LoginPage;
import pageObject.Register;
import webDriver.Driver;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LoggedInStepDefs {

    private static String windowHandleBefore = "";

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

    @And("^I select the Add Resource icon$")
    public void iSelectTheAddResourceIcon() throws Throwable {
        Register register = new Register();
        register.AddResourceIcon().click();

    }

    @Then("^I enter an incorrect Access code$")
    public void iEnterAnIncorrectAccessCode() throws Throwable {
        Register register = new Register();
        register.AccessCodeField().sendKeys("MAXP123234345435657");
    }

    @And("^I enter a not yet published code of \"([^\"]*)\"$")
    public void iEnterANotYetPublishedCodeOf(String code) throws Throwable {
        Register register = new Register();
        register.AccessCodeField().sendKeys(code);

    }

    @And("^I have clicked on the Access code Next button$")
    public void iHaveClickedOnTheAcessCodeNextButton() throws Throwable {
        Register register = new Register();
        register.AccessCodeNextButton().click();
    }

    @Then("^I enter an Access code of \"([^\"]*)\"$")
    public void iEnterAnAccessCodeOf(String code) throws Throwable {
        Register register = new Register();
        register.AccessCodeField().clear();
        register.AccessCodeField().sendKeys(code);
    }

    @Then("^I enter a New Access code of \"([^\"]*)\"$")
    public void iEnterANewAccessCodeOf(String code) throws Throwable {
        Register register = new Register();
        register.AccessCodeField().clear();
        register.AccessCodeField().sendKeys(code);
        Thread.sleep(2000);
    }

    @Then("^I should see (?:a|an) (?:Activate|display) message (?:for|of) \"([^\"]*)\"$")
    public void iShouldSeeAnActivateMessageFor(String activate) throws Throwable {
        Register register = new Register();
        register.activate(activate).isDisplayed();
    }

    @And("^I select Activate$")
    public void iSelectActivateAndShouldSeeAActivateSuccessMessage() throws Throwable {
        Register register = new Register();
        register.SubmitButton().click();

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
//            size = 29454736;
        }
        if (Platform.equals("MAC")) {
            link = "https://mee-cdn-test.ws.macmillaneducation.com/Releases/MEE-latest.dmg";
            type = "application/x-apple-diskimage";
//            size = 40588481;
        }
        if (Platform.equals("Linux32")) {
            link = "https://mee-cdn-test.ws.macmillaneducation.com/Releases/MEE-latest32.deb";
            type = "application/x-debian-package";
//            size = 46614196;
        }
        if (Platform.equals("Linux64")) {
            link = "https://mee-cdn-test.ws.macmillaneducation.com/Releases/MEE-latest64.deb";
            type = "application/x-debian-package";
//            size = 44405580;
        }

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpHead request = new HttpHead(link);
        HttpResponse response = httpClient.execute(request);
        String contentType = response.getFirstHeader("Content-Type").getValue();
        int contentLength = Integer.parseInt(response.getFirstHeader("Content-Length").getValue());
        System.out.println("\n" + "Content Type: " + contentType);
        System.out.println("\n" + "Content Length: " + contentLength);
        assertThat(contentType, is(type));
//        assertThat(contentLength, is((size)));
    }

    @And("^a Success screen that the password reset link has been sent is shown$")
    public void aSuccessScreenThatThePasswordResetLinkHasBeenSentIsShown() throws Throwable {
        Register register = new Register();
        register.ResetPasswordSent().isDisplayed();
        Thread.sleep(3000);
    }

    @And("^I select the Contact our Customer Service Team link$")
    public void iSelectTheContactOurCustomerServiceTeamLink() throws Throwable {
        Register register = new Register();
        windowHandleBefore = Driver.getWindowHandle();
        register.CustomerServiceLink().click();
        for (String winHandle : Driver.getWindowHandles()) {
            Driver.switchToWindow(winHandle);
            System.out.println(winHandle);
        }

    }
}
