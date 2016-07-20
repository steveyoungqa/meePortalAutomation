package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webDriver.Driver;


public class Gmail {

    public WebElement GmailFrontPageSignIn() {
        return Driver.findElement(By.id("gmail-sign-in"));
    }

    public WebElement GmailInboxField() {
        return Driver.findElement(By.id("Email"));
    }

    public WebElement GmailNextButton() {
        return Driver.findElement(By.id("next"));
    }

    public WebElement GmailPasswordField() {
        return Driver.findElement(By.id("Passwd"));
    }

    public WebElement GmailStaySignedInCheckbox() {
        return Driver.findElement(By.id("PersistentCookie"));
    }

    public WebElement GmailSignIn() {
        return Driver.findElement(By.id("signIn"));
    }

    public WebElement GmailAnyMacmillanEmail () {
        return Driver.findElement(By.xpath("//*[@class='y6']//*[contains(text(), 'Macmillan Education Everywhere')]"));
    }

    public WebElement GmailResetYourPassword() {
        return Driver.findElement(By.xpath("//*[@class='y6']//*[contains(text(), 'Reset your password ')]"));
    }

    public WebElement GmailPasswordChanged() {
        return Driver.findElement(By.xpath("//*[@class='y6']//*[contains(text(), 'Macmillan Education Everywhere - Password changed')]"));
    }
    public WebElement GmailDetailsChanged() {
        return Driver.findElement(By.xpath("//*[@class='y6']//*[contains(text(), 'Macmillan Education Everywhere - Details changed')]"));
    }

    public WebElement GmailYourUsernameEmail () {
        return Driver.findElement(By.xpath("//*[@class='y6']//*[contains(text(), 'Your username for your Macmillan')]"));
    }

    public WebElement GmailMacmillanEmail() {
        return Driver.findElement(By.xpath("//*[@class='y6']//*[contains(text(), 'Thank you for creating your Macmillan Education Everywhere (MEE) account')]"));
    }

    public WebElement GmailMacmillanEmailSpanish() {
        return Driver.findElement(By.xpath("//*[@class='y6']//*[contains(text(), 'Gracias por registrarte en Macmillan Education Everywhere')]"));
    }

    public WebElement GmailMacmillanEmailJapanese() {
        return Driver.findElement(By.xpath("//*[@name='noreply']"));
    }

    public WebElement GmailMacmillanEmailKorean() {
        return Driver.findElement(By.xpath("//*[@class='y6']//*[contains(text(), 'Macmillan Education Everywhere (MEE) 계정을 만들어 주셔서 감사합니다')]"));
    }

    public WebElement GmailMacmillanEmailTaiwanese() {
        return Driver.findElement(By.xpath("//*[@class='y6']//*[contains(text(), 'ขอบคุณสำหรับการสร้างบัญชี Macmillan Education Everywhere (MEE) ของคุณ')]"));
    }

    public WebElement GmailMacmillanEmailVietnamese() {
        return Driver.findElement(By.xpath("//*[@class='y6']//*[contains(text(), 'Cảm ơn bạn đã tạo tài khoản Macmillan Education Everywhere (MEE)')]"));
    }

    public WebElement GmailMacmillanEmailChinese() {
        return Driver.findElement(By.xpath("//*[@name='noreply']"));
    }

    public WebElement GmailMacmillanEmailChineseTraditional() {
        return Driver.findElement(By.xpath("//*[@name='noreply']"));
    }

    public WebElement GmailClickEmailLink() {
        return Driver.findElement(By.xpath("//*[@role='main']//*[contains(text(), 'Go here to login')]"));
    }

    public WebElement GmailMinorClickEmailLink() {
        return Driver.findElement(By.xpath("//*[@role='main']//*[contains(text(), 'Click this link to confirm your email address.')]"));
    }
    
    public WebElement GmailClickEmailLinkSpanish() {
        return Driver.findElement(By.xpath("//*[contains(text(), 'Entra aquí para acceder')]"));
    }

    public WebElement GmailClickEmailLinkJapanese() {
        return Driver.findElement(By.xpath("//*[@role='main']//*[contains(text(), 'ログインはこちらから')]"));
    }

    public WebElement GmailClickEmailLinkKorean() {
        return Driver.findElement(By.xpath("//*[text()='로그인하려면 여기로 이동하세요.']"));
    }

    public WebElement GmailClickEmailLinkTaiwan() {
        return Driver.findElement(By.xpath("//*[contains(text(), 'เข้าสู่ระบบตรงนี้')]"));
    }

    public WebElement GmailClickEmailLinkVietnamese() {
        return Driver.findElement(By.xpath("//*[contains(text(), 'Vào đây để đăng nhập')]"));
    }

    public WebElement GmailClickEmailLinkChinese() {
        return Driver.findElement(By.xpath("//*[@role='main']//*[contains(text(), '转至此处登录')]"));
    }

    public WebElement GmailClickEmailLinkChineseTraditional() {
        return Driver.findElement(By.xpath("//*[@role='main']//*[contains(text(), '請點這裡登入')]"));
    }

    public WebElement GmailExpandEmail () {
        return Driver.findElement(By.xpath("//*[@src='images/cleardot.gif'][@role='menu']"));
    }

    public WebElement GmailSelectAllMenu () {
        return Driver.findElement(By.xpath("//*[@data-tooltip='Select']"));
    }

    public WebElement GmailTrashIcon() {
        return Driver.findElement(By.xpath("//*[@data-tooltip='Delete']"));
    }

    public WebElement GmailDeleteEmail () {
        return Driver.findElement(By.xpath("//*[contains(text(), 'Delete this message')]"));
    }

    public WebElement GmailSignOutLogo () {
        return Driver.findElement(By.xpath("//*[@class='gb_3a gbii']"));
    }

    public WebElement GmailSignOutLink() {
        return Driver.findElement(By.xpath("//*[@aria-label='Account Information']//*[contains(text(), 'Sign out')]"));
    }

    public WebElement EmailBodyContains (String contains) {
        return Driver.findElement(By.xpath("//*[@role='main']//*[contains(text(),'" + contains + "')]"));
    }
}
