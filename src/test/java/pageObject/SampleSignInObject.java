package pageObject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import webDriver.Driver;


public class SampleSignInObject {

	public List<WebElement> Login;
	public List<WebElement> Register;
	public WebElement Username;
	public WebElement Password;
	public WebElement LoginButton;
	public WebElement ForgotUsername;
	public WebElement ForgotPassword;
	public WebElement ForgotUserPass;
	
	
	public void LandingPageApp(){
		
		Login = Driver.findElements(By.cssSelector("a[href*='#/login']"));
		Register = Driver.findElements(By.cssSelector("a[href*='#/register']"));

	}
	
	public void LandingPagePortal(){

		Login = Driver.findElements(By.cssSelector("a[href*='/Login']"));
		Register = Driver.findElements(By.cssSelector("a[href*='/Registration']"));
	}
	
	public void LoginPage(WebDriver mDriver){
		Username = Driver.findElement(By.id("username"));
		Password = Driver.findElement(By.id("password"));		
	}
}
