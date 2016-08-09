package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webDriver.Driver;

import java.io.IOException;


public class Gmail {

    public WebElement GmailFrontPageSignIn() throws IOException {
        return Driver.findElement(By.id("gmail-sign-in"));
    }

    public WebElement GmailInboxField() throws IOException{
        return Driver.findElement(By.id("Email"));
    }

    public WebElement GmailNextButton() throws IOException{
        return Driver.findElement(By.id("next"));
    }

    public WebElement GmailPasswordField() throws IOException{
        return Driver.findElement(By.id("Passwd"));
    }

    public WebElement GmailStaySignedInCheckbox()throws IOException {
        return Driver.findElement(By.id("PersistentCookie"));
    }

    public WebElement GmailSignIn()throws IOException {
        return Driver.findElement(By.id("signIn"));
    }

    public WebElement GmailAnyMacmillanEmail () throws IOException{
        return Driver.findElement(By.xpath("//*[@class='y6']//*[contains(text(), 'Macmillan Education Everywhere')]"));
    }

    public WebElement GmailResetYourPassword() throws IOException{
        return Driver.findElement(By.xpath("//*[@class='y6']//*[contains(text(), 'Reset your password ')]"));
    }

    public WebElement GmailPasswordChanged() throws IOException{
        return Driver.findElement(By.xpath("//*[@class='y6']//*[contains(text(), 'Macmillan Education Everywhere - Password changed')]"));
    }
    public WebElement GmailDetailsChanged() throws IOException{
        return Driver.findElement(By.xpath("//*[@class='y6']//*[contains(text(), 'Macmillan Education Everywhere - Details changed')]"));
    }

    public WebElement GmailYourUsernameEmail () throws IOException{
        return Driver.findElement(By.xpath("//*[@class='y6']//*[contains(text(), 'Your username for your Macmillan')]"));
    }

    public WebElement GmailMacmillanEmail()throws IOException {
        return Driver.findElement(By.xpath("//*[@class='y6']//*[contains(text(), 'Thank you for creating your Macmillan Education Everywhere (MEE) account')]"));
    }

    public WebElement GmailMacmillanEmailSpanish() throws IOException{
        return Driver.findElement(By.xpath("//*[@class='y6']//*[contains(text(), 'Gracias por registrarte en Macmillan Education Everywhere')]"));
    }

    public WebElement GmailMacmillanEmailJapanese()throws IOException {
        return Driver.findElement(By.xpath("//*[@name='noreply']"));
    }

    public WebElement GmailMacmillanEmailKorean() throws IOException{
        return Driver.findElement(By.xpath("//*[@class='y6']//*[contains(text(), 'Macmillan Education Everywhere (MEE) 계정을 만들어 주셔서 감사합니다')]"));
    }

    public WebElement GmailMacmillanEmailTaiwanese() throws IOException{
        return Driver.findElement(By.xpath("//*[@class='y6']//*[contains(text(), 'ขอบคุณสำหรับการสร้างบัญชี Macmillan Education Everywhere (MEE) ของคุณ')]"));
    }

    public WebElement GmailMacmillanEmailVietnamese() throws IOException{
        return Driver.findElement(By.xpath("//*[@class='y6']//*[contains(text(), 'Cảm ơn bạn đã tạo tài khoản Macmillan Education Everywhere (MEE)')]"));
    }

    public WebElement GmailMacmillanEmailChinese()throws IOException {
        return Driver.findElement(By.xpath("//*[@name='noreply']"));
    }

    public WebElement GmailMacmillanEmailChineseTraditional() throws IOException{
        return Driver.findElement(By.xpath("//*[@name='noreply']"));
    }

    public WebElement GmailClickEmailLink() throws IOException{
        return Driver.findElement(By.xpath("//*[@role='main']//*[contains(text(), 'Go here to login')]"));
    }

    public WebElement GmailMinorClickEmailLink() throws IOException{
        return Driver.findElement(By.xpath("//*[@role='main']//*[contains(text(), 'Click this link to confirm your email address.')]"));
    }
    
    public WebElement GmailClickEmailLinkSpanish() throws IOException{
        return Driver.findElement(By.xpath("//*[contains(text(), 'Entra aquí para acceder')]"));
    }

    public WebElement GmailClickEmailLinkJapanese() throws IOException{
        return Driver.findElement(By.xpath("//*[@role='main']//*[contains(text(), 'ログインはこちらから')]"));
    }

    public WebElement GmailClickEmailLinkKorean() throws IOException{
        return Driver.findElement(By.xpath("//*[text()='로그인하려면 여기로 이동하세요.']"));
    }

    public WebElement GmailClickEmailLinkTaiwan() throws IOException{
        return Driver.findElement(By.xpath("//*[contains(text(), 'เข้าสู่ระบบตรงนี้')]"));
    }

    public WebElement GmailClickEmailLinkVietnamese() throws IOException{
        return Driver.findElement(By.xpath("//*[contains(text(), 'Vào đây để đăng nhập')]"));
    }

    public WebElement GmailClickEmailLinkChinese() throws IOException{
        return Driver.findElement(By.xpath("//*[@role='main']//*[contains(text(), '转至此处登录')]"));
    }

    public WebElement GmailClickEmailLinkChineseTraditional() throws IOException{
        return Driver.findElement(By.xpath("//*[@role='main']//*[contains(text(), '請點這裡登入')]"));
    }

    public WebElement GmailExpandEmail () throws IOException{
        return Driver.findElement(By.xpath("//*[@src='images/cleardot.gif'][@role='menu']"));
    }

    public WebElement GmailSelectAllMenu ()throws IOException {
        return Driver.findElement(By.xpath("//*[@data-tooltip='Select']"));
    }

    public WebElement AllOptionDropdown () throws IOException {
        return Driver.findElement(By.xpath("//*[@selector='all']"));
    }

    public WebElement GmailTrashIcon() throws IOException {
        return Driver.findElement(By.xpath("//*[@data-tooltip='Delete']"));
    }

    public WebElement GmailDeleteEmail () throws IOException{
        return Driver.findElement(By.xpath("//*[contains(text(), 'Delete this message')]"));
    }

    public WebElement GmailSignOutLogo ()throws IOException {
        return Driver.findElement(By.xpath("//*[@class='gb_3a gbii']"));
    }

    public WebElement GmailSignOutLink() throws IOException{
        return Driver.findElement(By.xpath("//*[@aria-label='Account Information']//*[contains(text(), 'Sign out')]"));
    }

    public WebElement EmailBodyContains (String contains) throws IOException{
        return Driver.findElement(By.xpath("//*[@role='main']//*[contains(text(),'" + contains + "')]"));
    }
}
