package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pageObject.LoginPage;
import pageObject.Register;
import supportMethods.FileReader;
import webDriver.Driver;

import static org.junit.Assert.assertEquals;

public class MailClientsStepDefs {

    private static String windowHandleBefore = "";

    @Then("^I check the Mailinator account for the email$")
    public void iCheckTheMailinatorAccountForTheEmail() throws Throwable {
        Register register = new Register();
        String email = FileReader.readProperties().get("emailAddress");
        windowHandleBefore = Driver.getWindowHandle();
        Driver.findElement(By.cssSelector("body")).sendKeys(Keys.COMMAND +"t");
        Driver.loadPage("https://www.mailinator.com/");
        for (String winHandle : Driver.getWindowHandles()) {
            Driver.switchToWindow(winHandle);
            System.out.println(winHandle);
        }
        Thread.sleep(20000);
        register.MailinatorInboxField().sendKeys(email);
        register.MailinatorGoButton().click();
        Thread.sleep(2000);
        register.MailinatorEmailLink().click();
    }

    @Then("^I check the Parent/Guardian Mailinator account for the email$")
    public void iCheckTheParentMailinatorAccountForTheEmail() throws Throwable {
        Register register = new Register();
        String email = FileReader.readProperties().get("parentEmailAddress");
        Driver.loadPage("https://www.mailinator.com/");
        Thread.sleep(20000);
        register.MailinatorInboxField().sendKeys(email);
        register.MailinatorGoButton().click();
        Thread.sleep(2000);
        register.MailinatorEmailLink().click();

        String language = FileReader.readProperties().get("language");

        Driver.switchToFrame("publicshowmaildivcontent");

        switch (language) {
            case "English":
                RegisterStepDefs.iStoreTheMinorUsernameAndPassword();
                register.MailinatorMinorClickEmailLink().click();
                break;
        }
    }

    @And("^I click on the link to confirm the email address$")
    public void iClickOnTheLinkToConfirmTheEmailAddress() throws Throwable {
        Register register = new Register();
        String language = FileReader.readProperties().get("language");

        Driver.switchToFrame("publicshowmaildivcontent");
        Thread.sleep(1000);

        switch (language) {
            case "English":
                RegisterStepDefs.iStoreTheUsernameAndPassword();
                register.MailinatorClickEmailLink().click();
                break;
            case "Spanish":
                RegisterStepDefs.iStoreTheUsernameAndPassword();
                register.MailinatorClickEmailLinkSpanish().click();
                break;
            case "Japanese":
                RegisterStepDefs.iStoreTheUsernameAndPassword();
                register.MailinatorClickEmailLinkJapanese().click();
                break;
            case "Korean":
                RegisterStepDefs.iStoreTheUsernameAndPassword();
                register.MailinatorClickEmailLinkKorean().click();
                break;
            case "Taiwanese":
                RegisterStepDefs.iStoreTheUsernameAndPassword();
                register.MailinatorClickEmailLinkTaiwan().click();
                break;
            case "Vitenamese":
                RegisterStepDefs.iStoreTheUsernameAndPassword();
                register.MailinatorClickEmailLinkVietnamese().click();
                break;
            case "Chinese":
                RegisterStepDefs.iStoreTheUsernameAndPassword();
                register.MailinatorClickEmailLinkChinese().click();
                break;
            case "ChineseTraditional":
                RegisterStepDefs.iStoreTheUsernameAndPassword();
                register.MailinatorClickEmailLinkChineseTraditional().click();
                break;

        }
        Driver.close();
        Driver.switchToWindow(windowHandleBefore);
    }

    @And("^I reset the password by following the link and Login$")
    public void aCheckIsMadeThatThePasswordReminderIsCorrect() throws Throwable {
        Register register = new Register();
        LoginPage login = new LoginPage();

        String windowHandleBefore = Driver.getWindowHandle();
        for (String winHandle : Driver.getWindowHandles()) {
            Driver.switchToFrame("publicshowmaildivcontent");
            Thread.sleep(2000);
        }
        register.ResetPasswordLink().click();

        Thread.sleep(1000);
        Driver.switchToWindow(windowHandleBefore);
        Thread.sleep(5000);
        String username = FileReader.readProperties().get("username");
        login.ChangePasswordUsernameField().sendKeys(username);
        String resetPassword = RandomStringUtils.randomAlphabetic(5) + RandomStringUtils.randomNumeric(2);
        FileReader.addData("resetPassword", resetPassword);
        login.NewPasswordField().sendKeys(resetPassword);
        login.ConfirmNewPasswordField().sendKeys(resetPassword);

    }

    @And("^a check is made that the Username reminder is correct$")
    public void aCheckIsMadeThatTheUsernameReminderIsCorrect() throws Throwable {
        Register register = new Register();
        Driver.switchToFrame("publicshowmaildivcontent");
        Thread.sleep(2000);

        String username = Driver.findElement(By.xpath("//html/body/p[1]/span[1]")).getText().replace("Username: ", "");
        String forgotUsername = Driver.findElement(By.xpath("//html/body/b")).getText();
        FileReader.addData("ForgotUsername", forgotUsername);
        assertEquals(forgotUsername, username);
    }
}
