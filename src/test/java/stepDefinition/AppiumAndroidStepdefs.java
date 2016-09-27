package stepDefinition;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import java.net.URL;
import java.util.concurrent.TimeUnit;


public class AppiumAndroidStepdefs {
    AndroidDriver driver;

    @Given("^I am using Appium to run automation tests for device \"([^\"]*)\" and Android version \"([^\"]*)\"$")
    public void iAmUsingAppiumToRunAutomationTestsForDevice(String device, String version) throws Throwable {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,device);
        caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser");
        caps.setCapability("avd",device);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @And("^I am using the \"([^\"]*)\" url for the mobile browser$")
    public void iAmUsingTheUrlForTheMobileBrowser(String url) throws Throwable {
        driver.get(url);
    }

    @Then("^I register a new user in the mobile browser in language \"([^\"]*)\"$")
    public void iRegisterANewUserInTheMobileBrowser(String language) throws Throwable {
        WebElement registerButton = driver.findElement(By.xpath("//*[@data-reactid='.1.2.0.0']"));
        registerButton.click();
//        WebElement languageSelector = driver.findElement(By.xpath("//*[@class='mee-select mee-purple-select']//*[@data-reactid = '.1.0']"));
//        Select languageSelect = new Select(languageSelector);
//        languageSelect.selectByValue(language);
//  Selector not functioning on Android
    }

    @And("^I use a Country of \"([^\"]*)\" and a First Name of \"([^\"]*)\" and Surname of \"([^\"]*)\"$")
    public void iUseALanguageOfFirstnameSurname(String country, String first, String last) throws Throwable {
        WebElement countrySelector = driver.findElement(By.xpath("//*[@data-flux-key='countryOfResidence']"));
        Select countrySelect = new Select(countrySelector);
        countrySelect.selectByValue(country);
        WebElement firstName = driver.findElement(By.id("_FirstName"));
        firstName.clear();
        firstName.sendKeys(first);
        WebElement surname = driver.findElement(By.id("_LastName"));
        surname.clear();
        surname.sendKeys(last);
    }


    @Then("^use a date of birth of \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void useADateOfBirthOf(String day, String month, String year) throws Throwable {
        WebElement daySelect = driver.findElement(By.xpath("//*[@id='_DateOfBirth_Day']"));
        Select dayValue = new Select(daySelect);
        dayValue.selectByValue(day);

        WebElement monthSelect = driver.findElement(By.xpath("//*[@id='_DateOfBirth_Month']"));
        Select monthValue = new Select(monthSelect);
        monthValue.selectByValue(month);

        WebElement yearSelect = driver.findElement(By.xpath("//*[@id='_DateOfBirth_Year']"));
        Select yearValue = new Select(yearSelect);
        yearValue.selectByValue(year);

    }
    @After
    public void tearDown() {driver.closeApp();}

}
