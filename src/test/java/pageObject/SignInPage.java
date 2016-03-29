package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webDriver.Driver;

import java.util.List;


public class SignInPage {

	public List<WebElement> Login;
	public List<WebElement> Register;
	public WebElement Username;
	public WebElement Password;
	public WebElement LoginButton;
	public WebElement ForgotUsername;
	public WebElement ForgotPassword;
	public WebElement ForgotUserPass;
	
	
	public void LandingPageApp(){
		
		Login = Driver.findElements(By.xpath("//*[@data-reactid='.1.2.1.0']"));
		Register = Driver.findElements(By.xpath("//*[@data-reactid='.1.2.0.0']"));

	}
	
	public void LandingPagePortal(){

		Login = Driver.findElements(By.xpath("//*[@data-reactid='.1.2.1.0']"));
		Register = Driver.findElements(By.xpath("//*[@data-reactid='.1.2.0.0']"));
	}
	
	public void LoginPage(WebDriver mDriver){
		Username = Driver.findElement(By.id("username"));
		Password = Driver.findElement(By.id("password"));
	}
}
