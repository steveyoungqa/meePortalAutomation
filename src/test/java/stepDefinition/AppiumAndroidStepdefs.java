package stepDefinition;

import appium.RuntimeExec;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import pageObject.AppiumBrowser;

import java.net.URL;
import java.util.concurrent.TimeUnit;


public class AppiumAndroidStepdefs {
    AndroidDriver driver;
    DesiredCapabilities caps = new DesiredCapabilities();
    RuntimeExec appiumObj = new RuntimeExec();

    @Given("^I am using Appium to run Mobile Browser automation tests for device \"([^\"]*)\" and Android version \"([^\"]*)\"$")
    public void iAmUsingAppiumToRunAutomationTestsForDevice(String device, String version) throws Throwable {
        appiumObj.startAppium("appium --address 127.0.0.1");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,device);
        caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser");
        caps.setCapability("avd",device);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Given("^I am using Appium to run APK automation tests for device \"([^\"]*)\" and Android version \"([^\"]*)\"$")
    public void iAmUsingAppiumToRunAPKAutomationTestsForDeviceAndAndroidVersion(String device, String version) throws Throwable {
        appiumObj.startAppium("appium --address 127.0.0.1");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,device);
        caps.setCapability("avd",device);
    }

    @And("^I am using the \"([^\"]*)\" local path$")
    public void iAmUsingTheLocalPath(String apk) throws Throwable {
        caps.setCapability(MobileCapabilityType.APP, apk);
    }

    @And("^I run some Example Tests$")
    public void iRunSomeExampleTests() throws Throwable {
        WebElement planner=driver.findElement(By.id("uk.co.nationalrail.google:id/journeyPlannerTabButton"));
        planner.click();
        WebElement stationFrom=driver.findElement(By.id("uk.co.nationalrail.google:id/stationFrom"));
        stationFrom.click();
    }


    @And("^I close the Mobile Browser$")
    public void iCloseTheMobileBrowser() throws Throwable {
        driver.closeApp();
        driver.quit();
//        Actions action2 = new Actions(driver);
//        action2.sendKeys(Keys.COMMAND + "Q");
    }
    
    @Then("^I launch the App on the Device$")
    public void iLaunchTheAppOnTheDevice() throws Throwable {
        driver = new AndroidDriver (new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }

    @And("^I am using the \"([^\"]*)\" url for the mobile browser$")
    public void iAmUsingTheUrlForTheMobileBrowser(String url) throws Throwable {
        driver.get(url);
    }

    @And("^I have clicked on the New Register button for mobile browser$")
    public void iHaveClickedOnTheNewRegisterButtonForMobileBrowser() throws Throwable {
        AppiumBrowser appium = new AppiumBrowser();
        driver.findElement(By.xpath(String.valueOf(appium.NewRegisterLandingPage()))).click();
    }

    @Then("^I enter a New Access code of \"([^\"]*)\" for mobile browser$")
    public void iEnterANewAccessCodeOfForMobileBrowser(String code) throws Throwable {
        AppiumBrowser appium = new AppiumBrowser();
        driver.findElement(By.id(String.valueOf(appium.AccessCodeField()))).clear();
        Thread.sleep(1000);
        driver.findElement(By.id(String.valueOf(appium.AccessCodeField()))).sendKeys(code);
        Thread.sleep(1000);
    }

    @And("^I have clicked on the Access code Next button for mobile browser$")
    public void iHaveClickedOnTheAccessCodeNextButtonForMobileBrowser() throws Throwable {
        AppiumBrowser appium = new AppiumBrowser();
        driver.findElement(By.id(String.valueOf(appium.AccessCodeNextButton()))).click();
    }


    @Then("^I register a new user in the mobile browser in language \"([^\"]*)\"$")
    public void iRegisterANewUserInTheMobileBrowser(String language) throws Throwable {
      //TO DO - NOT REQUIRED TO CREATE NEW USER
    }

    @Then("^I register a first name of \"([^\"]*)\" and surname of \"([^\"]*)\" for mobile browser$")
    public void iRegisterAFirstNameOfAndSurnameOfForMobileBrowser(String first, String last) throws Throwable {
        AppiumBrowser appium = new AppiumBrowser();
        driver.findElement(By.id(String.valueOf(appium.FirstName()))).clear();
        Thread.sleep(1000);
        driver.findElement(By.id(String.valueOf(appium.FirstName()))).sendKeys(first);
        Thread.sleep(1000);
        driver.findElement(By.id(String.valueOf(appium.Surname()))).clear();
        Thread.sleep(1000);
    }




    @And("^I select a Country of residence of \"([^\"]*)\" for mobile browser$")
    public void iSelectACountryOfResidenceOfForMobileBrowser(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
