package appium;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ios {
    IOSDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException{
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.APP, "/Users/syn3286/Documents/Appium/UICatalog.app");
        caps.setCapability(MobileCapabilityType.BROWSER_NAME, "=Safari");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"=iPhone 6");

        IOSDriver driver = new IOSDriver (new
                URL("http://127.0.0.1:4723/wd/hub"),caps);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test
    public void webTest() throws IOException {
        driver.get("https://www.google.com");
        WebElement searchBox=driver.findElement(By.name("q"));
        searchBox.sendKeys("Appium for mobile automation");

    }

    @AfterClass
    public void tearDown(){
        driver.closeApp();
    }
}
