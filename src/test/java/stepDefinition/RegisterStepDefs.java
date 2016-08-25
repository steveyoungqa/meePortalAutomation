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
import org.openqa.selenium.support.ui.SystemClock;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.LoginPage;
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
        FileReader.addData("firstName", first);
        FileReader.addData("surname", last);
    }

    @Then("^the registered first name and surname is validated$")
    public void theRegisteredFirstNameOfAndSurnameOfIsValidated() throws Throwable {
        Register register = new Register();
        String firstOnScreen = register.FirstName().getAttribute("value");
        String lastOnScreen = register.Surname().getAttribute("value");

        String firstRegistered = FileReader.readProperties().get("firstName");
        String lastRegistered = FileReader.readProperties().get("surname");
        assertEquals(firstOnScreen, firstRegistered);
        assertEquals(lastOnScreen, lastRegistered);
    }

    @Then("^the Registration form should be empty$")
    public void registrationFormShouldBeEmpty() throws Throwable {
        Register register = new Register();
        if(register.FirstName().getAttribute("value").isEmpty()) {

        }
        else {
           Assert.fail("First name field is NOT empty!!");
        }

        if(register.Surname().getAttribute("value").isEmpty()) {

        }
        else {
            Assert.fail("Surname name field is NOT empty!!");
        }

        if(register.CountrySelector().getFirstSelectedOption().getAttribute("value").contains("")) {

        }
        else {
            Assert.fail("Country field is NOT empty!!");
        }

        if(register.DaySelector().getFirstSelectedOption().getAttribute("value").contains("0")) {

        }
        else {
            Assert.fail("Day field has not been reset");
        }

        if(register.MonthSelector().getFirstSelectedOption().getAttribute("value").contains("")) {

        }
        else {
            Assert.fail("Month field has not been reset");
        }

        if(register.YearSelector().getFirstSelectedOption().getAttribute("value").contains("")) {

        }
        else {
            Assert.fail("Year field has not been reset");
        }

    }

    @And("^I select a Country of residence of \"([^\"]*)\"$")
    public void iSelectACountryOfResidenceOf(String country) throws Throwable {
        Register.CountrySelector().selectByValue(country);
        FileReader.addData("country", country);
    }

    @Then("^the Country of Residence is validated$")
    public void theCountryOfResidenceIsValidated() throws Throwable {
        Register register = new Register();
        String countryRegistered = FileReader.readProperties().get("country");
        String residence = register.CountrySelector().getFirstSelectedOption().getAttribute("value");
        assertEquals(countryRegistered, residence);
    }

    @Then("^I select a date of birth of \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void iSelectADateOfBirthOf(String day, String month, String year) throws Throwable {
        int monthValue = Month.valueOf(month).getMonthValue();
        Register.DaySelector().selectByValue(day);
        Register.MonthSelector().selectByIndex(monthValue);
        Register.YearSelector().selectByValue(year);
        FileReader.addData("dayOfBirth", day);
        FileReader.addData("monthOfBirth", month);
        FileReader.addData("yearOfBirth", year);
    }

    @And("^the Date of Birth is validated$")
    public void theDateOfBirthIsValidated() throws Throwable {
        Register register = new Register();
        String dayOfBirthRegistered = FileReader.readProperties().get("dayOfBirth");
        String monthOfBirthRegistered = FileReader.readProperties().get("monthOfBirth");
        String yearOfBirthRegistered = FileReader.readProperties().get("yearOfBirth");
        String dayBirth = Register.DaySelector().getFirstSelectedOption().getAttribute("value");
        String monthBirth = Register.MonthSelector().getFirstSelectedOption().getAttribute("value");
        String yearBirth = Register.YearSelector().getFirstSelectedOption().getAttribute("value");

        String monthValue = Integer.toString(Month.valueOf(monthOfBirthRegistered).getMonthValue());

        assertEquals(dayOfBirthRegistered, dayBirth);
        assertEquals(monthValue, monthBirth);
        assertEquals(yearOfBirthRegistered, yearBirth);
    }

    @And("^I have clicked on the Next button$")
    public void iHaveClickedOnTheNextButton() throws Throwable {
        Register register = new Register();
        register.NextButton().click();
    }

    @And("^I have clicked on the Continue button$")
    public void iHaveClickedOnTheContinue() throws Throwable {
        Register register = new Register();
        register.ContinueButton().click();
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

    @Then("^I enter a unique Gmail email address$")
    public void iEnterAUniqueGmailEmailAddress() throws Throwable {
        Register register = new Register();
        String email = "springertester" + "+" +RandomStringUtils.randomAlphabetic(3) + RandomStringUtils.randomNumeric(2) + "@gmail.com";
        FileReader.addData("uniqueEmailAddress", email);
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

    @Then("^I enter a Parent/Guardian Gmail address$")
    public void iEnterAParentGmailAddressOf() throws Throwable {
        Register register = new Register();
        String email = "springertester" + "+" +RandomStringUtils.randomAlphabetic(3) + RandomStringUtils.randomNumeric(2) + "@gmail.com";
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

    @Then("^I enter a confirmation of the unique Gmail email address$")
    public void iEnterAConfirmationGmailEmailAddressOf() throws Throwable {
        Register register = new Register();
        String emailConfirm = FileReader.readProperties().get("uniqueEmailAddress");
        register.EmailConfirm().clear();
        register.EmailConfirm().sendKeys(emailConfirm);
    }

    @Then("^I attempt to Paste confirmation of the unique Gmail email address$")
    public void attemptPaste() throws Throwable {


        Register register = new Register();

        Actions doubleclick = new Actions(Driver.webdriver).contextClick(register.Email());
        doubleclick.sendKeys(Keys.COMMAND, "a");


        Actions action1 = new Actions(Driver.webdriver).contextClick(register.Email());
        action1.sendKeys(Keys.ARROW_DOWN);
        action1.sendKeys(Keys.ARROW_DOWN);
        action1.sendKeys(Keys.ARROW_DOWN);
        action1.sendKeys(Keys.ENTER);
        action1.perform();


        register.FirstName().click();
        Actions action2 = new Actions(Driver.webdriver).contextClick(register.FirstName());
        action2.sendKeys(Keys.ARROW_DOWN);
        action2.sendKeys(Keys.ENTER);
        action2.perform();

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

    @And("^I select Third Party checkbox$")
    public void iSelectTheThirdPartyCheckbox() throws Throwable {
        Register register = new Register();
        register.thirdPartyCheckbox().click();
    }

    @Then("^I select the Terms & Conditions checkbox$")
    public void iSelectTheTermsConditionsCheckbox() throws Throwable {
        Register register = new Register();
        register.TermsConditionsCheckbox().click();
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
        Driver.switchToWindow(windowHandleBefore);
        Thread.sleep(2000);
    }

    @Then("^I select the Cookie Policy link$")
    public void iSelectTheCookiePolicyLink() throws Throwable {
        Register register = new Register();
        windowHandleBefore = Driver.getWindowHandle();
        register.CookiePolicy().click();
        for (String winHandle : Driver.getWindowHandles()) {
            Driver.switchToWindow(winHandle);
            System.out.println(winHandle);
        }
        Driver.waitForUrlToContain("http://www.macmillanenglish.com/privacy-policy/#OnlineTracking", 50);
        Driver.close();
        Driver.switchToWindow(windowHandleBefore);
        Thread.sleep(2000);
    }

    @Then("^I should see the Email sent confirmation page$")
    public void iShouldSeeTheEmailSentConfirmationPage() throws Throwable {
        String language = FileReader.readProperties().get("language");
        Register register = new Register();

        switch (language){
            case "English":
                 register.MailNotification().isDisplayed();
                    break;
        }
        switch (language){
            case "Spanish":
                register.MailNotificationSpanish().isDisplayed();
                break;
        }
        switch (language){
            case "Korean":
                register.MailNotificationKorean().isDisplayed();
                break;
        }
        switch (language){
            case "Japanese":
                register.MailNotificationJapanese().isDisplayed();
                break;
        }
        switch (language){
            case "Taiwanese":
                register.MailNotificationTaiwan().isDisplayed();
                break;
        }
        switch (language){
            case "Vitenamese":
                register.MailNotificationVitenamese().isDisplayed();
                break;
        }
        switch (language){
            case "Chinese":
                register.MailNotificationChinese().isDisplayed();
                break;
        }
        switch (language){
            case "ChineseTraditional":
                register.MailNotificationChineseTraditional().isDisplayed();
                break;
        }

        Thread.sleep(3000);
    }

    @Then("^I should see the Registration Completed screen$")
    public void iShouldSeeTheRegistrationCompletedScreen() throws Throwable {
        Register register = new Register();
        String windowHandleBefore = Driver.getWindowHandle();
        Driver.switchToWindow(windowHandleBefore);
        Thread.sleep(2000);
        for (String winHandle : Driver.getWindowHandles()) {
            Driver.switchToWindow(winHandle);
        }
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

    public static void iStoreTheGmailUsernameAndPassword() throws Throwable {
        String language = FileReader.readProperties().get("language");

        switch (language) {
            case "English":

                String username = Driver.findElement(By.xpath("//*[@class='adn ads']//*[contains(text(), 'Username:')]")).getText().replace("Username: ", "");
                String password = Driver.findElement(By.xpath("//*[@class='adn ads']//*[contains(text(), 'Password:')]")).getText().replace("Password: ", "");
                FileReader.addData("username", username);
                FileReader.addData("password", password);
                break;
        }

        switch (language) {
            case "Spanish":

                String username = Driver.findElement(By.xpath("//*[@class='adn ads']//*[contains(text(), 'Nombre de usuario:')]")).getText().replace("Nombre de usuario: ", "");
                String password = Driver.findElement(By.xpath("//*[@class='adn ads']//*[contains(text(), 'Contraseña:')]")).getText().replace("Contraseña: ", "");
                FileReader.addData("username", username);
                FileReader.addData("password", password);
                break;
        }

        switch (language) {
            case "Japanese":

                String username = Driver.findElement(By.xpath("//*[@class='adn ads']//*[contains(text(), 'ユーザー名:')]")).getText().replace("ユーザー名: ", "");
                String password = Driver.findElement(By.xpath("//*[@class='adn ads']//*[contains(text(), 'パスワード:')]")).getText().replace("パスワード: ", "");
                FileReader.addData("username", username);
                FileReader.addData("password", password);
                break;
        }

        switch (language) {
            case "Korean":

                String username = Driver.findElement(By.xpath("//*[@class='adn ads']//*[contains(text(), '사용자명:')]")).getText().replace("사용자명: ", "");
                String password = Driver.findElement(By.xpath("//*[@class='adn ads']//*[contains(text(), '비밀번호:')]")).getText().replace("비밀번호: ", "");
                FileReader.addData("username", username);
                FileReader.addData("password", password);
                break;
        }

        switch (language) {
            case "Taiwanese":

                String username = Driver.findElement(By.xpath("//*[@role='main']//*[contains(text(), 'ชื่อบัญชีผู้ใช้:')]")).getText().replace("ชื่อบัญชีผู้ใช้: ", "");
                String password = Driver.findElement(By.xpath("//*[@role='main']//*[contains(text(), 'รหัสผ่าน:')]")).getText().replace("รหัสผ่าน: ", "");
                FileReader.addData("username", username);
                FileReader.addData("password", password);
                break;
        }

        switch (language) {
            case "Vitenamese":

                String username = Driver.findElement(By.xpath("//*[@role='main']//*[contains(text(), 'Tên người dùng:')]")).getText().replace("Tên người dùng: ", "");
                String password = Driver.findElement(By.xpath("//*[@role='main']//*[contains(text(), 'Mật khẩu:')]")).getText().replace("Mật khẩu: ", "");
                FileReader.addData("username", username);
                FileReader.addData("password", password);
                break;
        }

        switch (language) {
            case "Chinese":

                String username = Driver.findElement(By.xpath("//*[@class='adn ads']//*[contains(text(), '用户名:')]")).getText().replace("用户名: ", "");
                String password = Driver.findElement(By.xpath("//*[@class='adn ads']//*[contains(text(), '密码:')]")).getText().replace("密码: ", "");
                FileReader.addData("username", username);
                FileReader.addData("password", password);
                break;
        }

        switch (language) {
            case "ChineseTraditional":

                String username = Driver.findElement(By.xpath("//*[@class='adn ads']//*[contains(text(), '使用者名稱：:')]")).getText().replace("使用者名稱：: ", "");
                String password = Driver.findElement(By.xpath("//*[@class='adn ads']//*[contains(text(), '密碼：:')]")).getText().replace("密碼：: ", "");
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



    @Then("^I enter an email address of \"([^\"]*)\"$")
    public void iEnterAnEmailAddressOf(String email) throws Throwable {
        Register register = new Register();
        FileReader.addData("emailAddress", email);
        register.Email().clear();
        register.Email().sendKeys(email);
    }

    @And("^I enter a confirmation email address of \"([^\"]*)\"$")
    public void iEnterAConfirmationEmailAddressOf(String email) throws Throwable {
        Register register = new Register();
        email = FileReader.readProperties().get("emailAddress");
        register.EmailConfirm().clear();
        register.EmailConfirm().sendKeys(email);
    }

    @And("^I select the Use the Same Email Address checkbox$")
    public void iSelectTheUseTheSameEmailAddressCheckbox() throws Throwable {
        Register register = new Register();
        register.SameEmailAddressCheckbox().click();
    }

    @Then("^I register a Unique first name$")
    public void iRegisterAUniqueFirstName() throws Throwable {
        Register register = new Register();
        register.FirstName().clear();
        String firstName = RandomStringUtils.randomAlphabetic(5);
        FileReader.addData("uniqueFirstName", firstName);
        register.FirstName().sendKeys(firstName);
    }

    @Then("^I register a Unique Surname$")
    public void iRegisterAUniqueSurname() throws Throwable {
        Register register = new Register();
        register.Surname().clear();
        String surname = RandomStringUtils.randomAlphabetic(5);
        FileReader.addData("uniqueSurname", surname);
        register.Surname().sendKeys(surname);
    }



}
