package webDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import supportFactory.BrowserFactory;
import supportFactory.PlatformFactory;
import supportFactory.WebdriverFactory;
import supportMethods.BrowserStack;
import testRunner.TestRunner;

import static org.apache.commons.io.FileUtils.waitFor;

public class Driver {


    public static WebDriver webdriver= new ChromeDriver();


    public static void quit() {
        webdriver.quit();
    }

    public static void close() {
        webdriver.close();
    }

    public static void loadPage(String url) {
        webdriver.get(url);
        maximise();
    }

    public static WebElement findElement(By element) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        webdriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        try {
            new WebDriverWait(webdriver, 5).until(ExpectedConditions.elementToBeClickable((By) element));
        } catch (Exception e) {

        }
        WebElement foundElement;

        try {
            foundElement = webdriver.findElement(element);
        } catch (Exception e) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            System.out.println("Waiting 5 seconds.");
            foundElement = webdriver.findElement(element);
        }
        return foundElement;
    }

    public static List<WebElement> findElements(By element) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webdriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        try {
            new WebDriverWait(webdriver, 1).until(ExpectedConditions
                    .presenceOfAllElementsLocatedBy((By) element));
        } catch (TimeoutException e) {
            System.out.println("Supressed: " + e.getMessage());
        }
        return webdriver.findElements(element);

    }

    public static String getCurrentUrl() {
        return webdriver.getCurrentUrl();

    }

    public static void refreshPage() {
        webdriver.navigate().refresh();
    }

    public static String getTitle() {
        return webdriver.getTitle();
    }

    public static String screenshot(String filename) throws IOException {
        File file = ((TakesScreenshot) webdriver)
                .getScreenshotAs(OutputType.FILE);
        String filePath = ("./screenshot/" + filename + ".jpg");
        FileUtils.copyFile(file, new File(filePath));
        return filePath;
    }

    public static void embedScreenshot() {

        byte[] screenshot = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.BYTES);
        TestRunner.scenario.embed(screenshot, "image/png");
    }

    public static void writeToReport(String string) {
        TestRunner.scenario.write(string);
    }

    public static WebDriver switchToWindow(String window) {
        return webdriver.switchTo().window(window);
    }

    public static WebDriver switchToFrame(String name) {
        return webdriver.switchTo().frame(name);
    }

    public static WebDriver switchToFrame(int index) {
        return webdriver.switchTo().frame(index);
    }

    public static WebDriver switchToFrame(WebElement iframe) {
        return webdriver.switchTo().frame(iframe);
    }

    public static String getWindowHandle() {
        return webdriver.getWindowHandle();
    }

    public static Set<String> getWindowHandles() {
        return webdriver.getWindowHandles();
    }


    public static Dimension getResolution() {
        return webdriver.manage().window().getSize();
    }

    public static void setResolution(int x, int y) {
        webdriver.manage().window().setSize(new Dimension(x, y));
    }

    public static void maximise() {
        webdriver.manage().window().maximize();
    }

    public static Actions actions() {
        return new Actions(webdriver);
    }

    public static void dragAndDrop(WebElement start, WebElement finish) {
        Driver.actions().moveToElement(finish).perform();
        Driver.actions().moveToElement(start).perform();
        Driver.actions().clickAndHold(start).perform();
        Driver.actions().moveToElement(finish).perform();
        Driver.actions().moveToElement(finish).perform();
        Driver.actions().release(finish).perform();
    }

    public static void scrollToTopOfPage() throws Throwable {
        JavascriptExecutor jse = (JavascriptExecutor) webdriver;
        jse.executeScript("scrollBy(0, -6000);");
        Thread.sleep(2000);
    }

    public static void scrollToBottomOfPage() throws Throwable {
        JavascriptExecutor jse = (JavascriptExecutor) webdriver;
        jse.executeScript("window.scrollTo(0,document.body.scrollHeight);");
        Thread.sleep(2000);
    }

    public static void scrollToElement(WebElement element) throws Throwable {
        Actions actions = new Actions(webdriver);
//        actions.moveToElement(element).perform();
        actions.moveToElement(element).click(element).perform();
        Thread.sleep(2000);
    }


    public static Boolean waitForUrlToContain(String url, int time) {
        return new WebDriverWait(webdriver, time).until(ExpectedConditions.urlContains(url));
    }

    public static Boolean waitForIsDisplayed (By locator, Integer...timeout) {
       try {
           waitFor( ExpectedConditions.visibilityOfElementLocated(locator),
                   (timeout.length > 0 ? timeout[0] : null));
       }
       catch (org.openqa.selenium.TimeoutException exception) {
           return false;
       }
        return true;
    }

   public static void waitFor(ExpectedCondition<WebElement> condition, Integer timeout) {
        timeout = timeout != null ? timeout : 5;
        WebDriverWait wait = new WebDriverWait(Driver.webdriver, timeout);
        wait.until(condition);
    }

}
