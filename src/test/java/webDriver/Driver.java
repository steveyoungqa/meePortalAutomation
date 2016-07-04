package webDriver;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import supportFactory.PlatformFactory;
import supportFactory.WebdriverFactory;
import testRunner.TestRunner;

public class Driver {

    public static WebDriver webdriver;

    public synchronized static WebDriver getCurrentDriver() {

        if (webdriver == null) {
            webdriver = WebdriverFactory.createWebdriver();
        }
        return webdriver;
    }

    public static void close() {

        getCurrentDriver().close();
    }

    public static void quit() {

        getCurrentDriver().quit();
        webdriver = null;
    }

    public static void loadPage(String url) {
        getCurrentDriver().get(url);
        maximise();
    }

    public static Boolean logInToAtlassian() throws InterruptedException {

        loadPage("https://crowd.macmillan.education");
        findElement(By.id("j_username")).sendKeys(TestRunner.config.get("atlassianUsername"));
        Thread.sleep(1000);
        findElement(By.id("j_password")).sendKeys(TestRunner.config.get("atlassianPassword"));
        Thread.sleep(1000);
        findElement(By.xpath(".//input[@type='submit']")).click();
        return new WebDriverWait(getCurrentDriver(), 60).until(ExpectedConditions.urlContains("https://crowd.macmillan.education/crowd/console/user/viewprofile.action"));
    }

    public static Object runJavascript(String javascript) {

        return ((JavascriptExecutor) getCurrentDriver()).executeScript(javascript);

    }

    public static void refreshPage() {

        getCurrentDriver().navigate().refresh();
    }

    public static WebElement findElement(By element) {

        return wait(10).until(ExpectedConditions.presenceOfElementLocated((By) element));
    }

    public static List<WebElement> findElements(By element) {

        try {
            return wait(10).until(ExpectedConditions.presenceOfAllElementsLocatedBy((By) element));
        }
        catch (TimeoutException e)
        {
            System.out.println("Supressed: " + e.getMessage());
        }
        return new ArrayList<WebElement>();

    }

    public static String getCurrentUrl() {

        return getCurrentDriver().getCurrentUrl();

    }

    public static String getTitle() {

        return getCurrentDriver().getTitle();
    }

    public static String screenshot(String filename) throws IOException {

        try {
            File file = ((TakesScreenshot) getCurrentDriver()).getScreenshotAs(OutputType.FILE);
            String filePath = ("./screenshot/" + filename + ".jpg");
            FileUtils.copyFile(file, new File(filePath));
            return filePath;
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            return null;
        }
    }

    public static void embedScreenshot() {
        try {
            byte[] screenshot = ((TakesScreenshot) getCurrentDriver()).getScreenshotAs(OutputType.BYTES);
            TestRunner.scenario.embed(screenshot, "image/png");
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }
    }

    public static void writeToReport(String string) {
        TestRunner.scenario.write(string);
    }

    public static WebDriver switchToWindow(String window) {
        return getCurrentDriver().switchTo().window(window);
    }

    public static String getWindowHandle() {
        return getCurrentDriver().getWindowHandle();
    }

    public static Set<String> getWindowHandles() {
        return getCurrentDriver().getWindowHandles();
    }

    public static void nextTab()
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}
        ArrayList<String> tabs = new ArrayList<String> (Driver.getWindowHandles());
        int index = 0;
        for (String tab : tabs)
        {
            if (tab == Driver.mainWindowHandle)
            {
                index = tabs.indexOf(tab);
            }
        }
        Driver.switchToWindow(tabs.get(index + 1));
    }

    /**
     * Designed when there are only two tabs. Avoids issues where the order of window handles differs between browsers
     */
    public static void otherTab()
    {
        ArrayList<String> tabs = new ArrayList<String> (Driver.getWindowHandles());
        int index = 0;
        for (String tab : tabs)
        {
            if (tab != Driver.mainWindowHandle)
            {
                index = tabs.indexOf(tab);
            }
        }
        Driver.switchToWindow(tabs.get(index));
    }

    public static void mainTab()
    {
        ArrayList<String> tabs = new ArrayList<String> (Driver.getWindowHandles());
        int index = 0;
        for (String tab : tabs)
        {
            if (tab == Driver.mainWindowHandle)
            {
                index = tabs.indexOf(tab);
            }
        }
        Driver.switchToWindow(tabs.get(index));
    }

    public static Dimension getResolution()
    {
        return getCurrentDriver().manage().window().getSize();
    }

    public static void setResolution(int x, int y)
    {
        switch (PlatformFactory.platform) {
            case Android:
                System.out.println("Cannot adjust resolution on Android devices");
                break;
            case iOS:
                System.out.println("Cannot adjust resolution on iOS devices");
                break;
            default:
                getCurrentDriver().manage().window().setSize(new Dimension(x, y));
                break;
        }

    }

    public static void maximise()
    {
        switch (PlatformFactory.platform) {
            case Android:
                System.out.println("Cannot maximise on Android devices");
                break;
            case iOS:
                System.out.println("Cannot maximise on iOS devices");
                break;
            default:
                getCurrentDriver().manage().window().maximize();
                break;
        }

    }

    public static Actions actions(){
        return new Actions(getCurrentDriver());
    }

    public static void dragAndDrop(WebElement start, WebElement finish) throws InterruptedException  {
        maximise();
        actions().moveToElement(start).clickAndHold(start).moveToElement(finish, 1, 1).moveToElement(finish).build().perform();
        Thread.sleep(1000);
        actions().moveToElement(finish).release().build().perform();

    }

    public static WebDriver switchToFrame(String name) {
        return getCurrentDriver().switchTo().frame(name);
    }

    public static WebDriver switchToFrame(int index) {
        return getCurrentDriver().switchTo().frame(index);
    }

    public static WebDriver switchToFrame(WebElement iframe) {
        return getCurrentDriver().switchTo().frame(iframe);
    }

    public static WebDriverWait wait(int seconds) {

        return new WebDriverWait(getCurrentDriver(), seconds);
    }

    public static Boolean waitForUrlToContain(String url, int time) {
        return new WebDriverWait(getCurrentDriver(), time).until(ExpectedConditions.urlContains(url));
    }

    public static void scrollToElement(WebElement element) throws Throwable {
        Actions actions = new Actions(webdriver);
//        actions.moveToElement(element).perform();
        actions.moveToElement(element).click(element).perform();
        Thread.sleep(2000);
    }

    public static String mainWindowHandle;
    public static Set<String> allWindowHandles;


}
