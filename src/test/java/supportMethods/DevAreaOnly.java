package supportMethods;

import enums.MeePortal;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pageObject.Mailinator;
import stepDefinition.EnvironmentStepDefs;
import webDriver.Driver;

import org.apache.commons.collections.bag.TreeBag;
import org.apache.http.impl.client.SystemDefaultCredentialsProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.impl.client.HttpClientBuilder;
import pageObject.LoginPage;
import supportMethods.FileReader;

public class DevAreaOnly {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }


    @Test
    public void scrollTest() throws Throwable {
        driver.get("https://www.bbc.co.uk");
//        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.chord(Keys.COMMAND,"t"));
        Thread.sleep(3000);
//        driver.get("https://www.mailinator.com/");

    }

//    @Test
//    public void downloadFileSpringer() throws Exception {
//        driver.get("https://mee-test-useraccesscontrolmanager.ws.macmillaneducation.com/");
//        driver.findElement(By.xpath("//*[@data-reactid='.1.2.1.0']")).click();
//        String username = FileReader.readProperties().get("username");
//        String password = FileReader.readProperties().get("password");
//        driver.findElement(By.id("_Username")).sendKeys(username);
//        driver.findElement(By.id("_Password")).sendKeys(password);
//        driver.findElement(By.xpath(".//input[@type='submit']")).click();
//        Thread.sleep(3000);
//}

}