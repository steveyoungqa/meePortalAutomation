package appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.LoginPage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class android {
    AndroidDriver driver;

    String apk = "/Users/syn3286/Documents/Appium/uk.co.nationalrail.google.8.2.2.apk";
    String avd = "Samsung_Galaxy_S7_Edge_API_22";

    @BeforeClass
    public void setUp() throws MalformedURLException{
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.APP, apk);
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Nantucket");
        caps.setCapability("avd",avd);// Mention the created AVD name
        caps.setCapability(MobileCapabilityType.APP_PACKAGE,"uk.co.nationalrail.google");
//        caps.setCapability(MobileCapabilityType.APP_ACTIVITY,"uk.co.fortunecookie.nre.activities.SplashScreen");
        caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser");
        driver = new AndroidDriver (new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }
    @Test
    public void apkExample() throws Exception{

        WebElement planner=driver.findElement(By.id("uk.co.nationalrail.google:id/journeyPlannerTabButton"));
        planner.click();
        WebElement stationFrom=driver.findElement(By.id("uk.co.nationalrail.google:id/stationFrom"));
        stationFrom.click();
        WebElement stationOrPostcodeSearch=driver.findElement(By.id("uk.co.nationalrail.google:id/stationSearchEditText"));
        stationOrPostcodeSearch.sendKeys("London Bridge");
        Thread.sleep(2000);
        WebElement selectSearchResult=driver.findElement(By.id("uk.co.nationalrail.google:id/name"));
        selectSearchResult.click();

        WebElement stationTo = driver.findElement(By.id("uk.co.nationalrail.google:id/stationTo"));
        stationTo.click();
        stationOrPostcodeSearch.sendKeys("Maidstone East");
        Thread.sleep(2000);
        selectSearchResult.click();

        WebElement nowDeparture = driver.findElement(By.id("uk.co.nationalrail.google:id/nowButton"));
        nowDeparture.click();

        WebElement goButton  = driver.findElement(By.id("uk.co.nationalrail.google:id/goButton"));
        goButton.click();
        Thread.sleep(5000);

    }

    @Test
    public void webTest() throws IOException {

        LoginPage login = new LoginPage();
        driver.get("https://mee-test-useraccesscontrolmanager.ws.macmillaneducation.com/");
        WebElement registerButton = driver.findElement(By.xpath("//*[@data-reactid='.1.2.0.0']"));
        registerButton.click();
    }

    @AfterClass
    public void tearDown(){
        driver.closeApp();
    }
}
