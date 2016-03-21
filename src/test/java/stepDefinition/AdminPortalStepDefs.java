package stepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import supportMethods.SessionUtilities;
import enums.MeeAdminPortal;
import org.openqa.selenium.By;
import pageObject.AdminPortal;
//import pageObject.UserPortal;
//import supportMethods.SessionUtilities;
import testRunner.TestRunner;
import webDriver.Driver;
import webDriver.GlobalVariables;


public class AdminPortalStepDefs {


	AdminPortal admin = new AdminPortal();
	
	@Given("^I have navigated to the HTTP version of the admin portal Url$")
	public void i_have_navigated_to_the_HTTP_version_of_the_admin_portal_Url() throws Throwable {

//		Driver.loadPage(GlobalVariables.config.get("test"));
		String stripSsl = MeeAdminPortal.getUrl().replace("https", "http");
		Driver.loadPage(stripSsl);
	}

	@Then("^the new Url is in HTTPS format$")
	public void the_new_Url_is_in_HTTPS_format() throws Throwable {

		Driver.getCurrentUrl().contentEquals(MeeAdminPortal.getUrl());
	}

	@Given("^I have navigated to the admin portal$")
	public void i_have_navigated_to_the_admin_portal() throws Throwable {
		Driver.loadPage(MeeAdminPortal.getUrl());
        Thread.sleep(2000);
	}

	@Given("^I have entered a \"(.*?)\" and \"(.*?)\"$")
	public void i_have_entered_a_and(String username, String password) throws Throwable {

		admin.Username().sendKeys(username);
		AdminPortal.Password(password);
		admin.Login().click();
	}

	@When("^I click the Log in button$")
	public void i_click_the_Log_in_button() throws Throwable {

		admin.Login().click();

	}

	@Then("^A validation \"(.*?)\" is displayed$")
	public void a_validation_is_displayed(String validation) throws Throwable {
;
		if(validation.equals("validation-summary-errors")){

			 Driver.findElement(By.className(validation)).isDisplayed();
		}else{
			 Driver.findElement(By.id(validation)).isDisplayed();
		}
	}
//
//
	@Given("^I have logged into the admin portal$")
	public void i_have_logged_into_the_admin_portal() throws Throwable {

		SessionUtilities.LoginAdminPortal("meeadmin", "M4cmillan");
	}


	String field;
	String data;
	@When("^I enter a search parameter \"(.*?)\" into a search field \"(.*?)\"$")
	public void i_enter_a_search_parameter_into_a_search_field(String searchParameter, String searchField) throws Throwable {
		field = searchField;
		data = searchParameter;
		Driver.findElement(By.id("SearchBy" + searchField)).sendKeys(searchParameter);
	}

	@Given("^I have navigated to the Users page of the site$")
	public void i_have_navigated_to_the_Users_page_of_the_site() throws Throwable {

		admin.UsersSectionNavigation().click();
        Thread.sleep(2000);

	}

	@When("^Click the search button$")
	public void click_the_search_button() throws Throwable {

		admin.SearchButton().click();
        Thread.sleep(2000);
    }

