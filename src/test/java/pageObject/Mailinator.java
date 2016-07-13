package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webDriver.Driver;


public class Mailinator {

    public WebElement MailinatorInboxField() {
        return Driver.findElement(By.id("inboxfield"));
    }

    public WebElement MailinatorGoButton() {
        return Driver.findElement(By.xpath("//*[@class='btn btn-dark'][contains(text(), 'Go')]"));
    }

    public WebElement MailinatorEmailLink() {
        return Driver.findElement(By.xpath("//*[@class='innermail ng-binding'][contains(text(), 'Macmillan Education')]"));
    }

    public WebElement MailinatorResetPasswordEmailLink() {
        return Driver.findElement(By.xpath("//*[@class='innermail ng-binding'][contains(text(), 'Macmillan Education Everywhere - Reset your password')]"));
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
    public WebElement MailinatorResetYourPasswordHereLink() {
        return Driver.findElement(By.xpath("//span[1]//*[contains(text(), 'here')]"));
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
        return Driver.findElement(By.xpath("//*[text()='เข้าสู่ระบบตรงนี้']"));
    }

    public WebElement MailinatorClickEmailLinkVietnamese() {
        return Driver.findElement(By.xpath("//*[contains(text(), 'Vào đây để đăng nhập')]"));
    }

    public WebElement MailinatorClickEmailLinkChinese() {
        return Driver.findElement(By.xpath("//*[text()= '转至此处登录']"));
    }

    public WebElement MailinatorClickEmailLinkChineseTraditional() {
        return Driver.findElement(By.xpath("//*[text()= '請點這裡登入']"));
    }
}
