package stepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.Gmail;
import pageObject.LoginPage;
import pageObject.Mailinator;
import pageObject.Register;
import supportMethods.FileReader;
import webDriver.Driver;

import static org.junit.Assert.assertEquals;

public class MailClientsStepDefs {

    private static String windowHandleBefore = "";

//    @Then("^I check the Mailinator account for the email$")
//    public void iCheckTheMailinatorAccountForTheEmail() throws Throwable {
//        Mailinator mailinator = new Mailinator();
//        String email = FileReader.readProperties().get("emailAddress");
//
//        windowHandleBefore = Driver.getWindowHandle();
//        Driver.loadPage("https://www.mailinator.com/");
//        for (String winHandle : Driver.getWindowHandles()) {
//            Driver.switchToWindow(winHandle);
//            System.out.println(winHandle);
//        }
//
//        Thread.sleep(25000);
//        mailinator.MailinatorInboxField().sendKeys(email);
//        mailinator.MailinatorGoButton().click();
//        Thread.sleep(2000);
//        mailinator.MailinatorEmailLink().click();
//        Thread.sleep(2000);
//    }

    @Then("^I check the Test Gmail account for the email$")
    public void iCheckTheGmail() throws Throwable {
        Gmail gmail = new Gmail();
        String email = FileReader.readProperties().get("gmailTestAccount");
        String password = FileReader.readProperties().get("emailPassword");

        windowHandleBefore = Driver.getWindowHandle();
        Thread.sleep(5000);
        Driver.loadPage("https://mail.google.com/");
        for (String winHandle : Driver.getWindowHandles()) {
            Driver.switchToWindow(winHandle);
            System.out.println(winHandle);
        }

        gmail.GmailInboxField().sendKeys(email);
        gmail.GmailNextButton().click();
        gmail.GmailPasswordField().sendKeys(password);

        WebElement signedInCheckBox = gmail.GmailStaySignedInCheckbox();
        if
                (signedInCheckBox.isSelected()) {
            signedInCheckBox.click();
        }

        gmail.GmailSignIn().click();

    }

    @Then("^I open the logged in Gmail page$")
    public void iCheckLoggedInTheGmail() throws Throwable {
        Driver.loadPage("https://mail.google.com/");
    }

//    @Then("^I check the Mailinator account for the Reset Password email$")
//    public void iCheckTheMailinatorAccountForResetPasswordEmail() throws Throwable {
//        Mailinator mailinator = new Mailinator();
//        String email = FileReader.readProperties().get("emailAddress");
//
//        windowHandleBefore = Driver.getWindowHandle();
//        Driver.loadPage("https://www.mailinator.com/");
//        for (String winHandle : Driver.getWindowHandles()) {
//            Driver.switchToWindow(winHandle);
//            System.out.println(winHandle);
//        }
//
//        Thread.sleep(25000);
//        mailinator.MailinatorInboxField().sendKeys(email);
//        mailinator.MailinatorGoButton().click();
//        Thread.sleep(2000);
//        mailinator.MailinatorResetPasswordEmailLink().click();
//    }
//
//    @Then("^I check the Parent/Guardian Mailinator account for the email$")
//    public void iCheckTheParentMailinatorAccountForTheEmail() throws Throwable {
//        Mailinator mailinator = new Mailinator();
//        String email = FileReader.readProperties().get("parentEmailAddress");
//        Driver.loadPage("https://www.mailinator.com/");
//        Thread.sleep(25000);
//        mailinator.MailinatorInboxField().sendKeys(email);
//        mailinator.MailinatorGoButton().click();
//        Thread.sleep(2000);
//        mailinator.MailinatorEmailLink().click();
//        Thread.sleep(2000);
//        String language = FileReader.readProperties().get("language");
//
//        Driver.switchToFrame("publicshowmaildivcontent");
//        Thread.sleep(2000);
//        switch (language) {
//            case "English":
//                RegisterStepDefs.iStoreTheMinorUsernameAndPassword();
//                mailinator.MailinatorMinorClickEmailLink().click();
//                break;
//        }
//    }

