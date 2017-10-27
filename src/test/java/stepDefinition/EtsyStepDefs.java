package stepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.Etsy;
import pageObject.LoginPage;
import webDriver.Driver;

/**
 * Created by steveyoung on 26/10/2017.
 */
public class EtsyStepDefs {

    @When("^he searches for a product \"([^\"]*)\" from the input box$")
    public void heSearchesForAProductFromTheInputBox(String input) throws Throwable {
        Etsy etsy = new Etsy();
        etsy.ProductInputBox(input).sendKeys(input);
        etsy.SubmitSearch(input).click();
    }

    @Then("^the result should be displayed$")
    public void theResultShouldBeDisplayed() throws Throwable {
//        TODO
    }

    @Given("^John is viewing the \"([^\"]*)\" landing page$")
    public void johnIsViewingTheLandingPage(String url) throws Throwable {
        Driver.loadPage(url);
    }

    @And("^he searches for a product from the dropdown of \"([^\"]*)\"$")
    public void heSearchesForAProductFromTheDropdownOf(String product) throws Throwable {
       Etsy etsy = new Etsy();
       etsy.ProductDropdown(product).click();
    }

    @And("^selects the product category of \"([^\"]*)\"$")
    public void selectsTheProductCategoryOf(String category) throws Throwable {
        Etsy etsy = new Etsy();
        etsy.ProductCategory(category).click();
    }

    @And("^he searches for a product from the icon of \"([^\"]*)\"$")
    public void heSearchesForAProductFromTheIconOf(String icon) throws Throwable {
        Etsy etsy = new Etsy();
        etsy.ProductIcon(icon).click();
    }



}