	@Then("^appropriate results are displayed$")
	public void appropriate_results_are_displayed() throws Throwable {
	    String ariaDescribedby = null;
		switch (field) {
	    case "Email":
	    	ariaDescribedby = "SearchByEmail";
	    	break;
	    case "Username":
	    	ariaDescribedby = "SearchByUsername";
	    	break;
	    case "Firstname":
	    	ariaDescribedby = "SearchByUsername";
	    	break;
	    case "Lastname":
	    	ariaDescribedby = "SearchByLastname";
	    	break;
	    case "Country":
	    	ariaDescribedby = "SearchByCountry";
	    	break;
	    case "UserType":
	    	ariaDescribedby = "usersGrid_Is migrated";
	    	break;
	    }
		String dataFound = Driver.findElement(By.cssSelector("*[aria-describedby='" + ariaDescribedby + "']")).getText();
		dataFound.equals(data);
	}
//
//	@Given("^I have searched for a user$")
//	public void i_have_searched_for_a_user() throws Throwable {
//
//		admin.UsernameSearchField().sendKeys("wprit1");
//		admin.SearchButton().click();
//		admin.EditUserButton().click();
//	}
//
//	@When("^I go to the subscriptions page of the user profile$")
//	public void i_go_to_the_subscriptions_page_of_the_user_profile() throws Throwable {
//
//		AdminPortal.EditUserButtons("Subscriptions");
//
//	}
//
//	@Then("^I can see all subscriptions for the user$")
//	public void i_can_see_all_subscriptions_for_the_user() throws Throwable {
//
//		admin.SubsciptionsList().isDisplayed();
//	}
//
//	@When("^I make changes to a users username$")
//	public void i_make_changes_to_a_users_username() throws Throwable {
//
//		AdminPortal.EditUserButtons("Update user's username");
//		admin.NewUsernameField().sendKeys("wprit12");
//		admin.UpdateUsernameConfirm().get(0).click();
//		admin.ClosePopupWindow().get(0).click();
//		String username = admin.UsernameDisplayed().getAttribute("innerText");
//		System.out.println(username);
//		username.equals("wprit12");
//
//	}
//
//
//	@Then("^I can access the user account with the updated username$")
//	public void i_can_access_the_user_account_with_the_updated_username() throws Throwable {
//
//		SessionUtilities.Login("wprit12", "password");
//		UserPortal portal = new UserPortal();
//		portal.ProfileMenuButton().isDisplayed();
//
//		Driver.loadPage(MeeAdminPortal.getUrl());
//		SessionUtilities.CleanUpUsernameChange();
//	}
//
//	@When("^I make changes to a users password$")
//	public void i_make_changes_to_a_users_password() throws Throwable {
//
//		AdminPortal.EditUserButtons("Reset User Password");
//		AdminPortal.Password("password1");
//		admin.UpdateUsernameConfirm().get(0).click();
//		admin.ClosePopupWindow().get(0).click();
//	}
//
//	@Then("^I can access the user account with the updated password$")
//	public void i_can_access_the_user_account_with_the_updated_password() throws Throwable {
//
//		SessionUtilities.Login("wprit1", "password1");
//		UserPortal portal = new UserPortal();
//		portal.ProfileMenuButton().isDisplayed();
//
//		Driver.loadPage(MeeAdminPortal.getUrl());
//		SessionUtilities.CleanUpPasswordChange();
//	}
//
//
//	@Given("^Navigate to the user portal$")
//	public void navigate_to_the_user_portal() throws Throwable {
//
//		Driver.loadPage("https://mee-test-useraccesscontrolmanager.ws.macmillaneducation.com/");
//	}
//
//	@Given("^Make changes to the users details$")
//	public void make_changes_to_the_users_details() throws Throwable {
//
//		admin.EditFirstName().sendKeys("Test");
//		admin.EditLastName().sendKeys("Test");
//		admin.EditCountry().sendKeys("France");
//		admin.SaveChanges().get(0).click();
//		admin.ClosePopupWindow().get(0).click();
//	}
//
//	@When("^I login as the user$")
//	public void i_login_as_the_user() throws Throwable {
//
//		SessionUtilities.Login("wprit1", "password");
//	}
//
//	@When("^Go to the user details section of the portal$")
//	public void go_to_the_user_details_section_of_the_portal() throws Throwable {
//
//		UserPortal portal = new UserPortal();
//		portal.ProfileMenuButton().click();
//		portal.EditProfileDetailsButton().click();
//
//	}
//
//	@Then("^The changes I have made are displayed$")
//	public void the_changes_I_have_made_are_displayed() throws Throwable {
//
//		UserPortal portal = new UserPortal();
//		portal.EditFirstName().getAttribute("value").equals("willTest");
//		portal.EditLastName().getAttribute("value").equals("pritTest");
//
//		Driver.loadPage(MeeAdminPortal.getUrl());
//		SessionUtilities.CleanUpUserDetails();
//
//	}
//
//	@Given("^I have searched for a resource$")
//	public void i_have_searched_for_a_resource() throws Throwable {
//
//		admin.ResourceNameSearchField().sendKeys("Breakthrough Plus Digibook 1");
//		admin.ResourceSeachButton().click();
//
//	}
//
//	@When("^I edit the resource$")
//	public void i_edit_the_resource() throws Throwable {
//
//		admin.ResourceEditButton().click();
//	}
//
//	@When("^Update the build number of resource$")
//	public void update_the_build_number_of_resource() throws Throwable {
//
//		admin.ResourceVersionsAccordion().click();
//		admin.ResourceBuildNumber().sendKeys("6");
//	}
//
//	@Then("^the build number is stored against the resource$")
//	public void the_build_number_is_stored_against_the_resource() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
}