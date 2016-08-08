package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import webDriver.Driver;

import java.io.IOException;

public class LoginPage {

    public WebElement FromRegisterSuccessToLogin() throws IOException {
        return Driver.findElement(By.cssSelector(".mee-button.mee-white"));
    }

    public WebElement LoginLandingPage() throws IOException{
        return Driver.findElement(By.xpath("//*[@data-reactid='.1.2.1.0']"));
    }

    public WebElement CloseForm()throws IOException {
        return Driver.findElement(By.xpath("//*[@class='mee-icon-close']"));
    }

    public WebElement RegisterLandingPage()throws IOException {
        return Driver.findElement(By.xpath("//*[@data-reactid='.1.2.0.0']"));
    }

    public WebElement UsernameApp() throws IOException{
        return Driver.findElement(By.xpath("//input['Username' = translate(@id, 'u', 'U')]"));
    }

    public WebElement PasswordApp()throws IOException {
        return Driver.findElement(By.id("password"));
    }

    public WebElement UsernameField()throws IOException {
        return Driver.findElement(By.id("_Username"));
    }

    public WebElement ChangePasswordUsernameField()throws IOException {
        return Driver.findElement(By.id("_UserName"));
    }

    public WebElement PasswordField()throws IOException {
        return Driver.findElement(By.id("_Password"));
    }

    public WebElement CurrentPassword()throws IOException {
        return Driver.findElement(By.id("_CurrentPassword"));
    }

    public WebElement NewPasswordField()throws IOException {
        return Driver.findElement(By.id("_NewPassword"));
    }

    public WebElement ConfirmNewPasswordField()throws IOException {
        return Driver.findElement(By.id("_ConfirmPassword"));
    }

    public WebElement LoginButton()throws IOException {
        return Driver.findElement(By.xpath(".//input[@type='submit']"));
    }

    public WebElement LogoutButton()throws IOException {
        return Driver.findElement(By.xpath("//*[@class='mee-icon-logout']"));
    }

    public WebElement DownloadTitle() throws IOException{
        return Driver.findElement(By.xpath("//*[@class='mee-intro']//*[contains(text(), 'Download the Macmillan Education Everywhere App')]"));
    }

    public WebElement ForgotUsername()throws IOException {
        return Driver.findElement(By.id("_ForgotUsername"));
    }

    public WebElement ForgotPassword()throws IOException {
        return Driver.findElement(By.id("_ForgotPassword"));
    }

    public WebElement ForgotUsernameAndPassword()throws IOException {
        return Driver.findElement(By.id("_ForgotUsernameAndPassword"));
    }

    public static Select LanguageSelector() throws IOException{
        return new Select(Driver.findElement(By.xpath("//*[@class='mee-select mee-purple-select']//*[@data-reactid = '.1.0']")));
    }

    public static WebElement errorMessage(String dataValmsgFor) throws IOException{
        return Driver.findElement(By.xpath("//*[@class='mee-validation field-validation-error'][contains(text(),'" + dataValmsgFor + "')]"));
    }

    public WebElement helpIcon() throws IOException{
        return Driver.findElement(By.xpath("//*[@class='mee-icon-help-white mee-vertical-center']"));
    }

    public Select topRightLanguageSelector () throws IOException{
        return new Select(Driver.findElement(By.xpath("//*[@class='mee-select mee-white-select mee-vertical-center']//*[@data-reactid = '.0.1.1.0.0']")));
    }
}
