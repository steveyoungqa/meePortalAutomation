package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webDriver.Driver;

/**
 * Created by syn3286 on 18/05/2016.
 */
public class HelpPage {

    //Help Section links

    public WebElement HelpHeader() {
        return Driver.findElement(By.xpath("//*[@name='_Help']"));
    }

    public WebElement SystemReqs() {
        return Driver.findElement(By.cssSelector("a[href='#_System_Requirements']"));
    }

    public WebElement HowAccess() {
        return Driver.findElement(By.cssSelector("a[href='#_How_do_I']"));
    }

    public WebElement HowMeeLinux() {
        return Driver.findElement(By.cssSelector("a[href='#_How_do_I_Linux']"));
    }

    public WebElement HowRegister() {
        return Driver.findElement(By.cssSelector("a[href='#_How_do_I_1"));
    }

    public WebElement HowLogin() {
        return Driver.findElement(By.cssSelector("a[href='#_How_do_I_2"));
    }

    public WebElement HowRequestUserPass() {
        return Driver.findElement(By.cssSelector("a[href='#_How_do_I_3"));
    }

    public WebElement HowFindCode() {
        return Driver.findElement(By.cssSelector("a[href='#_How_do_I_4"));
    }

    public WebElement HowActivateCode() {
        return Driver.findElement(By.cssSelector("a[href='#_How_do_I_5"));
    }

    public WebElement HowAccessResource() {
        return Driver.findElement(By.cssSelector("a[href='#_How_do_I_6"));
    }

    public WebElement WhyResource() {
        return Driver.findElement(By.cssSelector("a[href='#_Why_cant_I"));
    }

    public WebElement WhyNoDownload() {
        return Driver.findElement(By.cssSelector("a[href='#_Why_can_I"));
    }

    public WebElement HowChangeProfile() {
        return Driver.findElement(By.cssSelector("a[href='#_How_do_I_7"));
    }

    public WebElement HowNewVersion() {
        return Driver.findElement(By.cssSelector("a[href='#_How_will_I"));
    }

    public WebElement UpdateLinux() {
        return Driver.findElement(By.cssSelector("a[href='#_How_do_I_update_Linux"));
    }

    public WebElement RemoveResource() {
        return Driver.findElement(By.cssSelector("a[href='#_How_do_I_8"));
    }

    public WebElement ChangeLanguage() {
        return Driver.findElement(By.cssSelector("a[href='#_How_do_I_9"));
    }

    public WebElement CloseMeeApp() {
        return Driver.findElement(By.cssSelector("a[href='#_How_do_I_10"));
    }

    public WebElement GetMoreHelp() {
        return Driver.findElement(By.cssSelector("a[href='#_How_do_I_11"));
    }
}
