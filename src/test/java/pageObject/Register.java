package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import webDriver.Driver;

import java.io.IOException;

public class Register {

    public WebElement FirstName()throws IOException {
        return Driver.findElement(By.id("_FirstName"));
    }

    public WebElement Surname()throws IOException {
        return Driver.findElement(By.id("_LastName"));
    }

    public WebElement NextButton()throws IOException {
        return Driver.findElement(By.id("_nextBtn"));
    }

    public WebElement Email()throws IOException {
        return Driver.findElement(By.id("_EmailAddress"));
    }

    public WebElement EmailConfirm()throws IOException {
        return Driver.findElement(By.id("_ConfirmEmailAddress"));
    }

    public WebElement optInCheckbox()throws IOException {
        return Driver.findElement(By.id("_MacmillanOptIn"));
    }

    public WebElement thirdPartyCheckbox()throws IOException {
        return Driver.findElement(By.id("_ThirdPartyOptIn"));
    }

    public WebElement TermsConditionsCheckbox()throws IOException {
        return Driver.findElement(By.id("_AgreeToTermsOfUse"));
    }

    public WebElement NewTermsConditionsCheckbox()throws IOException {
        return Driver.findElement(By.id("_AgreeToTermsOfUseLabel"));
    }

    public WebElement SameEmailAddressCheckbox()throws IOException {
        return Driver.findElement(By.id("_ReuseEmailAddress"));
    }

    public WebElement EmailAddress()throws IOException {
        return Driver.findElement(By.id("_EmailAddress"));
    }

    public WebElement ConfirmEmail()throws IOException {
        return Driver.findElement(By.id("_ConfirmEmailAddress"));
    }

    public WebElement TermsLink()throws IOException {
        return Driver.findElement(By.xpath("//*[@id='_AgreeToTermsOfUseLabel']/span/a[1]"));
    }

    public WebElement PrivacyPolicy() throws IOException{
        return Driver.findElement(By.xpath("//*[@id='_AgreeToTermsOfUseLabel']/span/a[2]"));
    }

    public WebElement CookiePolicy() throws IOException{
        return Driver.findElement(By.xpath("//*[@id='_AgreeToTermsOfUseLabel']/span/a[3]"));
    }

    public WebElement OptInCheckbox()throws IOException {
        return Driver.findElement(By.id("_MacmillanOptIn"));
    }

    public WebElement SubmitButton()throws IOException {
        return Driver.findElement(By.xpath("//*[@type='submit']"));
    }

    public WebElement CancelButton()throws IOException {
        return Driver.findElement(By.xpath(".//*[@class='editorial']//*[contains(text(), 'Cancel')]"));
    }

    public WebElement ResgisterAndActivateCode()throws IOException {
        return Driver.findElement(By.xpath("//*[@value='Register and activate code']"));
    }

    public WebElement AlreadyRegisteredLink() throws IOException {
        return Driver.findElement(By.xpath("//*[@class='mee-white']"));
    }

    public WebElement ForgotSubmitButton()throws IOException {
        return Driver.findElement(By.xpath("//*[@type='submit']"));
    }

    public WebElement BackButton()throws IOException {
        return Driver.findElement(By.id("_backBtn"));
    }

    public WebElement RegistrationComplete() throws IOException{
        return Driver.findElement(By.xpath("//*[@class='mee-mail-notification']"));
    }

    public WebElement CloseButton() throws IOException{
        return Driver.findElement(By.xpath("//*[@class='mee-button'][contains(text(), 'Close')]"));
    }

    public WebElement message(String message) throws IOException{
        return Driver.findElement(By.xpath("//*[contains(text(),'" + message + "')]"));
    }

    public WebElement activate(String activate) throws IOException{
        return Driver.findElement(By.xpath("//*[contains(text(),'" + activate + "')]"));
    }

    public WebElement MailNotification()throws IOException {
        return Driver.findElement(By.xpath("//*[@class='mee-module-mail-notification']//*[contains(text(), 'Thank you for registering!')]"));
    }

    public WebElement MailNotificationSpanish()throws IOException {
        return Driver.findElement(By.xpath("//*[@class='mee-module-mail-notification']//*[contains(text(), '¡Gracias por registrarse!')]"));
    }

    public WebElement MailNotificationKorean()throws IOException {
        return Driver.findElement(By.xpath("//*[@class='mee-module-mail-notification']//*[contains(text(), '등록해 주셔서 감사합니다!')]"));
    }

