package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import webDriver.Driver;

public class LoginPage {
	
	public WebElement FromRegisterSuccessToLogin() {
		return Driver.findElement(By.cssSelector(".mee-button.mee-white"));
	}
	public WebElement UsernameApp() {
		return Driver.findElement(By.xpath("//input['Username' = translate(@id, 'u', 'U')]"));
	}
	public WebElement PasswordApp() {
		return Driver.findElement(By.id("password"));	
	}	
	public WebElement UsernamePortal() {
		return Driver.findElement(By.id("Username"));
	}
	public WebElement PasswordPortal() {
		return Driver.findElement(By.id("Password"));	
	}
	public WebElement LoginButton() {
		return Driver.findElement(By.xpath(".//input[@type='submit']"));
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
		return Driver.findElement(By.cssSelector(".mee-validation.field-validation-error[data-valmsg-for*='" + dataValmsgFor +  "']"));
		
	}
}