    @And("^I click on the link to confirm the Gmail Minor email address$")
    public void iClickOnTheLinkToConfirmTheMinorGmailEmailAddress() throws Throwable {
        Gmail gmail = new Gmail();
        gmail.GmailMacmillanEmail().click();
        RegisterStepDefs.iStoreTheGmailUsernameAndPassword();
        gmail.GmailMinorClickEmailLink().click();
    }

    public void storeGmailDetails () throws Throwable{
        RegisterStepDefs.iStoreTheGmailUsernameAndPassword();
    }

    public void checkGmailContents () throws Throwable {
        Gmail gmail = new Gmail();
        String firstRegistered = FileReader.readProperties().get("firstName");
        String lastRegistered = FileReader.readProperties().get("surname");
        gmail.EmailBodyContains(firstRegistered).isDisplayed();
        gmail.EmailBodyContains(lastRegistered).isDisplayed();
    }

    @And("^I click on the link to confirm the Gmail email address$")
    public void iClickOnTheLinkToConfirmTheGmailEmailAddress() throws Throwable {
        Gmail gmail = new Gmail();
        Mailinator mailinator = new Mailinator();
        String language = FileReader.readProperties().get("language");

        switch (language) {
            case "English":
                gmail.GmailMacmillanEmail().click();
                storeGmailDetails();
                checkGmailContents();
                gmail.GmailClickEmailLink().click();
                break;
            case "Spanish":
                gmail.GmailMacmillanEmailSpanish().click();
                storeGmailDetails();
                checkGmailContents();
                gmail.GmailClickEmailLinkSpanish().click();
                break;
            case "Japanese":
                gmail.GmailMacmillanEmailJapanese().click();
                storeGmailDetails();
                checkGmailContents();
                gmail.GmailClickEmailLinkJapanese().click();
                break;
            case "Korean":
                gmail.GmailMacmillanEmailKorean().click();
                storeGmailDetails();
                checkGmailContents();
                gmail.GmailClickEmailLinkKorean().click();
                break;
            case "Taiwanese":
                gmail.GmailMacmillanEmailTaiwanese().click();
                storeGmailDetails();
                checkGmailContents();
                gmail.GmailClickEmailLinkTaiwan().click();
                break;
            case "Vitenamese":
                gmail.GmailMacmillanEmailVietnamese().click();
                storeGmailDetails();
                checkGmailContents();
                gmail.GmailClickEmailLinkVietnamese().click();
                break;
            case "Chinese":
                gmail.GmailMacmillanEmailChinese().click();
                storeGmailDetails();
                checkGmailContents();
                gmail.GmailClickEmailLinkChinese().click();
                break;
            case "ChineseTraditional":
                gmail.GmailMacmillanEmailChineseTraditional().click();
                storeGmailDetails();
                checkGmailContents();
                gmail.GmailClickEmailLinkChineseTraditional().click();
                break;
        }
    }

    @And("^I click on the link to confirm the email address$")
    public void iClickOnTheLinkToConfirmTheEmailAddress() throws Throwable {
        Mailinator mailinator = new Mailinator();
        String language = FileReader.readProperties().get("language");

        Driver.switchToFrame("publicshowmaildivcontent");
        Thread.sleep(5000);

        switch (language) {
            case "English":
                storeGmailDetails();
                mailinator.MailinatorClickEmailLink().click();
                break;
            case "Spanish":
                storeGmailDetails();
                mailinator.MailinatorClickEmailLinkSpanish().click();
                break;
            case "Japanese":
                storeGmailDetails();
                mailinator.MailinatorClickEmailLinkJapanese().click();
                break;
            case "Korean":
                storeGmailDetails();
                mailinator.MailinatorClickEmailLinkKorean().click();
                break;
            case "Taiwanese":
                storeGmailDetails();
                mailinator.MailinatorClickEmailLinkTaiwan().click();
                break;
            case "Vitenamese":
                storeGmailDetails();
                mailinator.MailinatorClickEmailLinkVietnamese().click();
                break;
            case "Chinese":
                storeGmailDetails();
                mailinator.MailinatorClickEmailLinkChinese().click();
                break;
            case "ChineseTraditional":
                storeGmailDetails();
                mailinator.MailinatorClickEmailLinkChineseTraditional().click();
                break;

        }
        String windowHandleBefore = Driver.getWindowHandle();
        Driver.switchToWindow(windowHandleBefore);
        for (String winHandle : Driver.getWindowHandles()) {
            Driver.switchToWindow(winHandle);
            Thread.sleep(2000);
        }
    }