    public WebElement MailNotificationJapanese()throws IOException {
        return Driver.findElement(By.xpath("//*[@class='mee-module-mail-notification']//*[contains(text(), 'ご登録いただきありがとうございます')]"));
    }

    public WebElement MailNotificationTaiwan()throws IOException {
        return Driver.findElement(By.xpath("//*[@class='mee-module-mail-notification']//*[contains(text(), 'ขอบคุณสำหรับการลงทะเบียน!')]"));
    }

    public WebElement MailNotificationVitenamese()throws IOException {
        return Driver.findElement(By.xpath("//*[@class='mee-module-mail-notification']//*[contains(text(), 'Cảm ơn bạn đã đăng ký!')]"));
    }

    public WebElement MailNotificationChinese()throws IOException {
        return Driver.findElement(By.xpath("//*[@class='mee-module-mail-notification']//*[contains(text(), '感谢您注册')]"));
    }

    public WebElement MailNotificationChineseTraditional()throws IOException {
        return Driver.findElement(By.xpath("//*[@class='mee-module-mail-notification']//*[contains(text(), '感謝您的註冊')]"));
    }

    public WebElement PasswordChangedMessage() throws IOException{
        return Driver.findElement(By.xpath("//*[@class='mee-module-mail-notification']//*[contains(text(), 'You have successfully changed your password. Please log in with your new password.')]"));
    }

    public WebElement ForgotEmailSent() throws IOException{
        return Driver.findElement(By.xpath("//*[@class='mee-module-mail-notification']//*[contains(text(), 'Check your email for your username.')]"));
    }

    public WebElement ForgotEmailUserAndPassword() throws IOException{
        return Driver.findElement(By.xpath("//*[@class='mee-module-mail-notification']//*[contains(text(), 'Check your email for your username and password.')]"));
    }

    public WebElement ResetPasswordSent() throws IOException{
        return Driver.findElement(By.xpath("//*[@class='mee-module-mail-notification']//*[contains(text(), 'Check your email for a link to reset your password.')]"));
    }

    public WebElement ResetPasswordLink()throws IOException {
        return Driver.findElement(By.xpath("//*[text()='Please click here to reset the password.']"));
    }

    public WebElement ProfileIcon()throws IOException {
        return Driver.findElement(By.xpath("//*[@class='mee-icon-profile']"));
    }

    public WebElement AddResourceIcon()throws IOException {
        return Driver.findElement(By.xpath("//*[@class='mee-icon-add']"));
    }

    public WebElement AccessCodeField()throws IOException {
        return Driver.findElement(By.id("_AccessCode"));
    }

    public WebElement ClickAwayFromAccessField()throws IOException {
        return Driver.findElement(By.id("js-page-content"));
    }

    public WebElement AccessCodeNextButton()throws IOException {
        return Driver.findElement(By.id("_submitBtn"));
    }

    public WebElement ProfileHelpIcon()throws IOException {
        return Driver.findElement(By.xpath("//*[@class='mee-icon-help-white']"));
    }

    public WebElement ChangePassword() throws IOException{
        return Driver.findElement(By.xpath("//*[@class='mee-button'][contains(text(), 'Change password')]"));
    }

    public WebElement EditPassword() throws IOException{
        return Driver.findElement(By.xpath("//*[@class='mee-button'][contains(text(), 'Edit details')]"));
    }

    public static Select CountrySelector() throws IOException{
        return new Select(Driver.findElement(By.xpath("//*[@data-flux-key='countryOfResidence']")));
    }

    public static Select DaySelector() throws IOException{
        return new Select(Driver.findElement(By.xpath("//*[@id='_DateOfBirth_Day']")));
    }

    public static Select MonthSelector() throws IOException{
        return new Select(Driver.findElement(By.xpath("//*[@id='_DateOfBirth_Month']")));
    }

    public static Select YearSelector() throws IOException{
        return new Select(Driver.findElement(By.xpath("//*[@id='_DateOfBirth_Year']")));
    }

    public WebElement CustomerServiceLink () throws IOException{
        return Driver.findElement(By.xpath("//*[@class='mee-footer mee-error mee-align-text-center mee-error-container']//*[contains(text(), 'contact our Customer Service team')]"));
    }

    public WebElement ContinueButton() throws IOException{
        return Driver.findElement(By.xpath("//*[@class='mee-align-text-center']//*[contains(text(), 'Continue')]"));
    }

}
