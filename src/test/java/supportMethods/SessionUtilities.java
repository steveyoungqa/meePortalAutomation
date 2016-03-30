package supportMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObject.LoginPage;
import webDriver.Driver;

public class SessionUtilities {

    static Boolean loggedInApp = false;
    static Boolean loggedInWeb = false;

    public static void Login(String userName, String password) {

        // TODO: Adjust the method to work with new framework changes.

        LoginPage login = new LoginPage();

        login.UsernamePortal().sendKeys(userName);
        login.PasswordPortal().sendKeys(password);
        login.LoginButton().click();
        loggedInWeb = true;
    }


    public String getCulture(WebDriver mDriver) {

        String countryCode = null;
        return countryCode;
    }

//	public static void LoginAdminPortal(String username, String password) throws Exception{
//
//		AdminPortal admin = new AdminPortal();
//
//		admin.Username().sendKeys(username);
//		AdminPortal.Password(password);
//		admin.Login().click();
//		Thread.sleep(2000);
//	}
//
//	public static void CleanUpUsernameChange() {
//
//		AdminPortal admin = new AdminPortal();
//		admin.UsersSectionNavigation().click();
//		admin.UsernameSearchField().sendKeys("wprit12");
//		admin.SearchButton().click();
//		admin.EditUserButton().click();
//		AdminPortal.EditUserButtons("Update user's username");
//		admin.NewUsernameField().sendKeys("wprit1");
//		admin.UpdateUsernameConfirm().get(0).click();
//		admin.ClosePopupWindow().get(0).click();
//		String username = admin.UsernameDisplayed().getAttribute("innerText");
//		username.equals("wprit1");
//	}
//
//	public static void CleanUpPasswordChange() {
//
//		AdminPortal admin = new AdminPortal();
//		admin.UsersSectionNavigation().click();
//		admin.UsernameSearchField().sendKeys("wprit1");
//		admin.SearchButton().click();
//		admin.EditUserButton().click();
//		AdminPortal.EditUserButtons("Reset User Password");
//		AdminPortal.Password("password");
//		admin.UpdateUsernameConfirm().get(0).click();
//		admin.ClosePopupWindow().get(0).click();
//	}
//
//	public static void CleanUpUserDetails() {
//
//		AdminPortal admin = new AdminPortal();
//		admin.UsersSectionNavigation().click();
//		admin.UsernameSearchField().sendKeys("wprit1");
//		admin.SearchButton().click();
//		admin.EditUserButton().click();
//		admin.EditFirstName().clear();
//		admin.EditFirstName().sendKeys("will");
//		admin.EditLastName().clear();
//		admin.EditLastName().sendKeys("prit");
//		admin.EditCountry().sendKeys("United Kingdom");
//		admin.SaveChanges().get(0).click();
//		admin.ClosePopupWindow().get(0).click();
//
//	}

    public static void ApplicationUpdateMessageCheck() {
        try {
            Driver.findElement(By.className("mee-button-gray")).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
