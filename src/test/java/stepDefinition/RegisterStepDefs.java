package stepDefinition;

import com.sun.media.jfxmedia.logging.Logger;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.Language;
import enums.Month;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.LoginPage;
import pageObject.Mailinator;
import pageObject.Register;
import supportMethods.FileReader;
import webDriver.Driver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class RegisterStepDefs {

    private static String windowHandleBefore = "";

    @And("^I have clicked on the Register button$")
    public void iHaveClickedOnTheRegisterButton() throws Throwable {
        LoginPage login = new LoginPage();
        login.RegisterLandingPage().click();
    }

    @Then("^I (?:register|enter) a first name of \"([^\"]*)\" and surname of \"([^\"]*)\"$")
    public void iRegisterAFirstNameOfAndSurnameOf(String first, String last) throws Throwable {
        Register register = new Register();
        register.FirstName().clear();
        register.FirstName().sendKeys(first);
        register.Surname().clear();
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

    @Then("^I select the Back button$")
    public void iSelectTheBackButton() throws Throwable {
        Register register = new Register();
        register.BackButton().click();
    }

    @Then("^I enter a unique email address$")
    public void iEnterAnEmailAddressOf() throws Throwable {
        Register register = new Register();
        String email = RandomStringUtils.randomAlphabetic(10) + RandomStringUtils.randomNumeric(2) + "@mailinator.com";
        FileReader.addData("emailAddress", email);
        register.Email().clear();
        register.Email().sendKeys(email);
    }

    @Then("^I enter a Parent/Guardian email address$")
    public void iEnterAParentEmailAddressOf() throws Throwable {
        Register register = new Register();
        String email = RandomStringUtils.randomAlphabetic(7) + RandomStringUtils.randomNumeric(4) + "@mailinator.com";
        FileReader.addData("parentEmailAddress", email);
        register.Email().sendKeys(email);
    }

    @Then("^I enter a confirmation of the unique email address$")
    public void iEnterAConfirmationEmailAddressOf() throws Throwable {
        Register register = new Register();
        String emailConfirm = FileReader.readProperties().get("emailAddress");
        register.EmailConfirm().clear();
        register.EmailConfirm().sendKeys(emailConfirm);
    }

    @Then("^I enter a confirmation of the unique Parent/Guardian email address$")
    public void iEnterAConfirmationParentEmailAddressOf() throws Throwable {
        Register register = new Register();
        String emailConfirm = FileReader.readProperties().get("parentEmailAddress");
        register.EmailConfirm().sendKeys(emailConfirm);
    }

    @And("^I select the Opt In checkbox$")
    public void iSelectTheOptInCheckbox() throws Throwable {
        Register register = new Register();
        register.optInCheckbox().click();
    }

    @Then("^I select the Terms of Use link$")
    public void iSelectTheTermsOfUseLink() throws Throwable {
        Register register = new Register();
        windowHandleBefore = Driver.getWindowHandle();
        register.TermsLink().click();
        for (String winHandle : Driver.getWindowHandles()) {
            Driver.switchToWindow(winHandle);
            System.out.println(winHandle);
        }
        Driver.waitForUrlToContain("https://mee-test-useraccesscontrolmanager.ws.macmillaneducation.com/en/Docs/Terms", 50);
        Driver.close();
        Driver.switchToWindow(windowHandleBefore);
        Thread.sleep(2000);
    }

    @Then("^I select the Privacy Policy link$")
    public void iSelectThePrivacyPolicyLink() throws Throwable {
        Register register = new Register();
        windowHandleBefore = Driver.getWindowHandle();
        register.PrivacyPolicy().click();
        for (String winHandle : Driver.getWindowHandles()) {
            Driver.switchToWindow(winHandle);
            System.out.println(winHandle);
        }
        Driver.waitForUrlToContain("http://www.macmillanenglish.com/privacy-policy/", 50);
        Driver.close();
        Thread.sleep(2000);
    }

    @Then("^I should see the Email sent confirmation page$")
    public void iShouldSeeTheEmailSentConfirmationPage() throws Throwable {
        Register register = new Register();
        register.MailNotification().isDisplayed();
    }

    @Then("^I should see the Registration Completed screen$")
    public void iShouldSeeTheRegistrationCompletedScreen() throws Throwable {
        Register register = new Register();
        Thread.sleep(3000);
        register.RegistrationComplete().isDisplayed();
    }

    public static void iStoreTheMinorUsernameAndPassword() throws Throwable {
        String language = FileReader.readProperties().get("language");
        Thread.sleep(2000);
        switch (language) {
            case "English":

                String username = Driver.findElement(By.xpath("html/body/p[4]/span[1]")).getText().replace("Username: ", "");
                String password = Driver.findElement(By.xpath("html/body/p[4]/span[2]")).getText().replace("Password: ", "");
                FileReader.addData("username", username);
                FileReader.addData("password", password);
                break;
        }
    }

    public static void iStoreTheUsernameAndPassword() throws Throwable {
        String language = FileReader.readProperties().get("language");

        switch (language) {
            case "English":

                String username = Driver.findElement(By.xpath("html/body/p[3]/span[1]")).getText().replace("Username: ", "");
                String password = Driver.findElement(By.xpath("html/body/p[3]/span[2]")).getText().replace("Password: ", "");
                FileReader.addData("username", username);
                FileReader.addData("password", password);
                break;
        }

        switch (language) {
            case "Spanish":

                String username = Driver.findElement(By.xpath("html/body/p[3]/span[1]")).getText().replace("Nombre de usuario: ", "");
                String password = Driver.findElement(By.xpath("html/body/p[3]/span[2]")).getText().replace("Contraseña: ", "");
                FileReader.addData("username", username);
                FileReader.addData("password", password);
                break;
        }

        switch (language) {
            case "Japanese":

                String username = Driver.findElement(By.xpath("html/body/p[3]/span[1]")).getText().replace("ユーザー名: ", "");
                String password = Driver.findElement(By.xpath("html/body/p[3]/span[2]")).getText().replace("パスワード: ", "");
                FileReader.addData("username", username);
                FileReader.addData("password", password);
                break;
        }

        switch (language) {
            case "Korean":

                String username = Driver.findElement(By.xpath("html/body/p[3]/span[1]")).getText().replace("사용자명: ", "");
                String password = Driver.findElement(By.xpath("html/body/p[3]/span[2]")).getText().replace("비밀번호: ", "");
                FileReader.addData("username", username);
                FileReader.addData("password", password);
                break;
        }

        switch (language) {
            case "Taiwanese":

                String username = Driver.findElement(By.xpath("html/body/p[3]/span[1]")).getText().replace("ชื่อผู้ใช้: ", "");
                String password = Driver.findElement(By.xpath("html/body/p[3]/span[2]")).getText().replace("รหัสผ่าน: ", "");
                FileReader.addData("username", username);
                FileReader.addData("password", password);
                break;
        }

        switch (language) {
            case "Vitenamese":

                String username = Driver.findElement(By.xpath("//html/body/p[3]/span[1]")).getText().replace("Tên người dùng: ", "");
                String password = Driver.findElement(By.xpath("//html/body/p[3]/span[2]")).getText().replace("Mật khẩu: ", "");
                FileReader.addData("username", username);
                FileReader.addData("password", password);
                break;
        }

        switch (language) {
            case "Chinese":

                String username = Driver.findElement(By.xpath("//html/body/p[3]/span[1]")).getText().replace("用户名: ", "");
                String password = Driver.findElement(By.xpath("//html/body/p[3]/span[2]")).getText().replace("密码: ", "");
                FileReader.addData("username", username);
                FileReader.addData("password", password);
                break;
        }

        switch (language) {
            case "ChineseTraditional":

                String username = Driver.findElement(By.xpath("//html/body/p[3]/span[1]")).getText().replace("使用者名稱:: ", "");
                String password = Driver.findElement(By.xpath("//html/body/p[3]/span[2]")).getText().replace("密碼:: ", "");
                FileReader.addData("username", username);
                FileReader.addData("password", password);
                break;
        }
    }

    @Then("^I select Change Password$")
    public void iSelectChangePassword() throws Throwable {
        Register register = new Register();
        register.ChangePassword().click();
    }

    @Then("^I select Edit Details$")
    public void iSelectEditDetails() throws Throwable {
        Register register = new Register();
        register.EditPassword().click();
    }

    @And("^I change the current password to a new one and confirm$")
    public void iChangeTheCurrentPasswordToANewOneAndConfirm() throws Throwable {
        LoginPage login = new LoginPage();
        String currentPassword = FileReader.readProperties().get("password");
        login.CurrentPassword().sendKeys(currentPassword);
        String resetPassword = RandomStringUtils.randomAlphabetic(5) + RandomStringUtils.randomNumeric(2);
        FileReader.addData("resetPassword", resetPassword);
        login.NewPasswordField().sendKeys(resetPassword);
        login.ConfirmNewPasswordField().sendKeys(resetPassword);

    }

    @And("^I try to change the new password to include invalid characters$")
    public void iTryToChangeTheNewPasswordToIncludeInvalidCharacters() throws Throwable {
        LoginPage login = new LoginPage();
        String currentPassword = FileReader.readProperties().get("password");
        login.CurrentPassword().sendKeys(currentPassword);
        String resetPassword = RandomStringUtils.randomAlphabetic(5) + "&";
        login.NewPasswordField().sendKeys(resetPassword);
        login.ConfirmNewPasswordField().sendKeys(resetPassword);
    }

    @Then("^I should see the Password changed Success message$")
    public void iShouldSeeThePasswordChangedSuccessMessage() throws Throwable {
        Register register = new Register();
        register.PasswordChangedMessage().isDisplayed();
    }

    @And("^I click on the link to confirm the Edited email address$")
    public void iClickOnTheLinkToConfirmTheEditedEmailAddress() throws Throwable {
        Mailinator mailinator = new Mailinator();
        String language = FileReader.readProperties().get("language");

        String windowHandleBefore = Driver.getWindowHandle();
        for (String winHandle : Driver.getWindowHandles()) {
            Driver.switchToFrame("publicshowmaildivcontent");
            Thread.sleep(2000);
        }
        mailinator.MailinatorMinorClickEmailLink().click();
    }

}
