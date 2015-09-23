package supportMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import pageObject.LoginPage;
import pageObject.SampleSignInObject;
import pageObject.SamplePageObject;
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

	public static void LoginAdminPortal(String username, String password) {

		SamplePageObject admin = new SamplePageObject();

		admin.Username().sendKeys(username);
		SamplePageObject.Password(password);
		admin.Login().click();

	}

	public static void CleanUpUsernameChange() {

		SamplePageObject admin = new SamplePageObject();
		admin.UsersSectionNavigation().click();
		admin.UsernameSearchField().sendKeys("wprit12");
		admin.SearchButton().click();
		admin.EditUserButton().click();
		SamplePageObject.EditUserButtons("Update user's username");
		admin.NewUsernameField().sendKeys("wprit1");
		admin.UpdateUsernameConfirm().get(0).click();
		admin.ClosePopupWindow().get(0).click();
		String username = admin.UsernameDisplayed().getAttribute("innerText");
		username.equals("wprit1");
	}

	public static void CleanUpPasswordChange() {

		SamplePageObject admin = new SamplePageObject();
		admin.UsersSectionNavigation().click();
		admin.UsernameSearchField().sendKeys("wprit1");
		admin.SearchButton().click();
		admin.EditUserButton().click();
		SamplePageObject.EditUserButtons("Reset User Password");
		SamplePageObject.Password("password");
		admin.UpdateUsernameConfirm().get(0).click();
		admin.ClosePopupWindow().get(0).click();
	}

	public static void CleanUpUserDetails() {

		SamplePageObject admin = new SamplePageObject();
		admin.UsersSectionNavigation().click();
		admin.UsernameSearchField().sendKeys("wprit1");
		admin.SearchButton().click();
		admin.EditUserButton().click();
		admin.EditFirstName().clear();
		admin.EditFirstName().sendKeys("will");
		admin.EditLastName().clear();
		admin.EditLastName().sendKeys("prit");
		admin.EditCountry().sendKeys("United Kingdom");
		admin.SaveChanges().get(0).click();
		admin.ClosePopupWindow().get(0).click();

	}

	public static void ApplicationUpdateMessageCheck() {
		try {
			Driver.findElement(By.className("mee-button-gray")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
