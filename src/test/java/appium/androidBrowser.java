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

public class androidBrowser {
    AndroidDriver driver;

    String apk = "/Users/youngey/Documents/JVMProjects/Appium/uk.co.nationalrail.google.8.2.2.apk";
    String avd = "Nexus_One_API_22";

    @BeforeClass
    public void setUp() throws MalformedURLException{
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Device");
        caps.setCapability("avd",avd);// Mention the created AVD name
        caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser");
        driver = new AndroidDriver (new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
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
