package supportMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import pageObject.LoginPage;
import pageObject.SampleSignInObject;
import webDriver.Driver;

public class SessionUtilities {

	static Boolean loggedInApp = false;
	static Boolean loggedInWeb = false;

	public static void Login(String userName, String password) {

		// TODO: Adjust the method to work with new framework changes.

		LoginPage login = new LoginPage();
		if (Driver.currentDriver == Driver.chromiumDriver) {
			if (!loggedInApp) {
				try {
					Driver.findElement(By.cssSelector("a[href*='#/logout']"))
							.click();
				} catch (ElementNotVisibleException e) {
					e.printStackTrace();
				} catch (TimeoutException f) {
					f.printStackTrace();
				}

				SampleSignInObject landing = new SampleSignInObject();
				landing.LandingPageApp();
				landing.Login.get(0).click();
				login.UsernameApp().sendKeys(userName);
				login.PasswordApp().sendKeys(password);
				login.LoginButton().click();
				loggedInApp = true;
			}
		}
		if (Driver.currentDriver == Driver.chromeDriver) {
			if (!loggedInWeb) {
				try {
					Driver.findElement(By.cssSelector("a[href*='/Logout']"))
							.click();
				} catch (ElementNotVisibleException e) {
					e.printStackTrace();
				} catch (TimeoutException f) {
					f.printStackTrace();
				}

				try {
					SampleSignInObject landing = new SampleSignInObject();
					landing.LandingPagePortal();
					landing.Login.get(0).click();
				} catch (Exception e) {
				}

				login.UsernamePortal().sendKeys(userName);
				login.PasswordPortal().sendKeys(password);
				login.LoginButton().click();
				loggedInWeb = true;
			}
		}

	}

	public String getCulture(WebDriver mDriver) {

		String countryCode = null;
		return countryCode;
	}

	public static void ApplicationUpdateMessageCheck() {
		try {
			Driver.findElement(By.className("mee-button-gray")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