    @And("^I click the Reset Password link$")
    public void iClickTheResetPasswordLink() throws Throwable {
        Register register = new Register();
        Driver.switchToFrame("publicshowmaildivcontent");
        Thread.sleep(2000);
        String windowHandleBefore = Driver.getWindowHandle();
        register.ResetPasswordLink().click();
        for (String winHandle : Driver.getWindowHandles()) {
            Driver.switchToWindow(winHandle);
            Thread.sleep(2000);
        }

    }

    @And("^I click the Gmail Reset Password link$")
    public void iClickTheGmailResetPasswordLink() throws Throwable {
        Register register = new Register();
        Gmail gmail = new Gmail();
        gmail.GmailResetYourPassword().click();
        register.ResetPasswordLink().click();
    }


    @And("^I reset the password by following the link and Login$")
    public void aCheckIsMadeThatThePasswordReminderIsCorrect() throws Throwable {
        Register register = new Register();
        LoginPage login = new LoginPage();

        Driver.switchToFrame("publicshowmaildivcontent");
        String windowHandleBefore = Driver.getWindowHandle();
        register.ResetPasswordLink().click();
        for (String winHandle : Driver.getWindowHandles()) {
            Driver.switchToWindow(winHandle);
            Thread.sleep(2000);
        }

        String resetPassword = RandomStringUtils.randomAlphabetic(6) + RandomStringUtils.randomNumeric(2);
        FileReader.addData("resetPassword", resetPassword);
        String username = FileReader.readProperties().get("username");
        String Newpassword = FileReader.readProperties().get("resetPassword");
        login.UsernameField().sendKeys(username);
    }

    @And("^a check is made that the Username reminder is correct$")
    public void aCheckIsMadeThatTheUsernameReminderIsCorrect() throws Throwable {
        Gmail gmail = new Gmail();
        gmail.GmailYourUsernameEmail().click();

        String username = FileReader.readProperties().get("username");
        String ForgotUsername = Driver.findElement(By.xpath("//*[@class='adn ads']//*[contains(text(), 'Username:')]")).getText().replace("Username: ", "");
        FileReader.addData("ForgotUsername", ForgotUsername);
        assertEquals(ForgotUsername, username);
        gmail.GmailClickEmailLink().click();
    }

    @And("^I delete the Test Gmail Email$")
    public void iDeleteTheTestGmailEmail() throws Throwable {
        Gmail gmail = new Gmail();
        gmail.GmailAnyMacmillanEmail().click();
        Thread.sleep(5000);
        gmail.GmailExpandEmail().click();
        Thread.sleep(5000);
        gmail.GmailDeleteEmail().click();
    }

    @And("^I delete ALL Test Gmail Emails$")
    public void iDeleteAllGmailEmail() throws Throwable {
        Gmail gmail = new Gmail();
        gmail.GmailSelectAllMenu().click();
        Thread.sleep(3000);

        if
                (gmail.GmailTrashIcon().isDisplayed()) {
            gmail.GmailTrashIcon().click();
        }
    }

    @Then("^I switch back to Gmail$")
    public void iSwitchBackToGmail() throws Throwable {
        windowHandleBefore = Driver.getWindowHandle();
        Driver.loadPage("https://mail.google.com/");
        for (String winHandle : Driver.getWindowHandles()) {
            Driver.switchToWindow(winHandle);
            System.out.println(winHandle);
        }
    }

    @Then("^I log out of Gmail$")
    public void iLogOutOfGmail() throws Throwable {
        Gmail gmail = new Gmail();
        gmail.GmailSignOutLogo().click();
        Thread.sleep(2000);
        gmail.GmailSignOutLink().click();
    }

    @And("^a check is made that the Password has been changed$")
    public void aCheckIsMadeThatThePasswordHasBeenChanged() throws Throwable {
        Gmail gmail = new Gmail();
        gmail.GmailPasswordChanged().isDisplayed();
    }

    @And("^a check is made that Details have been changed$")
    public void aCheckIsMadeThatDetailsHasBeenChanged() throws Throwable {
        Gmail gmail = new Gmail();
        gmail.GmailDetailsChanged().isDisplayed();
    }

}
