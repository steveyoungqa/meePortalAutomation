package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import webDriver.Driver;

public class LoginPage {

    public WebElement FromRegisterSuccessToLogin() {
        return Driver.findElement(By.cssSelector(".mee-button.mee-white"));
    }

    public WebElement LoginLandingPage() {
        return Driver.findElement(By.xpath("//*[@data-reactid='.1.2.1.0']"));
    }

    public WebElement RegisterLandingPage() {
        return Driver.findElement(By.xpath("//*[@data-reactid='.1.2.0.0']"));
    }

    public WebElement UsernameApp() {
        return Driver.findElement(By.xpath("//input['Username' = translate(@id, 'u', 'U')]"));
    }

    public WebElement PasswordApp() {
        return Driver.findElement(By.id("password"));
    }

    public WebElement UsernameField() {
        return Driver.findElement(By.id("_Username"));
    }
    public WebElement ChangePasswordUsernameField() {
        return Driver.findElement(By.id("_UserName"));
    }

    public WebElement PasswordField() {
        return Driver.findElement(By.id("_Password"));
    }
    public WebElement CurrentPassword() {
        return Driver.findElement(By.id("_CurrentPassword"));
    }
    public WebElement NewPasswordField() {
        return Driver.findElement(By.id("_NewPassword"));
    }
    public WebElement ConfirmNewPasswordField() {
        return Driver.findElement(By.id("_ConfirmPassword"));
    }

    public WebElement LoginButton() {
        return Driver.findElement(By.xpath(".//input[@type='submit']"));
    }

    public WebElement LogoutButton() {
        return Driver.findElement(By.xpath("//*[@class='mee-icon-logout']"));
    }

    public WebElement DownloadTitle() {
        return Driver.findElement(By.xpath("//*[@class='mee-intro']//*[contains(text(), 'Download the Macmillan Education Everywhere App')]"));
    }

    public WebElement ForgotUsername() {
        return Driver.findElement(By.id("_ForgotUsername"));
    }

    public WebElement ForgotPassword() {
        return Driver.findElement(By.id("_ForgotPassword"));
    }

    public WebElement ForgotUsernameAndPassword() {
        return Driver.findElement(By.id("_ForgotUsernameAndPassword"));
    }

    public static Select LanguageSelector() {
        return new Select(Driver.findElement(By.xpath("//*[@class='mee-select mee-purple-select']//*[@data-reactid = '.0.0']")));
    }

    public static WebElement errorMessage(String dataValmsgFor) {
        return Driver.findElement(By.xpath("//*[@class='mee-validation field-validation-error'][contains(text(),'" + dataValmsgFor + "')]"));
    }
}
