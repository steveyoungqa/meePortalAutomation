package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import webDriver.Driver;

public class Register {

    public WebElement FirstName() {
        return Driver.findElement(By.id("_FirstName"));
    }

    public WebElement Surname() {
        return Driver.findElement(By.id("_LastName"));
    }

    public WebElement NextButton() {
        return Driver.findElement(By.id("_nextBtn"));
    }

    public WebElement Email() {
        return Driver.findElement(By.id("_EmailAddress"));
    }

    public WebElement EmailConfirm() {
        return Driver.findElement(By.id("_ConfirmEmailAddress"));
    }

    public WebElement optInCheckbox() {
        return Driver.findElement(By.id("_MacmillanOptIn"));
    }

    public WebElement helpIcon() {
        return Driver.findElement(By.id("help"));
    }

    public WebElement EmailAddress() {
        return Driver.findElement(By.id("_EmailAddress"));
    }

    public WebElement ConfirmEmail() {
        return Driver.findElement(By.id("_ConfirmEmailAddress"));
    }

    public WebElement TermsLink() {
        return Driver.findElement(By.id("_TermsOfUse"));
    }

    public WebElement PrivacyPolicy() {
        return Driver.findElement(By.id("_PrivacyPolicy"));
    }

    public WebElement OptInCheckbox() {
        return Driver.findElement(By.id("_MacmillanOptIn"));
    }

    public WebElement SubmitButton() {
        return Driver.findElement(By.xpath("//*[@type='submit']"));
    }

    public WebElement ForgotSubmitButton() {
        return Driver.findElement(By.xpath("//*[@type='submit']"));
    }

    public WebElement BackButton() {
        return Driver.findElement(By.id("_backBtn"));
    }

    public WebElement RegistrationComplete() {
        return Driver.findElement(By.xpath("//*[@class='mee-mail-notification']"));
    }

    public WebElement CloseButton() {
        return Driver.findElement(By.xpath("//*[@class='mee-button mee-app-home']"));
    }

    public WebElement message(String message) {
        return Driver.findElement(By.xpath("//*[contains(text(),'" + message + "')]"));
    }

    public WebElement activate(String activate) {
        return Driver.findElement(By.xpath("//*[contains(text(),'" + activate + "')]"));
    }


    public WebElement MailNotification() {
        return Driver.findElement(By.className("mee-module-mail-notification"));
    }

    public WebElement PasswordChangedMessage() {
        return Driver.findElement(By.xpath("//*[@class='mee-module-mail-notification']//*[contains(text(), 'You have changed your password')]"));
    }

    public WebElement ForgotEmailSent() {
        return Driver.findElement(By.xpath("//*[@class='mee-module-mail-notification']//*[contains(text(), 'Check your email for your username.')]"));
    }

    public WebElement ForgotEmailUserAndPassword() {
        return Driver.findElement(By.xpath("//*[@class='mee-module-mail-notification']//*[contains(text(), 'Check your email for your username and password.')]"));
    }

    public WebElement ResetPasswordSent() {
        return Driver.findElement(By.xpath("//*[@class='mee-module-mail-notification']//*[contains(text(), 'Check your email for a link to reset your password.')]"));
    }

    public WebElement ResetPasswordLink() {
        return Driver.findElement(By.xpath("//*[text()='here']"));
    }

    public WebElement ProfileIcon() {
        return Driver.findElement(By.xpath("//*[@class='mee-icon-profile']"));
    }

    public WebElement AddResourceIcon() {
        return Driver.findElement(By.xpath("//*[@class='mee-icon-add']"));
    }

    public WebElement AccessCodeField() {
        return Driver.findElement(By.id("_AccessCode"));
    }

    public WebElement AccessCodeNextButton() {
        return Driver.findElement(By.xpath("//*[@class='mee-align-center']"));
    }

    public WebElement ProfileHelpIcon() {
        return Driver.findElement(By.xpath("//*[@class='mee-icon-help-white']"));
    }

    public WebElement ChangePassword() {
        return Driver.findElement(By.xpath("//*[@class='mee-button'][contains(text(), 'Change password')]"));
    }

    public WebElement EditPassword() {
        return Driver.findElement(By.xpath("//*[@class='mee-button'][contains(text(), 'Edit details')]"));
    }

    public static Select CountrySelector() {
        return new Select(Driver.findElement(By.xpath("//*[@data-flux-key='countryOfResidence']")));
    }

    public static Select DaySelector() {
        return new Select(Driver.findElement(By.xpath("//*[@id='_DateOfBirth_Day']")));
    }

    public static Select MonthSelector() {
        return new Select(Driver.findElement(By.xpath("//*[@id='_DateOfBirth_Month']")));
    }

    public static Select YearSelector() {
        return new Select(Driver.findElement(By.xpath("//*[@id='_DateOfBirth_Year']")));
    }

    //Mailinator selectors
    public WebElement MailinatorInboxField() {
        return Driver.findElement(By.id("inboxfield"));
    }

    public WebElement MailinatorGoButton() {
        return Driver.findElement(By.xpath("//*[@class='btn btn-dark'][contains(text(), 'Go')]"));
    }

    public WebElement MailinatorEmailLink() {
        return Driver.findElement(By.xpath("//*[@class='innermail ng-binding'][contains(text(), 'Macmillan Education')]"));
    }

    public WebElement MailinatorEmailUsernameLink() {
        return Driver.findElement(By.xpath("//*[@class='innermail ng-binding'][contains(text(), 'Macmillan Education Everywhere - Your username')]"));
    }

    public WebElement MailinatorClickEmailLink() {
        return Driver.findElement(By.xpath("//*[contains(text(), 'Go here to login')]"));
    }

    public WebElement MailinatorMinorClickEmailLink() {
        return Driver.findElement(By.xpath("//*[contains(text(), 'Click this link to confirm your email address.')]"));
    }

    public WebElement MailinatorGoHereToLoginLink() {
        return Driver.findElement(By.xpath("//*[contains(text(), 'Go here to login')]"));
    }

    public WebElement MailinatorClickEmailLinkSpanish() {
        return Driver.findElement(By.xpath("//*[contains(text(), 'Entra aquí para acceder')]"));
    }

    public WebElement MailinatorClickEmailLinkJapanese() {
        return Driver.findElement(By.xpath("//*[contains(text(), 'ログインはこちらから')]"));
    }

    public WebElement MailinatorClickEmailLinkKorean() {
        return Driver.findElement(By.xpath("//*[contains(text(), '로그인하려면 여기로 이동하세요.')]"));
    }

    public WebElement MailinatorClickEmailLinkTaiwan() {
        return Driver.findElement(By.xpath("//*[contains(text(), 'เข้าสู่ระบบตรงนี้')]"));
    }

    public WebElement MailinatorClickEmailLinkVietnamese() {
        return Driver.findElement(By.xpath("//*[contains(text(), 'Vào đây để đăng nhập')]"));
    }

    public WebElement MailinatorClickEmailLinkChinese() {
        return Driver.findElement(By.xpath("//*[contains(text(), '转至此处登录')]"));
    }

    public WebElement MailinatorClickEmailLinkChineseTraditional() {
        return Driver.findElement(By.xpath("//*[contains(text(), '請點這裡登入')]"));
    }


}
